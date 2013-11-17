package com.bayan.sigaw.govdata.service;

import com.bayan.sigaw.govdata.model.ProjectDetail;

public interface GovDataService {
	
	ProjectDetail getProjectBySaroNoInRegion(String saroNo, String region);
}
