package com.bayan.sigaw.users.dao;

import java.sql.Timestamp;
import java.util.List;

import com.bayan.sigaw.users.model.Sentiment;

public interface SentimentsDAO {
	void insertSentiment(String saroNo, String sentiment, Timestamp dateCreated, float rating, String type);
	List<Sentiment> getAllSentiments();
}
