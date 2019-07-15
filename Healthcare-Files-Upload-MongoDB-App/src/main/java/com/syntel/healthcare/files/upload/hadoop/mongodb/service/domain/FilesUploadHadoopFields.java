package com.syntel.healthcare.files.upload.hadoop.mongodb.service.domain;

public class FilesUploadHadoopFields {

	private String JobName;
	private String clusterIP;
	private String mongocollecname;

	public String getJobName() {
		return JobName;
	}

	public void setJobName(String jobName) {
		JobName = jobName;
	}

	public String getClusterIP() {
		return clusterIP;
	}

	public void setClusterIP(String clusterIP) {
		this.clusterIP = clusterIP;
	}

	public String getMongocollecname() {
		return mongocollecname;
	}

	public void setMongocollecname(String mongocollecname) {
		this.mongocollecname = mongocollecname;
	}

}
