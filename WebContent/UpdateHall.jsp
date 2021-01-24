<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hall</title>
</head>
<body>
<h2>Update Hall</h2>
<form action="UpdateHall" method="post">
<pre>
Hall Name: 	<input type="text" name="hallName" value="${hall.hallName}" required/> <br><br>
Hall Type: 	<input type="text" name="hallType" value="${hall.hallType}" required/> <br><br>
Hall Location: 	<input type="text" name="hallLocation" value="${hall.hallLocation}" required/> <br><br>
Hall Contact: 	<input type="text" name="hallContact" value="${hall.hallContact}" required/> <br><br>
No of Seats: 	<input type="number" name="noOfSeats" value="${hall.noOfSeats}" required/> <br><br>
				<input type="hidden" name="ownerID" value="<%=session.getAttribute("ownerID")%>"/>
				<input type="hidden" name="hallID" value="${hall.hallId}"/> 
		<input type="submit" value="Update"/> 

</pre>
</form>

<a href="javascript:history.back()">Go Back</a>
</body>
</html>