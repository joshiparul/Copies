package com.syntel.digital.one.datalakeview.getdata.constants;

public class Constants {

	private static String mysqlJDBCDriver = "com.mysql.jdbc.Driver";
	private static String mysqlJDBCHost = "jdbc:mysql://10.119.32.97:3306/DataLakeView";
	private static String mysqlHost = "root";
	private static String mysqlPassword = "";

	public static String getMysqlJDBCDriver() {
		return mysqlJDBCDriver;
	}

	public static void setMysqlJDBCDriver(String mysqlJDBCDriver) {
		Constants.mysqlJDBCDriver = mysqlJDBCDriver;
	}

	public static String getMysqlJDBCHost() {
		return mysqlJDBCHost;
	}

	public static void setMysqlJDBCHost(String mysqlJDBCHost) {
		Constants.mysqlJDBCHost = mysqlJDBCHost;
	}

	public static String getMysqlHost() {
		return mysqlHost;
	}

	public static void setMysqlHost(String mysqlHost) {
		Constants.mysqlHost = mysqlHost;
	}

	public static String getMysqlPassword() {
		return mysqlPassword;
	}

	public static void setMysqlPassword(String mysqlPassword) {
		Constants.mysqlPassword = mysqlPassword;
	}

}
