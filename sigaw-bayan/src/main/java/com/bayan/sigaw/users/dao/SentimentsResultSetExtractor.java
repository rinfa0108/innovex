package com.bayan.sigaw.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bayan.sigaw.users.model.Sentiment;

public class SentimentsResultSetExtractor implements ResultSetExtractor{

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Sentiment sentiment = new Sentiment();
		sentiment.setDateCreated(rs.getTimestamp("dateCreated"));
		sentiment.setRating(rs.getFloat("rating"));
		sentiment.setSaroNo(rs.getString("saroNo"));
		sentiment.setType(rs.getString("type"));
		return sentiment;
	}

}
