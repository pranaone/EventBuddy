package com.eb.servlet.hall;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eb.dao.HallDAO;
import com.eb.model.Hall;


@WebServlet("/ViewHallList")
public class ViewHallList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("ownerID")!=null)
		{
			int ownerID = Integer.parseInt(request.getParameter("ownerID"));
			HallDAO dao = new HallDAO();
			List<Hall> list = dao.getHallListByOwner(ownerID);
			if (list != null) {
				request.setAttribute("hallList", list);
				request.setAttribute("hallCount", list.size());
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewHallList.jsp");
				dispatcher.forward(request, response);
			}
			else 
			{
				response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
			}
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}	
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
