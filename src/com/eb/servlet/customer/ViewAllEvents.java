package com.eb.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eb.dao.EventDAO;
import com.eb.model.Event;



@WebServlet("/ViewAllEvents")
public class ViewAllEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//int customerID = Integer.parseInt(request.getParameter("customerID"));
		int customerID = (Integer)session.getAttribute("customerID");
		EventDAO eventDAO = new EventDAO();
		List<Event> list = eventDAO.getEventListByToday();
		if (list != null) {
			request.setAttribute("eventList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllEvents.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
