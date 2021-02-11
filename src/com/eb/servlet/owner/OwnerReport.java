package com.eb.servlet.owner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.EventDAO;
import com.eb.dao.HallDAO;
import com.eb.dao.TicketDAO;

@WebServlet("/OwnerReport")
public class OwnerReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("ownerID")!=null)
		{
			int ownerID = Integer.parseInt(request.getParameter("ownerID"));
			HallDAO hdao = new HallDAO();
			int hallCount = hdao.getHallCountByOwner(ownerID);
			request.setAttribute("hallCount", hallCount);
			EventDAO edao = new EventDAO();
			int eventCount = edao.getEventCountByOwner(ownerID);
			request.setAttribute("eventCount", eventCount);
			TicketDAO tdao = new TicketDAO();
			int ticketCount = tdao.getTicketCountByOwner(ownerID);
			request.setAttribute("ticketCount", ticketCount);
			double salesAmount = tdao.getTicketSaleByOwner(ownerID);
			String sales = String.format("%,.2f", salesAmount);
			request.setAttribute("salesAmount",sales);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("OwnerReport.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}
		
	}

}
