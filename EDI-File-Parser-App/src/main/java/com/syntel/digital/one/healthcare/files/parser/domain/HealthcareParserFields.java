package com.syntel.digital.one.healthcare.files.parser.domain;

import org.springframework.web.multipart.MultipartFile;

public class HealthcareParserFields {

	public static String jobName;
	public static String dirPath;
	public static MultipartFile[] file;
	public static String targetFileType;

	public static String getJobName() {
		return jobName;
	}

	public static void setJobName(String jobName) {
		HealthcareParserFields.jobName = jobName;
	}

	public static String getDirPath() {
		return dirPath;
	}

	public static void setDirPath(String dirPath) {
		HealthcareParserFields.dirPath = dirPath;
	}

	public static MultipartFile[] getFile() {
		return file;
	}

	public static void setFile(MultipartFile[] file) {
		HealthcareParserFields.file = file;
	}

	public static String getTargetFileType() {
		return targetFileType;
	}

	public static void setTargetFileType(String targetFileType) {
		HealthcareParserFields.targetFileType = targetFileType;
	}
}
