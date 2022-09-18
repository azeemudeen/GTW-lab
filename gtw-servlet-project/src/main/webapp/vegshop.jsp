<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vegetable Shop</title>
<link rel="stylesheet" type="text/css" href="res/css/style.css" />
</head>
<body>
	<div class="container">
  		<h1>Vegetable Shop</h1>
	    <form action= <%= response.encodeURL("invoice.demo") %>  method="post">
    	    <input type="hidden" name="formid" value="shopping" />
    	    <input type="hidden" name="shopid" value="invoice" />
    	    
       	    <label class="checkbox-container">Carrot
			  <input type="checkbox" name="c1" value="Carrot">
			  <span class="checkmark"></span>
			</label>
    	    <label class="checkbox-container">Tomato
			  <input type="checkbox" name="c2" value="Tomato">
			  <span class="checkmark"></span>
			</label>
    	    <label class="checkbox-container">Onion
			  <input type="checkbox" name="c3" value="Onion">
			  <span class="checkmark"></span>
			</label>
        	<button type="submit" class="btn btn-primary btn-block btn-large">Invoice</button>
    	</form>
	</div>
</body>
</html>