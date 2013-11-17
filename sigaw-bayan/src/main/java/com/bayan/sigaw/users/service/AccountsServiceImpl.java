package com.bayan.sigaw.users.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.bayan.sigaw.sentiment.model.Results;
import com.bayan.sigaw.users.dao.AuthorotiesDAO;
import com.bayan.sigaw.users.dao.SentimentsDAO;
import com.bayan.sigaw.users.dao.UsersDAO;
import com.bayan.sigaw.users.model.Sentiment;

public class AccountsServiceImpl implements AccountsService{
	
	@Inject
	private UsersDAO usersDAO;
	
	@Inject
	private AuthorotiesDAO authorotiesDAO;
	
	@Inject
	private SentimentsDAO sentimentsDAO;
	
	@Override
	public void insertAccount(String username, String password, String email,
				String enabled,	String role) {		
		
		usersDAO.insertUser(username, password, email, enabled);
		authorotiesDAO.insertAuthority(username, role);
	}

	@Override
	public void insertSentiment(String saroNo, String sentiment,
			Timestamp dateCreated, float rating, String type) {
		sentimentsDAO.insertSentiment(saroNo, sentiment, dateCreated, rating, type);		
	}

	@Override
	public List<Sentiment> getallSentiments() {		
		return sentimentsDAO.getAllSentiments();
	}

}
