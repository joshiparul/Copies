package com.syntel.healthcare.files.upload.hadoop.mongodb.service.constants;


public class Constants {

	private static String mysqlDriverName="com.mysql.jdbc.Driver";
	private static String mysqlHostUrl="jdbc:mysql://10.119.32.97:3306/Healthcare_Parser";
	private static String mysqlUserId="root";
	private static String mysqlUserPwd="";
	private static String sourceScriptPath="/root/HealthcareParseDocker/OutputFiles/";
	
	public static String getMysqlDriverName() {
		return mysqlDriverName;
	}
	public static void setMysqlDriverName(String mysqlDriverName) {
		Constants.mysqlDriverName = mysqlDriverName;
	}
	public static String getMysqlHostUrl() {
		return mysqlHostUrl;
	}
	public static void setMysqlHostUrl(String mysqlHostUrl) {
		Constants.mysqlHostUrl = mysqlHostUrl;
	}
	public static String getMysqlUserId() {
		return mysqlUserId;
	}
	public static void setMysqlUserId(String mysqlUserId) {
		Constants.mysqlUserId = mysqlUserId;
	}
	public static String getMysqlUserPwd() {
		return mysqlUserPwd;
	}
	public static void setMysqlUserPwd(String mysqlUserPwd) {
		Constants.mysqlUserPwd = mysqlUserPwd;
	}
	public static String getSourceScriptPath() {
		return sourceScriptPath;
	}
	public static void setSourceScriptPath(String sourceScriptPath) {
		Constants.sourceScriptPath = sourceScriptPath;
	}		
	
}
