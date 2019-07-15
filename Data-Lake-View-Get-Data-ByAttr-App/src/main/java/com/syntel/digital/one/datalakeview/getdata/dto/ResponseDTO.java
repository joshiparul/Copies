package com.syntel.digital.one.datalakeview.getdata.dto;

public class ResponseDTO {

	private String attrName;
	private String ownerName;
	private String tableName;
	private String size;
	private String storage;
		
	public ResponseDTO(String attrName,String ownerName, String tableName, String size, String storage) {
		super();
		this.attrName = attrName;
		this.ownerName = ownerName;
		this.tableName = tableName;
		this.size = size;
		this.storage = storage;
	}
	
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}
	
	

}
