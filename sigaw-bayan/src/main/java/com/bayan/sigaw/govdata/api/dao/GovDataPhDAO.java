package com.bayan.sigaw.govdata.api.dao;

import java.util.List;

import com.bayan.sigaw.govdata.model.ProjectDetail;

public interface GovDataPhDAO {
	
	List<ProjectDetail> getAllProjects();
	List<ProjectDetail> getAllProjects(String limit);
	List<ProjectDetail> getFewProjectsPerRegion();
	String callGenericGovDataApi(String requestUri);	
	List<ProjectDetail> getAllProjectsInRegion(String region);
}
