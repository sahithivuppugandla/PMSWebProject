<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">
	<jsp:include page="header.jsp" />
	<div align="right">
		<a href="index.jsp">Logout</a>
	</div>
	<nav>
		<a href="userhome.jsp">User Dashboard</a><br>
	</nav>
	<h1>Loan Application Form</h1>

	

	<!--
	write the html code to accept laon info from user and send to placeloan servlet
-->

	<table>
		<tr>
			<td>Loan Application Number</td>
			<td><input type="" name="loanApplicationNumber" required /></td>
		</tr>
		<tr>
			<td>Loan Name</td>
			<td><input type="text" name="loanName" required /></td>
		</tr>

		<tr>
			<td>Loan Amount</td>
			<td><input type="number" name="loanAmount" required /></td>
		</tr>
		<tr>
			<td>Loan Application Date</td>
			<td><input type="datetime-local" name="loanApplicationDate"
				required /></td>
		</tr>

		<tr>
			<td>Business Structure</td>
			<td><select name="businessStructure" id="businessStructure"
				required>

					<option value="">Select one...</option>
					<option value="individual">Individual</option>
					<option value="organization">Organization</option>
			</select></td>
		</tr>
		<tr>
			<td>Billing Indicator</td>
			<td><select name="billingIndicator" id="billingIndicator"
				required>

					<option value="">Select one...</option>
					<option value="salaried">Salaried</option>
					<option value="nonSalaried">Non-Salaried</option>

			</select></td>
		</tr>
		<tr>
			<td>Tax Indicator</td>
			<td><select name="taxIndicator" id="taxIndicator" required>

					<option value="">Select one...</option>
					<option value="taxPayer">Tax Payer</option>
					<option value="nonTaxPayer">Non-Tax Payer</option>

			</select></td>
		</tr>
		<tr>
			<td>Contact Address</td>
			<td><input type="text" name="contactAddress" required /></td>
		</tr>
		<tr>
			<td>Contact Email</td>
			<td><input type="email" name="contactEmail" required /></td>
		</tr>
		<tr>
			<td>Contact Mobile</td>
			<td><input type="number" name="contactMobile" required /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>


	<jsp:include page="footer.jsp" />

</body>
</html>