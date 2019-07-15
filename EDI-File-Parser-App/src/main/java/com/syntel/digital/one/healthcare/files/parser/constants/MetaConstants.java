package com.syntel.digital.one.healthcare.files.parser.constants;

public class MetaConstants {

	public static String mysqlClusterurl = "jdbc:mysql://10.119.32.97:3306/Healthcare_Parser";
	public static String mysqlDriverName = "com.mysql.jdbc.Driver";
	public static String mysqlUserName = "root";
	public static String mysqlPassword = "";
	
	public static String getMysqlClusterurl() {
		return mysqlClusterurl;
	}
	public static void setMysqlClusterurl(String mysqlClusterurl) {
		MetaConstants.mysqlClusterurl = mysqlClusterurl;
	}
	public static String getMysqlDriverName() {
		return mysqlDriverName;
	}
	public static void setMysqlDriverName(String mysqlDriverName) {
		MetaConstants.mysqlDriverName = mysqlDriverName;
	}
	
	public static String getMysqlUserName() {
		return mysqlUserName;
	}
	public static void setMysqlUserName(String mysqlUserName) {
		MetaConstants.mysqlUserName = mysqlUserName;
	}
	
	public static String getMysqlPassword() {
		return mysqlPassword;
	}
	public static void setMysqlPassword(String mysqlPassword) {
		MetaConstants.mysqlPassword = mysqlPassword;
	}
	
}
