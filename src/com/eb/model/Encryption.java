package com.eb.model;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encryption {
	
	//static final String salt = BCrypt.gensalt();
	
	public String createPassword(String password) {
		
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		System.out.println(hashedPassword);
		return hashedPassword;
		//BCrypt.checkpw(plaintext, hashed)
		
	}
	
	public boolean checkPassword(String inputPassword, String dbPassword) {
		
		boolean isValid = false;
		
//		String hashedInput = BCrypt.hashpw(inputPassword,  BCrypt.gensalt(10));
		
		if (BCrypt.checkpw(inputPassword, dbPassword)) 
		{
			isValid = true;
		}
		
		
		return isValid;
	}

}