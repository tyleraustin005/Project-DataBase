<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Confirmed Booking</title>
   </head>
   <body>
   
   	<form method="POST"
		action="${pageContext.request.contextPath}/deleteBooking">
	</form>
   
      <h3>Delete Booking</h3>
      
      <h4>The following booking is now deleted.</h4>
 
      <c:if test="${not empty booking}">
      
      <table border="0">
               <tr>
                  <td><b>Customer SIN</b></td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${booking.c_sin}</td>
               </tr>
               <tr>
                  <td><b>Room ID</b></td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${booking.room_id}</td>
               </tr>
               <tr>
                  <td><b>Start Date</b></td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${booking.start_date}</td>
               </tr>
               <tr>
                  <td><b>End Date</b></td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${booking.end_date}</td>
               </tr>
            </table>
             </c:if>

             <br>

         <br>
         <a href="employeeHome">Home</a>
     
   </body>
</html>