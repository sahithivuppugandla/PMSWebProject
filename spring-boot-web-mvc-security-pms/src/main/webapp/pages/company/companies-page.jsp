<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>Companies List</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
				<!-- Font Awesome -->
		<script src="https://kit.fontawesome.com/996973c893.js"></script>
	</head>
	<body>
		<jsp:include page="/pages/back-office-user.jsp"/>
		<section class="container-fluid p-4">
			
			<h3>List of Companies</h3>
						
			<c:choose>
				<c:when test="${companies==null || companies.isEmpty() }">
					<div class="alert alert-info">
						<p>No Companies Available!
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Company Code</th>
								<th>Company Title</th>
								<th>Operations</th>
								<th>Currency</th>
								<th>Open Share Price</th>
								<th>Sector</th>
								<th>Share Count</th>
								<th>Turnover</th>
								<th colspan="2"></th>
							</tr>							
						</thead>
						<tbody>
							<c:forEach var="c" items="${companies }">
								<tr>
									<td>${c.companyCode }</td>
									<td>${c.companyTitle }</td>
									<td>${c.companyOperations }</td>
									<td>${c.currency }</td>
									<td>${c.openSharePrice }</td>
									<td>${c.sector }</td>
									<td>${c.shareCount }</td>
									<td>${c.turnover }</td>
									
									<td>
										<a href="/company/edit?cid=${c.companyCode }" class="btn btn-sm btn-info">
											EDIT
										</a>
									</td>
									<td>
										<a href="/stocks/byCompany?cid=${c.companyCode }" class="btn btn-sm btn-info">
											STOCKS
										</a>
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
	</body>
</html>