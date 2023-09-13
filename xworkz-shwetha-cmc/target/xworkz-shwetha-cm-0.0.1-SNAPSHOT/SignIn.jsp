
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

<h1>Welcome To SignIn Page</h1>

<h1 style="color: green;">${save}</h1>
<%-- <h1 stype="color: red;">${message}</h1>  --%>

<c:forEach items="${errors}" var="e">
<span style="color:red;">${e.message}</span>
</c:forEach>

<form action="signIn" method="post">
User Id<input id="userId"  	name="userId" placeholder="enter user id" type="text"/>
 
Password<input name = "password" id="passwords" placeholder="enter password" type="password"/><br><br>

<input type="submit" value="SignIn">

</form>
</body>
</html>