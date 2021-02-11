package com.eb.servlet.event;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.eb.dao.EventDAO;
import com.eb.model.Event;


@WebServlet("/UpdateEvent")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";

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
		/*String imageURL= request.getParameter("eventImage");
		if(imageURL==null || imageURL.isEmpty())
		{
			imageURL = "https://rangrezz.chitkara.edu.in/assets/images/stagetheater.jpg";
		}*/
		EventDAO edao = new EventDAO();
		boolean updateEvent=false;
		
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
	        Event event = new Event(id,name,type,description,date,stime,etime,price,dbFileName);
	        updateEvent =edao.updateEvent(event); 
		}
		else 
		{
			Event event = new Event(id,name,type,description,date,stime,etime,price);
			updateEvent = edao.updateEventWithoutImage(event);
		}
        
        if(updateEvent)
		{
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
