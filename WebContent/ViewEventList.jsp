<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp" %>

<%@page import="java.util.List" %> 
<%@page import="com.eb.model.Event"%> <%-- Import Java class for list --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event List</title>
</head>
<body>
	<h1>Event List</h1>
	<table border="1">
	<tr>
	<th>Name</th><th>Type</th><th>Description</th><th>Date</th><th>Start Time</th><th>End Time</th><th>Ticket Price</th><th>Image</th><th colspan=2>Options</th>
	</tr>
	<c:forEach var="event" items="${eventList}">
		<tr>
		<td>${event.eventName}</td>
		<td>${event.eventType}</td>
		<td>${event.eventDescription}</td>
		<td>${event.eventDate}</td>
		<td>${event.startTime}</td>
		<td>${event.endTime}</td>
		<td>${event.ticketPrice}</td>
		<td><img src="${event.eventImage}" alt="${event.eventName}" width="75" height="75"></td>				
		<td>
		<a href="<%=request.getContextPath()%>/SearchEvent?id=${event.eventId}&hid=<%=request.getAttribute("hallId")%>">Update</a>
		</td>
		<td>
		<a href="<%=request.getContextPath()%>/DeleteEvent?id=${event.eventId}&hid=<%=request.getAttribute("hallId")%>" 
			onclick="if(!confirm('Are you sure to delete the event?')) return false"> Delete</a>
		</td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="CreateEvent.jsp?hid=<%=request.getAttribute("hallID")%>">Create Event</a> 
	<br><br>
	<a href="javascript:history.back()">Go Back</a>
</body>
</html>