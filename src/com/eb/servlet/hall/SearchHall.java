package com.eb.servlet.hall;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.HallDAO;
import com.eb.model.Hall;


@WebServlet("/SearchHall")
public class SearchHall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HallDAO dao = new HallDAO();
		Hall hall = dao.getHallByID(id);
		if (hall != null) {
			request.setAttribute("hall", hall);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateHall.jsp");
			dispatcher.forward(request, response);
		} 
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
		
	}


}
