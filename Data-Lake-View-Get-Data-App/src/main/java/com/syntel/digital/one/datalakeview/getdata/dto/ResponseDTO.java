package com.syntel.digital.one.datalakeview.getdata.dto;

public class ResponseDTO {

	public ResponseDTO(String tableName, String type) {

		super();
		this.tableName = tableName;
		// this.tags = tags;
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/*
	 * public String getTags() { return tags; } public void setTags(String tags) {
	 * this.tags = tags; }
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String tableName;
	// private String tags;
	private String type;

}
