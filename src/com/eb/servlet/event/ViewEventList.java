package com.eb.servlet.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.EventDAO;

import com.eb.model.Event;


@WebServlet("/ViewEventList")
public class ViewEventList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int hallID = Integer.parseInt(request.getParameter("hid"));
		EventDAO edao = new EventDAO();
		List<Event> list = edao.getEventListByHall(hallID);
		if (list!=null) {

			request.setAttribute("eventList", list);
			request.setAttribute("hallId", hallID);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewEventList.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}	
	}

}
