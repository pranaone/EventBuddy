package com.eb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.UserDAO;
import com.eb.model.Encryption;
import com.eb.model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		Encryption encryption = new Encryption();
		UserDAO udao = new UserDAO();
		
		String hashedPassword = encryption.createPassword(password);
		
		User user = new User(username, hashedPassword, userType);
		
		boolean registrationSuccessful = udao.registerUser(user);
		
		if(registrationSuccessful) {
			System.out.println("Succesfully Registered");
		} else {
			System.out.println("Username already found");
		}
		
	}

}