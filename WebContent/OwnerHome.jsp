<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Owner Home Page</title>
</head>
<body>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Event Buddy</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<% 
	if(session.getAttribute("ownerID")==null)
	{
		response.sendRedirect("Login.jsp");
	}
%>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="OwnerHome.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ViewHallList?ownerID=<%=session.getAttribute("ownerID")%>">Manage Halls</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="OwnerReport?ownerID=<%=session.getAttribute("ownerID")%>">View Report</a>
      </li>
    </ul>   
    <form class="form-inline my-2 my-lg-0" action="LogoutUser" method="get">
    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Logout</button>
	</form>
  </div>
</nav>
<div class="card" align="center">
 				<hr>
				<h1 align="center">Welcome <%=session.getAttribute("ownerName")%> !!</h1>
				<hr>
				<br>
				<form action="ViewHallList" method="get">
				<input type="hidden" name="ownerID" value="<%=session.getAttribute("ownerID")%>"/>
				<input type="submit" value="Manage Hall" class="btn btn-success btn-md">
				</form>
				<br>
				<form action="OwnerReport" method="get">
				<input type="hidden" name="ownerID" value="<%=session.getAttribute("ownerID")%>"/>
				<input type="submit" value="View Report" class="btn btn-primary btn-md">
				</form>
				<br>
       </div>      

</body>
</html>