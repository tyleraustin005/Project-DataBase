package hotelchain.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelChains.beans.Customer;
import hotelChains.beans.Employee;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
 

@WebServlet(urlPatterns = { "/employeeLogin"})
public class employeeLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public employeeLoginServlet() {
		super();
	}
	
	 @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	      
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/employeeLoginView.jsp");
	        
	       dispatcher.forward(request, response);
	        
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   
		    String sinInst = (String) request.getParameter("Sin");
		    String password = (String) request.getParameter("Password");
		    
		    int sin = 0;
		    
		    try {
	            sin = Integer.parseInt(sinInst);
	        } catch (Exception e) {
	        }
		    
		    Employee emp = null;
	        boolean hasError = false;
	        String errorString = null;
	 
	        if (sinInst == null  || sinInst.length() == 0 ) {
	            hasError = true;
	            errorString = "Required Sin!";
	        } else if (password.isEmpty()) {
	        	hasError = true;
				errorString = "Password is Required!";
	        }
	        else {
	            Connection conn = MyUtils.getStoredConnection(request);
	            try {
	                // Find the user in the DB.
	            	emp = DBUtils.findEmployee(conn, sin, password);
	 
	                if (emp == null) {
	                    hasError = true;
	                    errorString = "Sin invalid, please try again.";
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                hasError = true;
	                errorString = e.getMessage();
	            }
	        }
	        // If error, forward to /WEB-INF/views/login.jsp
	        if (hasError) {
	            // Need to figure out how to display error message on page
	        	System.out.print("\nERROR!\n");
	            response.sendRedirect(request.getContextPath() + "/customerLogin");
	        }
	      
	        else {
	        	System.out.print("\nNO ERROR BITCHES!\n");
	            HttpSession session = request.getSession();
	            MyUtils.storeLoginedEmployee(session, emp);
	         
	            MyUtils.deleteUserCookie(response);
	 
	            // Redirect to booking page.
	            response.sendRedirect(request.getContextPath() + "/employeeHome");
	        }
	        
	   }

}
