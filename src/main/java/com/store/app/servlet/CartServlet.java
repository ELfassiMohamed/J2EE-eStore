package com.store.app.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.store.app.model.Cart;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CartServlet() { super(); }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			ArrayList<Cart> cart = new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("id"));
			Cart carty = new Cart();
			carty.setId(id);
			carty.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-session");
			
			if(cart_list == null ) {
				cart.add(carty);
				session.setAttribute("cart-session", cart);
			     response.sendRedirect("home.jsp");
			}else {
				cart =  cart_list; 
				boolean exist = false; 
				  for (Cart c : cart_list) {
	                    if (c.getId() == id) {
	                        exist = true;
	                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
	                    }
	                }

	                if (!exist) {
	                	cart.add(carty);
	                    response.sendRedirect("home.jsp");
	                }
				}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
