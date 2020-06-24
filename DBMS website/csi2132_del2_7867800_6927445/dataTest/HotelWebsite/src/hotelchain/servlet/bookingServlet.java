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
 

@WebServlet(urlPatterns = { "/bookingRoomView"})
 
public class bookingServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public bookingServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
        
        
        Customer cust = MyUtils.getLoginedCustomer(session);
        
        request.setAttribute("customerSin", cust.getSin());
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/bookingRoomView.jsp");
	        
	    dispatcher.forward(request, response);
	        
	   }
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		

		
		String start_date = (String) request.getParameter("start_date");
		String end_date = (String) request.getParameter("end_date");
		String city = (String) request.getParameter("city");
		String capacity = (String) request.getParameter("capacity");
		String chain_name = (String) request.getParameter("chain_name");
		String ratingS = (String) request.getParameter("rating");
		String min_priceS = (String) request.getParameter("min_price");
		String max_priceS = (String) request.getParameter("max_price");			
		
		int min_price =0;
		int max_price =1;
		int rating = 0;
		try {
            min_price = Integer.parseInt(min_priceS);
            max_price = Integer.parseInt(max_priceS);
            rating = Integer.parseInt(ratingS);
            
        } catch (Exception e) {
        }
		
		
		Room room = new Room();
		Booking booking = new Booking();
		Address address = new Address();
		HotelChains hotelChain = new HotelChains();
		hotel hotel = new hotel();
		String errorString = null;
		
		hotel.setRating(rating);
		
		hotelChain.setChain_name(chain_name);
		
		room.setCapacity(capacity);
		room.setMax_price(max_price);
		room.setMin_price(min_price);
		
		
		booking.setStart_date(start_date);
		booking.setEnd_date(end_date);
		
		address.setCity(city);
		request.setAttribute("room1", room);
		request.setAttribute("booking1", booking);
		request.setAttribute("address1", address);
		//request.setAttribute("customerSin", sin);
		HttpSession session = request.getSession();
        MyUtils.storeBooking(session, booking);
        MyUtils.storeRoom(session, room);
        MyUtils.storeAddress(session, address);
        MyUtils.storeChain(session, hotelChain);
        MyUtils.storeHotel(session, hotel);
        
		

        response.sendRedirect(request.getContextPath() + "/roomListView");
		
		
	}
	
	
	
	
}
