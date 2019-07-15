package com.syntel.healthcare.files.upload.hadoop.mongodb.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.syntel.healthcare.files.upload.hadoop.mongodb.service.service.FilesUploadHadoopService;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.utils.FilesUploadHadoop;

@Service
public class FilesUploadHadoopServiceImpl implements FilesUploadHadoopService{

	public void FilesUploadHadoop(String jobName, String clusterIP,
			String mongocollecname) throws Exception {

		FilesUploadHadoop.uploadHadoop(jobName,clusterIP,mongocollecname);
		
	}
}
