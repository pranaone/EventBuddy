package com.eb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eb.dao.CustomerDAO;
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
				
				 // Create a session object if it is already not  created.
			      HttpSession session = request.getSession(true);

				if (user.getUserType().equals("customer")) {

					CustomerDAO cdao = new CustomerDAO();

					Customer customer = cdao.getCustomerbById(user.getUserId());

					Customer cutsomerWithUserObj = new Customer(customer.getCustomerId(), customer.getFirstName(),
							customer.getLastName(), customer.getEmail(), customer.getMobile(), customer.getNicNo(),
							user);

					session.setAttribute("customerObj", cutsomerWithUserObj);
					
					//TODO Redirect to customer Dashboard and use this Obj

				} else if (user.getUserType().equals("owner")) {

					OwnerDAO odao = new OwnerDAO();

					Owner owner = odao.getOwnerbById(user.getUserId());

					Customer ownerWithUserObj = new Customer(owner.getOwnerId(), owner.getFirstName(),
							owner.getLastName(), owner.getEmail(), owner.getMobile(), owner.getBrNo(),
							user);

					session.setAttribute("ownerObj", ownerWithUserObj);
					
					//TODO Redirect to owner Dashboard and use this Obj

				} else if (user.getUserType().equals("admin")) {
					
					session.setAttribute("adminObj", user);
					
					//TODO Redirect to admin Dashboard and use this Obj
					
				}

			} else {
				System.out.println("Invalid");
			}
		}
	}

}