
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
<style>
body {
	font-family: Calibri, sans-serif;
	background-color: lightblue;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<!-- write code to display all the loan details 
             which are received from the admin controllers' listall method
	-->

	<jsp:include page="header.jsp" />
	<div align="right">
		<a href="index.jsp">Logout</a>
	</div>
	<nav>
		<a href="adminhome1.jsp">Admin Dashboard</a><br>
	</nav>
	<hr />
	<h4>${approve}</h4>
	<h3>Pending Loan Applications</h3>
	<c:choose>
		<c:when test="${submittedloans==null || submittedloans.isEmpty() }">
			<p>No Record Found!</p>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>Loan Application Number</th>
						<th>Loan Name</th>
						<th>Requested Amount</th>
						<th>Date of Application</th>
						<th>Business Structure</th>
						<th>Billing Indicator</th>
						<th>Tax Indicator</th>
						<th>Contact Address</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${submittedloans }">
						<tr>
							<td>${l.applno }</td>
							<td>${l.purpose }</td>
							<td>${l.amtrequest }</td>
							<td>${l.doa }</td>
							<td>${l.bstructure }</td>
							<td>${l.bindicator }</td>
							<td>${l.tindicator }</td>
							<td>${l.address }</td>
							<td>${l.email }</td>
							<td>${l.mobile }</td>
							<td>${l.status }</td>
							<td><a href="admin?action=process&applno=${l.applno }">Approve</a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<h3>Approved Loan Applications</h3>
	<c:choose>
		<c:when test="${approvedloans==null || approvedloans.isEmpty() }">
			<p>No Record Found!</p>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>Loan Application Number</th>
						<th>Loan Amount Samctioned</th>
						<th>Loan Term</th>
						<th>Payment start Date</th>
						<th>Loan Closure Date</th>
						<th>Interest Rate</th>
						<th>Monthly Payment(EMI)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${approvedloans }">
						<tr>
							<td>${l.applno }</td>
							<td>${l.amotsanctioned }</td>
							<td>${l.loanterm }</td>
							<td>${l.psd }</td>
							<td>${l.lcd }</td>
							<td>${l.interestrate }</td>
							<td>${l.emi }</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>


	<jsp:include page="footer.jsp" />

</body>
</html>