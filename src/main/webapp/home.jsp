<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<%@ page import="com.store.app.model.*" %>
<%@ page import="com.store.app.dao.*" %>
<%@ page import="com.store.app.connection.*" %>
<% User auth = (User) request.getSession().getAttribute("auth"); 
	if(auth != null){
		request.setAttribute("auth", auth);
	}
	
	ProductDao pd = new ProductDao(dbConnection.getConnection());
	List<Product> products = pd.showProducts();
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-session");
	List<Cart> cartProduct = null;
	if(cart_list != null){
		request.setAttribute("cart_list", cart_list);
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
			<% if(!products.isEmpty()){
				for(Product p:products){ %>
					<div class="col-md-3 my-3">
					<div class="card" style="width: 18rem;">
					  <img src="product-images/image.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title"><%= p.getName() %></h5>
					    <h6 class="price"><%= p.getPrice() %></h6>
					    <h6 class="category"><%= p.getCategory() %></h6>
					    <div class="mt-3 d-flex justify-content-between">
					    <a href="CartServlet?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a>
					    <a href="Operations?action=post&quantity=1&id=<%= p.getId() %>" class="btn btn-primary">Buy Now</a>
					    </div>
					  </div>
			</div>
			</div>
			<%	}
			} %>
	
</div>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>