<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Event</title>
</head>
<body>
<h2>Create Event</h2>
<form action="CreateEvent" method="post" enctype="multipart/form-data" id="eventform">
<pre>
Event Name: 	<input type="text" name="eventName" required/> <br><br>
Event Type: 	<input type="text" name="eventType" required/> <br><br>
Description:    <textarea name="eventDescription" form="eventform" required></textarea> <br><br>
Event Date: 	<input type="date" name="eventDate" required/> <br><br>
Start Time: 	<input type="time" name="startTime" required/> <br><br>
End Time: 	<input type="time" name="endTime" required/> <br><br>
Ticket Price:	<input type="number" name="ticketPrice" required/> <br><br>
Event Image:	<input type="file" accept=".jpg" name="eventImage"/> <br><br>
				<input type="hidden" name="hallId" value="<%=request.getParameter("hid")%>"/> 
			<input type="submit" value="Create"/> &nbsp; <input type="reset" value="Clear"/>
</pre>
</form>
<a href="javascript:history.back()">Go Back</a>
</body>
</html>