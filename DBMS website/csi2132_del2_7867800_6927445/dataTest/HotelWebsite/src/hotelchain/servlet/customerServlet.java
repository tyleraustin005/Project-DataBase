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
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
 

@WebServlet(urlPatterns = { "/customerLogin"})
public class customerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public customerServlet() {
		super();
	}
	
	 @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	      
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerLoginView.jsp");
	        
	       dispatcher.forward(request, response);
	        
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   
		    String sinInst = (String) request.getParameter("Sin");
		    String password = (String) request.getParameter("password");
		    int sin = 0;
		    
		    try {
	            sin = Integer.parseInt(sinInst);
	        } catch (Exception e) {
	        }
		    
		    Customer cust = null;
	        boolean hasError = false;
	        String errorString = null;
	 
	        if (sinInst == null  || sinInst.length() == 0 ) {
	            hasError = true;
	            errorString = "Required Sin!";
	        } else {
	            Connection conn = MyUtils.getStoredConnection(request);
	            try {
	                // Find the user in the DB.
	                cust = DBUtils.findCustomer(conn, sin);
	 
	                if (cust == null) {
	                    hasError = true;
	                    errorString = "Sin invalid, please use the new customer page";
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                hasError = true;
	                errorString = e.getMessage();
	            }
	        }
	        // If error, forward to /WEB-INF/views/login.jsp
	        if (hasError) {
	            cust = new Customer();
	            cust.setSin(sin);
	            cust.setPassword(password);
	 
	            // Store information in request attribute, before forward.
	            request.setAttribute("errorString", errorString);
	            request.setAttribute("customer", cust);
	 
	            // Forward to /WEB-INF/views/login.jsp
	            RequestDispatcher dispatcher //
	                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerLoginView.jsp");
	 
	            dispatcher.forward(request, response);
	        }
	      
	        else {
	            HttpSession session = request.getSession();
	            MyUtils.storeLoginedCustomer(session, cust);
	         
	            MyUtils.deleteUserCookie(response);
	            
	            request.setAttribute("customer", cust);
	 
	            // Redirect to booking page.
	            response.sendRedirect(request.getContextPath() + "/bookingRoomView");
	        }
	   }

}
