package com.springdemo.bootboard.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringBoardNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		// do nothing for encoding
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		boolean valid = encode(rawPassword).equals(encodedPassword);		
		return valid;
	}

}
