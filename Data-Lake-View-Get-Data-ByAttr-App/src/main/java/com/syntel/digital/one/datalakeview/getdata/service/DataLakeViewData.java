package com.syntel.digital.one.datalakeview.getdata.service;

import java.util.ArrayList;

import org.json.JSONException;

import com.syntel.digital.one.datalakeview.getdata.dto.ResponseDTO;

public interface DataLakeViewData {

	public ArrayList<ResponseDTO> getRecords(String tags, String tag2) throws JSONException, Exception;

}
