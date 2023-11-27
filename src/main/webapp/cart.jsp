<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.store.app.model.*" %>
	<%@ page import="com.store.app.dao.*" %>
	<%@ page import="com.store.app.connection.*" %>
	<%@ page import="java.util.*" %>
<% User auth = (User) request.getSession().getAttribute("auth"); 
	if(auth != null){
		request.setAttribute("auth", auth);
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-session");
	ProductDao cpd = new ProductDao(dbConnection.getConnection());
	List<Cart> cartProduct = null;
	if(cart_list != null){
		cartProduct = cpd.getCartProduct(cart_list);
		request.setAttribute("cart_list", cart_list);
		
		double TotaleP = cpd.totalPrice(cart_list);
		request.setAttribute("TotaleP", TotaleP);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="includes/header.jsp"%>
<title>eStrore Cart</title>
<style type="text/css">

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${TotaleP} </h3> <a class="mx-3 btn btn-primary" href="orderops">Check Out</a></div>
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
				<% if(cart_list != null){
					for(Cart cp:cartProduct){ %>
						<tr>
						<td><%= cp.getName() %></td>
						<td><%= cp.getCategory() %></td>
						<td><%= cp.getPrice() %> $</td>
						<td>
							<form action="Operations" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=cp.getId() %>" class="form-input">
								<div class="form-group d-flex justify-content-between">
									<a class="btn bnt-sm btn-incre" href="Operations?action=inc&id=<%= cp.getId() %>">
									<i class="fas fa-plus-square"></i></a> 
									<input type="text" name="quantity" class="form-control"  value="<%= cp.getQuantity() %>" readonly> 
									<a class="btn btn-sm btn-decre" href="Operations?action=dec&id=<%= cp.getId() %>">
									<i class="fas fa-minus-square"></i></a>
								</div>
								<button type="submit" class="btn btn-primary btn-sm">Buy</button>
							</form>
						</td>
						<td><a href="Operations?action=remove&id=<%= cp.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
					</tr>
					<%}
					} %>
				

			</tbody>
		</table>
	</div>
	
	<%@ include file="includes/footer.jsp"%>
</body>
</html>