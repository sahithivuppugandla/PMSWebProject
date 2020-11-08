<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Error</title>
<style>   
body {  
  font-family: Calibri,sans-serif;  
  background-color: lightblue;  
} 
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
	<div>
		<h3>Something went wrong! We regret the inconvenience!</h3>
		<p>Error Message : <%=exception.getMessage()%> </p>
		<p>Please Contact Administrator</p>
		<p><b>${errMsg }!</b></p>
	</div>
	<a href="index.jsp">Go Back to Home Page</a>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>