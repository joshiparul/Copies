package com.syntel.digital.one.datalakeview.getdata.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.syntel.digital.one.datalakeview.getdata.daoImpl.DataLakeViewDataDaoImpl;
import com.syntel.digital.one.datalakeview.getdata.dto.ResponseDTO;

@RestController
@RequestMapping(value = "/DataLakeView/")
public class DataLakeViewDataController {
	
	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getDataByAttr/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractDataByAttr(@RequestParam("tag3") String tag3)
			throws Exception {

		System.out.println("tag3 ::" + tag3);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getRecordsByFilter(tag3);

		System.out.println(al.size());
		return ResponseEntity.ok().body(al);

	}
	
	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getDataBySearch/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractDataBySearch(@RequestParam("tags") String tags,
			@RequestParam("tag3") String tag3) throws Exception {

		System.out.println("tag3 ::" + tag3 + "tags ::" + tags);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getRecordsByFormatFilter(tags, tag3);

		System.out.println(al.size());
		return ResponseEntity.ok().body(al);

	}
	
	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getData_Name/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractText(@RequestParam("tag2") String tag2,
			@RequestParam("tag3") String tag3) throws Exception {

		System.out.println("tag2 :: " + tag2 + "tag3 ::" + tag3);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getRecords(tag2, tag3);
		
		System.out.println(al.size());
		return ResponseEntity.ok().body(al);

	}

	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getData_FilterName/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractText_Attr(@RequestParam("tags") String tags, @RequestParam("tag2") String tag2,
			 @RequestParam("tag3") String tag3) throws Exception {

		System.out.println("tag2 :: " + tag2 + "tag3 ::" + tag3 + "tags ::" + tags);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getRecordsByAllFilter(tags, tag2, tag3);
		
		System.out.println(al.size());
		return ResponseEntity.ok().body(al);

	}
	
//	@CrossOrigin(value = "http://127.0.0.1:8888")
//	@RequestMapping(value = "/secondStageFilter/", method = RequestMethod.GET)
//	public ResponseEntity<ArrayList<ResponseDTO>> furtherFilter(@RequestParam("tag4") String tag4) throws Exception {
//
//		System.out.println("tags ::" + tag4);
//		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
//		ArrayList<ResponseDTO> al = dl.getRecordsforSecondFilter_one(tag4);
//		
//		System.out.println(al.size());
//		return ResponseEntity.ok().body(al);
//
//	}
}
