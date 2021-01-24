package com.eb.servlet.hall;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.HallDAO;
import com.eb.model.Hall;

@WebServlet("/UpdateHall")
public class UpdateHall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("hallName");
		String type = request.getParameter("hallType");
		String location = request.getParameter("hallLocation");
		String contact = request.getParameter("hallContact");
		int seats = Integer.parseInt(request.getParameter("noOfSeats"));
		int ownerID = Integer.parseInt(request.getParameter("ownerID"));
		int id = Integer.parseInt(request.getParameter("hallID"));
		HallDAO dao = new HallDAO();
		
		if(dao.updateHall(new Hall(id,name,type,location,contact,seats))) 
		{
			response.sendRedirect(request.getContextPath() + "/ViewHallList?ownerID="+ownerID);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
		
	}

}
