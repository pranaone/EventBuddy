package com.eb.servlet.customer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eb.dao.CustomerDAO;
import com.eb.dao.EventDAO;
import com.eb.dao.SeatDAO;
import com.eb.dao.TicketDAO;
import com.eb.model.Customer;
import com.eb.model.Event;
import com.eb.model.Seat;
import com.eb.model.Ticket;

@WebServlet("/BookTicket")
public class BookTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		 
		//String seats[] = request.getParameterValues("seats");
		ArrayList<Seat> seatList = (ArrayList<Seat>)session.getAttribute("seatArrayList");
		//int eventId = Integer.parseInt(request.getParameter("eventId"));
		int customerId = (Integer)session.getAttribute("customerID");
		System.out.println(customerId);
		
		EventDAO eventDAO = new EventDAO();
		SeatDAO seatDAO = new SeatDAO();
		TicketDAO ticketDAO = new TicketDAO();
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer c =  customerDAO.getCustomerbyId(customerId);
		Event e = (Event)session.getAttribute("event");
		
		
		Date date = new Date();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate bookingDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
	      int size = seatList.size();
	      
			
		  double price = e.getTicketPrice();	
	      double cost = size*price;
	      if (cost!=0.0) {
	    	
				request.setAttribute("ticketPrice", cost);
				//request.setAttribute("seats", Arrays.toString(seats));
				request.setAttribute("seats", seatList);
				request.setAttribute("event", e);
				request.setAttribute("noOfTickets", size);
	    	
				for(Seat s:seatList) {
					
					seatDAO.updateSeatStatus(s.getSeatId());
					String seatNo = s.getSeatNo();
					ticketDAO.createTicket(new Ticket(seatNo,20.0,bookingDate,price,"success",c,e));
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("SuccessfullyBooked.jsp");
				rd.forward(request, response);
			}
			else 
			{
				response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
			}
	}

}
