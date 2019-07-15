package com.syntel.digital.one.datalakeview.getdata.dto;

public class ResponseTableDTO {

	private String tablename;
	private String LOCATION;
	private String TBL_OWNER;
	private String DB_NAME;
	private String TBL_TYPE;
	private String COLUMN_NAMES;

	private String DB_OWNER_NAME;
	private String OWNER_TYPE;
	private String TBL_LAST_ACCESS_TIME;
	private String INPUT_FORMAT;
	private String TBL_CREATE_TIME;
	private String COLUMN_NAME;
	private String IS_STOREDASSUBDIRECTORIES;
	private String DB_LOCATION_URI;
	private String IS_COMPRESSED;
	private String OUTPUT_FORMAT;
	private String TBL_RETENTION;
	private String id;
	private String TYPE_NAME;
	private String _version_;

	// public ResponseTableDTO(String tablename,String LOCATION,String
	// TBL_OWNER,String DB_NAME,String TBL_TYPE,String COLUMN_NAMES)
	// {
	//
	// super();
	// this.tablename=tablename;
	// this.LOCATION=LOCATION;
	// this.TBL_OWNER=TBL_OWNER;
	// this.DB_NAME=DB_NAME;
	// this.TBL_TYPE=TBL_TYPE;
	// this.COLUMN_NAMES=COLUMN_NAMES;
	//
	// }

	public String getTablename() {
		return tablename;
	}

	@Override
	public String toString() {
		return "ResponseTableDTO [tablename=" + tablename + ", LOCATION=" + LOCATION + ", TBL_OWNER=" + TBL_OWNER
				+ ", DB_NAME=" + DB_NAME + ", TBL_TYPE=" + TBL_TYPE + ", COLUMN_NAMES=" + COLUMN_NAMES
				+ ", DB_OWNER_NAME=" + DB_OWNER_NAME + ", OWNER_TYPE=" + OWNER_TYPE + ", TBL_LAST_ACCESS_TIME="
				+ TBL_LAST_ACCESS_TIME + ", INPUT_FORMAT=" + INPUT_FORMAT + ", TBL_CREATE_TIME=" + TBL_CREATE_TIME
				+ ", COLUMN_NAME=" + COLUMN_NAME + ", IS_STOREDASSUBDIRECTORIES=" + IS_STOREDASSUBDIRECTORIES
				+ ", DB_LOCATION_URI=" + DB_LOCATION_URI + ", IS_COMPRESSED=" + IS_COMPRESSED + ", OUTPUT_FORMAT="
				+ OUTPUT_FORMAT + ", TBL_RETENTION=" + TBL_RETENTION + ", id=" + id + ", TYPE_NAME=" + TYPE_NAME
				+ ", _version_=" + _version_ + "]";
	}

	public String getDB_OWNER_NAME() {
		return DB_OWNER_NAME;
	}

	public void setDB_OWNER_NAME(String dB_OWNER_NAME) {
		DB_OWNER_NAME = dB_OWNER_NAME;
	}

	public String getOWNER_TYPE() {
		return OWNER_TYPE;
	}

	public void setOWNER_TYPE(String oWNER_TYPE) {
		OWNER_TYPE = oWNER_TYPE;
	}

	public String getTBL_LAST_ACCESS_TIME() {
		return TBL_LAST_ACCESS_TIME;
	}

	public void setTBL_LAST_ACCESS_TIME(String tBL_LAST_ACCESS_TIME) {
		TBL_LAST_ACCESS_TIME = tBL_LAST_ACCESS_TIME;
	}

	public String getINPUT_FORMAT() {
		return INPUT_FORMAT;
	}

	public void setINPUT_FORMAT(String iNPUT_FORMAT) {
		INPUT_FORMAT = iNPUT_FORMAT;
	}

	public String getTBL_CREATE_TIME() {
		return TBL_CREATE_TIME;
	}

	public void setTBL_CREATE_TIME(String tBL_CREATE_TIME) {
		TBL_CREATE_TIME = tBL_CREATE_TIME;
	}

