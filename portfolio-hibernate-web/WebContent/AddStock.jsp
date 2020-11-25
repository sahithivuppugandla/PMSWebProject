<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Stock</title>
</head>
<body>

	<form>
		<table>
			<tr>
				<td>Company Code</td>
				<td><input type="number" name="comp_code" required /></td>
			</tr>
			<tr>
				<td>Stock Exchange</td>
				<td><input type="text" name="stock_exc" required /></td>
			</tr>
			<tr>
				<td>Current Market Price</td>
				<td><input type="number" name="current_price" required /></td>
			</tr>
			<tr>
				<td>Date Updated</td>
				<td><input type="datetime-local" name="date_upd" required /></td>
			</tr>
			<tr>
				<td>Time Updated</td>
				<td><input type="text" name="time_upd" required /></td>
			</tr>

			<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>