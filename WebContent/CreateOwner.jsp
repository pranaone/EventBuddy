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
<title>Register Owner</title>

<script>
    function validateForm() {
        var username, password, firstName, lastName, email, mobile, brNo = "";
        var alertMessage = "";
        var passwordRegex = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z!#@$^%&? "])[a-zA-Z0-9!#@^$%&?]{6,25}$/;
        var emailRegex = /\S+@\S+\.\S+/;
        var mobileRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
        username = document.forms["ownerForm"]["userName"].value.trim();
        password = document.forms["ownerForm"]["password"].value;
        firstName = document.forms["ownerForm"]["firstName"].value.trim();
        lastName = document.forms["ownerForm"]["lastName"].value.trim();
        email = document.forms["ownerForm"]["email"].value.trim();
        mobile = document.forms["ownerForm"]["mobile"].value.trim();
        brNo = document.forms["ownerForm"]["brNo"].value.trim();
        if(username.length==0) {
            alertMessage += "Username must be filled out\n";
        }
        if(username.length<6) {
            alertMessage += "Username must atleast contain 6 characters minimum\n";
        }
        if(username.length>25) {
            alertMessage += "Username must only contain 25 characters at max\n";
        }
        if(!passwordRegex.test(password)) {
            alertMessage += "password must atleast contain 6 characters minimum\n" + "password must only contain 25 characters at max\n"
                            + "password must contain atleast 1 uppercase character\n" +  "password must contain atleast 1 lowerase character\n"
                            + "password must contain atleast 1 digit\n" + "password must contain atleast 1 one special character\n";
        }
        if(firstName.length==0) {
            alertMessage += "First Name must be filled out\n";
        }
        if(firstName.length<3) {
            alertMessage += "First Name must atleast contain 3 characters minimum\n";
        }
        if(firstName.length>25) {
            alertMessage += "First Name must only contain 25 characters at max\n";
        }
        if(lastName.length==0) {
            alertMessage += "Last Name must be filled out\n";
        }
        if(lastName.length<3) {
            alertMessage += "Last Name must atleast contain 3 characters minimum\n";
        }
        if(lastName.length>25) {
            alertMessage += "Last Name must only contain 25 characters at max\n";
        }
        if(!emailRegex.test(email)) {
            alertMessage += "Please provide a valid email address\n";
        }
        if(email.length>50) {
            alertMessage += "email can only have a maximum of 50 characters\n";
        } 
        if(!mobileRegex.test(mobile)) {
            alertMessage += "please provide a valid mobile number with 10 digits\n";
        }
        if(isNaN(brNo)) {
            alertMessage += "please provide a valid br number with digits only\n";
        }else if(brNo.length>10) {
            alertMessage += "please provide a valid br number within 10 digits only\n";
        }
        
        if(alertMessage.length>10) {
            alert(alertMessage);
            return false;
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
        <a class="nav-link" href="ViewOwnerList">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>   
    <form class="form-inline my-2 my-lg-0" action="LogoutUser" method="get">
    <strong style="color:white" > Admin User </strong> &nbsp; &nbsp;
    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Logout</button>
	</form>
  </div>
</nav>
<center>
<hr>
<h2>Register Owner</h2>
<hr>
<br>
<form name="ownerForm" action="CreateOwner" method="post" onsubmit="return validateForm()">
<pre>
User Name:	<input type="text" name="userName" required/> 

Password:	<input type="password" name="password" required/> 

First Name:	<input type="text" name="firstName" required/> 

Last Name:	<input type="text" name="lastName" required/> 

E-mail Address:	<input type="email" name="email" required/> 

Mobile Number:	<input type="text" name="mobile" required/>

BR Number:	<input type="text" name="brNo" required/> 

</pre>
<hr>
<input type="submit" value="Create Account" class="btn btn-success"/> &nbsp; <input type="reset" value="Clear" class="btn btn-warning"/> &nbsp; <a href="javascript:history.back()" class="btn btn-secondary">Go Back</a>
<hr>
</form>
</center>
</body>
</html>