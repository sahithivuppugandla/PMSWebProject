<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Company Profile</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
</head>
<body>
	<div class="offset-md-4 container-fluid">
		<div class="row">
			<div class="col-md-4">

				<c:if test="${comp_code != null}">
					<form action="modify" method="post">
				</c:if>
				<c:if test="${comp_code == null}">
					<form action="add" method="post">
				</c:if>


				<h2>
					<c:if test="${comp_code != null}">
                                    Edit Company 
                                </c:if>
					<c:if test="${comp_code == null}">
                                    Add New Company
                                </c:if>
				</h2>


				<form>

					<div class="form-group">
						<label for="">Company code</label> <input type="text"
							name="comp_code" class="form-control" required
							value="<c:out value='${company.companyCode}' />" />
					</div>

					<div class="form-group">
						<label for="">Company Title</label> <input type="text"
							name="comp_title" class="form-control" required
							value="<c:out value='${company.companyTitle}' />" />
					</div>

					<div class="form-group">
						<label for="">Operations</label> <input type="text"
							name="comp_operations" class="form-control" required
							value="<c:out value='${company.companyOperations}' />" />
					</div>

					<div class="form-group">
						<label for="">Share Count</label> <input type="number"
							name="sharecount" class="form-control" required
							value="<c:out value='${company.shareCount}' />" />
					</div>

					<div class="form-group">
						<label for="">Open Share Price</label> <input type="number"
							name="open_share_price" class="form-control" required
							value="<c:out value='${company.openSharePrice}' />" />
					</div>

					<div class="form-group">
						<label for="">Sector</label> <select name="sector" id="sector"
							class="form-control" required
							value="<c:out value='${company.sector}' />">
							<option value="">Select one</option>
							<option value="agriculture">Agriculture</option>
							<option value="pharma">Pharmaceutical</option>
							<option value="finance">Finance</option>
						</select>
					</div>

					<div class="form-group">
						<label for="">Currency</label> <select name="currency"
							id="currency" class="form-control" required
							value="<c:out value='${company.currency}' />">
							<option value="">Select one</option>
							<option value="usd">USD</option>
							<option value="inr">INR</option>
							<option value="eur">EUR</option>
						</select>
					</div>

					<div class="form-group">
						<label for="">Turnover</label> <input type="number"
							name="turnover" class="form-control" required
							value="<c:out value='${company.turnover}' />" />
					</div>
					<button type="submit" class="btn btn-primary">Save</button>


				</form>
			</div>
		</div>
	</div>
</body>
</html>