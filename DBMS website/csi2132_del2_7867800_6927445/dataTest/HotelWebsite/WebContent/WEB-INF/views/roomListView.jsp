<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of available rooms</title>
</head>
<body>
<h3>List of available rooms</h3>
<p style="color: red;">${errorString}</p>
<form method="POST" action="${pageContext.request.contextPath}/roomListView">



<div style="float: left; width: 12.5%;">
	
	<h4>Hotel Name</h4>
	<ul>
	<c:forEach items="${hotelList}" var="hotel" >
		<li>${hotel.hotel_name}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Hotel Rating</h4>
	<ul>
	<c:forEach items="${hotelList}" var="hotel" >
		<li>${hotel.rating}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Room ID</h4>
	<ul>
	<c:forEach items="${roomList}" var="room" >
		<li>${room.room_id}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Room Capacity</h4>
	<ul>
	<c:forEach items="${roomList}" var="room" >
		<li>${room.capacity}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Room Quality</h4>
	<ul>
	<c:forEach items="${roomList}" var="room" >
		<li>${room.room_quality}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Room View</h4>
	<ul>
	<c:forEach items="${roomList}" var="room" >
		<li>${room.room_view}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Room Price ($)</h4>
	<ul>
	<c:forEach items="${roomList}" var="room" >
		<li>${room.price}</li>
	</c:forEach>
	</ul>
</div>
<div style="float: left; width: 12.5%;">
	<h4>Room Price ($)</h4>
	<ul>
	<c:forEach items="${roomList}" var="room" >
		<li><a href="bookingConfirm?room_id=${room.room_id}">book</a></li>
	</c:forEach>
	</ul>
</div>
           
       		
</form>
</body>
<footer>
		<br> to change your selected parameters click
				  <a href="bookingRoomView">here</a> to go back to the booking page now!
				  
		<br>		  
       		<p><%=request.getAttribute("emptyList") %> </p>
       		

</footer>
</html>