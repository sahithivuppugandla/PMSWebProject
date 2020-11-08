<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin home</title>
<style>   
body {  
  font-family: Calibri,sans-serif;  
  background-color: lightblue;  
} 
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<h3>Welcome ${username} !</h3>
<h4>${msg}</h4>
<h2>Admin Dash Board</h2>
<a href="admin?action=listall">List All</a><br>
<a href="process.jsp">Process Loan</a><br>
<jsp:include page="footer.jsp"/>
</body>
</html>