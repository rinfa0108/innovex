package com.bayan.sigaw;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bayan.sigaw.users.form.Register;
import com.bayan.sigaw.users.service.AccountsService;

@Controller
public class RegisterController {
	
	@Inject
	private AccountsService accountsService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		return "register";
	}
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute Register register, ModelMap model) {
		
		accountsService.insertAccount(register.getUsername(), register.getPassword(), 
				register.getEmail(), "true", "ROLE_USER");
		
		return "home";
	}
	
}
