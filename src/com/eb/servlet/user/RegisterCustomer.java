package com.eb.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.CustomerDAO;
import com.eb.dao.UserDAO;
import com.eb.model.Customer;
import com.eb.model.Encryption;
import com.eb.model.User;


@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String nicNo = request.getParameter("nicNo");
		String password = request.getParameter("password");
		
		UserDAO udao = new UserDAO(); 
		Encryption encryption = new Encryption();
		String hashedPassword = encryption.createPassword(password);
		boolean createUser = udao.registerUser(new User(username, hashedPassword, "customer"));
		
		if(createUser) {
			User u = udao.getUser(username);
			
			CustomerDAO cdao = new CustomerDAO();
			
			boolean createCustomer = cdao.createCustomer(new Customer(firstName, lastName, email, mobile, nicNo, u));
			if(createCustomer)
			{
				response.sendRedirect(request.getContextPath() + "/Login.jsp");
				System.out.println("Customer Creation Success");
			}
			else
			{
				System.out.println("Customer Creation Failed");
			}
				
		} else {
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
	}

}