<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mott MacDonald P/L APP</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Employee Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
</head>
<body>
		<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Mott MacDonald P/L Timesheet </a><br>
			<a class="navbar-brand"> Employee Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
			href="<%=request.getContextPath()%>/userservlets/dashboard"
			class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	
	<div class="container col-md-6">
	<div class="card">
	<div class="card-body">
				<c:if test="${!empty userlist.empID}">
				<form action="update" method="post">
				
			</c:if>
			<c:if test="${empty userlist.empID}">
				<form action="insert" method="post">
				
			</c:if>
		<caption>
		<h2>
				<c:if test="${!empty userlist.empID}">
				Edit Employee Record
				</c:if>
				<c:if test="${empty userlist.empID}">
				Add New Employee Record
				</c:if>
		</h2>
		</caption>
		<c:if test="${userlist != null}">
			<input type="hidden" name="oriname"
			value="<c:out
			value='${userlist.empID}' />" />
		</c:if>
		<fieldset class="form-group">
			<label>Employee ID</label> <input type="text"
			value="<c:out
			value='${userlist.empID}' />" 
			class="form-control"
			name="empID">
		</fieldset>
		
		<fieldset class="form-group">
			<label>First Name</label> <input type="text"
			value="<c:out
			value='${userlist.firstName}' />" class="form-control"
			name="FirstName">
		</fieldset>
		<fieldset class="form-group">
			<label>Last Name</label> <input type="text"
			value="<c:out
			value='${userlist.lastName}' />" class="form-control"
			name="LastName">
			</fieldset>
		<fieldset class="form-group">
			<label> DOB</label> <input type="text"
			value="<c:out
			value='${userlist.DOB}' />" class="form-control"
			name="DOB">
		</fieldset>
		
		<fieldset class="form-group">
			<label> Pay Grade</label> <input type="text"
			value="<c:out
			value='${userlist.payGrade}' />" class="form-control"
			name="PayGrade">
		</fieldset>
		<fieldset class="form-group">
			<label> Employment date</label> <input type="text"
			value="<c:out
			value='${userlist.empDate}' />" class="form-control"
			name="EmpDate">
		</fieldset>
		<fieldset class="form-group">
			<label> Email</label> <input type="text"
			value="<c:out
			value='${userlist.comEmail}' />" class="form-control"
			name="ComEmail">
		</fieldset>
		<fieldset class="form-group">
			<label> Contact no</label> <input type="text"
			value="<c:out
			value='${userlist.mobileph}' />" class="form-control"
			name="Mobileph">
		</fieldset>
		
		<fieldset class="form-group">
			<label> stored password</label> <input type="text"
			value="<c:out
			value='${userlist.pssword}' />" class="form-control"
			name="Pssword">
		</fieldset>
		
		<fieldset class="form-group">
			<label> Annual Leave</label> <input type="text"
			value="<c:out
			value='${userlist.annualLeave}' />" class="form-control"
			name="AnnualLeave">
		</fieldset>
		<fieldset class="form-group">
			<label> Statutory Leave</label> <input type="text"
			value="<c:out
			value='${userlist.statLeave}' />" class="form-control"
			name="StatLeave">
		</fieldset>
		<fieldset class="form-group">
			<label> Sick Leave</label> <input type="text"
			value="<c:out
			value='${userlist.sickLeave}' />" class="form-control"
			name="SickLeave">
		</fieldset>
		
	<button type="submit" class="btn btn-success">Save</button>
	</form>
	</div>
	</div>
	</div>
</body>
</html>