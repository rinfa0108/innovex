package com.bayan.sigaw.users.service;

import javax.inject.Inject;

import com.bayan.sigaw.users.dao.AuthorotiesDAO;
import com.bayan.sigaw.users.dao.UsersDAO;

public class AccountsServiceImpl implements AccountsService{
	
	@Inject
	private UsersDAO usersDAO;
	
	@Inject
	private AuthorotiesDAO authorotiesDAO;
	
	@Override
	public void insertAccount(String username, String password, String email,
				String enabled,	String role) {		
		
		usersDAO.insertUser(username, password, email, enabled);
		authorotiesDAO.insertAuthority(username, role);
	}

}
