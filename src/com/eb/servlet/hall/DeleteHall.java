package com.eb.servlet.hall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.HallDAO;

@WebServlet("/DeleteHall")
public class DeleteHall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int ownerID = Integer.parseInt(request.getParameter("oid"));
		HallDAO dao = new HallDAO();
		if(dao.deleteHall(id))
		{
			response.sendRedirect(request.getContextPath() + "/ViewHallList?ownerID="+ownerID);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
	}


}
