package hotelchain.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelChains.beans.Booking;
import hotelChains.beans.Customer;
import hotelChains.beans.Renting;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
 

@WebServlet(urlPatterns = { "/rentingList"})
public class rentingListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public rentingListServlet() {
		super();
	}
	
	 @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       
	       Connection conn = MyUtils.getStoredConnection(request);
	       
	       HttpSession session = request.getSession();
	       
	       String errorString = null;
	       List<Renting> list = null;
	       
	        try {
	            list = DBUtils.queryRenting(conn, session);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("bookingList", list);
	        
	        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/rentingListView.jsp");
		    dispatcher.forward(request, response);
		       
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   doGet(request, response);  
	   }

}
