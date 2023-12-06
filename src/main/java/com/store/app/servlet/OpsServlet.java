package com.store.app.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.store.app.connection.dbConnection;
import com.store.app.dao.OrderDao;
import com.store.app.model.Cart;
import com.store.app.model.Order;
import com.store.app.model.User;

public class OpsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter();){
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-session");
			
			if(action != null && id >= 1) {
				if(action.equals("post")) {
					doPost(request,response);
				}
				//inc
				if(action.equals("inc")) {
					for(Cart c:cart_list) {
						if(c.getId() == id) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect("cart.jsp");
						}
					}
				}
				//dec
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						if(c.getId() == id ) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
						}
					}
					response.sendRedirect("cart.jsp");
				}
				//delete
				if(action.equals("remove")) {
					for(Cart c:cart_list) {
						if(c.getId() == id ) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
					response.sendRedirect("cart.jsp");
				}
			
			}else {response.sendRedirect("cart.jsp");}
			
		}  
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter();){
			User auth = (User) request.getSession().getAttribute("auth");
			if(auth != null) {
				
				String productId = request.getParameter("id");
				int productQ = Integer.parseInt(request.getParameter("quantity"));
					if(productQ <= 0) {
						productQ = 1;
					}
					Order order = new Order();
					order.setId(Integer.parseInt(productId));
					order.setUser_id(auth.getId());
					order.setQuantity(productQ);
					OrderDao orderDao = new OrderDao(dbConnection.getConnection());
					boolean result = orderDao.submitOrder(order);
						if(result) {
							response.sendRedirect("orders.jsp");
						}else {
							out.print("zeyar karek");
						}
			}else {
				response.sendRedirect("login.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
