package com.eb.servlet.owner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.OwnerDAO;
import com.eb.model.Owner;


@WebServlet("/SearchOwner")
public class SearchOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		OwnerDAO dao = new OwnerDAO();
		Owner owner = dao.getOwnerbById(id);
		if (owner != null) {
			request.setAttribute("owner", owner);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateOwner.jsp");
			dispatcher.forward(request, response);
		} 
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
	}


}