<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Back Office Representative Registration Form</title>
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
				<form action="RegistrationSuccess.jsp" method="post">
					<div class="form-group">
						<label for="">Back Office Username</label> <input type="text"
							name="username" class="form-control" required />
					</div>

					<div class="form-group">
						<label for="">Password</label> <input type="password"
							name="password" class="form-control" required />
					</div>
					<button type="submit" class="btn btn-primary">Register</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>