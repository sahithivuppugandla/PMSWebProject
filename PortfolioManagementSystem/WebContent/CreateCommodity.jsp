<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Commodity</title>
</head>
<body>

<form>
		<table>
		<tr>
		<td>Commodity Name</td>
		<td><input type="text" name="comm_name" required/></td>
		</tr>
		<tr>
		<td>Commodity Price</td>
		<td><input type="number" name="comm_price" required/></td>
		</tr>
		<td>Date Updated</td>
		<td><input type="datetime-local" name="date_upd_comm" required/></td>
		</tr>
		<tr>
		<td>Time Updated</td>
		<td><input type="text" name="time_upd_comm" required/></td>
		</tr>
		
		<td><input type="submit" value="Add"/>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>