package com.bayan.sigaw;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bayan.sigaw.govdata.model.ProjectDetail;
import com.bayan.sigaw.govdata.service.GovDataService;
import com.bayan.sigaw.govdata.service.GovDataServiceImpl;
import com.bayan.sigaw.sentiment.model.Results;
import com.bayan.sigaw.sentiment.service.SentimentServiceImpl;
import com.bayan.sigaw.users.service.AccountsService;

@Controller
public class ProjectDetailsController {
	
	@Inject
	private AccountsService accountsService;
	
	private GovDataService govDataService = new GovDataServiceImpl();
	
	@RequestMapping(value="/projectdetails/{saroNo}/{region}", method = RequestMethod.GET)
	public String goToProjectDetails(@PathVariable String saroNo, @PathVariable String region, Model model) {		
		ProjectDetail p = govDataService.getProjectBySaroNoInRegion(saroNo, region);		
		model.addAttribute("projectDetail", p);		
		return "projectdetails";
	}
		
	@RequestMapping(value="/projectdetails/comment/{saroNo}/{region}/{comment}", method = RequestMethod.GET)
	public String commentOnProjectDetails(@PathVariable String saroNo, 
			@PathVariable String region, @PathVariable String comment, Model model) {
		Results result = new SentimentServiceImpl().getSentimentScore(comment);		
		accountsService.insertSentiment(saroNo, comment, new Timestamp(System.currentTimeMillis()), 
				result.getDocSentiment().getScore(), result.getDocSentiment().getType());
		return "projectdetails";
	}
}
