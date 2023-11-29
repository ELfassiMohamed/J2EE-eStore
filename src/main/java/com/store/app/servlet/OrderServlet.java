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

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public OrderServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-session");
			User auth = (User) request.getSession().getAttribute("auth");
			String action = request.getParameter("action");

			if(cart_list != null && auth != null) {
				for(Cart c:cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUser_id(auth.getId());
					order.setQuantity(c.getQuantity());
					OrderDao orderDao = new OrderDao(dbConnection.getConnection());
					boolean result = orderDao.submitOrder(order);
					if(!result) break;
				}
				cart_list.clear();
				response.sendRedirect("orders.jsp");
			}else {
				if(auth == null )response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
