<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Renting</title>
</head>
<body>

	<h3>Create New Renting</h3>
	<p style="color: red;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/createRenting">

		<table border="0">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>Customer Sin&nbsp;</td>
				<td><input type="text" name="c_sin" value="${renting.sin}" /></td>
			</tr>
			<tr>
				<td>Room ID&nbsp;</td>
				<td><input type="text" name="room_id" value="${renting.id}" /></td>
			</tr>
						<tr>
				<td>Start Date&nbsp;</td>
				<td><input type="text" name="start_date" value="${renting.start}" /></td>
			</tr>
			<tr>
				<td>End Date&nbsp;</td>
				<td><input type="text" name="end_date" value="${renting.end}" /></td>
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

</body>
</html>