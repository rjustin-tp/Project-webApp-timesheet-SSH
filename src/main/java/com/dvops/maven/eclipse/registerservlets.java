package com.dvops.maven.eclipse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**Import these libraries from java.io and java.sql*/
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * Servlet implementation class registerservlets
 */
@WebServlet("/registerservlets")
public class registerservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlets() {
       super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		/**Step 1: Initialize a PrintWriter object to return the html values via the response*/
		PrintWriter out = response.getWriter(); 
		/**Step 2: retrieve the four parameters from the request from the web form*/
		String n = request.getParameter("EmpID");
		String f = request.getParameter("FirstName");
		String l = request.getParameter("LastName");
		String d = request.getParameter("DOB");
		String p = request.getParameter("PayGrade");
		String e = request.getParameter("EmpDate");
		String c = request.getParameter("ComEmail");
		String m = request.getParameter("Mobileph");
		String w = request.getParameter("pssword");
		String a = request.getParameter("AnnualLeave");
		String s = request.getParameter("StatLeave");
		String k = request.getParameter("SickLeave");

		/**Step 3: attempt connection to database using JDBC, you can a new employee record*/
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectpart2", "root", "password");
		/**Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)*/
		PreparedStatement ps = con.prepareStatement("insert into emp_datadetails values(?,?,?,?,?,?,?,?,?,?,?,?)");
		/**Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly*/
		ps.setString(1, n);
		ps.setString(2, f);
		ps.setString(3, l);
		ps.setString(4, d);
		ps.setString(5, p);
		ps.setString(6, e);
		ps.setString(7, c);
		ps.setString(8, m);
		ps.setString(9, w);
		ps.setString(10, a);
		ps.setString(11, s);
		ps.setString(12, k); 
		/**Step 6: perform the query on the database using the prepared statement*/
		int i = ps.executeUpdate(); 
		/**Step 7: check if the query had been successfully execute, return You are successfully registered via the response,*/
		if (i > 0){
		PrintWriter writer = response.getWriter();
		writer.println("<h2>" + "You have successfully add a new employee account!" + "</h2>");
		writer.println("<h2>" + "Employee " + f + " " + l + "</h2>");
		writer.close();
		}
		} 
		/**Step 8: catch and print out any exception*/
		catch (Exception exception) {
		System.out.println(exception);
		out.close();
		}
		doGet(request, response);
	}

}
