package com.syntel.digital.one.datalakeview.getdata.daoImpl;

import java.util.ArrayList;

import com.syntel.digital.one.datalakeview.getdata.dao.DatabaseIO;
import com.syntel.digital.one.datalakeview.getdata.dto.ResponseDTO;
import com.syntel.digital.one.datalakeview.getdata.service.DataLakeViewData;

public class DataLakeViewDataDaoImpl implements DataLakeViewData {

	public ArrayList<ResponseDTO> getRecordsByFilter(String tag3) throws Exception {

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();
		al = DatabaseIO.getDataByFilter(tag3);

		return al;
	}
	
	public ArrayList<ResponseDTO> getRecordsByFormatFilter(String tags, String tag3) throws Exception {

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();
		al = DatabaseIO.getDataByFormatFilter(tags, tag3);

		return al;
	}
	
	public ArrayList<ResponseDTO> getRecords(String tag2, String tag3) throws Exception {

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();
		al = DatabaseIO.getData(tag2, tag3);

		return al;
	}

	public ArrayList<ResponseDTO> getRecordsByAllFilter(String tags, String tag2, String tag3) throws Exception {

		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();
		al = DatabaseIO.getDataByAllFilter(tags, tag2, tag3);

		return al;
	}
	
//	public ArrayList<ResponseDTO> getRecordsforSecondFilter_one(String tag4) throws Exception {
//
//		ArrayList<ResponseDTO> al = new ArrayList<ResponseDTO>();
//		al = DatabaseIO.getDataForSecondFilter(tag4);
//
//		return al;
//	}

}
