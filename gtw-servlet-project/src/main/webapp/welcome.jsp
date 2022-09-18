<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="res/css/style.css" />
</head>
<body>
	<div class="container">
	  	<h1> Welcome <% out.print(request.getParameter("uname")); %> </h1>
	  	
	  	<form action= <%= response.encodeURL("shop.demo") %> method="post">
   		<input type="hidden" name="formid" value="shopping" />
   		<input type="hidden" name="shopid" value="shop1" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Go Shopping</button>
        </form>
        <br>
	    <form action= <%= response.encodeURL("logout.demo") %> method="post">
   		<input type="hidden" name="formid" value="logout" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Logout</button>
    </form>
</div>
</body>
</html>