package com.syntel.digital.one.datalakeview.getmetadata.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import com.syntel.digital.one.datalakeview.getmetadata.constants.dataPOJO;
import com.syntel.digital.one.datalakeview.getmetadata.dao.DatabaseIO;
import com.syntel.digital.one.datalakeview.getmetadata.service.DataLakeView;

public class DataLakeViewDaoImpl implements DataLakeView {

	public List<dataPOJO> extractMetadata(String tablename)
			throws JSONException, Exception {
		List<dataPOJO> al1 = new ArrayList<dataPOJO>();
		
		String dataStore = DatabaseIO.getData(tablename);
		
		if(dataStore.equalsIgnoreCase("Hive")){
			
			al1 = DatabaseIO.getTableMeta(tablename, "Hive");
			
		} else if(dataStore.equalsIgnoreCase("HBase")){
			
			al1 = DatabaseIO.getTableMeta(tablename, "HBase");
			
		} else {
			
			al1 = DatabaseIO.getTableMeta(tablename, "HDFS");	
		}
		
		return al1;
	}

	/*public ArrayList<ResponseTableDTO> extractHiveMetadata(String tablename)
			throws JSONException, Exception {
		
		ArrayList<ResponseTableDTO> al1 = new ArrayList<ResponseTableDTO>();
		String url = "http://10.119.32.82:8983/solr/hivemeta/select?q=TBL_NAME:"
				+ tablename + "&rows=1000&start=0&wt=json";

		// URL url = new
		// URL("http://10.119.32.97:8983/solr/bview/select?q=tags:*test*&rows=1000&start=0&wt=json");

		JSONObject json = new JSONObject(readUrl(url));
		JSONObject resp = (JSONObject) json.get("response");
		JSONArray docs = resp.getJSONArray("docs");

		for (int i = 0; i < docs.length(); i++) {

			JSONObject rec = docs.getJSONObject(i);
			Object tname = rec.get("TBL_NAME");
			Object tlocation = rec.get("LOCATION");
			Object towner = rec.get("TBL_OWNER");
			Object dbname = rec.get("DB_NAME");
			Object ttype = rec.get("TBL_TYPE");
			Object tcolumns = rec.get("COLUMN_NAME");
			Object dbowner = rec.get("DB_OWNER_NAME");
			Object ownertype = rec.get("OWNER_TYPE");
			Object accesstm = rec.get("TBL_LAST_ACCESS_TIME");
			Object iformat = rec.get("INPUT_FORMAT");
			Object createt = rec.get("TBL_CREATE_TIME");
			Object cname = rec.get("COLUMN_NAME");
			Object subdir = rec.get("IS_STOREDASSUBDIRECTORIES");
			Object dblocuri = rec.get("DB_LOCATION_URI");
			Object compressed = rec.get("IS_COMPRESSED");
			Object oformat = rec.get("OUTPUT_FORMAT");
			Object retention = rec.get("TBL_RETENTION");
			Object id = rec.get("id");
			Object typenm = rec.get("TYPE_NAME");
			Object ver = rec.get("_version_");
			
			Object column_family = rec.get("column_family");
			Object qualifiers = rec.get("qualifiers");
			Object time_s = rec.get("time_s");
			Object storage = rec.get("storage");
			
			Object filename = rec.get("filename");
			Object location = rec.get("location");
			Object owner = rec.get("owner");
			Object permissions = rec.get("permissions");
			Object create_time = rec.get("create_time");
			Object size = rec.get("size");
			
			al1.add(new ResponseTableDTO(tname.toString(),
					tlocation.toString(), towner.toString(), dbname.toString(),
					ttype.toString(), tcolumns.toString(), dbowner.toString(),
					ownertype.toString(), accesstm.toString(), iformat
							.toString(), createt.toString(), cname.toString(),
					subdir.toString(), dblocuri.toString(), compressed
							.toString(), oformat.toString(), retention
							.toString(), id.toString(), typenm.toString(), ver
							.toString(),column_family.toString(),qualifiers.toString(),time_s.toString(),storage.toString(),filename.toString(),location.toString(),owner.toString(),permissions.toString(),create_time.toString(),size.toString()));
		}

		return al1;
		
	}*/
	
	/*public ArrayList<ResponseHbaseTableDTO> extractHBaseMetadata(String tablename)
			throws JSONException, Exception {
		ArrayList<ResponseHbaseTableDTO> al1 = new ArrayList<ResponseHbaseTableDTO>();
		String url = "http://10.119.32.82:8983/solr/hbasemeta/select?q=TBL_NAME:"
				+ tablename + "&rows=1000&start=0&wt=json";

		// URL url = new
		// URL("http://10.119.32.97:8983/solr/bview/select?q=tags:*test*&rows=1000&start=0&wt=json");

		JSONObject json = new JSONObject(readUrl(url));
		JSONObject resp = (JSONObject) json.get("response");
		JSONArray docs = resp.getJSONArray("docs");

		for (int i = 0; i < docs.length(); i++) {

			JSONObject rec = docs.getJSONObject(i);
			Object table_name = rec.get("table_name");
			Object column_family = rec.get("column_family");
			Object qualifiers = rec.get("qualifiers");
			Object time_s = rec.get("time_s");
			Object storage = rec.get("storage");
			
			al1.add(new ResponseHbaseTableDTO(table_name.toString(),column_family.toString(),qualifiers.toString(),time_s.toString(),storage.toString()));
		}

		return al1;
		
	}*/
	
	/*public ArrayList<ResponseHDFSTableDTO> extractHDFSMetadata(String tablename)
			throws JSONException, Exception {
		ArrayList<ResponseHDFSTableDTO> al1 = new ArrayList<ResponseHDFSTableDTO>();
		String url = "http://10.119.32.82:8983/solr/hdfsmeta/select?q=TBL_NAME:"
				+ tablename + "&rows=1000&start=0&wt=json";

		// URL url = new
		// URL("http://10.119.32.97:8983/solr/bview/select?q=tags:*test*&rows=1000&start=0&wt=json");

		JSONObject json = new JSONObject(readUrl(url));
		JSONObject resp = (JSONObject) json.get("response");
		JSONArray docs = resp.getJSONArray("docs");

		for (int i = 0; i < docs.length(); i++) {

			JSONObject rec = docs.getJSONObject(i);
			Object filename = rec.get("filename");
			Object location = rec.get("location");
			Object owner = rec.get("owner");
			Object permissions = rec.get("permissions");
			Object create_time = rec.get("create_time");
			Object size = rec.get("size");
			Object storage = rec.get("storage");
			al1.add(new ResponseHDFSTableDTO(filename.toString(),location.toString(),owner.toString(),permissions.toString(),create_time.toString(),size.toString(),storage.toString()));
		}

		return al1;
		
	}*/
	
	/*private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}*/
}
