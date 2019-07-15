package com.syntel.digital.one.datalakeview.getmetadata.daoImpl;

import java.util.List;

public class SolrResult {
	public Response response;
}

class Response {
	public int numFound;
	public int start;
	public List<Doc> docs;
}

class Doc {
	public String tablename;
	public String storage;
	public String tags;
}