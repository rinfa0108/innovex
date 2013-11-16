package com.bayan.sigaw.users.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;


public class AuthoritiesDAOImpl implements AuthorotiesDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insertAuthority(String username, String role) {
		String sql = "insert into opendata.authorities (username, authority) "
				+ "values(?,?)";
		jdbcTemplate.update(sql, new Object[]{username, role});
	}

}
