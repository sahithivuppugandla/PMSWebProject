<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate EMI</title>
<style>   
body {  
  font-family: Calibri,sans-serif;  
  background-color: lightblue;  
} 
</style>
</head>
<body>
 <!--
     Read the values from the admin servlet and cal emi and other details and send to
     to the same admin servlet to update the values in the database 
  -->  
<jsp:include page="header.jsp" />
	<div align="right">
		<a href="index.jsp">Logout</a>
	</div>
	<nav>
		<a href="adminhome1.jsp">Admin Dashboard</a><br>
	</nav>
	<hr />
	<div align=center>
		<h3>Calculate EMI</h3>

		<form action="admin?action=calemi" method="POST">

			<label>Application Number</label> 
			
			<input type="number" name="appNum" required readonly value="<c:out value='${appNum}' />" />
			<br><br>
			<label>Loan Amount</label> 
			
			<input type="number" name="loanAmount" required />
			<br><br>
			<label>Loan Duration(Months)</label> 
			
			<input type="number" name="loanDuration" required />
			<br><br>
			<label>Interest Rate</label> 
			
			<input type="number" name="interestRate" required />
			<br><br>
			<input type="submit" value="Calculate and Approve" />

		</form>
		</div>

		<jsp:include page="footer.jsp" />
</body>
</html>