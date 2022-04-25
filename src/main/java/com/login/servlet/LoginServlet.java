package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection connection;
	public void init(ServletConfig sc) {
		System.out.println("Intializing loginservlet...");
		ServletContext context=sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"),
					context.getInitParameter("dbPassword"));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			Statement stmt=connection.createStatement();
			ResultSet res=stmt.executeQuery("select * from admin where username ='"+username+"' and password='"+password+"'");
			if(res.next()) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<p>Login Successfull</p>");
				RequestDispatcher rd=request.getRequestDispatcher("homeServlet");
				//request.setAttribute("greeting","hello "+username);
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				out.println("Login Failed");
				rd.include(request, response);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			if(connection!=null) {
				connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
