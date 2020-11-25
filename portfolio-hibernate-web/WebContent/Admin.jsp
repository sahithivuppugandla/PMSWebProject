<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Homepage</title>


<style>

.navigation-link {
	border: 2px solid transparent;
}

.navigation-link:hover {
	text-decoration: none;
	border-bottom: 2px solid #f5ba09;
	transition: 0.5s ease;
}
</style>
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


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	 <i class="fas fa-code fa-2x text-warning pb-3 pt-3 pr-2"></i>
  <a class="navbar-brand"">Portfolio Management</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
     
      <a class="nav-item nav-link" href="BORRegistration.jsp">Register A Back Office Representative</a>
      <a class="nav-item nav-link" href="Logout.jsp">Logout</a>
    </div>
  </div>
</nav>
	
	
	<div class="text-dark">
						<p>Welcome Admin</p>
					</div>
</body>
</html>