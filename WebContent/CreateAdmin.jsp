<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Register Admin</h2>
<form action="RegisterAdmin" method="post">
<pre>
Username:	<input type="text" name="username" maxlength="10" required/> <br><br>
Password:	<input type="password" name="password" maxlength="10" required/> <br><br>			 
	<input type="submit" value="Create Account"/> &nbsp; <input type="reset" value="Clear"/>
			<font color="red">${message}</font>
<br><br>

</pre>
</form>
</body>
</html>