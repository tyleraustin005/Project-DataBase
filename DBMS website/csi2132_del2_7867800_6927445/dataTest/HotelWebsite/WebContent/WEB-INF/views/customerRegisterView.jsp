<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Form</title>
<title>Customer Registration Form</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form method="POST"
		action="${pageContext.request.contextPath}/customerRegister">
		<table border="0">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first" value="${cust.first}" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last" value="${cust.last}" /></td>
			</tr>
			<tr>
				<td>SIN Number</td>
				<td><input type="text" name="sin" value="${cust.sin}" /></td>
			</tr>
			<tr>
				<td>Password (Max 15 Characters)</td>
				<td><input type="text" name="pass" value="${cust.pass}" /></td>
			</tr>
			<tr>
				<td>Address</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Street</td>
				<td><input type="text" name="street" value="${cust.street}" /></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;City/State</td>
				<td><input type="text" name="city" value="${cust.city}" /></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Country</td>
				<td><input type="text" name="country" value="${cust.country}" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>

				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<br>
		<br>
		<a href="customerLogin">Cancel</a>
	</form>



</body>
</html>