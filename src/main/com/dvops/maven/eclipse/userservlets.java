package com.dvops.maven.eclipse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class userservlets
 */
@WebServlet("/userservlets")
public class userservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**Step 1: Prepare list of variables used for database connections*/
	private String jdbcURL = "jdbc:mysql://localhost:3306/projectpart2";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	private static final String INSERT_USERS_SQL = "insert into emp_datadetails" + "(empID, FirstName, LastName, DOB, PayGrade, EmpDate, ComEmail, Mobileph, pssword, AnnualLeave, StatLeave, SickLeave) values" + "(?,?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "select empID, FirstName, LastName, DOB, PayGrade, EmpDate, ComEmail, Mobileph, pssword, AnnualLeave, StatLeave, SickLeave from emp_datadetails where empID =?";
	private static final String SELECT_ALL_USERS = "select * from emp_datadetails";
	private static final String DELETE_USERS_SQL = "delete from emp_datadetails where empID = ?;";
	private static final String UPDATE_USERS_SQL = "update emp_datadetails set empID =?, FirstName =?, LastName = ?, DOB = ?, PayGrade = ?, empDate = ?, ComEmail = ?, Mobileph =?, Pssword =?, AnnualLeave =?, StatLeave =?, SickLeave =? where empID = ?;";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userservlets() {
        super();
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.*/
		String action = request.getServletPath();
			try {
			switch (action) {
				
		   case "/userservlets/update":
				updateUser(request, response);
				break;
			case "/userservlets/insert":
				addNewUser(request, response);
				break;
			 case "/userservlets/delete":
				deleteUser(request, response);
				break;
			case "/userservlets/edit":
				showEditForm(request, response);
				break;
			case "/userservlets/dashboard":
				listUsers(request, response);
				break;
			default:
				listUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**Step 3: Implement the getConnection method which facilitates connection to the database via JDBC*/
	protected Connection getConnection() {
	Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return connection;
	}
	
	/**Step 5: listUsers function to connect to the database and retrieve all users records*/
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
		{
	List <userlist> users = new ArrayList <>();
		try (Connection connection = getConnection(); 
/**Step 5.1: Create a statement using connection object*/
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) { 
/** Step 5.2: Execute the query or update query*/
			ResultSet rs = preparedStatement.executeQuery(); 
/** Step 5.3: Process the ResultSet object.*/
			while (rs.next()) {
				String n = rs.getString("empID");
				String f = rs.getString("firstName");
				String l = rs.getString("lastName");
				String d = rs.getString("DOB");
				String p = rs.getString("payGrade");
				String e = rs.getString("empDate");
				String c = rs.getString("comEmail");
				String m = rs.getString("mobileph");
				String w = rs.getString("pssword");
				String a = rs.getString("annualLeave");
				String s = rs.getString("statLeave");
				String k = rs.getString("sickLeave");
			users.add(new userlist(n, f, l, d, p, e, c, m, w, a, s, k));
			}
		} catch (SQLException e) {
	System.out.println(e.getMessage());
	} 
/** Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp*/
	request.setAttribute("listUsers", users);
	request.getRequestDispatcher("/usermanagements.jsp").forward(request, response);
	}
	
/**METHOD 1 TO SHOWEDIT FORM*/
/**method to get parameter, query database for existing user data and redirect to user edit page*/
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
/**get parameter passed in the URL*/
	String empID = request.getParameter("empID");
	userlist existingUser = new userlist("", "", "", "", "", "", "", "", "", "", "", ""); 
/** Step 1: Establishing a Connection*/
	try (Connection connection = getConnection(); 
/** Step 2:Create a statement using connection object*/
	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	preparedStatement.setString(1, empID); 
/** Step 3: Execute the query or update query*/
	ResultSet rs = preparedStatement.executeQuery(); 
/** Step 4: Process the ResultSet object*/
		while (rs.next()) {
			empID = rs.getString("empID");
			String firstname = rs.getString("firstName");
			String lastname = rs.getString("lastName");
			String DOB = rs.getString("DOB");
			String paygrade = rs.getString("payGrade");
			String empdate = rs.getString("empDate");
			String comemail = rs.getString("comEmail");
			String mobileph = rs.getString("mobileph");
			String passwords = rs.getString("pssword");
			String annual = rs.getString("annualLeave");
			String stats = rs.getString("statLeave");
			String sick = rs.getString("sickLeave");
			existingUser =new userlist(empID, firstname, lastname, DOB, paygrade, 
					empdate, comemail, mobileph, passwords, annual, stats, sick);
		}
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	} 
/**Step 5: Set existingUser to request and serve up the userEdit form*/
	request.setAttribute("userlist", existingUser);
	request.getRequestDispatcher("/useredits.jsp").forward(request, response);
	}
	
/**METHOD 2 TO EDIT USER BASED ON DATA ON FORM*/
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
/**Step 1: Retrieve value from the request*/
		String oriempID = request.getParameter("empID");
		String empID = request.getParameter("empID");
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String DOB = request.getParameter("DOB");
		String paygrade = request.getParameter("PayGrade");
		String empDate = request.getParameter("EmpDate");
		String comEmail = request.getParameter("ComEmail");
		String Mobileph = request.getParameter("Mobileph");
		String pssword = request.getParameter("Pssword");
		String AnnualLeave = request.getParameter("AnnualLeave");
		String StatLeave = request.getParameter("StatLeave");
		String SickLeave = request.getParameter("SickLeave");
/**Step 2A: Attempt connection with database and execute update user SQL query*/
	try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
		statement.setString(1, empID);
		statement.setString(2, firstName);
		statement.setString(3, lastName);
		statement.setString(4, DOB);
		statement.setString(5, paygrade);
		statement.setString(6, empDate);
		statement.setString(7, comEmail);
		statement.setString(8, Mobileph);
		statement.setString(9, pssword);
		statement.setString(10, AnnualLeave);
		statement.setString(11, StatLeave);
		statement.setString(12, SickLeave);
		statement.setString(13, oriempID);
		int i = statement.executeUpdate();
	} 
 	
/**Step 3: redirect back to UserServlet (note: remember to change the url to your project name)*/
		response.sendRedirect("http://localhost:8080/Project/userservlets/dashboard");
	}
	
/**METHOD 3 TO DELETE USER*/
		private void deleteUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException { 
/**Step 1: Retrieve value from the request*/
		String empID = request.getParameter("empID"); 
/**Step 2A: Attempt connection with database and execute delete user SQL query*/
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
		statement.setString(1, empID);
		int i = statement.executeUpdate();
			PrintWriter writer = response.getWriter();
			writer.println("Deleted account " + empID);
			writer.close();
			} 
/**Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)*/
		response.sendRedirect("http://localhost:8080/Project/userservlets/dashboard");
		}
	
/**Method 4: addNewUser (trigger registerservlets) //method to trigger RegisterServlet*/
	private void addNewUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
	RequestDispatcher rd = null;
	rd = getServletContext().getRequestDispatcher("/registerservlets");
	rd.include(request, response);
	}
}
