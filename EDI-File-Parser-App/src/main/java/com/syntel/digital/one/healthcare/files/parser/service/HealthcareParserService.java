package com.syntel.digital.one.healthcare.files.parser.service;

import org.springframework.web.multipart.MultipartFile;

public interface HealthcareParserService {
		
	public void ediParser(String jobName,MultipartFile[] files, String dirPath,String targetFileType) throws Exception;
}
