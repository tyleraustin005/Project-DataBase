<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>

</head>
<body>
<h1>Your Room Has Been Booked</h1>
<form method="POST" action="${pageContext.request.contextPath}/bookingConfirmView">
		
		
		
		<table border="0">
		<tr>
			<th>Customer Sin   </th>
			<th>Room Number   </th>
			<th>Start Of Booking  </th>
			<th>End of Booking </th>
		</tr>
		<tr>
			<td><%=request.getAttribute("customerSin") %> </td>
			<td><%=request.getAttribute("room_id") %> </td>			
			<td><%=request.getAttribute("start") %> </td>
			<td><%=request.getAttribute("end") %> </td>
		
		
		</tr>
  
        </table>
</form>

<a href="bookingRoomView">Make another booking?</a> <br>
<a href="index.html"> back to login </a> <br>

</body>
</html>