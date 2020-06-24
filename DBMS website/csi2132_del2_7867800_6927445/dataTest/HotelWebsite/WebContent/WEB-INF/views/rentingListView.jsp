<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Renting List</title>
</head>
<body>

	<h3>Renting List Page</h3>
	<p style="color: red;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/rentingList">
	</form>
	
	<h3>Rentings List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Customer SIN</th>
          <th>Room ID</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Confirm</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${bookingList}" var="booking" >
          <tr>
             <td>${booking.c_sin}</td>
             <td>${booking.room_id}</td>
             <td>${booking.start_date}</td>
             <td>${booking.end_date}</td>
             <td>
                <a href="confirmBooking?c_sin=${booking.c_sin}">Confirm</a>
             </td>
             <td>
                <a href="deleteBooking?c_sin=${booking.c_sin}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
    
    <br>

<a href="employeeHome">Home Page</a> <br>

</body>
</html>