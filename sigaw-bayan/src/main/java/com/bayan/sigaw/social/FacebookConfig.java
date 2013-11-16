package com.bayan.sigaw.social;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import com.bayan.sigaw.security.SimpleSignInAdapter;

@Configuration
public class FacebookConfig {
	
	@Bean
	public ProviderSignInController providerSignInController() {
		ProviderSignInController controller = 
				new ProviderSignInController(connectionFactoryLocator(), 
	        usersConnectionRepository(), new SimpleSignInAdapter());
		
		
		
		return controller;
	}
	
	@Bean
	public ConnectController connectController() {
		return new ConnectController(connectionFactoryLocator(), connectionRepository());
	}

	@Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory
        			(new FacebookConnectionFactory("372272306240326","e3457674cf41cb52b41f7e51d7b855f3"));
        return registry;
	}
	
	
	@Bean
    public UsersConnectionRepository usersConnectionRepository() {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), 
        		textEncryptor);
    }
	
	
	@Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }
        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }
	
    @Inject
    private DataSource dataSource;

    @Inject
    private TextEncryptor textEncryptor;
	
	
}
