package com.bayan.sigaw.users.dao;

public interface UsersDAO {
	
	void insertUser(String username, String password, String email, String enabled);
}
