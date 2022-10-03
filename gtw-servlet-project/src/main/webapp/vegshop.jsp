<%@page import= "com.goldentouch.service.ProductServiceImpl"%>
<%@page import="com.goldentouch.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.goldentouch.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vegetable Shop</title>
    <link rel="stylesheet" type="text/css" href="res/css/shop.css"> 
	<link rel="stylesheet" type="text/css" href="res/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
    <script src="res/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container-fluid">
        <h2 class="mt-3 mb-3 p-5 text-center bg-light"><b>Vegetable Shop</b></h2>
        <form action= <%= response.encodeURL("invoice.demo") %>  method="post">
	    	<input type="hidden" name="formid" value="shopping" />
	    	<input type="hidden" name="shopid" value="invoice" />
	        <div class="row">
	            <div class="d-flex align-content-center flex-wrap">
	            <c:forEach var="veg" items="${sessionScope.vegProducts}">
					<div class="card p-3 col-md-3 mt-2">
	            	<h4 class="main-heading mt-2">${veg.getName()}</h4>
		 	        <div class="mt-3">
	 	            <h5>Price : $ ${veg.getPrice()}</h5>
	 	            </div>
	 	            <div class="image mt-2">
	 	            <img src="res/img/${veg.getImageUri()}" width="150">
	 	            </div>
	 	            <div class="btn-group-toggle\">
	 	            <label id="change" class="btn btn-primary btn-block mt-4">
	 	            <input type="checkbox" name="${veg.getCode()}" value="${veg.getName()}" autocomplete="off">
	 	            <i class="fa fa-shopping-cart" aria-hidden="true"></i> Add to Cart</label>
	 	            </div>
	 	            </div>
	            </c:forEach>
	        <div class = "pull-right" style ="position:fixed; bottom:0; right:0;" >
	            <button type="submit" class="btn btn-success mt-4 mb-3 mr-2 col-sm-2" style ="position:fixed; bottom:0; right:0;">Next Store</button>
	        </div>
	    </div>
	    </div>
    </form>
    </div>
</body>
</html>