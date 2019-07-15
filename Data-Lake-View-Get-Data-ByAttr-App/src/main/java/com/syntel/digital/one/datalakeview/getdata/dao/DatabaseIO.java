package com.syntel.digital.one.datalakeview.getdata.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.syntel.digital.one.datalakeview.getdata.dto.ResponseDTO;

public class DatabaseIO {
	
	public static ArrayList<ResponseDTO> getDataByFilter(String tag3) throws ClassNotFoundException, SQLException {

		ArrayList<ResponseDTO> bgView = new ArrayList<ResponseDTO>();
		Connection conn = MYSQLConn.Conn();
		
		if (tag3.equalsIgnoreCase("Attribute_Name")) {
			
			String getDataStorequery = "select AttrName, TableName, Storage from bg_attributes";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(rs.getString("AttrName"), null, rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		} else if (tag3.equalsIgnoreCase("Owner")) {
			
			String getDataStorequery = "select OwnerName, TableName, Storage from bg_owner_size";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(null, rs.getString("OwnerName") , rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		} else {
//			String getDataStorequery = "select TableName, Size, Storage from bg_owner_size order by cast(Size as unsigned) desc";
			String getDataStorequery = "select Distinct TableName, Size, Storage from bg_owner_size";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(null, null, rs.getString("TableName"), rs.getString("Size"), rs.getString("Storage")));
			}

			return bgView;
		}
	}
	
	public static ArrayList<ResponseDTO> getDataByFormatFilter(String tags, String tag3) throws ClassNotFoundException, SQLException {

		ArrayList<ResponseDTO> bgView = new ArrayList<ResponseDTO>();
		Connection conn = MYSQLConn.Conn();

		if (tag3.equalsIgnoreCase("Attribute_Name")) {
			String getDataStorequery = "select AttrName, TableName, Storage from bg_attributes where AttrName LIKE '%"+tags+"%'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(rs.getString("AttrName"), null, rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		} else if (tag3.equalsIgnoreCase("Owner")) {
			String getDataStorequery = "select OwnerName, TableName, Storage from bg_owner_size where OwnerName LIKE '%"+tags+"%'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(null, rs.getString("OwnerName"), rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		}
		else {
//			String getDataStorequery = "select TableName, Size, Storage from bg_owner_size where TableName like '%"+tags+"%'  order by cast(Size as unsigned) desc";
			String getDataStorequery = "select Distinct TableName, Size, Storage from bg_owner_size where TableName like '%"+tags+"%'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(null, null, rs.getString("TableName"), rs.getString("Size"),rs.getString("Storage")));
			}
			return bgView;
		}
		
	}

	public static ArrayList<ResponseDTO> getData(String tag2, String tag3) throws ClassNotFoundException, SQLException {

		ArrayList<ResponseDTO> bgView = new ArrayList<ResponseDTO>();
		Connection conn = MYSQLConn.Conn();
		
		if (tag3.equalsIgnoreCase("Attribute_Name")) {
			
			String getDataStorequery = "select AttrName, TableName, Storage from bg_attributes where Storage = '" + tag2 + "'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(rs.getString("AttrName"), null, rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		} else if (tag3.equalsIgnoreCase("Owner")) {
			
			String getDataStorequery = "select OwnerName, TableName, Storage from bg_owner_size where Storage = '"+ tag2 +"'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO( null, rs.getString("OwnerName"), rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		} else {
//			String getDataStorequery = "select TableName, Size, Storage from bg_owner_size where Storage = '" + tag2 + "' order by cast(Size as unsigned) desc";
			String getDataStorequery = "select Distinct TableName, Size, Storage from bg_owner_size where Storage = '" + tag2 + "'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO( null, null, rs.getString("TableName"), rs.getString("Size"), rs.getString("Storage")));
			}
			return bgView;
		}		
	}

	public static ArrayList<ResponseDTO> getDataByAllFilter(String tags, String tag2, String tag3) throws ClassNotFoundException, SQLException {

		ArrayList<ResponseDTO> bgView = new ArrayList<ResponseDTO>();
		Connection conn = MYSQLConn.Conn();
		
		if (tag3.equalsIgnoreCase("Attribute_Name")) {
			String getDataStorequery = "select AttrName, TableName, Storage from bg_attributes where AttrName LIKE '%"+tags+"%' and Storage = '"+tag2+"'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(rs.getString("AttrName"), null, rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		} else if (tag3.equalsIgnoreCase("Owner")) {
			String getDataStorequery = "select OwnerName, TableName, Storage from bg_owner_size where OwnerName LIKE '%"+tags+"%' and  Storage = '"+tag2+"'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(null, rs.getString("OwnerName"), rs.getString("TableName"), null, rs.getString("Storage")));
			}
			return bgView;
			
		}else {
//			String getDataStorequery = "select TableName, Size, Storage from bg_owner_size where TableName like '%"+tags+"%' and  Storage = '"+tag2+"'  order by cast(Size as unsigned) desc";
			String getDataStorequery = "select Distinct TableName, Size, Storage from bg_owner_size where TableName like '%"+tags+"%' and  Storage = '"+tag2+"'";
			System.out.println("Query ::::::::: " + getDataStorequery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(getDataStorequery);
			while (rs.next()) {
				bgView.add(new ResponseDTO(null, null, rs.getString("TableName"), rs.getString("Size"),rs.getString("Storage")));
			}
			return bgView;
		}
	}
	
	
//	public static ArrayList<ResponseDTO> getDataForSecondFilter(String tag4) throws ClassNotFoundException, SQLException {
//
//		ArrayList<ResponseDTO> bgView = new ArrayList<ResponseDTO>();
//		Connection conn = MYSQLConn.Conn();
//		
//		String getDataStorequery = "select TableName, Size, Storage from bg_owner_size order by cast(Size as unsigned) desc";
//		System.out.println("Query ::::::::: " + getDataStorequery);
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery(getDataStorequery);
//		while (rs.next()) {
//			bgView.add(new ResponseDTO(null, null, rs.getString("TableName"), rs.getString("Size"),rs.getString("Storage")));
//		}
//		return bgView;
//	}
	
}
