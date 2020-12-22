
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Commodity Profile</title>
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
	<jsp:include page="/pages/back-office-user.jsp"/>
	<div class="offset-md-4 container-fluid">
	<h3>${isNew?"New":"Edit" } Commodity</h3>
		<div class="row">
			<div class="col-md-4">
				<form:form action="/commodity/${isNew?'add':'update' }" 
				method="POST" modelAttribute="commodity" class="form">
				<div class="form-control-group">
					<form:errors path="*"/>				
				</div>
				<div class="form-control-group">
					<form:label path="itemName" class="form-control-label">Commodity Name</form:label>
					<form:input path="itemName" class="form-control" type="text"/>
				</div>
			
				<div class="form-control-group">
					<form:label path="itemPrice" class="form-control-label">Current Price</form:label>
					<form:input path="itemPrice" class="form-control" type="number"/>
				</div>
				<div class="form-control-group">
					<form:label path="updatedDate" class="form-control-label">Updated date</form:label>
					<form:input path="updatedDate" class="form-control" type="date"/>
				</div> 
				<div class="form-control-group">
					<form:label path="updatedTime" class="form-control-label">Updated time</form:label>
					<form:input path="updatedTime" class="form-control" type="time"/>
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