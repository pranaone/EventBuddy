package com.eb.servlet.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.OwnerDAO;
import com.eb.dao.UserDAO;
import com.eb.model.Encryption;
import com.eb.model.Owner;
import com.eb.model.User;


@WebServlet("/CreateOwner")
public class CreateOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String brNo = request.getParameter("brNo");
		String password = request.getParameter("password");
		
		UserDAO udao = new UserDAO(); 
		Encryption encryption = new Encryption();
		String hashedPassword = encryption.createPassword(password);
		boolean createUser = udao.registerUser(new User(username, hashedPassword, "owner"));
		
		if(createUser) {
			User u = udao.getUser(username);
			
			OwnerDAO odao = new OwnerDAO();
			
			boolean createOwner = odao.createOwner(new Owner(firstName, lastName, email, mobile, brNo, u));
			
			response.sendRedirect(request.getContextPath() + "/ViewOwnerList");
			
		} else {
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
		
		

		
	}

}