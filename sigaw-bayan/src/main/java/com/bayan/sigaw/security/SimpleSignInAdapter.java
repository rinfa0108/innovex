package com.bayan.sigaw.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class SimpleSignInAdapter implements SignInAdapter{

	@Override
	public String signIn(String localUserId, Connection<?> arg1, NativeWebRequest request) {
		SecurityContextHolder.getContext().setAuthentication(
	            new UsernamePasswordAuthenticationToken(localUserId, null, null));
		
		System.out.println("localUserId:" + localUserId);
		
	    return "home";
	}

}
