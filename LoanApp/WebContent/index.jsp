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

	<h2 align="center" style="color:blue">Login Form</h2>
	<div class="container">
		<form action="user?action=validate" method="POST">
			<div>
				<label>Username</label> <input type="text" placeholder="Enter Username" name="username" required />
			</div>
			<div>
				<label>Password</label> <input type="password" placeholder="Enter Passsword" name="password"
					required />
			</div>
			<div class="container" style="background-color:#f1f1f1">
				<input type="submit" value="Login" />
			<a href="user?action=registernewuser">Register as a New User</a>
			</div>
			
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>