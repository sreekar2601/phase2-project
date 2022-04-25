package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet get...");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//out.println(request.getAttribute("greeting"));
		out.println("<p></p>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.println("<body style=background-color:#e6e6fae8;>");
		out.println("<h3 style=text-align:center;color:black;font-size:250%;>Welcome Admin </h3>");
		out.println("<p style=text-align:left;font-size:200%;>Menu:</p>");
		out.println("<ul style=list-style-type:disc>");
		out.println("<a href='AddTeacher.html'><li>Add Teacher</li></a>" );
		out.println("<p></p>");
		out.println("<a href='AddSubjects.html'><li>Add Subject</li></a>" );
		out.println("<p></p>");
		out.println("<a href='AddClass.html'><li>Add Class</li></a>" );
		out.println("<p></p>");
		out.println("<a href='AssignClass.html'><li>Assign Class for a Subject</li></a>" );
		out.println("<p></p>");
		out.println("<a href='AssignTeacher.html'><li>Assign Teacher to a Class</li></a>" );
		out.println("<p></p>");
		out.println("<a href='StudentServlet'><li>List of Students</li></a>" );
		out.println("<p></p>");
		out.println("<a href='ClassReport.html'><li>Class Report</li></a>" );
		out.println("</ul>");
		out.println("</body>");
		
		
		
	}

}
