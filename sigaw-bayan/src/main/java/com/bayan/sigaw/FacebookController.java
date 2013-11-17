package com.bayan.sigaw;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bayan.sigaw.sentiment.service.AlchemySentimentService;
import com.bayan.sigaw.sentiment.service.SentimentServiceImpl;
import com.bayan.sigaw.users.service.AccountsService;


@Controller
public class FacebookController {
	
	private static final Logger logger = Logger.getLogger(FacebookController.class);
	
	@Inject
	private ConnectionRepository connectionRepository;	
	
	@RequestMapping(value="/facebook", method=RequestMethod.GET)
	public String goToFacebookProfile(Model model) {
		Facebook facebook = getFacebookConnection();
		if (facebook == null) {
			return "redirect:/connect/facebook";
		}		
		FacebookProfile facebookProfile = facebook.userOperations().getUserProfile();
		//TODO save to DB
		
		
		model.addAttribute("profile", facebookProfile);		
		return "fb/profile";
	}
	
	@RequestMapping(value="/connect/facebook", method=RequestMethod.GET)
	public String goToFacebookConnected(Model model) {
		Facebook facebook = getFacebookConnection();
		if (facebook == null) {
			return "redirect:/connect/facebook";
		}		
		FacebookProfile facebookProfile = facebook.userOperations().getUserProfile();
	
		//accountsService.insertAccount(facebookProfile.getName(), "", "true", "ROLE_USER");		
		
		model.addAttribute("profile", facebookProfile);		
		return "fb/profile";
	}
	
	
	@RequestMapping(value="/facebook/feed", method=RequestMethod.POST)
	public String postUpdate(String message) {
		
		AlchemySentimentService sentimentService = new SentimentServiceImpl();		
		sentimentService.getSentimentScore(message);
		
		Facebook facebook = getFacebookConnection();
		if (facebook == null) {
			return "redirect:/connect/facebook";
		}
		facebook.feedOperations().updateStatus(message);
		return "redirect:/facebook";
	}
	
	private Facebook getFacebookConnection() {
		Facebook facebook = null;
		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
		if (connection != null) {
			facebook = connection.getApi();
		}
		return facebook;
	}
	
}
