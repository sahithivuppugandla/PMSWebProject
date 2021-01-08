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
		<jsp:include page="/header"/>
		<section class="container-fluid p-4">
			
			<h3>List of Commodities</h3>
						
			<c:choose>
				<c:when test="${commodity==null || commodity.isEmpty() }">
					<div class="alert alert-info">
						<p>No Commodity Available!
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Commodity Name</th>
								<th>Current Price</th>
								<th>Updated date</th>
								<th>Updated time</th>
								
							</tr>							
						</thead>
						<tbody>
							<c:forEach var="s" items="${commodity }">
								<tr>
									<td>${s.itemName }</td>
									<td>${s.itemPrice }</td>
									<td>${s.updatedDate }</td>
									<td>${s.updatedTime }</td>
								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
	</body>
</html>