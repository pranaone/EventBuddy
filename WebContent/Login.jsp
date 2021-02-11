<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Login</title>
</head>
<body>
<hr>
<h1 align="center">Event Buddy</h1>
<hr>
<br>
<h4 align="center">Please login to continue</h4>

<center>

<font color="red"> ${message} </font> 
<br>

<form action="LoginUser" method="post" class="form-group">

Username : <input type="text" name="username"  maxlength="25" required/> 
<br>
<br>
Password : <input type="password" name="password" maxlength="25" required/> 
<br>
<br>
<input type="submit" value="Login" class="btn btn-outline-primary"/> &nbsp; <input type="reset" value="Clear" class="btn btn-outline-secondary"/> 
<br>

</form>
<hr>
<strong> Don't have an account ? </strong> &nbsp; <a href="RegisterCustomer.jsp" class="btn btn-outline-success"> Register Now </a>
<hr>


</center>



</body>
</html>