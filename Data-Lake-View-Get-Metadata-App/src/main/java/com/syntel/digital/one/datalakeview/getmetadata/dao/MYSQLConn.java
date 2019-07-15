package com.syntel.digital.one.datalakeview.getmetadata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.syntel.digital.one.datalakeview.getmetadata.constants.Constants;

public class MYSQLConn {

	public static Connection Conn() throws SQLException,
			ClassNotFoundException {

		/* For Creating Connection object of MySQL database */
		Class.forName(Constants.getMysqlJDBCDriver());
		Connection conn = DriverManager.getConnection(
				Constants.getMysqlJDBCHost(), Constants.getMysqlHost(), Constants.getMysqlPassword());

		return conn;
	}
}
