<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<style>
* {
    margin: 0;
    padding: 0
}

html {
    height: 100%
}

body {
    background-color: #000000
}

.card0 {
    margin: 50px 12px 40px 12px;
    border: 0
}

.card1 {
    margin: 0;
    padding: 0;
    object-fit: contain;
    height: 100%
}

#heading {
    font-size: 33px;
    color: #000000;
    padding-bottom: 20px
}

.placeicon {
    font-family: fontawesome !important
}

.card2 {
    padding: 25px;
    padding-left: 35px;
    padding-right: 35px;
    margin: 0;
    height: 100%
}

.form-card .pay {
    font-weight: bold;
    color: lightgrey;
    text-transform: uppercase;
    font-size: 15px;
    letter-spacing: 2px
}

.form-card input,
.form-card textarea {
    padding: 5px 1px 10px 1px;
    border: none;
    border-bottom: 1px solid lightgrey;
    border-radius: 0px;
    margin-bottom: 35px;
    margin-top: 2px;
    width: 100%;
    box-sizing: border-box;
    font-family: montserrat;
    color: #2C3E50;
    font-size: 20px;
    letter-spacing: 1px
}

.form-card input:focus,
.form-card textarea:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    border: none;
    font-weight: bold;
    border-bottom: 1.5px solid lightgreen;
    padding-bottom: 9.5px;
    outline-width: 0
}

select.list-dt {
    border: none;
    outline: 0;
    border-bottom: 1px solid #ccc;
    padding: 12px 1px 10px 1px;
    margin: 2px 0px 30px 0px
}

select#month {
    width: 50%
}

select.list-dt:focus {
    border-bottom: 1.5px solid lightgreen
}

.btn-success {
    color: #ffffff !important;
    margin-bottom: 25px !important
}
</style>

</head>
<body>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-12 col-sm-10 col-md-12 col-lg-10">
            <div class="card card0 rounded-0">
                <div class="row">
                    <div class="col-md-5 d-block p-0 box">
                        <div class="card rounded-0 border-0 card1 pr-xl-4 pr-lg-3"> <img src="https://usa.visa.com/dam/VCOM/regional/na/us/pay-with-visa/images/contactless-how-to-640x640.jpg" height="572px"> </div>
                    </div>
                    <div class="col-md-7 col-sm-12 p-0 box">
                        <div class="card rounded-0 border-0 card2">
                        <form action="BookTicket" method="post">
                            <div class="form-card">
                                <h2 id="heading" class="">Your Payment Details</h2> <label class="pay">Name</label> <input type="text" name="holdername" placeholder="Your Name Here.." required="required">
                                <div class="row">
                                    <div class="col-12"> <label class="pay">Card Number</label> <input type="number" name="cardno" id="cr_no" placeholder="xxxx-xxxx-xxxx-xxxx" maxlength="16" required="required"> </div>
                                </div>
                                <div class="row">
                                    <div class="col-9 col-md-7"> <label class="pay">Expiration Date</label>
                                        <div class="col-12 pl-0"> <select class="list-dt pr-3 mr-4 mr-md-2 mr-lg-3" id="month" name="expmonth">
                                                
                                                <option selected>January</option>
                                                <option>February</option>
                                                <option>March</option>
                                                <option>April</option>
                                                <option>May</option>
                                                <option>June</option>
                                                <option>July</option>
                                                <option>August</option>
                                                <option>September</option>
                                                <option>October</option>
                                                <option>November</option>
                                                <option>December</option>
                                            </select> <select class="list-dt pr-3" id="year" name="expyear">
                                                
                                                <option selected>2021</option>
                                                <option>2022</option>
                                                <option>2023</option>
                                                <option>2024</option>
                                                <option>2025</option>
                                                <option>2026</option>
                                                <option>2027</option>
                                            </select> </div>
                                    </div>
                                    <div class="col-3 col-md-5"> <label class="pay">CVV</label> <input type="number" name="cvcpwd" placeholder="&#9679;&#9679;&#9679;" class="placeicon" maxlength="3" required="required"> </div>
                                </div>
                                <div class="row form-group">
                   					 <div class="col-md-6"><button class="btn btn-primary">Total Amount Rs.<%= session.getAttribute("ticketPrice") %></button></div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6"><input type="submit" value="PAY NOW" class="btn btn-success"></div>
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>