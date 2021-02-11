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
<title>Update Event</title>
<script>	
function validateDate(val){
	var today = new Date();
	var checkDate = new Date(val);
	if(checkDate<today)
	{
		alert("Back dated events cannot be created!!");
		document.getElementById("eventDate").value = today.toLocaleDateString('fr-CA');
	}
}
function validateTime(val){
	var x = document.getElementById("startTime").value;
	console.log(x);
	console.log(val);
	if(val<x)
	{
		alert("End time cannot be less than start time!!");
		document.getElementById("endTime").value = "";
	}
}
</script>
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
<h2 align="center">Update Event</h2>
<hr>
<br>
<form action="UpdateEvent" method="post" id="eventform" enctype="multipart/form-data">
<pre>
Event Name:	<input type="text" name="eventName" value="${event.eventName}" maxlength="25" required /> <br>
Event Type:	<input type="text" name="eventType" value="${event.eventType}" maxlength="25" required /> <br>
Description:	<textarea name="eventDescription" form="eventform" maxlength="100" required>${event.eventDescription}</textarea> <br>
Event Date:	<input type="date" name="eventDate" value="${event.eventDate}" onchange="validateDate(this.value)" id="eventDate" required/> <br>
Start Time:	<input type="time" name="startTime" value="${event.startTime}" id="startTime" required/> <br>
End Time:	<input type="time" name="endTime" value="${event.endTime}" id="endTime" onchange="validateTime(this.value)" required/> <br>
Ticket Price:	<input type="number" name="ticketPrice" value="${event.ticketPrice}" required/> <br>
Event Image: <input type="file" accept="image/*" name="eventImage"/>
  
<img src="${event.eventImage}" width="100" height="50"/>
<input type="hidden" name="eventId" value="${event.eventId}"/> <input type="hidden" name="hallId" value="<%=request.getParameter("hid")%>"/> 
</pre>
<hr>
<input type="submit" value="Update" class="btn btn-success"/> &nbsp; <input type="reset" value="Clear" class="btn btn-warning" /> &nbsp; <a href="javascript:history.back()" class="btn btn-secondary">Go Back</a>
<hr>
</form>
</center>

</body>
</html>