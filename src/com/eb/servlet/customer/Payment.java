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

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		 
		String seats[] = request.getParameterValues("seats");
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		int customerId = (Integer)session.getAttribute("customerID");
		//System.out.println(customerId);
		
		EventDAO eventDAO = new EventDAO();
		SeatDAO seatDAO = new SeatDAO();
		TicketDAO ticketDAO = new TicketDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer c =  customerDAO.getCustomerbyId(customerId);
		Event e = eventDAO.getEventByIDwithHall(eventId);
		
		
		Date date = new Date();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate bookingDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
	      int size = seats.length;
	      
	     /* int[] arr = new int[seats.length];
			for(int i=0;i<seats.length;i++) {
				arr[i] = Integer.parseInt(seats[i]);
			}*/
	      ArrayList<Seat> seatArrayList = new ArrayList<>();
	      for(int i=0;i<seats.length;i++) {
				
				seatArrayList.add(seatDAO.getSeat(Integer.parseInt(seats[i])));
			}
			
		  double price = e.getTicketPrice();	
	      double cost = size*price;
	      if (cost!=0.0) {
	    	
				session.setAttribute("ticketPrice", cost);
				session.setAttribute("seatArrayList", seatArrayList);
				session.setAttribute("event", e);
				session.setAttribute("noOfTickets", size);
				
				/*for(int i=0;i<size;i++) {
					
					seatDAO.updateSeatStatus(arr[i]);
					String seatNo = seatDAO.getSeat(arr[i]).getSeatNo();
					ticketDAO.createTicket(new Ticket(seatNo,20.0,bookingDate,price,"success",c,e));
				}*/
				
				RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
				rd.forward(request, response);
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
