package com.eb.servlet.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.EventDAO;
import com.eb.model.Event;


@WebServlet("/SearchEvent")
public class SearchEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int hid = Integer.parseInt(request.getParameter("hid"));
		EventDAO dao = new EventDAO();
		Event event= dao.getEventByID(id);
		if (event != null) {
			request.setAttribute("event", event);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateEvent.jsp?hid="+hid);
			dispatcher.forward(request, response);
		} 
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
	}
}
