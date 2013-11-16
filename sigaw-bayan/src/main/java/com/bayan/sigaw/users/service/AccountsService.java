package com.bayan.sigaw.users.service;

public interface AccountsService {
	
	void insertAccount(String username, String password, String email, String enabled, String role);
}
