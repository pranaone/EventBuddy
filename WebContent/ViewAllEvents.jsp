<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %> 
<%@page import="com.eb.model.Event"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>



<style>
.new-deal{width:100%;float:left;padding:15px 0;}
.new-deal .item-slide{position: relative;overflow: hidden;transition:all .5s ease;-moz-transition:all .5s ease;-webkit-transition:all .5s ease;margin:15px 0;}
.new-deal .slide-hover{ position: absolute;height: 100%;width: 100%;left: -100%; background:rgba(0,0,0,.5);top: 0;transition:all .5s ease;-moz-transition:all .5s ease;-webkit-transition:all .5s ease;-moz-border-radius: 5px; border-radius: 5px;-webkit-border-radius: 5px;  }
.new-deal .item-slide:hover .slide-hover{left:0px;}
.new-deal img{max-width:100%;}
.text-wrap {position: absolute;bottom: 0;left: 0;width: 100%;color: #fff;background: rgba(0, 0, 0, .5);z-index:999;transition:all .5s ease;-moz-transition:all .5s ease;-webkit-transition:all .5s ease;}
.text-wrap h4{padding:0 5px;}
.box-img{width: 100%;   float: left;    -moz-border-radius: 5px; border-radius: 5px;-webkit-border-radius: 5px;    overflow: hidden;    border: 1px solid #ccc;}
.text-wrap .desc{width:50%;float:left;padding:0 5px;}
.text-wrap p{padding: 15px;font-size: 15px;text-align: center;font-weight: normal;text-shadow: 2px 2px 3px #000;}
.text-wrap .desc h4{margin:0px;font: 400 17px/21px "Roboto";}
.text-wrap .desc h3{margin:0px;font: 400 32px/36px "Roboto";}
.new-deal .item-slide:hover .text-wrap{background:none}
.book-now-c {float:right;padding:10px;}
.book-now-c a {background: #029a8b;color: #fff;padding: 5px;border-radius: 5px;margin-top:0px;float: left;min-width: 101px;text-align: center;font-size: 16px;}
.new-deal .item-slide:hover .box-img .text-wrap{bottom:-100%;}

</style>
<title>Events</title>
</head>
<body>
<% 
	if(session.getAttribute("customerID")==null)
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
        <a class="nav-link" href="CustomerHome.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="LogoutUser">Logout<span class="sr-only">(current)</span></a>
      </li>
    </ul>   
  </div>
</nav>
<hr>
<h1 style="text-align: center;"> Available Events </h1>
<hr>
<section class="new-deal">
<div class="container">
<c:forEach var="event" items="${eventList}">
<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 deal deal-block">
	<div class="item-slide">
		<div class="box-img">
			<img src="${event.eventImage}" alt="Image" width="450" height="150"/>
				<div class="text-wrap">
					<h4>${event.eventName}&nbsp;<span class="deal-data"><span class="glyphicon glyphicon-calendar"></span>&nbsp;On &nbsp;${event.eventDate}&nbsp;<br>From ${event.startTime}&nbsp;To&nbsp;${event.endTime} </span></h4>
					<div class="desc">									
						<h3>Rs.${event.ticketPrice}</h3>
					</div>
					<div class="book-now-c">								
						<a href="<%=request.getContextPath()%>/ViewAllSeats?eventId=${event.eventId}">View Seats</a>
					</div>
				</div>
			</div>
			<div class="slide-hover">
				<div class="text-wrap">
					<p>${event.eventDescription}</p>
					<h4>${event.eventName}&nbsp;<span class="deal-data"><span class="glyphicon glyphicon-calendar"></span>&nbsp;On &nbsp;${event.eventDate}&nbsp;<br>From ${event.startTime}&nbsp;To&nbsp;${event.endTime} </span></h4>
					<div class="desc">									
						<h3>Rs.${event.ticketPrice}</h3>
					</div>
					<div class="book-now-c">
						<a href="<%=request.getContextPath()%>/ViewAllSeats?eventId=${event.eventId}">View Seats</a>
					</div>
				</div>
			</div>			
	</div>
</div>
</c:forEach>
</div>	
</section>


</body>
</html>