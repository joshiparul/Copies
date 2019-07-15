package com.syntel.digital.one.datalakeview.getmetadata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.digital.one.datalakeview.getmetadata.constants.dataPOJO;
import com.syntel.digital.one.datalakeview.getmetadata.daoImpl.DataLakeViewDaoImpl;
import com.syntel.digital.one.datalakeview.getmetadata.dto.ResponseDTO;

@RestController
@RequestMapping(value = "/DataLakeView/")
public class DataLakeViewController {

	@CrossOrigin(value = "http://127.0.0.1:8888")
	@RequestMapping(value = "/getmetadata/", method = RequestMethod.GET)
	public ResponseDTO extractMetdata(@RequestParam("tablename") String tablename) {

		ResponseDTO responsedto = new ResponseDTO();
		DataLakeViewDaoImpl dl = new DataLakeViewDaoImpl();
		List<dataPOJO> al1 = new ArrayList<dataPOJO>();
		try {
			
			al1 = dl.extractMetadata(tablename);
			responsedto.setStatus(true);
			responsedto.setOutput(al1);
			
		} catch (Exception e) {
			e.printStackTrace();
			responsedto.setStatus(false);
		}
		
		return responsedto;
	}
	
	/*public ResponseEntity<ArrayList<ResponseTableDTO>> extractMetdata(@RequestParam("tablename") String tablename)
			throws Exception {

		DataLakeViewDaoImpl dl = new DataLakeViewDaoImpl();
		ArrayList<ResponseTableDTO> al1 = new ArrayList<ResponseTableDTO>();
		ArrayList<ResponseHbaseTableDTO> al2 = new ArrayList<ResponseHbaseTableDTO>();
		ArrayList<ResponseHDFSTableDTO> al3 = new ArrayList<ResponseHDFSTableDTO>();
		
		String dataStore = DatabaseIO.getData(tablename);
		
		if(dataStore.equalsIgnoreCase("Hive")){
			
			al1 = dl.extractHiveMetadata(tablename);
			
		} else if(dataStore.equalsIgnoreCase("HBase")){
			
			al2 = dl.extractHBaseMetadata(tablename);
			//return ResponseEntity.ok().body(al2);
			
		} else {
			
			al3 = dl.extractHDFSMetadata(tablename);
			//return ResponseEntity.ok().body(al3);
			
		}
		
		return ResponseEntity.ok().body(al1);
	}*/

}
