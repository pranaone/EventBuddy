<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Home Page</title>
</head>
<body>
<% session.setAttribute("ownerID","301"); %>


<h1>Owner Dash board</h1>
<form action="ViewHallList" method="get">
<input type="hidden" name="ownerID" value="<%=session.getAttribute("ownerID")%>"/>
<input type="submit" value="Manage Hall">
</form>
<br><br>
</body>
</html>