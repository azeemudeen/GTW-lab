<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  		<%
			Map<String,String> shoppingList = (Map<String,String>) session.getAttribute("shoppingList");
			Iterator<Map.Entry<String,String>> iter = shoppingList.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String,String> entry = (Map.Entry<String,String>) iter.next();
				String name = entry.getKey();
				String value = entry.getValue();
				out.println("<h2>"+name+":"+value+"</h2>");
			}
			shoppingList.entrySet().stream().map(entry -> entry.getKey()).forEach(out::print);
		%>
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