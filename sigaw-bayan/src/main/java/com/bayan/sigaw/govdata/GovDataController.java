package com.bayan.sigaw.govdata;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bayan.sigaw.govdata.api.dao.GovDataPhDAO;
import com.bayan.sigaw.govdata.model.ProjectDetail;
import com.bayan.sigaw.govdata.model.ProjectOverview;

@Controller
public class GovDataController {
	
	
	@Inject 
	private GovDataPhDAO govDataPhDAO;
	
	/**
	 * Returns the Project Overview
	 * @return
	 */
	@RequestMapping(value="/opendata/getAllProjectsByLocation", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProjectOverview> getAllProjectsOverview() {		
		ArrayList<ProjectOverview> projects = new ArrayList<ProjectOverview>();
		//call the data.gov.ph
		for (ProjectDetail projectDetail: govDataPhDAO.getAllProjects()) {
			projects.add(projectDetail.extractProjectOverview());
		}
				
		return projects; 
	}
	
	
	/**
	 * Returns the Project Overview
	 * @return
	 */
	@RequestMapping(value="/opendata/getAllProjectsByLocation/{limit}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProjectOverview> getAllProjectsOverviewByLimit(@PathVariable String limit) {		
		ArrayList<ProjectOverview> projects = new ArrayList<ProjectOverview>();
		//call the data.gov.ph
		for (ProjectDetail projectDetail: govDataPhDAO.getAllProjects(limit)) {
			projects.add(projectDetail.extractProjectOverview());
		}
				
		return projects; 
	}
	
	
	
	
	/**
	 * Returns the Project details of a specific project based on Saro Number
	 * @param saroNo
	 * @return
	 */
	
	@RequestMapping(value="/opendata/getProjectDetails/{saroNo}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProjectDetail> getProjectDetails(@PathVariable String saroNo) {		
		ArrayList<ProjectDetail> projects = new ArrayList<ProjectDetail>();
		//call the data.gov.ph 
		return projects; 
	}
	
	
	/**
	 * Returns the Response from Generic Call to Gov Data API
	 * @return
	 */
	@RequestMapping(value="/opendata/{requestUri}", method = RequestMethod.GET)
	public @ResponseBody String callGenericGovDataApi(@PathVariable String requestUri) {		
		return govDataPhDAO.callGenericGovDataApi(requestUri); 
	}
	
	/**
	 * Returns the Response from Generic Call to Gov Data API
	 * @return
	 */
	@RequestMapping(value="/opendata/getFewProjectsPerRegion", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProjectDetail> getFewProjectsPerRegion() {		
		return (ArrayList<ProjectDetail>) govDataPhDAO.getFewProjectsPerRegion(); 
	}
	
}
