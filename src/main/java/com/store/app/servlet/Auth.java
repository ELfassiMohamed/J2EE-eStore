package com.store.app.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Auth() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch(path) {
		case "logout":
		{
			if(request.getSession().getAttribute("auth") != null) {
				request.getSession().removeAttribute("auth");
				response.sendRedirect("home.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
			break;
		}
		case "/login":
			doPost(request,response);
			break;
		default:
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
