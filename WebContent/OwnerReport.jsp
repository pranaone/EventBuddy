<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Owner Report</title>
<style>.table{
  width: auto !important;
  text-align: center;
}</style>
<script type="text/javascript">
function printDiv() 
{

  var divToPrint=document.getElementById('DivIdToPrint');

  var newWin=window.open('','Print-Window');

  newWin.document.open();

  newWin.document.write('<html><body onload="window.print()">'+divToPrint.innerHTML+'</body></html>');

  newWin.document.close();

  setTimeout(function(){newWin.close();},10);

}
</script>
</head>
<body>
<% 
	if(session.getAttribute("ownerID")==null)
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
      <li class="nav-item">
        <a class="nav-link" href="OwnerHome.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ViewHallList?ownerID=<%=session.getAttribute("ownerID")%>">Manage Halls</a>
      </li>
      <li class="nav-item active">
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
<h1 align="center">View Report</h1>
<hr>
<br>
<div id="DivIdToPrint">
<h3 align="center"> <u> Sales Report </u></h3>
<br>
<center>
<table class="table" style="text-align:left">
	<tr>
		<th>No. of Hall(s) Owned : </th>
		<td><%=request.getAttribute("hallCount")%></td>
	</tr>
	<tr>
		<th>No. of Event(s) Hosted : </th>
		<td><%=request.getAttribute("eventCount")%></td>
	</tr>
	<tr>
		<th>No. of Ticket(s) sold : </th>
		<td><%=request.getAttribute("ticketCount")%></td>
	</tr>
	<tr>
		<th>Total Collection (Rs) : </th>
		<td><%=request.getAttribute("salesAmount")%></td>
	</tr>
</table>
</center>
<br>
</div>
<div align="center">
<button onclick="printDiv()" class="btn btn-primary" > Print Report </button>
&nbsp;
<a href="OwnerHome.jsp" class="btn btn-secondary"> Go Back </a>
</div>
<br>
<hr>
</body>

</html>