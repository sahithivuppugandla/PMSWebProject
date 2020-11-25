<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Commodity</title>
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
				<h1>Add New Commodity</h1>
				<hr>

				<form>
					<div class="form-group">
						<label for="">Commodity Name</label> <input type="text"
							name="comm_name" class="form-control" required />
					</div>

					<div class="form-group">
						<label for="">Commodity Price</label> <input type="number"
							name="comm_price" class="form-control" required />
					</div>

					<div class="form-group">
						<label for="">Date Updated</label> <input type="datetime-local"
							name="date_upd_comm" class="form-control" required />
					</div>

					<div class="form-group">
						<label for="">Time Updated</label> <input type="datetime-local"
							name="time_upd_comm" class="form-control" required />
					</div>
					<button type="submit" class="btn btn-primary">Add</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>