package com.bayan.sigaw.users.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bayan.sigaw.sentiment.model.Results;
import com.bayan.sigaw.users.model.Sentiment;

public class SentimentsDAOImpl implements SentimentsDAO{

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertSentiment(String saroNo, String sentiment,
			Timestamp dateCreated, float rating, String type) {
		String sql = "insert into opendata.sentiments (saroNo, sentiment, dateCreated, rating, type)"
				+ "values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{saroNo, sentiment, dateCreated, rating, type});		
	}

	@Override
	public List<Sentiment> getAllSentiments() {		
		return jdbcTemplate.query("select * from opendata.sentiments", new SentimentsRowMapper());
	}

}
