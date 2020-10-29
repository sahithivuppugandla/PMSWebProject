<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Back Office Representative Registration Form</title>
</head>
<body>
<form action = "RegistrationSuccess.jsp" method="post">
		<table>
		<tr>
		<td>Back Office Username</td>
		<td><input type="text" name="username" required/></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="text" name="password" required/></td>
		</tr>
		<td><input type="submit" value="Register"/></td>
		</table>
</form>
</body>
</html>