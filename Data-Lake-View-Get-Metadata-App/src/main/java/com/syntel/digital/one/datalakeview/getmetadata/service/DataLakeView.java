package com.syntel.digital.one.datalakeview.getmetadata.service;

import java.util.List;
import org.json.JSONException;
import com.syntel.digital.one.datalakeview.getmetadata.constants.dataPOJO;

public interface DataLakeView {
	
	public List<dataPOJO> extractMetadata(String tablename)
			throws JSONException, Exception;
			
	
}
