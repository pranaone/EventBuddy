package com.eb.servlet.owner;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.OwnerDAO;
import com.eb.model.Owner;


@WebServlet("/ViewOwnerList")
public class ViewOwnerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OwnerDAO odao = new OwnerDAO();
		List<Owner> list = odao.getAllOwners();
		
		if (list != null) {
			request.setAttribute("ownerList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOwnerList.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}