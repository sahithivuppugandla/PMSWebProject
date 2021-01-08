
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Stock</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<!-- Font Awesome -->
		<script src="https://kit.fontawesome.com/996973c893.js"></script>
</head>
<body>
	<jsp:include page="/header"/>
	<div class="offset-md-4 container-fluid">
	<h3>Buy Stock</h3>
		<div class="row">
			<div class="col-md-4">
				<form:form action="/investor/wallet" 
				method="POST" modelAttribute="wallet" class="form">
				<div class="form-control-group">
					<form:errors path="*"/>				
				</div>
				
				 <div class="form-control-group">
					<form:label path="company.openSharePrice" class="form-control-label">Open share price </form:label>
											
						<form:input path="company.openSharePrice" items="${wallet }" itemLabel="${wallet}" itemValue="${wallet}" class="form-control"/>
					
				</div> 
				<div class="form-control-group">
					<form:label path="shareCount" class="form-control-label">Number of Share</form:label>
					<form:input path="shareCount" class="form-control" type="decimal"/>
				</div>				 
				<div class="form-control-group">
					<button class="btn btn-primary">SAVE</button>
				</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>