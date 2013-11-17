package com.bayan.sigaw.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SentimentsRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		SentimentsResultSetExtractor extractor 
			= new SentimentsResultSetExtractor();
		return extractor.extractData(rs);
	}

}
