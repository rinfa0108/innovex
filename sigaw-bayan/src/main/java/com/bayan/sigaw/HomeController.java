package com.bayan.sigaw;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
	
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String goToHomePage(ModelMap model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println("user: " + user.getAuthorities());		
		String name = user.getUsername();

		model.addAttribute("username", name);
		model.addAttribute("message", "Fight Corruption");
		return "home";
	}
	
	@RequestMapping(value="/connectToFacebook", method = RequestMethod.GET)
	public String goToConnectToFacebookPage(ModelMap model) {
		return "connectToFacebook";
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String goToSigninPage(ModelMap model) {
		return "home";
	}
	
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
 
	}

	@RequestMapping(value="/map", method = RequestMethod.GET)
	public String map(ModelMap model) {
		return "map";
	}
	
	@RequestMapping(value="/budgetgraph", method = RequestMethod.GET)
	public String budgetgraph(ModelMap model) {
		return "budgetgraph";
	}
	
	
}
