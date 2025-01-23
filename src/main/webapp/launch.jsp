<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mott MacDonald Timesheet App</title>
</head> 
<body>

<h2>Welcome to Mott MacDonald Timesheet Platform</h2><br>
<h2> Please login to begin</h2>
	
	<form action="loginservlets" method="post">
		Enter your employee ID: <input type="text" name="yourempID" size="20"><br>
		Enter your password: <input type="text" name="yourPwd" size="20">
<!-- Implement submit button w/type = submit to perform the request when clicked -->
		<input type="submit" value="Call Login Servlet" />
	</form>

</body>
</html>