package com.eb.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eb.dao.CustomerDAO;
import com.eb.dao.HallDAO;
import com.eb.dao.OwnerDAO;
import com.eb.dao.UserDAO;
import com.eb.model.Customer;
import com.eb.model.Encryption;
import com.eb.model.Owner;
import com.eb.model.User;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Encryption encryption = new Encryption();
		UserDAO udao = new UserDAO();

		User user = udao.getUser(username);

		if (user != null) {
		
			boolean isValid = encryption.checkPassword(password, user.getPassword());
			if (isValid) {

			      HttpSession session = request.getSession(true);
			      
				if (user.getUserType().equals("customer")) {

					CustomerDAO cdao = new CustomerDAO();

					Customer customer = cdao.getCustomerbByUserId(user.getUserId());
					System.out.println(customer.getFirstName());
					session.setAttribute("customerID", customer.getCustomerId());
					session.setAttribute("customerName", customer.getFirstName());
					session.setAttribute("userType","customer");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerHome.jsp");
					dispatcher.forward(request, response);

				} else if (user.getUserType().equals("owner")) {

					OwnerDAO odao = new OwnerDAO();

					Owner owner = odao.getOwnerbByUserId(user.getUserId());
					
					session.setAttribute("ownerID", owner.getOwnerId());
					session.setAttribute("ownerName", owner.getFirstName());
					session.setAttribute("userType","owner");

					RequestDispatcher dispatcher = request.getRequestDispatcher("OwnerHome.jsp");
					dispatcher.forward(request, response);

				} else if (user.getUserType().equals("admin")) {
					
					//session.setAttribute("adminObj", user);
					session.setAttribute("adminName", user.getUserName());
					session.setAttribute("userType","admin");
					RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOwnerList");
					dispatcher.forward(request, response);
				}
				else 
				{
					System.out.println("Unknown login");
					request.setAttribute("message","Login Error!!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
					dispatcher.forward(request, response);
				}
		}
		else 
		{
			System.out.println("Invalid Password");
			request.setAttribute("message","Please input valid password!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
		}
		else 
		{
			System.out.println("Invalid Username");
			request.setAttribute("message","Please input valid credentials!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		} 
	}
}