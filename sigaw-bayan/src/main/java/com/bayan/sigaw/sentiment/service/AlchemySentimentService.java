package com.bayan.sigaw.sentiment.service;

import com.bayan.sigaw.sentiment.model.Results;

public interface AlchemySentimentService {
	
	Results getSentimentScore(String sentiment);
}
