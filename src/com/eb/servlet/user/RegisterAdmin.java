package com.eb.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.UserDAO;
import com.eb.model.Encryption;
import com.eb.model.User;


@WebServlet("/RegisterAdmin")
public class RegisterAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String userType = request.getParameter("userType");
		
		Encryption encryption = new Encryption();
		UserDAO udao = new UserDAO();
		
		String hashedPassword = encryption.createPassword(password);
		
		User user = new User(username, hashedPassword, "admin");
		
		boolean registrationSuccessful = udao.registerUser(user);
		
		if(registrationSuccessful) {
			System.out.println("Succesfully Registered");
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		
		} else {
			System.out.println("Register Error");
			request.setAttribute("message","Username already taken!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("CreateAdmin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}