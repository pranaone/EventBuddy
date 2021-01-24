package com.eb.servlet.event;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.EventDAO;



@WebServlet("/DeleteEvent")
public class DeleteEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int hallID = Integer.parseInt(request.getParameter("hid"));
		EventDAO edao = new EventDAO();
		if(edao.deleteEvent(id))
		{
			response.sendRedirect(request.getContextPath() + "/ViewEventList?hid="+hallID);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
	}
}
