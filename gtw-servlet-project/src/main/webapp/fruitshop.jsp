<%@page import="com.goldentouch.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.goldentouch.service.ProductServiceImpl"%>
<%@page import="com.goldentouch.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Shop</title>
    <link rel="stylesheet" type="text/css" href="res/css/shop.css"> 
	<link rel="stylesheet" type="text/css" href="res/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
    <script src="res/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container-fluid">
        <h2 class="mt-3 mb-3 p-5 text-center bg-light"><b>Fruit Shop</b></h2>
        <form action= <%= response.encodeURL("shop.demo") %>  method="post">
	    	<input type="hidden" name="formid" value="shopping" />
	    	<input type="hidden" name="shopid" value="shop2" />
	        <div class="row">
	            <div class="d-flex align-content-center flex-wrap">
	            <%
	            ProductService productService = new ProductServiceImpl();
	           	List<Product> fruitProducts = productService.getFruitShopProducts();
	           	for(Product fruit : fruitProducts){
	           		out.print("<div class=\"card p-3 col-md-3 mt-2\">");
	           		out.print("<h4 class=\"main-heading mt-2\">"+fruit.getName()+"</h4>");
	           		out.print("<div class=\"mt-3\">");
	           		out.print("<h5>Price : $"+fruit.getPrice()+"</h5>");
	           		out.print("</div>");
	           		out.print("<div class=\"image mt-2\">");
	           		out.print("<img src=\"res/img/"+fruit.getImageUri()+"\" width=\"150\">");
	           		out.print("</div>");
	           		out.print("<div class=\"btn-group-toggle\">");
	           		out.print("<label id=\"change\" class=\"btn btn-primary btn-block mt-4\">");
	           		out.print("<input type=\"checkbox\" name=\""+fruit.getCode()+"\" value=\""+fruit.getName()+"\" autocomplete=\"off\"");
	           		out.print("<i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i> Add to Cart</label>");
	           		out.print("</div>");
	           		out.print("</div>");
	           	}
	            %>
	        <div class = "pull-right" >
	            <button type="submit" class="btn btn-success mt-4 mb-3 mr-2 col-sm-2" style ="position:fixed; bottom:0; right:0;">Next Store</button>
	        </div>
	    </div>
	    </div>
    </form>
    </div>
</body>
</html>