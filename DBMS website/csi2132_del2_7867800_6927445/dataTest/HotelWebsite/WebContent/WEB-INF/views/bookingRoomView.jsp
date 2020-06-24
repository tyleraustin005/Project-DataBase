<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
     

<script>
$(function() {
  $('input[name="daterange"]').daterangepicker({
    opens: 'left'
  }, function(start, end, label) {
    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
  });
});
</script>
      <title>Select Booking Parameters</title>
   </head>
   <body>

      <h3>Booking page</h3>
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/bookingRoomView">
         <table border="0">
         
         	<tr>
         		<td> Customer Sin </td>
         		<td> <%=request.getAttribute("customerSin") %> </td>
         	</tr>
         	<tr>
              	<td>Chain Name</td>
                <td><select name="chain_name">
                		<option value="none">No Preference</option>
  						<option value="Westin">Westin</option>
  						<option value="Radison">Radison</option>	
  						<option value="Best Northern">Best Northern</option>
  						<option value="Holiday Inn">Holiday Inn</option>
  						<option value="Comfort Zone">Comfort Zone</option>				
					</select></td>
            </tr>
         	<tr>
              	<td>City</td>
                <td><select name="city">
  						<option value="New York">New York</option>
  						<option value="Chicago">Chicago</option>
  						<option value="Vancouver">Vancouver</option>
  						<option value="Toronto">Toronto</option>
  						<option value="Atlanta">Atlanta</option>
  						<option value="Hamilton">Hamilton</option>
  						<option value="Detroit">Detroit</option>
  						<option value="Ottawa">Ottawa</option>
  						 						
					</select></td>
            </tr>
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
  					

            <tr>
              	<td>Capacity</td>
                <td><select name="capacity">
                		<option value="none">No Preference</option>
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
              	<td>Rating</td>
                <td><select name="rating">
                		<option value="0">No preference</option>
  						<option value="1">1 Stars</option>
  						<option value="2">2 Stars</option>
  						<option value="3">3 Stars</option>
  						<option value="4">4 Stars</option>
  						<option value="5">5 Stars</option>
  						
  						 						
					</select></td>
            </tr>
            
            
            <tr>
               <td>Max Price</td>
               <td><input type="text" name="max_price" value="200" /></td>
            </tr>
            <tr>
               <td>Min Price</td>
               <td><input type="text" name="min_price" value="0" /></td>
            </tr>
            
            		
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="productList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
  <br> to book your favourite hotel from our database click
				  <a href="favouriteHotelView">here</a> !
       
   </body>
</html>