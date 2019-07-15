package com.syntel.digital.one.datalakeview.getdata.daoImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntel.digital.one.datalakeview.getdata.dao.DatabaseIO;
import com.syntel.digital.one.datalakeview.getdata.dto.ResponseDTO;
import com.syntel.digital.one.datalakeview.getdata.service.DataLakeViewData;

public class DataLakeViewDataDaoImpl implements DataLakeViewData {

	/*
	 * public ArrayList<ResponseDTO> getRecords(String tags) throws JSONException,
	 * Exception { ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>(); String
	 * url = "http://10.119.32.82:8983/solr/bview/select?q=tags:*" + tags +
	 * "*&rows=1000&start=0&wt=json";
	 * 
	 * // URL url = new // URL(
	 * "http://10.119.32.97:8983/solr/bview/select?q=tags:*test*&rows=1000&start=0&wt=json"
	 * );
	 * 
	 * JSONObject json = new JSONObject(readUrl(url)); JSONObject resp =
	 * (JSONObject) json.get("response"); JSONArray docs =
	 * resp.getJSONArray("docs");
	 * 
	 * for (int i = 0; i < docs.length(); i++) {
	 * 
	 * JSONObject rec = docs.getJSONObject(i); Object value1 = rec.get("tablename");
	 * Object value = rec.get("storage"); String a = value.toString().replace("\"",
	 * ""); a = a.replace("[", ""); a = a.replace("]", ""); al.add(new
	 * ResponseDTO(value1.toString(), a)); // System.out.println("a1:::::::::"+al);
	 * // do whatever you want to do } return al; }
	 */

	public ArrayList<ResponseDTO> getRecords(String tags) throws JSONException, Exception {

		HashMap<String, String> bgView = new HashMap<String, String>();

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();

		bgView = DatabaseIO.getData(tags);

		for (String key : bgView.keySet()) {

			al.add(new ResponseDTO(key, bgView.get(key)));
		}

		return al;
	}

	private static String readUrl(String urlString) throws Exception {
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
	}

	public ArrayList<ResponseDTO> getFilterData(String tag2) throws JSONException, Exception {

		HashMap<String, String> bgView = new HashMap<String, String>();

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();

		bgView = DatabaseIO.getEachData(tag2);

		for (String key : bgView.keySet()) {

			al.add(new ResponseDTO(key, bgView.get(key)));
		}

		return al;
	}
	public ArrayList<ResponseDTO> getExtraFilterData(String tags , String tag2) throws JSONException, Exception {

		HashMap<String, String> bgView = new HashMap<String, String>();

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();

		bgView = DatabaseIO.getMixedData(tags, tag2);

		for (String key : bgView.keySet()) {

			al.add(new ResponseDTO(key, bgView.get(key)));
		}

		return al;
	}
}
