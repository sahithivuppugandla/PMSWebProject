<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String date = sdf.format(new Date());
%>
 <script>
        document.getElementById("businessStructure").value ='${existingLoan.bstructure}';
        </script>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${existingLoan.purpose != null}">
					<form action="user?action=editLoanProcess" method="post">
				</c:if>
				<c:if test="${existingLoan.purpose == null}">
					<form action="user?action=placeloan" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${existingLoan.purpose != null}">
                                    Edit Loan Application 
                                </c:if>
						<c:if test="${existingLoan.purpose == null}">
                                    Add New Loan Application
                                </c:if>
					</h2>
				</caption>
			</div>
			<!--
	write the html code to accept laon info from user and send to placeloan servlet
-->
			<table>
			 <c:if test="${existingLoan.applno!= null}">
                            <input type="hidden" name="id" value="<c:out value='${existingLoan.applno}' />" />
                        </c:if>
				<tr>
					<td>Loan Name</td>
					<td><input type="text" name="loanName" required
						value="<c:out value='${existingLoan.purpose}' />" /></td>

				</tr>

				<tr>
					<td>Loan Amount</td>
					<td><input type="number" name="loanAmount" required
						value="<c:out value='${existingLoan.amtrequest}' />" /></td>
				</tr>
				<tr>
					<td>Loan Application Date</td>
					<td><input type="datetime-local" name="loanApplicationDate"
						required value="<%=date%>" /></td>
				</tr>

				<tr>
					<td>Business Structure</td>
					<td><select name="businessStructure" id="businessStructure"
						required >

							<option value="">Select one...</option>
							<option value="individual">Individual</option>
							<option value="organization">Organization</option>


							
					</select></td>
				</tr>
				<tr>
					<td>Billing Indicator</td>
					<td><select name="billingIndicator" id="billingIndicator"
						required value="<c:out value='${existingLoan.bindicator}' />">

							<option value="">Select one...</option>
							<option value="salaried">Salaried</option>
							<option value="nonSalaried">Non-Salaried</option>

					</select></td>
				</tr>
				<tr>
					<td>Tax Indicator</td>
					<td><select name="taxIndicator" id="taxIndicator" required
						value="<c:out value='${existingLoan.tindicator}' />">

							<option value="">Select one...</option>
							<option value="taxPayer">Tax Payer</option>
							<option value="nonTaxPayer">Non-Tax Payer</option>

					</select></td>
				</tr>
				<tr>
					<td>Contact Address</td>
					<td><input type="text" name="contactAddress" required
						value="<c:out value='${existingLoan.address}' />" /></td>
				</tr>
				<tr>
					<td>Contact Email</td>
					<td><input type="email" name="contactEmail" required
						value="<c:out value='${existingLoan.email}' />" /></td>
				</tr>
				<tr>
					<td>Contact Mobile</td>
					<td><input type="number" name="contactMobile" required
						value="<c:out value='${existingLoan.mobile}' />" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>

			</form>
			</div>
			</div>
			
			<jsp:include page="footer.jsp" />
</body>
</html>