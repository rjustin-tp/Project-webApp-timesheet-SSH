package com.dvops.maven.eclipse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Servlet implementation class loginservlets
 */
@WebServlet("/loginservlets")
public class loginservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employID = request.getParameter("yourempID");
		String passwd = request.getParameter("yourPwd");
		PrintWriter writer = response.getWriter();
	
		 if(employID.equals("99999") && passwd.equals("password" )) {
			 writer.println("<h1>You have successfully login as Administrator</h1>");
		 }
		 else {
			 writer.println("<h1>Wrong credential entered</h1>");
		 }
				
		writer.close();
		doGet(request, response);
	}

}
