<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Create Hall</title>
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
<center>
<hr>
<h2>Create Hall</h2>
<hr>
<br>
<form action="CreateHall" method="post">
<pre>
Hall Name: 	<input type="text" name="hallName" maxlength="25" required/> <br>
Hall Type: 	<input type="text" name="hallType" maxlength="25" required/> <br>
Hall Location: 	<input type="text" name="hallLocation" maxlength="50" required/> <br>
Hall Contact: 	<input type="text" name="hallContact" maxlength="10" required/> <br>
No of Seats: 	<input type="number" name="noOfSeats" required/> <br>
				<input type="hidden" name="ownerID" value="<%=session.getAttribute("ownerID")%>"/>
</pre>
<hr>
<input type="submit" value="Create" class="btn btn-success"/> &nbsp; <input type="reset" value="Clear" class="btn btn-warning" /> &nbsp;  <a href="javascript:history.back()" class="btn btn-secondary">Go Back</a>
<hr>

</form>
</center>

</body>
</html>