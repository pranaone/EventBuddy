package com.eb.servlet.event;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.EventDAO;
import com.eb.model.Event;


@WebServlet("/UpdateEvent")
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("eventId"));
		String name = request.getParameter("eventName");
		String type = request.getParameter("eventType");
		String description = request.getParameter("eventDescription");
		String edate =request.getParameter("eventDate").toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(edate, formatter);
		LocalTime stime = LocalTime.parse(request.getParameter("startTime"));
		LocalTime etime = LocalTime.parse(request.getParameter("endTime")); 
		double price = Double.parseDouble(request.getParameter("ticketPrice"));
		int hallId =Integer.parseInt(request.getParameter("hallId"));
		
		EventDAO edao = new EventDAO();
        Event event = new Event(id,name,type,description,date,stime,etime,price,"Image File goes here");
        boolean updateEvent =edao.updateEvent(event);
        
        if(updateEvent)
		{

			response.sendRedirect(request.getContextPath() + "/ViewEventList?hid="+hallId);
			
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
	}

}
