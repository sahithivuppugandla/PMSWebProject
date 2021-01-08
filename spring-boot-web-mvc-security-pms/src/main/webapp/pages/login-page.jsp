
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<!-- Bootstrap core CSS -->
<script src="https://kit.fontawesome.com/996973c893.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/fontawesome.min.css"></script>
<style>
* {
	box-sizing: border-box;
}
body {
	background-color: #9b59b6;
	display: flex;
	font-family:sans-serif;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
	margin: 0;
}
.container {
	background-color: #fff;
	border-radius: 5px;
	overflow: hidden;
	width: 400px;
	max-width: 100%;
}
.header {
	border-bottom: 1px solid #f0f0f0;
	background-color: #f7f7f7;
	padding: 20px 40px;
}
.form {
	padding: 30px 40px;	
}
.form-control {
	margin-bottom: 10px;
	padding-bottom: 20px;
	position: relative;
}
.form-control label {
	display: inline-block;
	margin-bottom: 5px;
}
.form-control input {
	border: 2px solid black;
	border-radius: 4px;
	display: block;
	padding: 10px;
	width: 100%;
}

.form-control input:focus {
	outline: 0;
	border-color: #777;
}

.form-control.success input {
	border-color: #2ecc71;
}

.form-control.error input {
	border-color: #e74c3c;
}
.form-control i {
	visibility: hidden;
	position: absolute;
	top: 40px;
	right: 10px;
}

.form-control.success i.fa-check-circle {
	color: #2ecc71;
	visibility: visible;
}

.form-control.error i.fa-exclamation-circle {
	color: #e74c3c;
	visibility: visible;
}

.form-control small {
	color: #e74c3c;
	position: absolute;
	bottom: 0;
	left: 0;
	visibility: hidden;
}

.form-control.error small {
	visibility: visible;
}

.form button {
	background-color: #8e44ad;
	border: 2px solid #8e44ad;
	border-radius: 4px;
	color: #fff;
	display: block;
	font-family: inherit;
	font-size: 16px;
	padding: 10px;
	margin-top: 20px;
	width: 100%;
}
</style>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

</head>
<body>
	
	<div class="container">
	
		<div class="header">
		<h2>Login</h2>
		</div>		
				<form:form action="/login" 
				method="POST" id="form" class="form"  >
				
				<c:if test="${param.error != null}">
					Invalid Credentials! Access Denied!
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"	
						value="${_csrf.token}" />
				<div class="form-control-group">
					<form:errors path="*"/>				
				</div>
				<div class="form-control">
					<label for="username">Username: </label>
					<input type="text" name="unm" id="username" />
					<i class="fas fa-check-circle"></i>
					<i class="fa fa-exclamation-cicle"></i>
					<small>Error message</small>
				</div> 
				<div class="form-control">
					<label for="password">Password: </label>
					<input type="password" name="pwd" id="password"/>
					<i class="fa fa-check-circle"></i>
					<i class="fa fa-exclamation-circle"></i>
					<small>Error message</small>
				</div>					 
				
					<button>Login</button>				
				</form:form>
			</div>

	
	<script type="text/javascript">

	const form = document.getElementById('form');
	const username = document.getElementById('username');
	const password = document.getElementById('password');


	form.addEventListener('submit', e => {
		
		checkInputs();
	});

	function checkInputs() {
		// trim to remove the whitespaces
		const usernameValue = username.value.trim();
		const passwordValue = password.value.trim();
		
		if(usernameValue === '') {
			setErrorFor(username, 'Username cannot be blank');
		} else if(usernameValue.length<4 || usernameValue.length>15){
			setErrorFor(username, 'Username should contain 4 to 15 characters');
			}
		else {
			setSuccessFor(username);
		}
		
		if(passwordValue === '') {
			setErrorFor(password, 'Password cannot be blank');
		} else if (passwordValue.length<8 || passwordValue>15){
			setErrorFor(password, 'Password should contain 8 to 15 characters');
		}
		else {
			setSuccessFor(password);
		}
	}

	function setErrorFor(input, message) {
		const formControl = input.parentElement;
		const small = formControl.querySelector('small');
		formControl.className = 'form-control error';
		small.innerText = message;
	}

	function setSuccessFor(input) {
		const formControl = input.parentElement;
		formControl.className = 'form-control success';
	}
	</script>
</body>
</html>