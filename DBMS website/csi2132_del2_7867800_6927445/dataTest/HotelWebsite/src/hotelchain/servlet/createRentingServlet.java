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
import hotelChains.beans.Renting;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
 

@WebServlet(urlPatterns = { "/createRenting"})
public class createRentingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public createRentingServlet() {
		super();
	}
	
	 @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	      
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createRentingView.jsp");
	        
	       dispatcher.forward(request, response);
	        
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   
		    String c_sinInst = (String) request.getParameter("c_sin");
		    String room_idInst = (String) request.getParameter("room_id");
		    String start_date = (String) request.getParameter("start_date");
		    String end_date = (String) request.getParameter("end_date");
		    
		    HttpSession session = request.getSession();
		    
		    int c_sin = 0;
		    int room_id = 0;
		    
		    try {
	            c_sin = Integer.parseInt(c_sinInst);
	        } catch (Exception e) {
	        }
		    
		    try {
	            room_id = Integer.parseInt(room_idInst);
	        } catch (Exception e) {
	        }
		    
		    Renting renting = null;
	        boolean hasError = false;
	        String errorString = null;
	 
	        if (c_sinInst == null  || c_sinInst.length() == 0 ) {
	            hasError = true;
	            errorString = "Customer Sin is Required!";
	        } else if (room_idInst == null  || room_idInst.length() == 0 ) {
	            hasError = true;
	            errorString = "Room ID is Required!";
	        } else if (start_date.isEmpty()) {
	        	hasError = true;
				errorString = "Start Date is Required!";
	        } else if (end_date.isEmpty()) {
	        	hasError = true;
				errorString = "End Date is Required!";
	        }
	        else {
	            Connection conn = MyUtils.getStoredConnection(request);
	            try {
	                // Find the user in the DB.
	            	DBUtils.queryCeateRenting(conn, session, c_sin, room_id, start_date, end_date);
	            	response.sendRedirect(request.getContextPath() + "/rentingList");
	 
	            } catch (SQLException e) {
	                e.printStackTrace();
	                hasError = true;
	                errorString = e.getMessage();
	            }
	        }
	        // If error, forward to /WEB-INF/views/login.jsp
	        if (hasError) {
	        	System.out.print("\nERROR!\n");
	            response.sendRedirect(request.getContextPath() + "/rentingList");
	        }
	        
	   }

}
