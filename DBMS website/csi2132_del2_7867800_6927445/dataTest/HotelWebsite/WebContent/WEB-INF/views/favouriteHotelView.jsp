<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
     

      <title>Select Favourite Hotel</title>
   </head>
   <body>

      <h3>Hotels Page</h3>
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/favouriteHotelView">
         
         <h4>Please select your desired hotel</h4>
         	<select name="hotel_name">
         		<c:forEach items="${hotelsList}" var="hotel" >
													
					<option value="${hotel.hotel_name}">${hotel.hotel_name}</option>

			</c:forEach>
			</select>
			<table border="0">
			<tr>
         		<td>Start date</td>
         		<td>
  					<input type="date" name="start_date">
				</td>
            </tr>
  			<tr>
  				<td>end date</td>
         		<td>
					<input type="date" name="end_date">
				</td>
            </tr>

            </table>
            <br>
            <br>
            
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
			
         <input type="submit" value= "Submit" />
       
      </form>
       
    <br> 
    <a href="bookingRoomView">Make a different booking?</a> <br>
				  
   </body>
</html>