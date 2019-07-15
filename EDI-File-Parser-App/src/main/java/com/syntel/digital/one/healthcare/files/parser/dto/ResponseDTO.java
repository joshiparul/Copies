package com.syntel.digital.one.healthcare.files.parser.dto;

public class ResponseDTO {
	
	private boolean status;
	private String output;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}
