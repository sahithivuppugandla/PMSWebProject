<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Loan Status</title>

</style>
</head>
<body>
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method
	-->
	<jsp:include page="header.jsp"/>
	<div align="right">
		<a href="index.jsp">Logout</a>
	</div>
	<nav>
		<a href="userhome.jsp">User Dashboard</a><br>
	</nav>
	<hr />
	<c:choose>
		<c:when test="${loan==null }">
			<p>No Record Found!</p>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>Loan Application Number</th>
						<th>Loan Name</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${loan.applno }</td>
						<td>${loan.purpose }</td>
						<td>${loan.status }</td>
					</tr>
				</tbody>
			</table>
		</c:otherwise>
</c:choose>
	<jsp:include page="footer.jsp" />
</body>
</html>