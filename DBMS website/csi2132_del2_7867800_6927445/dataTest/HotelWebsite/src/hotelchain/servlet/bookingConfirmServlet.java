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
 
@WebServlet(urlPatterns = { "/bookingConfirm" })
public class bookingConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public bookingConfirmServlet() {
        super();
    }
 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        
        HttpSession session = request.getSession();      
        Customer cust = MyUtils.getLoginedCustomer(session); 
        Booking book1 = MyUtils.getBookingSaved(session);
        hotel hotel1 = MyUtils.getHotelSaved(session);
        Room room1 = MyUtils.getRoomSaved(session);

       //int room_id = room1.getRoom_id();
        int custSin = cust.getSin();
        String start = book1.getStart_date();
        String end = book1.getEnd_date();
        String name = (String) request.getParameter("hotel_name"); 
        String roomS = (String) request.getParameter("room_id");
        System.out.println(roomS);
        
        int room_id =0;
        try {
            room_id = Integer.parseInt(roomS);
          
            
        } catch (Exception e) {
        }
 
        String errorString = null;
        
        
        try {
			DBUtils.bookRoom(conn, room_id, custSin,start, end );
			System.out.println("inbookroom");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
       
 
        request.setAttribute("customerSin", custSin);
        request.setAttribute("room_id", room_id);
        request.setAttribute("start", start);
        request.setAttribute("end", end);
        request.setAttribute("hotel_name", name);
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/bookingConfirmView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}