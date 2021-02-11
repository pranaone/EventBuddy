package com.eb.servlet.hall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.HallDAO;
import com.eb.model.Hall;


@WebServlet("/CreateHall")
public class CreateHall extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("hallName");
		String type = request.getParameter("hallType");
		String location = request.getParameter("hallLocation");
		String contact = request.getParameter("hallContact");
		int seats = Integer.parseInt(request.getParameter("noOfSeats"));
		int ownerID = Integer.parseInt(request.getParameter("ownerID"));
		
		HallDAO hdao = new HallDAO();
		boolean createHall = hdao.createHall(new Hall(name,type,location,contact,seats),ownerID);
		if(createHall)
		{
			response.sendRedirect(request.getContextPath() + "/ViewHallList?ownerID="+ownerID);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewHallList?ownerID="+ownerID);
			//dispatcher.forward(request, response);
			
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
	}

}
