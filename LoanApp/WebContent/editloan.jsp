<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>

</head>
<body>
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->
<jsp:include page="header.jsp" />
	<div align="right">
		<a href="index.jsp">Logout</a>
	</div>
	<nav>
		<a href="userhome.jsp">User Dashboard</a><br>
	</nav>
	<hr />
	<div align=center>
		<h3>Edit Application</h3>

		<form action="user?action=editloan" method="POST">

			<label>Application Number</label> 
			<input type="text" name="applicationNum" required />
			<input type="submit" value="Submit" />

		</form>
		</div>

		<jsp:include page="footer.jsp" />
</body>
</html>