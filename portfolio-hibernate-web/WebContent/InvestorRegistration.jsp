
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Investor Registration Form</title>
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
				<h1>Register Here</h1>
				<hr>

				<form action="Investor.jsp">
					<div class="form-group">
						<label for="">Investor Username</label> <input type="text"
							name="username" class="form-control" required />
					</div>

					<div class="form-group">
						<label for="">Email</label> <input type="email" name="email"
							class="form-control" required />
					</div>

					<div class="form-group">
						<label for="">Phone</label> <input type="text" name="phone"
							class="form-control" required />
					</div>
					<div class="form-group">
						<label for="">Address</label> <input type="text" name="address"
							class="form-control" required />
					</div>
					<div class="form-group">
						<label for="">Pan Id</label> <input type="text" name="panid"
							class="form-control" required />
					</div>
					<button class="btn btn-primary">Register</button>


				</form>
			</div>
		</div>
	</div>
</body>

</html>