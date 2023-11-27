<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.store.app.model.*" %>
	<%@ page import="java.util.*" %>
<% User auth = (User) request.getSession().getAttribute("auth"); 
	if(auth != null){
		request.setAttribute("auth", auth);
	}
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-session");
	if(cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="includes/header.jsp"%>
<title>Store Orders</title>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<div class="container my-3">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
						<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
					</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>