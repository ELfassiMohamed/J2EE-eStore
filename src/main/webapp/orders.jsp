<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.store.app.connection.*" %>
	<%@ page import="com.store.app.model.*" %>
	<%@ page import="com.store.app.dao.*" %>
	<%@ page import="java.util.*" %>
<% User auth = (User) request.getSession().getAttribute("auth"); 
List<Order> orders = null ;
	if(auth != null){
		request.setAttribute("auth", auth);
		 orders = new OrderDao(dbConnection.getConnection()).userOrders(auth.getId());
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
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
						<% if(orders != null){
					for(Order o:orders){ %>
						<tr>
						<td><%= o.getDate() %></td>
						<td><%= o.getName() %></td>
						<td><%= o.getQuantity() %></td>
						<td><%= o.getPrice() %> $</td>
						<td><a href="orderops?action=removeOrder?id=<%= o.getOrder_id() %>" class="btn btn-sm btn-danger">Remove</a></td>
					</tr>
					<%}
					} %>
					</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>