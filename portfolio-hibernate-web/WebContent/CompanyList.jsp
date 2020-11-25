
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>

<body>

	<nav>
		<hr />
		<a href="<%=request.getContextPath()%>/list">Companies List</a> <span>|</span>
		<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
			New Company</a> <span>|</span> <a
			href="<%=request.getContextPath()%>/modify" class="btn btn-success">Edit
			Company</a>


		<hr />

	</nav>
	<table>
		<thead>
			<tr>
				<th>Company Code</th>
				<th>Company Title</th>
				<th>Operations</th>
				<th>Share Count</th>
				<th>Open Share Price</th>
				<th>Sector</th>
				<th>Currency</th>
				<th>Turnover</th>
				<th>Actions</th>
			</tr>
		</thead>

		<c:forEach var="company" items="${listCompany}">

			<tr>
				<td><c:out value="${company.companyCode}" /></td>
				<td><c:out value="${company.companyTitle}" /></td>
				<td><c:out value="${company.companyOperations}" /></td>
				<td><c:out value="${company.shareCount}" /></td>
				<td><c:out value="${company.openSharePrice}" /></td>
				<td><c:out value="${company.sector}" /></td>
				<td><c:out value="${company.currency}" /></td>
				<td><c:out value="${company.turnover}" /></td>
				<td><a
					href="modify?id=<c:out value='${company.companyCode}' />">Edit</a>
					<span>|</span> <a
					href="delete?id=<c:out value='${company.companyCode}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>

</body>

</html>