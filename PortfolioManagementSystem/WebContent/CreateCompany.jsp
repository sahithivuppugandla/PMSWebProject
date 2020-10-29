<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Company Profile</title>
</head>
<body>

<form>
		<table>
		<tr>
		<td>Company code</td>
		<td><input type="text" name="comp_code" required/></td>
		</tr>
		<tr>
		<td>Company Title</td>
		<td><input type="text" name="comp_title" required/></td>
		</tr>
		<tr>
		<td>Operations</td>
		<td><input type="text" name="comp_operations" required/></td>
		</tr>
		<tr>
		<td>Share Count</td>
		<td><input type="number" name="sharecount" required/></td>
		</tr>
		<tr>
		<td>Open Share Price</td>
		<td><input type="number" name="open_share_price" required/></td>
		</tr>
		<tr>
		<td>Sector</td>
		<td>
             <select name="sector" id = "sector" required>
             <option value = "">Select one</option>
               <option value = "agriculture">Agriculture</option>
               <option value = "pharma">Pharmaceutical</option>
               <option value = "finance">Finance</option>
              </select>
             </td>
		</tr>
		<tr>
		<td>Currency</td>
		<td><input type="text" name="currency" required/></td>
		</tr>
		<tr>
		<td>Turnover</td>
		<td><input type="number" name="turnover" required/></td>
		</tr>
		<td></td>
		<td><input type="submit" value="Create"/>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>