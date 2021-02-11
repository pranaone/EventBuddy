<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp" %>

<%@page import="java.util.List" %> 
<%@page import="com.eb.model.Hall"%> <%-- Import Java class for list --%>
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
<title>Hall List</title>
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
        <a class="nav-link" href="OwnerHome.jsp"> Home <span class="sr-only">(current)</span></a>
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
<h1 align="center">Hall List</h1>
<hr>
<center>
	<table class="table table-bordered table-striped" id="myTable">
	<thead>
	<tr>
		<th>Name</th> <th>Type</th> <th>Location</th> <th>Contact</th> <th>Seats</th><th>Manage</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="hall" items="${hallList}">
	<tr >
		<td>${hall.hallName}</td>
		<td>${hall.hallType}</td>
		<td>${hall.hallLocation}</td>
		<td>${hall.hallContact}</td>
		<td>${hall.noOfSeats}</td>					
		<td>
			<a href="<%=request.getContextPath()%>/SearchHall?id=${hall.hallId}" class="btn btn-warning"> Update </a>
			<a href="<%=request.getContextPath()%>/DeleteHall?id=${hall.hallId}&oid=<%=session.getAttribute("ownerID")%>"
			onclick="if(!confirm('Are you sure to delete the hall?')) return false" class="btn btn-danger"> Delete </a>
			<a href="<%=request.getContextPath()%>/ViewEventList?hid=${hall.hallId}" class="btn btn-primary"> Events </a>
		</td>
	</tr>
	</c:forEach>
	</tbody>	
	</table>
</center>
<div align="center">
<hr>
	<a href="CreateHall.jsp" class="btn btn-success"> Create Hall </a> &nbsp; <a href="OwnerHome.jsp" class="btn btn-secondary"> Go Back </a>
<hr>
</div>
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>	
</body>
</html>