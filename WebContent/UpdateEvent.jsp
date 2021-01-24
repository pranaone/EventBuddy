<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Event</title>
</head>
<body>
<h2>Update Event</h2>
<form action="UpdateEvent" method="post" id="eventform">
<pre>
Event Name: 	<input type="text" name="eventName" value="${event.eventName}" required/> <br><br>
Event Type: 	<input type="text" name="eventType" value="${event.eventType}" required/> <br><br>
Description:    <textarea name="eventDescription" form="eventform" required>${event.eventDescription}</textarea> <br><br>
Event Date: 	<input type="date" name="eventDate" value="${event.eventDate}" required/> <br><br>
Start Time: 	<input type="time" name="startTime" value="${event.startTime}" required/> <br><br>
End Time: 	<input type="time" name="endTime" value="${event.endTime}" required/> <br><br>
Ticket Price:	<input type="number" name="ticketPrice" value="${event.ticketPrice}"required/> <br><br>
				<input type="hidden" name="eventId" value="${event.eventId}"/>
				<input type="hidden" name="hallId" value="<%=request.getParameter("hid")%>"/> 
			<input type="submit" value="Update"/> &nbsp; <input type="reset" value="Clear"/>

</pre>
</form>
<a href="javascript:history.back()">Go Back</a>
</body>
</html>