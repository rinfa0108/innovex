package com.bayan.sigaw.users.service;

import java.sql.Timestamp;
import java.util.List;

import com.bayan.sigaw.users.model.Sentiment;

public interface AccountsService {
	
	void insertAccount(String username, String password, String email, String enabled, String role);
	void insertSentiment(String saroNo, String sentiment, Timestamp dateCreated, float rating, String type);
	List<Sentiment> getallSentiments();
}
