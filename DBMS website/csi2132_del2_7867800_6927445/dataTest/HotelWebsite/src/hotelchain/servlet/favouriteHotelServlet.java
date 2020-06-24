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
import java.util.List;

import hotelChains.beans.*;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
 

@WebServlet(urlPatterns = { "/favouriteHotelView"})
 
public class favouriteHotelServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public favouriteHotelServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
        
        
        Customer cust = MyUtils.getLoginedCustomer(session);
        List<hotel> list = null;
        
        try {
			System.out.println("above 1");
			list = DBUtils.getHotels(conn);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("hotelsList", list);
        request.setAttribute("customerSin", cust.getSin());
        
       
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/favouriteHotelView.jsp");
	        
	    dispatcher.forward(request, response);
	        
	   }
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoredConnection(request);
		String start_date = (String) request.getParameter("start_date");
		String end_date = (String) request.getParameter("end_date");
		Booking booking = new Booking();
		booking.setStart_date(start_date);
		booking.setEnd_date(end_date);
		
		
		String hotel_name = (String) request.getParameter("hotel_name");
		
		List<Room> list = null;
		List<hotel> list2 = null;
			
		try {
			System.out.println("above 1");
			list = DBUtils.queryRoom3(conn, hotel_name, booking);
			System.out.println("above 2");
			list2 = DBUtils.queryRoom4(conn, hotel_name, booking);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				
		request.setAttribute("roomList", list);
		request.setAttribute("hotelList", list2);
		HttpSession session = request.getSession();
        MyUtils.storeBooking(session, booking);
		
		doGet(request, response);

		 //response.sendRedirect(request.getContextPath() + "/favouriteHotelView");
		
		
		
	}
	
	
	
	
}
