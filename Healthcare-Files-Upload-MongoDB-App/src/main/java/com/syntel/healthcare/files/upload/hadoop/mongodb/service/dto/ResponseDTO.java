package com.syntel.healthcare.files.upload.hadoop.mongodb.service.dto;



public class ResponseDTO {

	private boolean status;
	private String message;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
