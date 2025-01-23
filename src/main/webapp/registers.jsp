<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mott MacDonald Timesheet App</title>
</head>
<body>
<h3>Mott MacDonald Timesheet Platform</h3>
<h3>Please entered all info for the new employee</h3><br>

	<form action="registerservlets" method="Post"> 
		<h3>
		Employee ID: <input type="text" name="EmpID">
		First Name: <input type="text" name="FirstName">
		Last Name: <input type="text" name="LastName"><br>
		Date Of Birth: <input type="text" name="DOB">
		Email: <input type="text" name="ComEmail">
		Contact no: <input type="text" name="Mobileph"><br>
		</h3>
		<h4>Leaves entitlement per calendar year</h4>
		<h3>
		Employment Date: <input type="text" name="EmpDate">
		Pay Grade: <input type="text" name="PayGrade"><br>
		Annual Leave: <input type="text" name="AnnualLeave">
		Statutory Leave: <input type="text" name="StatLeave">
		Sick Leave: <input type="text" name="SickLeave">
		</h3>
		<h4>Default password is 123456</h4>
		<h3>
		Stored passwords: <input type="text" name="pssword">
		</h3>
	<input type="submit" value = "Call Servlet"/> 
	</form>
</body>
</html>