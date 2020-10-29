<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investor Registration Form</title>
</head>
<body>
<h1>Register Here</h1>
<form action="Investor.jsp">
		<table>
		<tr>
		<td>Investor Username</td>
		<td><input type="text" name="username" required/></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><input type="text" name="password" required/></td>
		</tr>
		<tr>
		<td>Phone</td>
		<td><input type="text" name="phone" required/></td>
		</tr>
		<tr>
		<td>Address</td>
		<td><input type="text" name="address" required/></td>
		</tr>
		<tr>
		<td>Pan Id</td>
		<td><input type="text" name="panid" required/></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Register"/>
		</td>
		</tr>
		</table>
	</form>
</body>

</html>