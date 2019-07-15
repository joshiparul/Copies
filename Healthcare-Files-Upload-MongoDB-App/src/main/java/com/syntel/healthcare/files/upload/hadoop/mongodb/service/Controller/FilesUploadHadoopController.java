package com.syntel.healthcare.files.upload.hadoop.mongodb.service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.domain.FilesUploadHadoopFields;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.dto.ResponseDTO;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.service.FilesUploadHadoopService;

@RestController
@RequestMapping(value = "/healthcareParser/")
public class FilesUploadHadoopController {

	public static final String VERSION = "1.0";

	@Autowired
	FilesUploadHadoopService fileuploadhadoopService;

	@CrossOrigin(value = "http://10.119.32.80:9892")
	@RequestMapping(value = "/pushtoMongoDB/", method = RequestMethod.POST)
	public ResponseDTO FilesUploadHadoopRequest(FilesUploadHadoopFields filesuploadhadoopfields) {
		ResponseDTO responsedto = new ResponseDTO();

		System.out.println(filesuploadhadoopfields.getClusterIP() +" "+filesuploadhadoopfields.getJobName());
		try {
				fileuploadhadoopService.FilesUploadHadoop(filesuploadhadoopfields.getJobName(),filesuploadhadoopfields.getClusterIP(),filesuploadhadoopfields.getMongocollecname());
				responsedto.setStatus(true);
				responsedto.setMessage("File uploaded to MongoDB Successfully!!!!");
					
		} catch (Exception e) {
			
				e.printStackTrace();
				responsedto.setStatus(false);
				responsedto.setMessage("oops something went wrong!!!!");
		}
		return responsedto;
	}
}
