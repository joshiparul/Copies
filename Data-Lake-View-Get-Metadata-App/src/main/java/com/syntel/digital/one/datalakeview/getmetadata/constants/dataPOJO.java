package com.syntel.digital.one.datalakeview.getmetadata.constants;

public class dataPOJO {

	// HDFS parameters
	private String filename;
	private String owner;
	private String permissions;
	private String modification_time;
	private String access_time;
	private String size;
	private String replicas;
	private String storage;

	// Hive Parameters
	private String LOCATION;
	private String TBL_OWNER;
	private String DB_NAME;
	private String TBL_TYPE;
	private String COLUMN_NAMES;
	private String TBL_SIZE;
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
	private String NUM_BUCKETS;

	// HBase parameters
	private String table_name;
	private String column_family;
	private String qualifiers;
	private String time_s;
	
	public String getReplicas() {
		return replicas;
	}

	public void setReplicas(String replicas) {
		this.replicas = replicas;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getModification_time() {
		return modification_time;
	}

	public void setModification_time(String modification_time) {
		this.modification_time = modification_time;
	}

	public String getAccess_time() {
		return access_time;
	}

	public void setAccess_time(String access_time) {
		this.access_time = access_time;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
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

	public String getTBL_SIZE() {
		return TBL_SIZE;
	}

	public void setTBL_SIZE(String tBL_SIZE) {
		TBL_SIZE = tBL_SIZE;
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

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getColumn_family() {
		return column_family;
	}

	public void setColumn_family(String column_family) {
		this.column_family = column_family;
	}

	public String getQualifiers() {
		return qualifiers;
	}

	public void setQualifiers(String qualifiers) {
		this.qualifiers = qualifiers;
	}

	public String getTime_s() {
		return time_s;
	}

	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}

	public String getNUM_BUCKETS() {
		return NUM_BUCKETS;
	}

	public void setNUM_BUCKETS(String nUM_BUCKETS) {
		NUM_BUCKETS = nUM_BUCKETS;
	}
}
