package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Inside Teacher method");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String age = request.getParameter("age");
		String course = request.getParameter("course");
		try {
			Statement statement = connection.createStatement();
			int result =statement.executeUpdate("insert into teachers values ('" + name + "', '" + subject + "', '" + age + "', '" + course + "')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<html>");
				out.println("<head>");
				out.println("<h1 style=text-align:center>Faculty Added</h1>");
				out.println("</head>");
				out.println("<body style=background-color:#e6e6fae8");
				
				out.println("</body>");
				out.println("</html>");
			} else {
				out.println("<h1>Error While Adding Faculty</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}

}
