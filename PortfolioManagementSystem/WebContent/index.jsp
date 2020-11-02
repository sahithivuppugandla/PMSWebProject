<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Portfolio Management System</title>
	</head>
	<body>
		<form action="LoginServlet" method="POST">
		<table>
		<tr>
		<td>Username</td>
		<td><input type="text" name="username" required/></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="password" required/></td>
		</tr>
		<tr>
		<td>Role</td>
		<td>
             <select name="role" id = "role" required>
             <option value = "">Select...</option>
               <option value = "admin">Admin</option>
               <option value = "investor">Investor</option>
               <option value = "Back Office Representative">Back Office Representative</option>
              </select>
             </td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Login"/>
		<a href="InvestorRegistration.jsp">Register As New Investor</a>
		</td>
		</tr>
		<tr>
		</table>
				
		</form>
		
	</body>
	</html>