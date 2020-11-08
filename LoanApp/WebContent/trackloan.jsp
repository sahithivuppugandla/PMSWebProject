<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<!-- write html code to read the application number and send to usercontrollers'
             displaystatus method for displaying the information
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
		<h3>Track Application Status</h3>

		<form action="user?action=displaystatus" method="POST">

			<label>Application Number</label> 
			<input type="text" name="applicationNum" required />
			<input type="submit" value="Submit" />

		</form>
		</div>

		<jsp:include page="footer.jsp" />
</body>
</html>