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

import java.util.ArrayList;
import java.util.List;

import hotelChains.beans.*;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;
 

@WebServlet(urlPatterns = { "/roomListView"})
 
public class roomListServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public roomListServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		
		
		HttpSession session = request.getSession();
		Booking  booking = MyUtils.getBookingSaved(session);
		Room room = MyUtils.getRoomSaved(session);
		Address address = MyUtils.getAddressSaved(session);
		HotelChains chain = MyUtils.getChainSaved(session);
		hotel hotel1 = MyUtils.getHotelSaved(session);
		
		List<Room> list = null;
		List<hotel> list2 = null;
			
		try {
			System.out.println("above 1");
			list = DBUtils.queryRoom(conn, room, booking, address, hotel1, chain);
			System.out.println("above 2");
			list2 = DBUtils.queryRoom2(conn, room, booking, address, hotel1, chain);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (list.isEmpty()) {
			

			request.setAttribute("emptyList", "results returned no values, please search with different parameters");
		}
		
				
		request.setAttribute("roomList", list);
		request.setAttribute("hotelList", list2);
        
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/roomListView.jsp");
	        
	    dispatcher.forward(request, response);
	        
	   }
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		/*
		HttpSession session = request.getSession();
		Room room = new Room();
		int room_id = (int) request.getAttribute("room_id");
		room.setRoom_id(room_id);
		MyUtils.storeRoom(session, room);
		*/
		doGet(request, response);
	}
		
		
}
		
