<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-Workz</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 

crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-light bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="" width="80" height="48">
    </a>
</div>
</nav>
</head>

<body>

<h1>Welcome To SignUp Page</h1>

<h1 style="color: green;">${save}</h1>
<%-- <h1 stype="color: red;">${message}</h1>  --%>

<c:forEach items="${errors}" var="e">
<span style="color:red;">${e.message}</span>
</c:forEach>
<form action="signUp" method="post">

User Id<input id="userId"  	name="userId" placeholder="enter user id" type="text" onchange="onUser()"/>
<span id="idError" style="color:red"></span>
<h5 style="color: red">${existingUserId}</h5>
<span id="displayUserId" style="color: red"></span>
 
Email Id<input id="email" name="email" placeholder="enter your email id" type="text" onchange="validEmail()"/><br><br>
<span id="userEmailError" style="color:red"></span>
<span id="display" style="color: red;"></span>
<h5 style="color: red">${existingEmail}</h5>

Mobile No<input id="mobile" name="mobileNo" placeholder="enter your mobile number" type="number" onclick="mobileValidate()"/><br><br>
<span id="mobileError" style="color:red"></span>
<h5 style="color: red">${existingMobileNo}</h5>

Password<input name = "password" id="passwords" placeholder="enter password" type="password"/><br><br>
<span id="passwordError" style="color:red"></span>
<input type="checkbox" onclick="myPassword()">Show Password<br>


Confirm Password<input name = "confirmPassword" id="confirmPassword" placeholder="reenter password" type="password" onchange="validPassword()"/><br><br>
<span id="comparePassword" style="color:red"></span><br>

Accept Agreement<input id="acceptAgreement" type="checkbox" onclick="onAgreement()"/><br><br>

<input type="submit" id="submitId" disabled="true"/>

<script>


function onUser(){
var id = document.getElementById('userId');
  var ref = id.value;
  console.log(ref);
  if(ref!=null && ref!="" && ref.length>3 && ref.length<20){
	  console.log('valid user id');
  }
  else{
	  console.log('invalid user id');
  }
  
  const xhttp = new XMLHttpRequest();
  console.log("Running in ajax");
  console.log(ref);
  xhttp.open("GET", "http://localhost:8080/xworkz-shwetha-cm/userId/" +ref);
  xhttp.send();
  
  xhttp.onload = function(){
	  console.log(this);
	  
	  document.getElementById("displayUserId").innerHTML = this.responseText;
  }
  
}

function mobileValidate() {
	var userMobile = document.getElementById('mobile');
	var userMobilevalue = mobile.value;
	console.log(userMobilevalue);
	if (userMobilevalue != null && userMobilevalue != ""
			&& userMobilevalue.length == 10) {
		console.log('valid mobile number');
		document.getElementById('mobileError').innerHTML = '';
	} else {
		console.log('invalid mobile number');
		document.getElementById('mobileError').innerHTML = 'Plese enter valid Mobile Number';
 	}
}

function validEmail()
{
	  var user = document.getElementById('email');
	  var uservalue = user.value;
	  console.log(uservalue);
	  if(uservalue != null && uservalue != "" && uservalue.length>3 && uservalue.length<50)
		  {
		    console.log('valid email');
		  
		    document.getElementById('userEmailError').innerHTML = '';
		  }
	  else
		  {
		    console.log('invalid userId');
		    document.getElementById('submitId').disabled = 'disabled';
		    document.getElementById('userEmailError').innerHTML = 'Please enter the valid email min 3 and max 50';
		  }
	  const xhttp = new XMLHttpRequest();
	console.log('Running in ajax');
	console.log(uservalue);
	xhttp.open("GET", "http://localhost:8080/xworkz-shwetha-cm/email/"+ uservalue);
	xhttp.send();
	xhttp.onload = function() {
		console.log(this);
		document.getElementById("display").innerHTML = this.responseText
   }  
}
	
function myPassword(){
	
var password =	document.getElementById("passwords");
	if(password.type=='password'){
		password.type='text';
	}else{
		password.type='password';
	}
}

function validPassword(){
	
	var valid = document.getElementById('passwords');
	var confirmPassword = document.getElementById('confirmPassword');
	var PasswordValue = valid.value;
	var confirmPasswordValue = confirmPassword.value;
	console.log(PasswordValue);
	if (PasswordValue != null && PasswordValue != ""&& PasswordValue.length > 8 && PasswordValue.length < 12) {
		if (PasswordValue == confirmPasswordValue) {
			console.log('valid, both password are same');
			document.getElementById('comparePassword').innerHTML = '';
		} else {
			console.log('password not matching');
			document.getElementById('comparePassword').innerHTML = 'Password and ConfirmPassword must be same';
		}
		console.log('valid password');
		document.getElementById('passwordError').innerHTML = '';
	} else {
		console.log('invalid password');
		document.getElementById('passwordError').innerHTML = 'Plese enter valid password';
	}
}
function onAgreement(){
	var agreement = document.getElementById('acceptAgreement');
	console.log(agreement.checked);
	if(agreement.checked){
		document.getElementById('submitId').disabled=false;
	}
	else{
		document.getElementById('submitId').disabled='disabled';
	}
}



</script>
</form>
</body>
</html>