package com.syntel.healthcare.files.upload.hadoop.mongodb.service.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.syntel.healthcare.files.upload.hadoop.mongodb.service.constants.Constants;

public class MetaDataDao {

	public static java.sql.Connection Conn() throws SQLException,
			ClassNotFoundException {

		/* For Creating Connection object of MySQL database */
		Class.forName(Constants.getMysqlDriverName());
		java.sql.Connection conn = DriverManager.getConnection(
				Constants.getMysqlHostUrl(), Constants.getMysqlUserId(), Constants.getMysqlUserPwd());

		return conn;
	}
}
