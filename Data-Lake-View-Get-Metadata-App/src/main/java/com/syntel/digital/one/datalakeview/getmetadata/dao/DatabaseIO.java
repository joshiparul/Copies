package com.syntel.digital.one.datalakeview.getmetadata.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.syntel.digital.one.datalakeview.getmetadata.constants.dataPOJO;

public class DatabaseIO {

	public static String getData(String tableName)
			throws ClassNotFoundException, SQLException {

		String dataStore = null;

		Connection conn = MYSQLConn.Conn();

		String getDataStorequery = "select DataStore from bg_view where Table_name = "
				+ "\"" + tableName + "\"";
		System.out.println("Query ::::::::: " + getDataStorequery);
		java.sql.Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(getDataStorequery);
		while (rs.next()) {

			dataStore = rs.getString("DataStore");
		}

		return dataStore;
	}

	public static List<dataPOJO> getTableMeta(String tableName, String dataStore)
			throws SQLException, ClassNotFoundException {

		List<dataPOJO> tableMetaData = new ArrayList<dataPOJO>();
		
		String DB_NAME;
		String DB_OWNER_NAME;   
		String DB_LOCATION_URI; 
		String TBL_NAME;
		String TBL_SIZE;
		String TBL_OWNER;     
		String CREATE_TIME;   
		String INPUT_FORMAT;  
		String LOCATION; 
		String NUM_BUCKETS;  
		String OUTPUT_FORMAT; 
		String COLUMN_NAME;
		String TYPE_NAME;  
		String STORAGE;    
		String table_name;    
		String column_family; 
		String qualifiers;
		String time_s;
		String storage;
		String filename;   
		String location;  
		String owner;  
		String permissions;
		String replicas; 
		String modification_time;
		String access_time;
		String size;
		
		Connection conn = MYSQLConn.Conn();

		if (dataStore.equalsIgnoreCase("Hive")) {

			String gettablemetaquery = "select * from HIVE where TBL_NAME = "
					+ "\"" + tableName + "\"";
			System.out.println("Query ::::::::: " + gettablemetaquery);
			java.sql.Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(gettablemetaquery);
			while (rs.next()) {
				dataPOJO dp = new dataPOJO();
				
				DB_NAME = rs.getString("DB_NAME");
				DB_OWNER_NAME = rs.getString("DB_OWNER_NAME");  
				DB_LOCATION_URI = rs.getString("DB_LOCATION_URI");
				TBL_NAME = rs.getString("TBL_NAME");
				TBL_SIZE = rs.getString("TBL_SIZE");
				TBL_OWNER = rs.getString("TBL_OWNER");
				CREATE_TIME = rs.getString("CREATE_TIME");
				INPUT_FORMAT = rs.getString("INPUT_FORMAT");
				LOCATION = rs.getString("LOCATION");
				NUM_BUCKETS = rs.getString("NUM_BUCKETS");
				OUTPUT_FORMAT = rs.getString("OUTPUT_FORMAT");
				COLUMN_NAME = rs.getString("COLUMN_NAME");
				TYPE_NAME = rs.getString("TYPE_NAME");
				STORAGE = rs.getString("STORAGE");

				dp.setDB_NAME(DB_NAME);
				dp.setDB_OWNER_NAME(DB_OWNER_NAME);
				dp.setDB_LOCATION_URI(DB_LOCATION_URI);
				dp.setTable_name(TBL_NAME);
				dp.setTBL_SIZE(TBL_SIZE);
				dp.setTBL_OWNER(TBL_OWNER);
				dp.setTBL_CREATE_TIME(CREATE_TIME);
				dp.setINPUT_FORMAT(INPUT_FORMAT);
				dp.setLOCATION(LOCATION);
				dp.setNUM_BUCKETS(NUM_BUCKETS);
				dp.setOUTPUT_FORMAT(OUTPUT_FORMAT);
				dp.setCOLUMN_NAME(COLUMN_NAME);
				dp.setTYPE_NAME(TYPE_NAME);
				dp.setStorage(STORAGE);
				
				tableMetaData.add(dp);
			}

		} else if (dataStore.equalsIgnoreCase("HBase")) {

			String gettablemetaquery = "select * from HBASE where table_name = "
					+ "\"" + tableName + "\"";
			System.out.println("Query ::::::::: " + gettablemetaquery);
			java.sql.Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(gettablemetaquery);
			while (rs1.next()) {
				dataPOJO dp = new dataPOJO();
				
				table_name = rs1.getString("table_name");
				column_family = rs1.getString("column_family");
				qualifiers = rs1.getString("qualifiers");
				time_s = rs1.getString("time_s");
				storage = rs1.getString("storage");
				
				dp.setTable_name(table_name);
				dp.setColumn_family(column_family);
				dp.setQualifiers(qualifiers);
				dp.setTime_s(time_s);
				dp.setStorage(storage);

				tableMetaData.add(dp);
			}

		} else {

			String gettablemetaquery = "select * from HDFS where filename = "
					+ "\"" + tableName + "\"";
			System.out.println("Query ::::::::: " + gettablemetaquery);
			java.sql.Statement st2 = conn.createStatement();
			ResultSet rs2 = st2.executeQuery(gettablemetaquery);
			while (rs2.next()) {
				dataPOJO dp = new dataPOJO();
				
				filename = rs2.getString("filename");
				location = rs2.getString("location");
				owner = rs2.getString("owner");
				permissions = rs2.getString("permissions");
				modification_time = rs2.getString("modification_time");
				access_time = rs2.getString("access_time");
				size = rs2.getString("size");
				replicas = rs2.getString("replicas");
				storage = rs2.getString("storage");
				
				dp.setFilename(filename);
				dp.setLOCATION(location);
				dp.setOwner(owner);
				dp.setPermissions(permissions);
				dp.setModification_time(modification_time);
				dp.setAccess_time(access_time);
				dp.setSize(size);
				dp.setReplicas(replicas);
				dp.setStorage(storage);
				
				tableMetaData.add(dp);
			}

		}

		conn.close();

		return tableMetaData;
	}
}
