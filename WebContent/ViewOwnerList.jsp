<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@page import="java.util.List" %> 
<%@page import="com.eb.model.Owner"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<style>.table{
  width: auto !important;
  text-align: center;
}</style>
<title>Owner List</title>
</head>
<body>
<% 
	if(session.getAttribute("adminName")==null)
	{
		response.sendRedirect("Login.jsp");
	}
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Event Buddy</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="ViewOwnerList">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>   
    <form class="form-inline my-2 my-lg-0" action="LogoutUser" method="get">
    <strong style="color:white" > Admin User </strong> &nbsp; &nbsp;
    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Logout</button>
	</form>
  </div>
</nav>
<hr>
<h2 align="center"> Manage Owners </h2>
<hr>
<center>
	<table class="table table-bordered table-striped">
	<tr>
	<th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile</th><th>BR Number</th><th colspan=2>Options</th>
	</tr>
	<c:forEach var="owner" items="${ownerList}">
		<tr>
		<td>${owner.firstName}</td>
		<td>${owner.lastName}</td>
		<td>${owner.email}</td>
		<td>${owner.mobile}</td>
		<td>${owner.brNo}</td>					
		<td>
		<a href="<%=request.getContextPath()%>/SearchOwner?id=${owner.ownerId}" class="btn btn-warning"> Update </a>
		</td>
		<td><a href="<%=request.getContextPath()%>/DeleteOwner?id=${owner.userId}" 
			onclick="if(!confirm('Are you sure to delete the owner?')) return false" class="btn btn-danger" > Delete </a>
		</td>
		</tr>
	</c:forEach>
	</table>
<center>
<div align="center">
<hr>
	<a href="CreateOwner.jsp" class="btn btn-success"> Create Account </a> &nbsp;
	<a href="javascript:history.back()" class="btn btn-secondary"> Go Back </a>
<hr>
</div>
</body>
</html>