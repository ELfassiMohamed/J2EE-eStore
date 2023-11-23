<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.store.app.model.*" %>
<% User auth = (User) request.getSession().getAttribute("auth"); 
	if(auth != null){
		request.setAttribute("auth", auth);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@ include file="includes/header.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div class="container">
<div class="card-header my-3">All Products</div>
<div class="row">
	<div class="col-md-3">
			<div class="card" style="width: 18rem;">
			  <img src="..." class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">Card title</h5>
			    <h6 class="price">Price : 99$</h6>
			    <h6 class="category">Category : Vest</h6>
			    <div class="mt-3 d-flex justify-content-between">
			    <a href="#" class="btn btn-primary">Add to Cart</a>
			    <a href="#" class="btn btn-primary">Buy Now</a>
			    </div>
			  </div>
	</div>
</div>
</div>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>