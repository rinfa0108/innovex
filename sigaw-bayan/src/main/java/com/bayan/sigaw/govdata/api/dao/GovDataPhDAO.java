package com.bayan.sigaw.govdata.api.dao;

import java.util.List;

import com.bayan.sigaw.govdata.model.ProjectDetail;

public interface GovDataPhDAO {
	
	List<ProjectDetail> getAllProjects();
	List<ProjectDetail> getAllProjects(String limit);
	String callGenericGovDataApi(String requestUri);	
	
}
