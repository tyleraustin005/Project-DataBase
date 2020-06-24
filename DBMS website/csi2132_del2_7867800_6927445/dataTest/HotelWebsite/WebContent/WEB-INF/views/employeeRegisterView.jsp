<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
<title>Employee Registration Form</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form method="POST"
		action="${pageContext.request.contextPath}/employeeRegister">
		<table border="0">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first" value="${employee.first}" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last" value="${employee.last}" /></td>
			</tr>
			<tr>
				<td>SIN Number</td>
				<td><input type="text" name="sin" value="${employee.sin}" /></td>
			</tr>
			<tr>
				<td>Password (Max 15 Characters)</td>
				<td><input type="text" name="pass" value="${employee.pass}" /></td>
			</tr>
			<tr>
				<td>Position</td>
				<td><input type="text" name="position" value="${employee.position}" /></td>
			</tr>
			<tr>
				<td>Hotel id?</td>
				<td><input type="text" name="hotel_id" value="${employee.hotel_id}" /></td>
			</tr>
			
			<tr>
				<td>Address</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Street</td>
				<td><input type="text" name="street" value="${employee.street}" /></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;City/State</td>
				<td><input type="text" name="city" value="${employee.city}" /></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Country</td>
				<td><input type="text" name="country" value="${employee.country}" /></td>
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
		<a href="employeeLogin">Cancel</a>
	</form>



</body>
</html>