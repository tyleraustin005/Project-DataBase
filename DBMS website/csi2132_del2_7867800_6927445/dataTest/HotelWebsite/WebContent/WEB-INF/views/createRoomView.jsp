<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Room Form</title>
</head>
<body>
	<h1>Create New Room</h1>
	<form method="POST"
		action="${pageContext.request.contextPath}/createRoom">
		<table border="0">
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="${room.price}" /></td>
			</tr>
			<tr>
				<td>Capacity</td>
				<td><select name="capacity">
						<option value="single">Single</option>
						<option value="double">Double</option>
						<option value="queen">Queen</option>
						<option value="king">King</option>
						<option value="2 singles">2 Singles</option>
						<option value="2 doubles">2 Doubles</option>
						<option value="2 queens">2 Queens</option>
						<option value="2 kings">2 Kings</option>
				</select></td>
			</tr>
			<tr>
				<td>Room View</td>
				<td><select name="view">
						<option value="mountain">mountain</option>
						<option value="park">park</option>
						<option value="city">city</option>
						<option value="river">river</option>
						<option value="ocean">ocean</option>
						<option value="square">square</option>
				</select></td>
			</tr>
			<tr>
				<td>Can Be Extended</td>
				<td><select name="extended">
						<option value="yes">Yes</option>
						<option value="no">No</option>
				</select></td>
			</tr>
			<tr>
				<td>Room Quality</td>
				<td><select name="quality">
						<option value="very poor">very poor</option>
						<option value="poor">poor</option>
						<option value="fair">fair</option>
						<option value="good">good</option>
						<option value="very good">very good</option>
						<option value="excellent">excellent</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>

				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<br> <br> <a href="employeeLogin">Cancel</a>
	</form>



</body>
</html>