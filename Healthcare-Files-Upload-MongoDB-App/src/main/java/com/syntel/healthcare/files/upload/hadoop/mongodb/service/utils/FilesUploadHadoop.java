package com.syntel.healthcare.files.upload.hadoop.mongodb.service.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.constants.Constants;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.dao.MetaDataDao;

public class FilesUploadHadoop {

	@SuppressWarnings({ "resource", "deprecation" })
	public static void uploadHadoop(String jobName, String clusterIP, String mongocollecname)
			throws ClassNotFoundException, Exception {

		String fileList = getScripts(jobName);
		String[] files = fileList.split(",");
		for (String file : files) {

			String jsonInputString = new String(Files.readAllBytes(Paths.get(Constants.getSourceScriptPath() + file)));

			System.out.println("json string in mongodb" + jsonInputString);
			MongoClient mongoClient = new MongoClient(clusterIP, 27017);
			DB db = mongoClient.getDB("analytics");
			System.out.println("Your connection to DB is ready for Use::" + db);
			DBCollection collection = db.getCollection(mongocollecname);
			System.out.println("Collection created successfully");
			DBObject dbObject = (DBObject) JSON.parse(jsonInputString);
			collection.insert(dbObject);
			System.out.println("Data Loaded successfully");
		}

		uploadPushMeta(jobName, clusterIP, mongocollecname);
	}

	public static String getScripts(String jobName) throws ClassNotFoundException, SQLException {

		String scriptList = null;
		StringBuilder sb = new StringBuilder();
		java.sql.Connection conn = MetaDataDao.Conn();
		String getScriptsQuery = "select fileName from Healthcare_Parser.HP_File_List  where jobName =" + "\"" + jobName
				+ "\"";
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(getScriptsQuery);
		while (rs.next()) {

			scriptList = rs.getString("fileName");

		}
		String[] detailFiles = scriptList.split(",");
		for (String f : detailFiles) {
			sb.append(f).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();

	}

	private static void uploadPushMeta(String jobName, String clusterIP, String mongocollecname)
			throws ClassNotFoundException, SQLException {

		int rowId = 0;

		Connection conn = MetaDataDao.Conn();

		String getIdQuery = "select Max(jobId) from  Healthcare_Parser.HP_Push_Files_Metadata;";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(getIdQuery);

		while (rs.next()) {

			rowId = rs.getInt("Max(jobId)");
		}

		rowId = rowId + 1;

		String update_query = "insert into Healthcare_Parser.HP_Push_Files_Metadata values(" + rowId + " , " + "\""
				+ jobName + "\"" + " , " + "\"" + clusterIP + "\"" + " , " + "\"" + "MongoDB" + "\"" + " , " + "\""
				+ "NULL" + "\"" + " , " + "\"" + mongocollecname + "\"" + " , " + "\"" + "Uploaded Successfully!" + "\""
				+ ")";

		System.out.println(update_query);
		PreparedStatement preparedStmt = conn.prepareStatement(update_query);
		preparedStmt.executeUpdate();

		conn.close();
	}
}
