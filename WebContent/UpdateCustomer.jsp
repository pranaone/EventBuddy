<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
<center>
<hr>
<h2>Update Profile</h2>
<hr>
<br>
<form action="UpdateCustomer" method="post">
<pre>
First Name:	<input type="text" name="firstName" value="${customer.firstName}" minlength="3" maxlength="25" required/> <br>
Last Name:	<input type="text" name="lastName" value="${customer.lastName}" minlength="3" maxlength="25" required/> <br>
E-mail Address:	<input type="email" name="email" value="${customer.email}" maxlength="50" required/> <br>
Mobile Number:	<input type="tel" name="mobile" value="${customer.mobile}" maxlength="10" required/> <br>
NIC Number:	<input type="text" name="brNo" value="${customer.brNo}" maxlength="10" required/> <br>
<input type="hidden" name="ownerID" value="${customer.customerId}"/> 
<input type="submit" value="Update" class="btn btn-success"/> &nbsp; <input type="reset" value="Clear" class="btn btn-warning"/> &nbsp; <a href="javascript:history.back()" class="btn btn-secondary">Go Back</a>
</pre>
</form>
</center>
</body>
</html>