	public String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}

	public void setCOLUMN_NAME(String cOLUMN_NAME) {
		COLUMN_NAME = cOLUMN_NAME;
	}

	public String getIS_STOREDASSUBDIRECTORIES() {
		return IS_STOREDASSUBDIRECTORIES;
	}

	public void setIS_STOREDASSUBDIRECTORIES(String iS_STOREDASSUBDIRECTORIES) {
		IS_STOREDASSUBDIRECTORIES = iS_STOREDASSUBDIRECTORIES;
	}

	public String getDB_LOCATION_URI() {
		return DB_LOCATION_URI;
	}

	public void setDB_LOCATION_URI(String dB_LOCATION_URI) {
		DB_LOCATION_URI = dB_LOCATION_URI;
	}

	public String getIS_COMPRESSED() {
		return IS_COMPRESSED;
	}

	public void setIS_COMPRESSED(String iS_COMPRESSED) {
		IS_COMPRESSED = iS_COMPRESSED;
	}

	public String getOUTPUT_FORMAT() {
		return OUTPUT_FORMAT;
	}

	public void setOUTPUT_FORMAT(String oUTPUT_FORMAT) {
		OUTPUT_FORMAT = oUTPUT_FORMAT;
	}

	public String getTBL_RETENTION() {
		return TBL_RETENTION;
	}

	public void setTBL_RETENTION(String tBL_RETENTION) {
		TBL_RETENTION = tBL_RETENTION;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}

	public String get_version_() {
		return _version_;
	}

	public void set_version_(String _version_) {
		this._version_ = _version_;
	}

	public ResponseTableDTO(String tablename, String lOCATION, String tBL_OWNER, String dB_NAME, String tBL_TYPE,
			String cOLUMN_NAMES, String dB_OWNER_NAME, String oWNER_TYPE, String tBL_LAST_ACCESS_TIME,
			String iNPUT_FORMAT, String tBL_CREATE_TIME, String cOLUMN_NAME, String iS_STOREDASSUBDIRECTORIES,
			String dB_LOCATION_URI, String iS_COMPRESSED, String oUTPUT_FORMAT, String tBL_RETENTION, String id,
			String tYPE_NAME, String _version_) {
		super();
		this.tablename = tablename;
		LOCATION = lOCATION;
		TBL_OWNER = tBL_OWNER;
		DB_NAME = dB_NAME;
		TBL_TYPE = tBL_TYPE;
		COLUMN_NAMES = cOLUMN_NAMES;
		DB_OWNER_NAME = dB_OWNER_NAME;
		OWNER_TYPE = oWNER_TYPE;
		TBL_LAST_ACCESS_TIME = tBL_LAST_ACCESS_TIME;
		INPUT_FORMAT = iNPUT_FORMAT;
		TBL_CREATE_TIME = tBL_CREATE_TIME;
		COLUMN_NAME = cOLUMN_NAME;
		IS_STOREDASSUBDIRECTORIES = iS_STOREDASSUBDIRECTORIES;
		DB_LOCATION_URI = dB_LOCATION_URI;
		IS_COMPRESSED = iS_COMPRESSED;
		OUTPUT_FORMAT = oUTPUT_FORMAT;
		TBL_RETENTION = tBL_RETENTION;
		this.id = id;
		TYPE_NAME = tYPE_NAME;
		this._version_ = _version_;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getTBL_OWNER() {
		return TBL_OWNER;
	}

	public void setTBL_OWNER(String tBL_OWNER) {
		TBL_OWNER = tBL_OWNER;
	}

	public String getDB_NAME() {
		return DB_NAME;
	}

	public void setDB_NAME(String dB_NAME) {
		DB_NAME = dB_NAME;
	}

	public String getTBL_TYPE() {
		return TBL_TYPE;
	}

	public void setTBL_TYPE(String tBL_TYPE) {
		TBL_TYPE = tBL_TYPE;
	}

	public String getCOLUMN_NAMES() {
		return COLUMN_NAMES;
	}

	public void setCOLUMN_NAMES(String cOLUMN_NAMES) {
		COLUMN_NAMES = cOLUMN_NAMES;
	}

}
