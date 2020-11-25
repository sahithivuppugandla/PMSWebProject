
<!doctype html>
<html lang="en">
<head>


<title>Portfolio Management System</title>



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
				<h2>Login</h2>
				<hr>
				<form action="LoginServlet" method="POST">

					<div class="form-group">
						<label for="">Username</label> <input type="text"
							class="form-control" required>
					</div>

					<div class="form-group">
						<label for="">Password</label> <input type="password"
							class="form-control" required>
					</div>
					<div class="form-group">
						<label for="">Role</label>
						<select name="role" id="role" class="form-control" required>
							<option value="">Select...</option>
							<option value="admin">Admin</option>
							<option value="investor">Investor</option>
							<option value="Back Office Representative">Back Office Representative</option>
						</select>
					</div>
					
					<button class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>


	</div>

	
</body>
</html>
