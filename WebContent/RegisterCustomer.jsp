<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
<meta charset="ISO-8859-1">

<title>Customer Registration</title>
<script>
    function validateForm() {
        var username, password, firstName, lastName, email, mobile, nicNo = "";
        var alertMessage = "";
        var passwordRegex = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z!#@$^%&? "])[a-zA-Z0-9!#@^$%&?]{6,25}$/;

        password = document.forms["ownerForm"]["password"].value;

        
        if(!passwordRegex.test(password)) {
            alertMessage += "Password must atleast contain 6 characters minimum\n" + "Password must only contain 25 characters at max\n"
                            + "Password must contain atleast 1 uppercase character\n" +  "Password must contain atleast 1 lowerase character\n"
                            + "Password must contain atleast 1 digit\n" + "Password must contain atleast 1 one special character\n";
        }
        if(alertMessage.length>10) {
            alert(alertMessage);
            return false;
        }
}
</script>
</head>
<body>
<hr>
<h1 align="center"> Customer Registration </h1>
<hr>
<br>
<center>
<form name="ownerForm" action="RegisterCustomer" method="post" onsubmit="return validateForm()">
<pre>
User Name:	<input type="text" name="userName" minlength="6" maxlength="25" required/> 
<br>
Password:	<input type="password" name="password" minlength="6" maxlength="25" required/> 
<br>
First Name:	<input type="text" name="firstName" minlength="3" maxlength="25" required/>
<br>
Last Name:	<input type="text" name="lastName" minlength="3" maxlength="25" required/> 
<br>
E-mail Address:	<input type="email" name="email" maxlength="50" required/> 
<br>
Mobile Number:	<input type="tel"  name="mobile" maxlength="10" required/> 
<br>
NIC Number:	<input type="text" name="nicNo" minlength="10" maxlength="15" required/> 
<br>
</pre>
<hr>
	<input type="submit" value="Create Account" class="btn btn-success"/> &nbsp; <input type="reset" value="Clear" class="btn btn-warning"/> &nbsp; <a href="Login.jsp" class="btn btn-secondary"> Go Back </a>
<hr>			

</form>
</center>	
</body>
</html>