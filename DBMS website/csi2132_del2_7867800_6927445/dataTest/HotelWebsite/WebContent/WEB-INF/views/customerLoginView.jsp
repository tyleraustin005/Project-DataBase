<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Customer Login</title>
	</head>
	<body>
	
	<h3> Login Page </h3>
	<p style="color: red;">${errorString}</p>
	
	<form method="POST" action="${pageContext.request.contextPath}/customerLogin">
         <table border="0">
            <tr>
               <td>Sin</td>
               <td><input type="text" name="Sin" value= "${cust.sin}" /> </td>
            </tr>
            <tr>
               <td>password</td>
               <td><input type="text" name="password" value= "${cust.password}" /> </td>
            </tr>
            <tr>
              
           
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
                  <br>
	   			  <br> New to hotels.ca? Click
				  <a href="customerRegister">here</a> to register now!
               </td>
            </tr>
         </table>
      </form>

	</body>
</html>