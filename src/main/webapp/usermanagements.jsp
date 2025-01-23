<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mott MacDonald Timesheet App</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		crossorigin="anonymous">
</head>
<body>
		<div class="row">
<div class="container">
<h3 class="text-center">List of Employees</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/registers.jsp" class="btn btn-success">Add New Employee</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
	<thead>
		<tr>
		<th>EmployeeID</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>DOB</th>
		<th>PayGrade</th>
		<th>Employment date</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>password</th>
		<th>Annual Leave</th>
		<th>Stat Leave</th>
		<th>Sick leave</th>
		<th>Actions</th>
		</tr>
	</thead>
<!-- Pass in the list of users receive via the Servlet response to a loop -->
	<tbody>
	<c:forEach var="userlist" items="${listUsers}">
<!-- For each user in the database, display their information accordingly -->
	<tr>
		<td>
			<c:out value="${userlist.empID}" /> 
		</td>
		<td>
			<c:out value="${userlist.firstName}" />
		</td>
		<td>
			<c:out value="${userlist.lastName}" />
		</td>
		<td>
			<c:out value="${userlist.DOB}" />
		</td>
		<td>
			<c:out value="${userlist.payGrade}" />
		</td>
		<td>
			<c:out value="${userlist.empDate}" />
		</td>
		<td>
			<c:out value="${userlist.comEmail}" />
		</td>
		<td>
			<c:out value="${userlist.mobileph}" />
		</td>
		<td>
			<c:out value="${userlist.pssword}" />
		</td>
		<td>
			<c:out value="${userlist.annualLeave}" />
		</td>
		<td>
			<c:out value="${userlist.statLeave}" />
		</td>
		<td>
			<c:out value="${userlist.sickLeave}" />
		</td>

<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
		<td>
		<a href="edit?empID=<c:out value='${userlist.empID}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="delete?empID=<c:out value='${userlist.empID}' />">Delete</a>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>
</body>
</html>