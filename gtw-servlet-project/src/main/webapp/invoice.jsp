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
  		Enumeration<String> en=session.getAttributeNames();
		while(en.hasMoreElements()){
			String name=en.nextElement();
			String value=(String)session.getAttribute(name);
			out.println("<h2>"+name+":"+value+"</h2>");
		}
		%>
	    <form action= <%= response.encodeURL("shop1.demo") %> method="post">
    	    <input type="hidden" name="formid" value="shopping" />
    	    <input type="hidden" name="shopid" value="shop1" />
        	<button type="submit" class="btn btn-primary btn-block btn-large">Back to Shopping</button>
    	</form>
	</div>
</body>
</html>
