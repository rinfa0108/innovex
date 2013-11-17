package com.bayan.sigaw;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bayan.sigaw.users.model.Sentiment;
import com.bayan.sigaw.users.service.AccountsService;

@Controller
public class SentimentsController {
	
	@Inject
	private AccountsService accountsService;
	
	/**
	 * Returns the Project Overview
	 * @return
	 */
	@RequestMapping(value="/sentiments/getAllSentiments", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Sentiment> getAllSentiments() {		
		ArrayList<Sentiment> sentiments = new ArrayList<Sentiment>();		
		sentiments = (ArrayList<Sentiment>) accountsService.getallSentiments();		
		return sentiments; 
	}
}
