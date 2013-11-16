package com.bayan.sigaw.govdata.api.dao;

import java.util.List;

import com.bayan.sigaw.govdata.model.ProjectDetails;

public class GovDataPhDAOImpl implements GovDataPhDAO{

	
	private static final String OPENDATA_URL = "http://api.kabantayngbayan.ph/saro?";
	private static final String APP_ID = "527a5d935e13db265fc2598d";
	
	@Override
	public List<ProjectDetails> getAllProjects() {
		
		return null;
	}

}
