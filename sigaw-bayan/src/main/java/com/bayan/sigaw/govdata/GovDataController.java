package com.bayan.sigaw.govdata;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bayan.sigaw.govdata.model.ProjectDetails;
import com.bayan.sigaw.govdata.model.ProjectOverview;

@Controller
public class GovDataController {
	
	/**
	 * Returns the Project Overview
	 * @return
	 */
	@RequestMapping(value="/opendata/getAllProjectsByLocation", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProjectOverview> getAllProjectsOverview() {		
		ArrayList<ProjectOverview> projects = new ArrayList<ProjectOverview>();
		//call the data.gov.ph
		
		ProjectOverview projectOverview1 = new ProjectOverview();
		projectOverview1.setRegion("1");
		projectOverview1.setDecription("Northwestern Mindanao State College of Science and Technology");
		projectOverview1.setAmount(789000);
		projectOverview1.setDepartment_code("SUCS");
		projectOverview1.setSaro_no("SARO-ROX-13-0000109");
		
		ProjectOverview projectOverview2 = new ProjectOverview();
		projectOverview2.setRegion("1");
		projectOverview2.setDecription("Northwestern Mindanao State College of Science and Technology");
		projectOverview2.setAmount(789000);
		projectOverview2.setDepartment_code("SUCS");
		projectOverview2.setSaro_no("SARO-ROX-13-0000109");
		
		ProjectOverview projectOverview3 = new ProjectOverview();
		projectOverview3.setRegion("6");
		projectOverview3.setDecription("Northwestern Mindanao State College of Science and Technology");
		projectOverview3.setAmount(789000);
		projectOverview3.setDepartment_code("SUCS");
		projectOverview3.setSaro_no("SARO-ROX-13-0000109");
		
		ProjectOverview projectOverview4 = new ProjectOverview();
		projectOverview4.setRegion("NCR");
		projectOverview4.setDecription("Northwestern Mindanao State College of Science and Technology");
		projectOverview4.setAmount(789000);
		projectOverview4.setDepartment_code("SUCS");
		projectOverview4.setSaro_no("SARO-ROX-13-0000109");
		
		ProjectOverview projectOverview5 = new ProjectOverview();
		projectOverview5.setRegion("10");
		projectOverview5.setDecription("Northwestern Mindanao State College of Science and Technology");
		projectOverview5.setAmount(789000);
		projectOverview5.setDepartment_code("SUCS");
		projectOverview5.setSaro_no("SARO-ROX-13-0000109");
		
		projects.add(projectOverview1);
		projects.add(projectOverview2);
		projects.add(projectOverview3);
		projects.add(projectOverview4);
		projects.add(projectOverview5);
				
		return projects; 
	}
	
	/**
	 * Returns the Project details of a specific project based on Saro Number
	 * @param saroNo
	 * @return
	 */
	
	@RequestMapping(value="/opendata/getProjectDetails/{saroNo}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProjectDetails> getProjectDetails(@PathVariable String saroNo) {		
		ArrayList<ProjectDetails> projects = new ArrayList<ProjectDetails>();
		//call the data.gov.ph 
		return projects; 
	}
	
	
	
	
}
