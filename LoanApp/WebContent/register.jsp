<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Calibri, sans-serif;
	background-color: lightblue;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div align=center>
<a href="index.jsp">Go Back to Home Page</a>
	<h2>User Registration Form</h2>
	<form action="user?action=registeruser" method="post">
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="loginid" name="loginid"> </div>
		</div>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="password" id="password" name="password"> </div>
		</div>
		<div>
			<div><input type="submit" value="Register"> </div>
		</div>
	</form>
	</div>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>