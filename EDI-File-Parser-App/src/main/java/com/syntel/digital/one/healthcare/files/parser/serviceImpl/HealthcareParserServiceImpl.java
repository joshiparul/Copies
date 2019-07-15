package com.syntel.digital.one.healthcare.files.parser.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.syntel.digital.one.healthcare.files.parser.service.HealthcareParserService;
import com.syntel.digital.one.healthcare.files.parser.utils.ediParser;

@Service
public class HealthcareParserServiceImpl implements HealthcareParserService {

	public void ediParser(String jobName, MultipartFile[] files, String dirPath,String targetFileType)
			throws Exception {
		
		ediParser.parse(jobName,files,dirPath,targetFileType);
		
	}
}
