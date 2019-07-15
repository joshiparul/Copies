package com.syntel.digital.one.healthcare.files.parser.utils;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.camel.Exchange;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import com.berryworks.edireader.EDIReader;
import com.syntel.digital.one.healthcare.files.parser.constants.Constants;
import com.syntel.digital.one.healthcare.files.parser.dao.DatabaseIO;

public class ediParser {

	public static void parse(String jobName, MultipartFile[] files, String dirPath, String targetFileType)
			throws Exception {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		int fileCount = 0;

		if (!dirPath.equalsIgnoreCase("undefined")) {
			MockMultipartFile file;
			fileCount = new File(dirPath).list().length;
			File dir = new File(dirPath);
			for (File f : dir.listFiles()) {
				file = new MockMultipartFile(f.getName(), new FileInputStream(new File(dirPath + "\\" + f.getName())));
				try {

					// Get the file and save it somewhere
					byte[] bytes = file.getBytes();
					Path path = Paths.get(Constants.getInput_Path() + file.getName());
					Files.write(path, bytes);

					if (file.getName().contains("837")) {
						ediParser cv = new ediParser();
						System.out.println("file name " + Constants.getInput_Path() + file.getName());
						cv.ediParse(Constants.getInput_Path() + file.getName(),
								file.getName().substring(0, file.getName().lastIndexOf(".")));
						DatabaseIO.fileMetaLoad(jobName, "EDI", "JSON", fileCount, timeStamp);
						DatabaseIO.fileLoad(jobName, file.getName().substring(0, file.getName().lastIndexOf(".")) + "_"
								+ timeStamp.replace(".", "_") + ".json");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			fileCount = 1;
			for (MultipartFile file : files) {
				try {

					// Get the file and save it somewhere
					byte[] bytes = file.getBytes();
					Path path = Paths.get(Constants.getInput_Path() + file.getOriginalFilename());
					Files.write(path, bytes);

					if (file.getOriginalFilename().contains("837")) {
						ediParser cv = new ediParser();
						System.out.println("file name " + Constants.getInput_Path() + file.getOriginalFilename());
						cv.ediParse(Constants.getInput_Path() + file.getOriginalFilename(),
								file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")));
						DatabaseIO.fileMetaLoad(jobName, "EDI", "JSON", fileCount, timeStamp);
						DatabaseIO.fileLoad(jobName,
								file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."))
										+ "_" + timeStamp.replace(".", "_") + ".json");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings({ "static-access", "unused" })
	public void ediParse(String file, String filename) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String line = new String(Files.readAllBytes(Paths.get(file)));
		InputSource inputSource = null;
		OutputStream generatedOutput = null;
		ContentHandler handler;
		EDIReader parser;
		ediParser xj = new ediParser();
		String jsonstr = null;
		InputStream stream = new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8));
		System.out.println("stream :::: " + stream.toString() + stream);
		inputSource = new InputSource(new StringReader(line));
		System.out.println("InputSource ::: " + inputSource.toString() + inputSource);
		try {
			System.setProperty("javax.xml.parsers.SAXParserFactory", "com.berryworks.edireader.EDIParserFactory");
			SAXParserFactory sFactory = SAXParserFactory.newInstance();
			SAXParser sParser = sFactory.newSAXParser();
			XMLReader ediReader = sParser.getXMLReader();
			SAXSource source = new SAXSource(ediReader, inputSource);
			System.out.println("edireader ::::  " + ediReader.toString() + ediReader);

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);

			transformer.transform(source, result);
			System.out.println("result :::: " + result.toString() + result);
			System.out.println("source :::: " + source.toString() + source);
			System.out.println("Writer :::: " + writer.toString() + writer);
			String xmlString = writer.toString();
			System.out.println("cmlString :::: " + xmlString);
			xmlString = xmlString.replaceAll("[^\\x20-\\x7e]", "");
			line = EDIXMLConversion(xmlString);
			jsonstr = xj.xmltojson(line);
			System.out.println(":::::::::Json String" + jsonstr);
			try (Writer writer1 = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(
							Constants.getOutput_Path() + filename + "_" + timeStamp.replace(".", "_") + ".json", true),
					"utf-8"))) {

				writer1.write(jsonstr.toString() + "\n");
			}
			System.out.print("\nTransformation complete\n");
		} catch (SAXException e) {
			System.out.println("\nUnable to create EDIReader: " + e);
		} catch (ParserConfigurationException e) {
			System.out.println("\nUnable to create EDIReader: " + e);
		} catch (TransformerConfigurationException e) {
			System.out.println("\nUnable to create Transformer: " + e);
		} catch (TransformerException e) {
			System.out.println("\nFailure to transform: " + e);
		}
	}

	public static String EDIXMLConversion(String xmlstr)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		System.out.println("xml string :::::::: " + xmlstr);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new InputSource(new StringReader(xmlstr)));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String output = writer.getBuffer().toString();
		return output;
	}

	public static String xmltojson(String xmlstring) throws IOException {

		XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
		xmlJsonDataFormat.setEncoding("UTF-8");
		xmlJsonDataFormat.setForceTopLevelObject(true);
		xmlJsonDataFormat.setTrimSpaces(true);
		xmlJsonDataFormat.setRootName("newRoot");
		xmlJsonDataFormat.setSkipNamespaces(true);
		xmlJsonDataFormat.setRemoveNamespacePrefixes(true);
		try {
			xmlJsonDataFormat.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		@SuppressWarnings("unused")
		Exchange exchange;

		InputStream stream = new ByteArrayInputStream(xmlstring.getBytes(StandardCharsets.UTF_8));
		String json = xmlJsonDataFormat.getSerializer().readFromStream(stream).toString();
		System.out.println("json ::::::::::::::: " + json);
		return json;

	}
}
