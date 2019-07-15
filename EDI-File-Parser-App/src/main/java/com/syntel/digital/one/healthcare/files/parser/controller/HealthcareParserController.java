package com.syntel.digital.one.healthcare.files.parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.syntel.digital.one.healthcare.files.parser.domain.HealthcareParserFields;
import com.syntel.digital.one.healthcare.files.parser.dto.ResponseDTO;
import com.syntel.digital.one.healthcare.files.parser.service.HealthcareParserService;

@RestController
@RequestMapping(value = "/healthcareParser/")
public class HealthcareParserController {

	public static final String VERSION = "1.0";

	@Autowired
	HealthcareParserService healthcareparserService;

	@CrossOrigin(value = "http://10.119.32.80:9892")
	@RequestMapping(value = "/ediFileParser/", method = RequestMethod.POST)
	public ResponseDTO fileParserRequest(HealthcareParserFields healthcareparserfields) {

		// Declaring responseDTO object for output render on UI
		ResponseDTO responsedto = new ResponseDTO();
		try {
			System.out.println(
					"Fields :::: " + HealthcareParserFields.getJobName() + " " + HealthcareParserFields.getFile() + " "
							+ HealthcareParserFields.getDirPath() + " " + HealthcareParserFields.getTargetFileType());

			healthcareparserService.ediParser(HealthcareParserFields.getJobName(), HealthcareParserFields.getFile(),
					HealthcareParserFields.getDirPath(), HealthcareParserFields.getTargetFileType());

			responsedto.setStatus(true);
			responsedto.setOutput("EDI File is Parsed Successfully!!!!!");

		} catch (Exception e) {
			e.printStackTrace();
			responsedto.setStatus(false);
			responsedto.setOutput("Oops !!!! Something went wrong !!!!");
		}
		return responsedto;
	}
}