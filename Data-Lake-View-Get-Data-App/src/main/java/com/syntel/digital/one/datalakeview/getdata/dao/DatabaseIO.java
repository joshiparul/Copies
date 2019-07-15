package com.syntel.digital.one.datalakeview.getdata.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseIO {
	
	public static HashMap<String, String> getData(String tags)
			throws ClassNotFoundException, SQLException {

		HashMap<String,String> bgView = new HashMap<String,String>();
		
		Connection conn = MYSQLConn.Conn();

		String getDataStorequery = "select Table_name,DataStore from bg_view where Table_name LIKE "
				+ "\"" + "%" +tags+ "%" + "\"";
		System.out.println("Query ::::::::: " + getDataStorequery);
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(getDataStorequery);
		while (rs.next()) {
			
			bgView.put(rs.getString("Table_name"), rs.getString("DataStore"));
		}
		
		return bgView;
	}
	public static HashMap<String, String> getEachData(String tag2)
			throws ClassNotFoundException, SQLException {

		HashMap<String,String> bgView = new HashMap<String,String>();
		
		Connection conn = MYSQLConn.Conn();

//		String getDataStorequery = "select Table_name,DataStore from bg_view where Table_name LIKE "
//				+ "\"" + "%" +tags+ "%" + "\"";
		String filterQuery = "select Table_name,DataStore from bg_view where DataStore = '"+tag2+"'";
		System.out.println("Query ::::::::: " + filterQuery);
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(filterQuery);
		while (rs.next()) {
			
			bgView.put(rs.getString("Table_name"), rs.getString("DataStore"));
		}
		
		return bgView;
	}
	public static HashMap<String, String> getMixedData(String tags , String tag2)
			throws ClassNotFoundException, SQLException {

		HashMap<String,String> bgView = new HashMap<String,String>();
		
		Connection conn = MYSQLConn.Conn();

//		String getDataStorequery = "select Table_name,DataStore from bg_view where Table_name LIKE "
//				+ "\"" + "%" +tags+ "%" + "\"";
		String filterQuery = "select Table_name,DataStore from bg_view where DataStore = '"+tags+"' and Table_name LIKE '%"+tag2+"%'";
		System.out.println("Query ::::::::: " + filterQuery);
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(filterQuery);
		while (rs.next()) {
			
			bgView.put(rs.getString("Table_name"), rs.getString("DataStore"));
		}
		
		return bgView;
	}
}
