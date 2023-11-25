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
<title>Store Orders</title>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<h1>Your Orders is ready</h1>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>