<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Shop</title>
<link rel="stylesheet" type="text/css" href="res/css/style.css" />
</head>
<body>
	<div class="container">
  		<h1>Fruit Shop</h1>
	    <form action= <%= response.encodeURL("shop.demo") %> method="post">
    	    <input type="hidden" name="formid" value="shopping" />
    	    <input type="hidden" name="shopid" value="shop2" />
    	    
    	    <label class="checkbox-container">Apple
			  <input type="checkbox" name="c4" value="Apple">
			  <span class="checkmark"></span>
			</label>
			
    	    <label class="checkbox-container">Orange
			  <input type="checkbox" name="c5" value="Orange">
			  <span class="checkmark"></span>
			</label>
			
    	    <label class="checkbox-container">Lemon
			  <input type="checkbox" name="c6" value="Lemon">
			  <span class="checkmark"></span>
			</label>
        	<button type="submit" class="btn btn-primary btn-block btn-large">Next Shop</button>
    	</form>
	</div>
</body>
</html>