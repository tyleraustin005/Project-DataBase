package hotelchain.utils;
 
import java.sql.Connection;
 
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import hotelChains.beans.*;
 
public class MyUtils {
 
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
    // Store Connection in request attribute.
    // (Information stored only exist during requests)
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    // Get the Connection object has been stored in attribute of the request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
 
    // Store user info in Session.
    public static void storeLoginedCustomer(HttpSession session, Customer loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedCustomer", loginedUser);
    }
 
    // Get the user information stored in the session.
    public static Customer getLoginedCustomer(HttpSession session) {
        Customer loginedUser = (Customer) session.getAttribute("loginedCustomer");
        return loginedUser;
    }
    
    public static void storeBooking(HttpSession session, Booking book) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("booking_saved", book);
    }
 
    // Get the user information stored in the session.
    public static Booking getBookingSaved(HttpSession session) {
        Booking book = (Booking) session.getAttribute("booking_saved");
        return book;
    }
    
    public static void storeAddress(HttpSession session, Address book) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("address_saved", book);
    }
 
    // Get the user information stored in the session.
    public static Address getAddressSaved(HttpSession session) {
    	Address book = (Address) session.getAttribute("address_saved");
        return book;
    }
    
    public static void storeRoom(HttpSession session, Room book) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("room_saved", book);
    }
 
    // Get the user information stored in the session.
    public static Room getRoomSaved(HttpSession session) {
    	Room book = (Room) session.getAttribute("room_saved");
        return book;
    }
    
    public static void storeChain(HttpSession session, HotelChains book) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("chain_saved", book);
    }
 
    // Get the user information stored in the session.
    public static HotelChains getChainSaved(HttpSession session) {
    	HotelChains book = (HotelChains) session.getAttribute("chain_saved");
        return book;
    }

    public static void storeHotel(HttpSession session, hotel book) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("hotel_saved", book);
    }
 
    // Get the user information stored in the session.
    public static hotel getHotelSaved(HttpSession session) {
    	hotel book = (hotel) session.getAttribute("hotel_saved");
        return book;
    }
    
    // Store info in Cookie
    public static void storeUserCookie(HttpServletResponse response, Customer user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, Integer.toString(user.getSin()) );
       
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }
    
    // Store employee info in Session.
    public static void storeLoginedEmployee(HttpSession session, Employee loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedEmployee", loginedUser);
    }
 
    // Get the user information stored in the session.
    public static Employee getLoginedEmployee(HttpSession session) {
    	Employee loginedUser = (Employee) session.getAttribute("loginedEmployee");
        return loginedUser;
    }
 
    public static int getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return Integer.parseInt(cookie.getValue());
                }
            }
        }
        return 666;
    }
 
    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 seconds (This cookie will expire immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
 
}