<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<h3>Welcome ${username} !</h3>
	<h4>User Dash Board</h4>
	<h3>${msg}</h3>
	<div align="right">
		<a href="index.jsp">Logout</a>
	</div>
	<a href="user?action=application1">Apply for Loan</a>
	<br>
	<a href="trackloan.jsp">Track Loan Application</a>
	<br>
	<a href="editloan.jsp">Edit Loan Application</a>
	<jsp:include page="footer.jsp" />
</body>
</html>