<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>

	<h3>Employee Login Page</h3>
	<p style="color: red;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/employeeLogin">
		<table border="0">
					</tr>
			<tr>
			<td></td>
			</tr>
			<tr>
				<td>Sin&nbsp;</td>
				<td><input type="text" name="Sin" value="${cust.sin}" /></td>
			</tr>
			<tr>
			<td>Password&nbsp;</td>
				<td><input type="text" name="Password" value="${cust.pass}" /></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>

	<br>

	<a href="${pageContext.request.contextPath}/">Cancel</a>
	<br>
	<br>
	
	<br> to add a new employee Click
				  <a href="employeeRegister">here</a> to now!

</body>
</html>