<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
<link rel="stylesheet" type="text/css" href="res/css/style.css" />
</head>
<body>
	<div class="container">
  		<h1>Invoice</h1>
	    <c:forEach var="shopEntry" items="${sessionScope.shoppingList}">
         	<h2>${shopEntry.getKey()} : ${shopEntry.getValue()}</h2>
        </c:forEach>
	    <form action= <%= response.encodeURL("shop1.demo") %> method="post">
    	    <input type="hidden" name="formid" value="shopping" />
    	    <input type="hidden" name="shopid" value="shop1" />
        	<button type="submit" class="btn btn-primary btn-block btn-large">Back to Shopping</button>
    	</form>
    	<br>
    	<form action= <%= response.encodeURL("logout.demo") %> method="post">
	   		<input type="hidden" name="formid" value="logout" />
	        <button type="submit" class="btn btn-primary btn-block btn-large">Logout</button>
        </form>
	</div>
</body>
</html>