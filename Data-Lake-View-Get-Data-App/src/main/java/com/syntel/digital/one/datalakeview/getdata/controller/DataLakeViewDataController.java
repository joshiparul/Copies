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
	@RequestMapping(value = "/getDatas/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractText(@RequestParam("tags") String tags) throws Exception {

		System.out.println("tags :: " + tags);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getRecords(tags);
		return ResponseEntity.ok().body(al);

	}
	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getDatabaseData/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractByDatabase(@RequestParam("tag2") String tag2) throws Exception {

		System.out.println("tags :: " + tag2);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getFilterData(tag2);
		return ResponseEntity.ok().body(al);

	}
	
	
	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getDatabaseFilter/", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ResponseDTO>> extractDataFilter(@RequestParam("tag2") String tag2, @RequestParam("tags") String tags) throws Exception {

		System.out.println("tags :: " + tags + "and tag2 :::" + tag2);
		DataLakeViewDataDaoImpl dl = new DataLakeViewDataDaoImpl();
		ArrayList<ResponseDTO> al = dl.getExtraFilterData(tag2 , tags);
		return ResponseEntity.ok().body(al);

	}	
}
