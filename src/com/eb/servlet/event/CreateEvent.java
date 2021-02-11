package com.eb.servlet.event;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.eb.dao.EventDAO;
import com.eb.dao.HallDAO;
import com.eb.dao.SeatDAO;
import com.eb.model.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



@WebServlet("/CreateEvent")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class CreateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("eventName");
		String type = request.getParameter("eventType");
		String description = request.getParameter("eventDescription");
		String edate = request.getParameter("eventDate").toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(edate, formatter);
		LocalTime stime = LocalTime.parse(request.getParameter("startTime"));
		LocalTime etime = LocalTime.parse(request.getParameter("endTime")); 
		double price = Double.parseDouble(request.getParameter("ticketPrice"));
		int hallId = Integer.parseInt(request.getParameter("hallId"));
		/*String imageURL= request.getParameter("eventImage");
		if(imageURL==null || imageURL.isEmpty())
		{
			imageURL = "https://rangrezz.chitkara.edu.in/assets/images/stagetheater.jpg";
		}*/
		EventDAO edao = new EventDAO();
		boolean createEvent=false;
		
		if(request.getPart("eventImage")!=null && request.getPart("eventImage").getSize()!=0)
		{
		
			Part part = request.getPart("eventImage");//
	        String fileName = extractFileName(part);//file name

	        /**
	         * *** Get The Absolute Path Of The Web Application ****
	         */
	        String applicationPath = getServletContext().getRealPath("");
	        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
	        System.out.println("applicationPath:" + applicationPath);
	        File fileUploadDirectory = new File(uploadPath);
	        if (!fileUploadDirectory.exists()) {
	            fileUploadDirectory.mkdirs();
	        }
	        String savePath = uploadPath + File.separator + fileName;
	        System.out.println("savePath: " + savePath);
	        String sRootPath = new File(savePath).getAbsolutePath();
	        System.out.println("sRootPath: " + sRootPath);
	        part.write(savePath + File.separator);
	        File fileSaveDir1 = new File(savePath);
	        /*if you may have more than one files with same name then you can calculate some random characters
	         and append that characters in fileName so that it will  make your each image name identical.*/
	        dbFileName = UPLOAD_DIR + File.separator + fileName;
	        part.write(savePath + File.separator);
	        Event event = new Event(name,type,description,date,stime,etime,price,dbFileName);
	        createEvent = edao.createEvent(event,hallId); 
		}
		else 
		{
			String image = "https://rangrezz.chitkara.edu.in/assets/images/stagetheater.jpg";
			Event event = new Event(name,type,description,date,stime,etime,price,image);
			createEvent = edao.createEvent(event,hallId); 
		}
        
        if(createEvent)
		{
        	int createdEventID = edao.getEventByName(name).getEventId();
        	HallDAO hdao = new HallDAO();
        	int numSeats = hdao.getHallByID(hallId).getNoOfSeats();
        	if(numSeats>0)
        	{
        		SeatDAO sdao = new SeatDAO();
        		boolean createSeats = sdao.batchCreateSeats(numSeats, createdEventID);
        		if(createSeats)
        		{
        			System.out.println("Seats created!!");
        		}
        		else 
        		{
        			System.out.println("Failed to create seats!!");
        		}
        	}
        	
			response.sendRedirect(request.getContextPath() + "/ViewEventList?hid="+hallId);
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/ErrorPage.jsp");
		}
	}
	// file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
