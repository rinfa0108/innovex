package com.bayan.sigaw.sentiment.service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import com.bayan.sigaw.sentiment.model.DocSentiment;
import com.bayan.sigaw.sentiment.model.Results;
import com.likethecolor.alchemy.api.Client;
import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.call.SentimentCall;
import com.likethecolor.alchemy.api.call.type.CallTypeText;
import com.likethecolor.alchemy.api.call.type.CallTypeUrl;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;

public class SentimentServiceImpl implements AlchemySentimentService{

	private static final String ALCHEMY_URL 
		= "http://access.alchemyapi.com/calls/text/TextGetTextSentiment"; 
	
	private static final String API_KEY = "f1515794f621c0c1422170527f221df1b806b81b";
	
	@Override
	public Results getSentimentScore(String sentiment) {
		
		Results sentimentResult = null;		
		
		
		try {
			final Client client = new Client(API_KEY);
			
			
			final AbstractCall<SentimentAlchemyEntity> sentimentCall = new SentimentCall(new CallTypeText(sentiment));
		    final Response<SentimentAlchemyEntity> sentimentResponse = client.call(sentimentCall);
			
		    sentimentResult = new Results();
		    DocSentiment docSentiment = new DocSentiment(); 
		    
		    sentimentResult.setLanguage(sentimentResponse.getLanguage());
		    sentimentResult.setStatus(sentimentResponse.getStatus().toString());
		    sentimentResult.setUrl(sentimentResponse.getURL());
		    sentimentResult.setUsage(sentimentResponse.getUsage());
		    
		    System.out.println("Language: " + sentimentResponse.getLanguage());
		    System.out.println("Status: " + sentimentResponse.getStatus());
		    System.out.println("Status Info: " + sentimentResponse.getStatusInfo());
		    System.out.println("Text: " + sentimentResponse.getText());
		    System.out.println("Usage: " + sentimentResponse.getUsage());
		    System.out.println("URL: " + sentimentResponse.getURL());
		    
		    
		    SentimentAlchemyEntity entity;
		    final Iterator<SentimentAlchemyEntity> iter = sentimentResponse.iterator();
		    while(iter.hasNext()) {
		      entity = iter.next();		      
		      System.out.println("Score: " + entity.getScore());
		      docSentiment.setScore(entity.getScore());
		      System.out.println("Type: " + entity.getType());
		      docSentiment.setType(entity.getType().toString());
		    }
		    
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sentimentResult;
	}

}
