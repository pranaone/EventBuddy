<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp" %>
<%@page import="java.util.List" %> 
<%@page import="com.eb.model.Event"%> <%-- Import Java class for list --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<meta charset="ISO-8859-1">
<style>.table{
  width: auto !important;
  text-align: center;
}</style>
<title>Event List</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Event Buddy</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="OwnerHome.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ViewHallList?ownerID=<%=session.getAttribute("ownerID")%>" >Manage Halls</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="OwnerReport?ownerID=<%=session.getAttribute("ownerID")%>">View Report</a>
      </li>
    </ul>   
    <form class="form-inline my-2 my-lg-0" action="LogoutUser" method="get">
    <strong style="color:white" > <%=session.getAttribute("ownerName")%> </strong> &nbsp; &nbsp;
    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Logout</button>
	</form>
  </div>
</nav>
<hr>
	<h1 align="center">Event List</h1>
<hr>
<center>
<table class="table table-bordered table-striped" id="myTable1">
	<thead>
	<tr>
		<th>Name</th> <th>Type</th> <th>Description</th> <th>Date</th> <th>Start Time</th> <th>End Time</th> <th>Ticket Price</th> <th>Image</th> <th> Options</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="event" items="${eventList}">
		<tr>
			<td>${event.eventName}</td>
			<td>${event.eventType}</td>
			<td>${event.eventDescription}</td>
			<td>${event.eventDate}</td>
			<td>${event.startTime}</td>
			<td>${event.endTime}</td>
			<td>${event.ticketPrice}</td>
			<td><img src="${event.eventImage}" width="100" height="50"></td>			
			<td>
				<a href="<%=request.getContextPath()%>/SearchEvent?id=${event.eventId}&hid=<%=request.getAttribute("hallId")%>" class="btn btn-warning" > Update </a>
				<a href="<%=request.getContextPath()%>/DeleteEvent?id=${event.eventId}&hid=<%=request.getAttribute("hallId")%>" 
				onclick="if(!confirm('Are you sure to delete the event?')) return false" class="btn btn-danger"> Delete </a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<hr>	
	<a href="CreateEvent.jsp?hid=<%=request.getAttribute("hallId")%>" class="btn btn-success"> Create Event </a> &nbsp;
	<a href="javascript:history.back()" class="btn btn-secondary"> Go Back </a>
<hr>
</center>
<script>
$(document).ready(function(){
    $('#myTable1').dataTable();
});
</script>
</body>
</html>