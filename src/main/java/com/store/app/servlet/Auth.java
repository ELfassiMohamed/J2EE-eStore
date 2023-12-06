package com.store.app.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.store.app.connection.dbConnection;
import com.store.app.dao.UserDao;
import com.store.app.model.User;


@WebServlet("/")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Auth() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("logout")) {
			//logout
			if(request.getSession().getAttribute("auth") != null) {
				request.getSession().removeAttribute("auth");
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}

		}else {
			//login
			doPost(request,response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login
		String email = request.getParameter("login-email");
		String password = request.getParameter("login-password");
		try {
			UserDao userdao = new UserDao(dbConnection.getConnection());
			User user = userdao.userLogin(email, password);
			if(user != null) {
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("home.jsp");
			}else {
				PrintWriter out = response.getWriter();
				out.print("USER NOT FOUND");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
