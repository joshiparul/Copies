package com.syntel.digital.one.healthcare.files.parser.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.syntel.digital.one.healthcare.files.parser.constants.MetaConstants;

public class DatabaseIO {

	public static java.sql.Connection Conn() throws SQLException, ClassNotFoundException {

		/* For Creating Connection object of MySQL database */
		Class.forName(MetaConstants.getMysqlDriverName());
		java.sql.Connection conn = DriverManager.getConnection(MetaConstants.getMysqlClusterurl(),
				MetaConstants.getMysqlUserName(), MetaConstants.getMysqlPassword());

		return conn;
	}

	public static void fileMetaLoad(String jobName, String srcFileType, String tgtFileType, int fileCount,
			String timeStamp) throws ClassNotFoundException, SQLException {

		java.sql.Connection conn = Conn();
		String id_query = "select Max(jobId) from HP_Parsed_Files_Metadata";
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(id_query);
		System.out.println("resultset " + rs);
		int id = 0;
		while (rs.next()) {
			id = rs.getInt("Max(jobId)");
		}
		id = id + 1;
		String query = "Insert into HP_Parsed_Files_Metadata values( " + id + " ," + "\"" + jobName + "\"" + "," + "\""
				+ srcFileType + "\"" + " ," + "\"" + tgtFileType + "\"" + " , " + fileCount + " , " + "\"" + timeStamp
				+ "\"" + "," + "\"" + "File Parsed Successfully!!!!!" + "\"" + ");";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.executeUpdate();
		conn.close();
	}

	public static void fileLoad(String jobName, String fileName) throws ClassNotFoundException, SQLException {

		java.sql.Connection conn = Conn();
		String query = "Insert into HP_File_List values( " + "\"" + jobName + "\"" + "," + "\"" + fileName + "\""
				+ ");";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.executeUpdate();
		conn.close();
	}
}
