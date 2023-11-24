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
		<div class="d-flex py-3"><h3>Total Price: 99 </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
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
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=">
								<i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="1" readonly> 
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=">
								<i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="remove-from-cart?id=" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

			</tbody>
		</table>
	</div>
	
	<%@ include file="includes/footer.jsp"%>
</body>
</html>