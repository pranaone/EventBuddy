<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.eb.model.Seat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Success</title>
</head>
<style>

ul li {
  margin-bottom:1.4rem;
}
.pricing-divider {
border-radius: 20px;
background: #C64545;
padding: 1em 0 4em;
position: relative;
}

.green .pricing-divider {
background: #1AA85C; 
}

.green b {
  color:#1AA85C
}

.deco-layer {
	-webkit-transition: -webkit-transform 0.5s;
	transition: transform 0.5s;
}
.btn-custom  {
  background:#C64545; color:#fff; border-radius:20px
}

.btn-primary  {
  border-radius:20px
}

.btn-warning  {
  border-radius:20px
}

.img-float {
  width:50px; position:absolute;top:-3.5rem;right:1rem
}

.princing-item {
  transition: all 150ms ease-out;
}
.princing-item:hover {
  transform: scale(1.05);
}
.princing-item:hover .deco-layer--1 {
  -webkit-transform: translate3d(15px, 0, 0);
  transform: translate3d(15px, 0, 0);
}
.princing-item:hover .deco-layer--2 {
  -webkit-transform: translate3d(-15px, 0, 0);
  transform: translate3d(-15px, 0, 0);
}

</style>
<body>
<%
ArrayList<Seat> seatList = (ArrayList<Seat>)session.getAttribute("seatArrayList");

%>
<hr style="border: 10px solid green;border-radius: 5px;">
<div class="container-fluid p-5">
      <div class="row text-center w-75">
        <div class="col-md-4 princing-item green"></div>
        <div class="col-md-4 princing-item green">
          <div class="pricing-divider ">
              <h3 class="text-light">${event.eventName}</h3>
            <h4 class="my-0 display-2 text-light font-weight-normal mb-3"><span class="h3">Rs.&nbsp;</span> ${ticketPrice} </h4>
          </div>
			
          <div class="card-body bg-white mt-0 shadow">
            <ul class="list-unstyled mb-5 position-relative">
              <li><b> On </b> ${event.eventDate} </li>
              <li><b> Starts at: </b> ${event.startTime} </li>
              <li><b> Ends at: </b> ${event.endTime} </li>
              <li><b> No of Tickets: </b> ${noOfTickets} </li>
             	
             	
             	<li><b> Seat Numbers </b> <% for(Seat s:seatList){ %> <%= s.getSeatNo() %> <% } %></li>
            </ul>
            <button type="button" class="btn btn-lg btn-block  btn-custom" onclick="window.print()"> Print Ticket </button>
            <form action="LogoutUser" method="get"><button type="submit" class="btn btn-lg btn-block  btn-warning">Logout</button></form>
            <form action="ViewAllEvents" method="get"><button type="submit" class="btn btn-lg btn-block  btn-primary">Home</button></form>
            
          </div>
        </div>
      </div>
    </div>
 <hr style="border: 10px solid green;border-radius: 5px;">
</body>
</html>