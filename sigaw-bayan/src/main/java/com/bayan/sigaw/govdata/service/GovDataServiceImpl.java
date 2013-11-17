package com.bayan.sigaw.govdata.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bayan.sigaw.govdata.api.dao.GovDataPhDAO;
import com.bayan.sigaw.govdata.api.dao.GovDataPhDAOImpl;
import com.bayan.sigaw.govdata.model.ProjectDetail;

public class GovDataServiceImpl implements GovDataService{
	
	private GovDataPhDAO govDataPhDAO = new GovDataPhDAOImpl();
	
	@Override
	public ProjectDetail getProjectBySaroNoInRegion(String saroNo, String region) {
		List<ProjectDetail> projects = govDataPhDAO.getAllProjectsInRegion(region);
		ProjectDetail project = null;
		for (ProjectDetail p: projects) {
			if (StringUtils.equalsIgnoreCase(saroNo, p.getSaro_no())) {
				project = p;
				break;
			}
		}		
		return project;
	}

}
