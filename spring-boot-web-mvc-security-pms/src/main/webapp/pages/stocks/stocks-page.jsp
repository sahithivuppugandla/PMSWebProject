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
			
			<h3>List of Stocks</h3>
						
			<c:choose>
				<c:when test="${stocks==null || stocks.isEmpty() }">
					<div class="alert alert-info">
						<p>No Stocks Available!
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Stock Id</th>
								<th>Stock Exchange</th>
								<th>Current Price</th>
								<th>Updated date</th>
								<th>Updated time</th>
								<th>Company</th>
								
							</tr>							
						</thead>
						<tbody>
							<c:forEach var="s" items="${stocks }">
								<tr>
									<td>${s.stockId }</td>
									<td>${s.stockExchange }</td>
									<td>${s.currentPrice }</td>
									<td>${s.date }</td>
									<td>${s.time }</td>
									<td>${s.company.companyTitle }</td>
									
									
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
	</body>
</html>