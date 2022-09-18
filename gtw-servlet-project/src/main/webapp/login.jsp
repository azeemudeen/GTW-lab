<%@page import="java.net.HttpURLConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="res/css/style.css" />
</head>
<body>
<div class="container">
  <h1>Login</h1>
    <form action="login.demo" method="post">
    	<input type="hidden" name="formid" value="login" />
    	<input type="text" name="uname" placeholder="Username" required="required" />
    	<input type="password" name="upass" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>
    </form>
	<% 
        if(response.getStatus() == HttpURLConnection.HTTP_UNAUTHORIZED){
        	out.print("<h3>Incorrect Credentials,Try Again!</h3>");
        	out.print("<button class=\"btn btn-block \"><a href=\"register.html\">Click here to Register..</a></button>");
        }        
	%>
</div>
</body>
</html>