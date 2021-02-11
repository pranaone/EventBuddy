package com.eb.servlet.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.OwnerDAO;
import com.eb.model.Owner;


@WebServlet("/UpdateOwner")
public class UpdateOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String brNo = request.getParameter("brNo");
		int ownerId = Integer.parseInt(request.getParameter("ownerID"));
		
		OwnerDAO dao = new OwnerDAO();
		
		if(dao.updateOwner(new Owner(ownerId,firstName,lastName,email,mobile,brNo)))
		{
			response.sendRedirect(request.getContextPath() + "/ViewOwnerList");
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
	}

}