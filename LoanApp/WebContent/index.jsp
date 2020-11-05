<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan system</title>
</head>
<body>
	<!-- write the html code to read user credentials and send it to validateservlet
	    to validate and user servlet's registernewuser method if create new user
	    account is selected
	-->
	<jsp:include page="header.jsp" />

	<h3>Login Form</h3>

	<form action="user?action=validate" method="POST">
		<div>
			<label>Username</label> <input type="text" name="username" required />
		</div>
		<div>
			<label>Password</label> <input type="password" name="password"
				required />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
		<div>
			<a href="user?action=registernewuser">Register as a New User</a>
		</div>
	</form>

	<jsp:include page="footer.jsp" />
</body>
</html>