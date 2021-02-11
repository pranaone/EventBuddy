package com.eb.servlet.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.EventDAO;
import com.eb.dao.SeatDAO;
import com.eb.model.Seat;


@WebServlet("/ViewAllSeats")
public class ViewAllSeats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int eventID = Integer.parseInt(request.getParameter("eventId"));
		
		
		//EventDAO eventDAO = new EventDAO();
		SeatDAO seatDAO = new SeatDAO();
		//int noOfSeats = eventDAO.getEventByIDwithHall(eventID).getHall().getNoOfSeats();
		List<Seat> list = seatDAO.getAllSeatsByEvent(eventID);
		if (list != null) {
			List<Seat> listOfNotBookedSeats = new ArrayList<>();
			List<Seat> listOfBookedSeats = new ArrayList<>();
			for(Seat s:list) {
				if(!s.isSeatStatus()) {
					listOfNotBookedSeats.add(s);
				} else {
					listOfBookedSeats.add(s);
				}
			}
			
			request.setAttribute("seatList", listOfNotBookedSeats);
			request.setAttribute("bookedSeatList", listOfBookedSeats);
			request.setAttribute("noOfSeatsAvailable", listOfNotBookedSeats.size());
			request.setAttribute("eventId",eventID);
			RequestDispatcher rd = request.getRequestDispatcher("ViewAllSeats.jsp");
			rd.forward(request, response);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
