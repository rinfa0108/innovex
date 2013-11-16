package com.bayan.sigaw.users.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;

public class UsersDAOImpl implements UsersDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertUser(String username, String password, String email, String enabled) {		
		String sql = "insert into opendata.users (username, password, email, enabled) "
				+ "VALUES(?,?,?,?)";		
		jdbcTemplate.update(sql, new Object[] {username, password, email, enabled});		
	}

}
