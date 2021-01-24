package com.eb.model;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encryption {
	
	public String createPassword(String password) {
		
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		return hashedPassword;
		
	}
	
	public boolean checkPassword(String inputPassword, String dbPassword) {
		
		boolean isValid = false;
		
		if (BCrypt.hashpw(inputPassword, BCrypt.gensalt(10)).equals(dbPassword)) {
			isValid = true;
		}
		
		return isValid;
	}

}