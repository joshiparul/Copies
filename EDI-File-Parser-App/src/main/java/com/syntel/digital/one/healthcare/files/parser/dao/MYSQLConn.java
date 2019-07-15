package com.syntel.digital.one.healthcare.files.parser.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.syntel.digital.one.healthcare.files.parser.constants.MetaConstants;

public class MYSQLConn {

	public static Connection Conn() throws SQLException,
			ClassNotFoundException {

		/* For Creating Connection object of MySQL database */
		Class.forName(MetaConstants.getMysqlDriverName());
		Connection conn = DriverManager.getConnection(
				MetaConstants.getMysqlClusterurl(), MetaConstants.getMysqlUserName(), MetaConstants.getMysqlPassword());

		return conn;
	}

}
