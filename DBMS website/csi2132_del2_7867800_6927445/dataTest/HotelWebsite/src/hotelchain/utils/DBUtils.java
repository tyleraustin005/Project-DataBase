package hotelchain.utils;
 
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import hotelChains.beans.*;
 
public class DBUtils {
 
    public static Customer findCustomer(Connection conn, int Sin) throws SQLException {
    	
    	
        String sql = "select a.sin, a.full_name, a.address_id, a.registration_date from customer a " //
        		 + " where a.sin = ?"; 
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, Sin);

        ResultSet rs = pstm.executeQuery();

       if (rs.next()) {
    	   
    	   int address_id = rs.getInt("address_id");
    	   String full_name = rs.getString("full_name");
    	   String registration_date = rs.getString("registration_date");
    	   
    	   Customer cust = new Customer();
    	   cust.setAddress_id(address_id);
    	   cust.setFull_name(full_name);
    	   cust.setRegistration_date(registration_date);
    	   cust.setSin(Sin);
    	   /*
    	   rs.close();
    	   pstm.close();
    	   conn.close();    	   
    	   */
    	   return cust;
    	   
    	   
       }
       
       return null;
    }
    
    // returns a list of rooms who are in a certain area and meet other selected criteria
	public static List<Room> queryRoom(Connection conn, Room room, Booking booking, Address address, hotel hotel, HotelChains chain) throws SQLException {
		
		 String capacity = room.getCapacity();
		 
		 int maxP = room.getMax_price();
		 int minP = room.getMin_price();
		
		 int rating = hotel.getRating();
			
		 String start = booking.getStart_date();
		 String end = booking.getEnd_date();
			
		 String city = address.getCity();
		 String chain1 = chain.getChain_name();
		 System.out.println(chain1);
		 
		 String capSql = "";
		 String ratSql = "";
		 String chainSql = "";
		 int f1 = 0;
		 int f2 =0;
		 int f3 =0;
		 
		 
		 String mainSql = "select distinct r.capacity, r.room_view, r.room_id, r.price, r.room_quality from room r, hotel h, "//
				 + " address ad, booking b, hotel_chain ch where r.hotel_id = h.hotel_id and ad.address_id = h.address_id"//
				 + " and (r.price >= ? and  r.price <= ?) and ad.city = ?"//
				 +  " and (not ((b.start_date between ? and ?) or (b.end_date between ? and ?))) ";
		
		 String none = "none";
		 if (!capacity.equals(none)){
			capSql =  " and r.capacity = ? ";
			f1 =1;
		 }
		 if (rating != 0) {
			 ratSql = " and h.rating = ? ";
			 f2=1;
		 }
		 if (!chain1.equals(none)){
			 chainSql =  " and ch.chain_name = ? ";
			 f3=1;
		 }
		 
		 System.out.println(f3);
		String sql = mainSql + capSql + ratSql + chainSql;		 
		
		 
		 System.out.println(capacity);
		 System.out.println(maxP);
		 System.out.println(minP);
		 System.out.println(start);
		 System.out.println(end);
		 System.out.println(city);
		  
		 
		// String sql = "select r.capacity, h.hotel_name, r.room_id from room r, hotel h"//
		//		 + " where r.hotel_id = h.hotel_id";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		 
        if (f1 ==1 && f2 == 1 && f3 == 1) {
        	 
	   		pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setString(8, capacity);
	   		pstm.setInt(9, rating);
	   		pstm.setString(10, chain1);
	   		System.out.println("1");
        	
        }
        else if (f1 ==0 && f2 == 0 && f3 == 1) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setString(8, chain1);
	   		System.out.println("2");
        	
        }else if (f1 ==0 && f2 == 1 && f3 == 0) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setInt(8, rating);
	   		System.out.println("3");
	   		
        }else if (f1 ==0 && f2 == 1 && f3 == 1) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setInt(8, rating);
	   		pstm.setString(9, chain1);
	   		System.out.println("4");
        	
        }else if (f1 ==1 && f2 == 0 && f3 == 0) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setString(8, capacity);
	   		System.out.println("5");
        	
        }else if (f1 ==1 && f2 == 0 && f3 == 1) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setString(8, capacity);
	   		pstm.setString(9, chain1);
	   		System.out.println("6");
        	
        }else if (f1 ==1 && f2 == 1 && f3 == 0) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setString(8, capacity);
	   		pstm.setInt(9, rating);
	   		System.out.println("7");
        	
        }else if (f1 ==0 && f2 == 0 && f3 == 0) {
        	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);	   		
	   		System.out.println("8");
	   		
        	
        }
        
		 
		 ResultSet rs = pstm.executeQuery();

		 
		 List<Room> list = new ArrayList<Room>();

		 

		 while (rs.next()) {
    	   
			 String capacityNew = rs.getString("capacity");
			 int id = rs.getInt("room_id");
			 int price = rs.getInt("price");
			 String view = rs.getString("room_view");
			 String room_quality = rs.getString("room_quality");
			 
			 Room room2 = new Room();
			 room2.setRoom_id(id);
			 room2.setCapacity(capacityNew);
			 room2.setPrice(price);
			 room2.setRoom_view(view);
			 room2.setRoom_quality(room_quality);
			 list.add(room2);			 
			     		
		 }
		 System.out.println(list.size());
		 rs.close();
		 return list;
		
		
	}
	
	public static List<hotel> queryRoom2(Connection conn, Room room, Booking booking, Address address, hotel hotel, HotelChains chain) throws SQLException {
		String capacity = room.getCapacity();
		 
		 int maxP = room.getMax_price();
		 int minP = room.getMin_price();
		
		 int rating = hotel.getRating();
			
		 String start = booking.getStart_date();
		 String end = booking.getEnd_date();
			
		 String city = address.getCity();
		 String chain1 = chain.getChain_name();
		 System.out.println(chain1);
		 
		 String capSql = "";
		 String ratSql = "";
		 String chainSql = "";
		 int f1 = 0;
		 int f2 =0;
		 int f3 =0;
		 
		 
		 String mainSql = "select distinct r.room_id, h.hotel_name, h.rating from room r, hotel h, "//
				 + " address ad, hotel_chain ch left outer join booking b "
				 + "on (not ((b.start_date between ? and ?) or (b.end_date between ? and ?))) "
				 + " where r.hotel_id = h.hotel_id and ad.address_id = h.address_id"//
				 + " and (r.price >= ? and  r.price <= ?) and ad.city = ? ";//
				 
		
		 String none = "none";
		 if (!capacity.equals(none)){
			capSql =  " and r.capacity = ? ";
			f1 =1;
		 }
		 if (rating != 0) {
			 ratSql = " and h.rating = ? ";
			 f2=1;
		 }
		 if (!chain1.equals(none)){
			 chainSql =  " and ch.chain_name = ? ";
			 f3=1;
		 }
		 
		 System.out.println(f3);
		String sql = mainSql + capSql + ratSql + chainSql;		 
		
		 
		 System.out.println(capacity);
		 System.out.println(maxP);
		 System.out.println(minP);
		 System.out.println(start);
		 System.out.println(end);
		 System.out.println(city);
		  
		 
		// String sql = "select r.capacity, h.hotel_name, r.room_id from room r, hotel h"//
		//		 + " where r.hotel_id = h.hotel_id";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		 
       if (f1 ==1 && f2 == 1 && f3 == 1) {
       	 
    	    pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);
	   		
	   		pstm.setString(8, capacity);
	   		pstm.setInt(9, rating);
	   		pstm.setString(10, chain1);
	   		System.out.println("1");
       	
       }
       else if (f1 ==0 && f2 == 0 && f3 == 1) {
       	pstm.setInt(1, minP);
	   		pstm.setInt(2, maxP);
	   		pstm.setString(3, city);
	   		pstm.setString(4, start);
	   		pstm.setString(5, end);
	   		pstm.setString(6, start);
	   		pstm.setString(7, end);
	   		pstm.setString(8, chain1);
	   		System.out.println("2");
       	
       }else if (f1 ==0 && f2 == 1 && f3 == 0) {
    	    pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);
	   		pstm.setInt(8, rating);
	   		System.out.println("3");
	   		
       }else if (f1 ==0 && f2 == 1 && f3 == 1) {
    	    pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);
	   		pstm.setInt(8, rating);
	   		pstm.setString(9, chain1);
	   		System.out.println("4");
       	
       }else if (f1 ==1 && f2 == 0 && f3 == 0) {
    	   pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);
	   		pstm.setString(8, capacity);
	   		System.out.println("5");
       	
       }else if (f1 ==1 && f2 == 0 && f3 == 1) {
    	   pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);
	   		pstm.setString(8, capacity);
	   		pstm.setString(9, chain1);
	   		System.out.println("6");
       	
       }else if (f1 ==1 && f2 == 1 && f3 == 0) {
    	   pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);
	   		pstm.setString(8, capacity);
	   		pstm.setInt(9, rating);
	   		System.out.println("7");
       	
       }else if (f1 ==0 && f2 == 0 && f3 == 0) {
    	   pstm.setString(1, start);
	   		pstm.setString(2, end);
	   		pstm.setString(3, start);
	   		pstm.setString(4, end);
	   		pstm.setInt(5, minP);
	   		pstm.setInt(6, maxP);
	   		pstm.setString(7, city);	   		
	   		System.out.println("8");
	   		
       	
       }
       
		 
		 ResultSet rs = pstm.executeQuery();

		 
		 List<hotel> list = new ArrayList<hotel>();

		 while (rs.next()) {
   	   
			 String hotel_name2 = rs.getString("hotel_name");
			 int rating2 = rs.getInt("rating");
			 System.out.println(hotel_name2);
			 hotel hotel2 = new hotel();
			 hotel2.setHotel_name(hotel_name2);
			 hotel2.setRating(rating2);
			 list.add(hotel2);			 
			     		
		 }
		 System.out.println(list.size());

		 rs.close();
		 return list;
		
		
	}

	public static void bookRoom(Connection conn, int room_id, int custSin, String start, String end) throws SQLException {
		
		String sql = "Insert into Booking values (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, custSin);
        pstm.setInt(2, room_id);
        pstm.setString(3, start);
        pstm.setString(4, end);
 
        pstm.executeUpdate();
        
        
        
	}

public static void insertCustomer(Connection conn, Customer customer) throws SQLException {
	
    String sql = "Insert into customer(sin, full_name, address_id, registration_date, password) values(?,?,?,?,?)";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setInt(1, customer.getSin());
    pstm.setString(2, customer.getFull_name());
    pstm.setInt(3, customer.getAddress_id());
    pstm.setString(4, customer.getRegistration_date());
    pstm.setString(5, customer.getPassword());
    
    pstm.executeUpdate();
}

public static void insertAddress(Connection conn, Address address) throws SQLException {
	
	String sql1 = "SELECT MAX(address_id)+1 FROM address";
	PreparedStatement pstm1 = conn.prepareStatement(sql1);
	ResultSet rs = pstm1.executeQuery();
	String max_id = "";
	
	while(rs.next()) {
		max_id = rs.getString(1);
	}
	
	int max_id2 = Integer.parseInt(max_id);
	
    String sql = "Insert into address(address_id, street, city, country) values(?,?,?,?)";

    PreparedStatement pstm = conn.prepareStatement(sql);

    address.setAddress_id(max_id2);
    
    pstm.setInt(1, max_id2);
    pstm.setString(2, address.getStreet());
    pstm.setString(3, address.getCity());
    pstm.setString(4, address.getCountry());

    pstm.executeUpdate();
}

public static Employee findEmployee(Connection conn, int Sin, String password) throws SQLException {
	
    String sql = "Select a.sin, a.hotel_id, a.full_name, a.address_id, a.em_position, a.password from employee a where a.sin = ? and a.password = ?"; 
   
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1, Sin);
    pstm.setString(2, password);
    
    ResultSet rs = pstm.executeQuery();

   if (rs.next()) {
	   
	   int sin = rs.getInt("sin");
	   int hotel_id = rs.getInt("hotel_id");
	   String full_name = rs.getString("full_name");
	   int address_id = rs.getInt("address_id");
	   String em_position = rs.getString("em_position");
	   String em_password = rs.getString("password");
	   
	  Employee em = new Employee(sin, hotel_id, full_name, address_id, em_position, em_password);
	  return em;
	   
   }
    return null;
}

public static void insertEmployee(Connection conn, Employee employee) throws SQLException {
	
	String sql = "Insert into employee values(?,?,?,?,?,?)";

    PreparedStatement pstm = conn.prepareStatement(sql);

    pstm.setInt(1, employee.getSin());
    pstm.setInt(2, employee.getHotel_id());
    pstm.setString(3, employee.getFull_name());
    pstm.setInt(4, employee.getAddress_id());
    pstm.setString(5, employee.getEm_position());
    pstm.setString(6, employee.getPassword());
    
    pstm.executeUpdate();
	
}

public static List<hotel> getHotels(Connection conn) throws SQLException {
	
	String sql = "select hotel_name from hotel";

    PreparedStatement pstm = conn.prepareStatement(sql);
    
    
    ResultSet rs = pstm.executeQuery();
    
    List<hotel> list = new ArrayList<hotel>();

	 while (rs.next()) {
	   
		 String hotel_name2 = rs.getString("hotel_name");
		 
		 hotel hotel2 = new hotel();
		 hotel2.setHotel_name(hotel_name2);
		 list.add(hotel2);			 
		     		
	 }
	 System.out.println(list.size());

	 rs.close();
	
	
	return list;
}

public static List<Room> queryRoom3(Connection conn, String hotel_name, Booking booking) throws SQLException{
	
	 String start = booking.getStart_date();
	 String end = booking.getEnd_date();

    
	 String sql = "select distinct r.capacity, r.room_view, r.room_id, r.price, r.room_quality from room r, hotel h, "//
			 + " address ad, booking b where r.hotel_id = h.hotel_id and ad.address_id = h.address_id "
			 + " and h.hotel_name = ?"
			 + " and (not ((b.start_date between ? and ?) or (b.end_date between ? and ?)))";
    
	 PreparedStatement pstm = conn.prepareStatement(sql);
	 pstm.setString(1, hotel_name);
	 pstm.setString(2, start);
	 pstm.setString(3, end);
	 pstm.setString(4, start);
	 pstm.setString(5, end);
	 

	 ResultSet rs = pstm.executeQuery();

	 
	 List<Room> list = new ArrayList<Room>();
	 
	 while (rs.next()) {
	   
		 String capacityNew = rs.getString("capacity");
		 int id = rs.getInt("room_id");
		 int price = rs.getInt("price");
		 String view = rs.getString("room_view");
		 String room_quality = rs.getString("room_quality");
		 
		 Room room2 = new Room();
		 room2.setRoom_id(id);
		 room2.setCapacity(capacityNew);
		 room2.setPrice(price);
		 room2.setRoom_view(view);
		 room2.setRoom_quality(room_quality);
		 list.add(room2);			 
		     		
	 }
	 System.out.println(list.size());
	 rs.close();
	 return list;
	
	
}

public static List<hotel> queryRoom4(Connection conn, String hotel_name, Booking booking)throws SQLException {

	 String start = booking.getStart_date();
	 String end = booking.getEnd_date();
	
	 String sql = "select distinct r.room_id, h.hotel_name, h.rating from room r, hotel h, "//
			 + " address ad, hotel_chain ch left outer join booking b "
			 + "on (not ((b.start_date between ? and ?) or (b.end_date between ? and ?))) "
			 + " where r.hotel_id = h.hotel_id and ad.address_id = h.address_id"//
			 + " and h.hotel_name = ?";//
	 
	 PreparedStatement pstm = conn.prepareStatement(sql);
	 pstm.setString(1, start);
	 pstm.setString(2, end);
	 pstm.setString(3, start);
	 pstm.setString(4, end);
	 pstm.setString(5, hotel_name);
	 
	 ResultSet rs = pstm.executeQuery();

	 
	 List<hotel> list = new ArrayList<hotel>();

	 while (rs.next()) {
	   
		 String hotel_name2 = rs.getString("hotel_name");
		 int rating2 = rs.getInt("rating");
		 System.out.println(hotel_name2);
		 hotel hotel2 = new hotel();
		 hotel2.setHotel_name(hotel_name2);
		 hotel2.setRating(rating2);
		 list.add(hotel2);			 
		     		
	 }
	 System.out.println(list.size());

	 rs.close();
	 return list;
}

//EMPLOYEE HOME PAGE
	public static List<Booking> queryBooking(Connection conn, HttpSession session) throws SQLException {

		Employee emp = MyUtils.getLoginedEmployee(session);

		String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from booking a where a.room_id in (select b.room_id from room b where b.hotel_id = ?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, emp.getHotel_id());

		ResultSet rs = pstm.executeQuery();
		List<Booking> list = new ArrayList<Booking>();
		while (rs.next()) {
			Integer c_sin = rs.getInt("c_sin");
			Integer room_id = rs.getInt("room_id");
			String start_date = rs.getString("start_date");
			String end_date = rs.getString("end_date");
			Booking booking = new Booking(c_sin, room_id, start_date, end_date);
			list.add(booking);
		}
		return list;
	}

public static Booking querySpecificBooking(Connection conn, HttpSession session, String c_sin) throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	int sin = 0;

	try {
		sin = Integer.parseInt(c_sin);
	} catch (Exception e) {
	}

	String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from booking a where a.c_sin = ? and a.room_id in (select b.room_id from room b where b.hotel_id = ?)";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, sin);
	pstm.setInt(2, emp.getHotel_id());

	ResultSet rs = pstm.executeQuery();

	Integer sin2 = 0;
	Integer room_id = 0;
	String start_date = "";
	String end_date = "";

	while (rs.next()) {
		sin2 = rs.getInt("c_sin");
		room_id = rs.getInt("room_id");
		start_date = rs.getString("start_date");
		end_date = rs.getString("end_date");
	}

	Booking booking = new Booking(sin2, room_id, start_date, end_date);

	return booking;
}

// BOOKIING TO RENTING
public static void queryBookingToRenting(Connection conn, HttpSession session, String c_sin)
		throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	int sin = 0;

	try {
		sin = Integer.parseInt(c_sin);
	} catch (Exception e) {
	}
	
	String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from booking a where a.c_sin = ? and a.room_id in (select b.room_id from room b where b.hotel_id = ?)";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, sin);
	pstm.setInt(2, emp.getHotel_id());

	ResultSet rs = pstm.executeQuery();

	Integer sin2 = 0;
	Integer room_id = 0;
	String start_date = "";
	String end_date = "";

	while (rs.next()) {
		sin2 = rs.getInt("c_sin");
		room_id = rs.getInt("room_id");
		start_date = rs.getString("start_date");
		end_date = rs.getString("end_date");
	}
	
	String sql2 = "Insert into renting (c_sin, e_sin, room_id, start_date, end_date) values (?, ?, ?, ?, ?)";
	
	PreparedStatement pstm2 = conn.prepareStatement(sql2);
	pstm2.setInt(1, sin2);
	pstm2.setInt(2, emp.getSin());
	pstm2.setInt(3, room_id);
	pstm2.setString(4, start_date);
	pstm2.setString(5, end_date);

	pstm2.executeUpdate();
}

// RENTING LIST PAGE
public static List<Renting> queryRenting(Connection conn, HttpSession session) throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from renting a where a.e_sin = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, emp.getSin());

	ResultSet rs = pstm.executeQuery();
	List<Renting> list = new ArrayList<Renting>();
	while (rs.next()) {
		Integer c_sin = rs.getInt("c_sin");
		Integer room_id = rs.getInt("room_id");
		String start_date = rs.getString("start_date");
		String end_date = rs.getString("end_date");
		Renting renting = new Renting(c_sin, emp.getSin(), room_id, start_date, end_date);
		list.add(renting);
	}
	return list;
}

// DELETE BOOKING

public static void queryDeleteBooking(Connection conn, HttpSession session, String c_sin)
		throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	int sin = 0;

	try {
		sin = Integer.parseInt(c_sin);
	} catch (Exception e) {
	}
	
	String sql = "Delete from booking a where a.c_sin = ? and a.room_id in (select b.room_id from room b where b.hotel_id = ?)";
	
	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, sin);
	pstm.setInt(2, emp.getHotel_id());

	pstm.executeQuery();

}


public static void queryInsertBookingArchive(Connection conn, HttpSession session, String c_sin)
		throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	int sin = 0;

	try {
		sin = Integer.parseInt(c_sin);
	} catch (Exception e) {
	}

	String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from booking a where a.c_sin = ? and a.room_id in (select b.room_id from room b where b.hotel_id = ?)";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, sin);
	pstm.setInt(2, emp.getHotel_id());

	ResultSet rs = pstm.executeQuery();

	Integer sin2 = 0;
	Integer room_id = 0;
	String start_date = "";
	String end_date = "";

	while (rs.next()) {
		sin2 = rs.getInt("c_sin");
		room_id = rs.getInt("room_id");
		start_date = rs.getString("start_date");
		end_date = rs.getString("end_date");
	}

	String sql2 = "Insert into archive_booking (c_sin, room_id, start_date, end_date) values (?, ?, ?, ?)";

	PreparedStatement pstm2 = conn.prepareStatement(sql2);
	pstm2.setInt(1, sin2);
	pstm2.setInt(2, room_id);
	pstm2.setString(3, start_date);
	pstm2.setString(4, end_date);

	pstm2.executeUpdate();
}

//INSERT INTO RENTING ARCHIVE

public static void queryInsertRentingArchive(Connection conn, HttpSession session, String c_sin)
		throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	int sin = 0;

	try {
		sin = Integer.parseInt(c_sin);
	} catch (Exception e) {
	}

	String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from booking a where a.c_sin = ? and a.room_id in (select b.room_id from room b where b.hotel_id = ?)";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, sin);
	pstm.setInt(2, emp.getHotel_id());

	ResultSet rs = pstm.executeQuery();

	Integer sin2 = 0;
	Integer room_id = 0;
	String start_date = "";
	String end_date = "";

	while (rs.next()) {
		sin2 = rs.getInt("c_sin");
		room_id = rs.getInt("room_id");
		start_date = rs.getString("start_date");
		end_date = rs.getString("end_date");
	}

	String sql2 = "Insert into archive_renting (c_sin, e_sin, room_id, start_date, end_date) values (?, ?, ?, ?, ?)";

	PreparedStatement pstm2 = conn.prepareStatement(sql2);
	pstm2.setInt(1, sin2);
	pstm2.setInt(2, emp.getSin());
	pstm2.setInt(3, room_id);
	pstm2.setString(4, start_date);
	pstm2.setString(5, end_date);

	pstm2.executeUpdate();
}

// Delete Booking when transforming to renting

public static void queryDelete(Connection conn, HttpSession session, String c_sin) throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	int sin = 0;

	try {
		sin = Integer.parseInt(c_sin);
	} catch (Exception e) {
	}

	String sql = "Select a.c_sin, a.room_id, a.start_date, a.end_date from booking a where a.c_sin = ? and a.room_id in (select b.room_id from room b where b.hotel_id = ?)";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, sin);
	pstm.setInt(2, emp.getHotel_id());

	ResultSet rs = pstm.executeQuery();

	Integer sin2 = 0;
	Integer room_id = 0;
	String start_date = "";
	String end_date = "";

	while (rs.next()) {
		sin2 = rs.getInt("c_sin");
		room_id = rs.getInt("room_id");
		start_date = rs.getString("start_date");
		end_date = rs.getString("end_date");
	}

	// delete booking

	String sql3 = "Delete from booking where c_sin = ? and room_id = ? and start_date = ? and end_date = ?";

	PreparedStatement pstm3 = conn.prepareStatement(sql3);
	pstm3.setInt(1, sin2);
	pstm3.setInt(2, room_id);
	pstm3.setString(3, start_date);
	pstm3.setString(4, end_date);

	pstm3.executeQuery();
}



// CREATE RENTING

public static void queryCeateRenting(Connection conn, HttpSession session, int c_sin, int room_id,
		String start_date, String end_date) throws SQLException {

	Employee emp = MyUtils.getLoginedEmployee(session);

	String sql = "Insert into renting (c_sin, e_sin, room_id, start_date, end_date) values (?, ?, ?, ?, ?)";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, c_sin);
	pstm.setInt(2, emp.getHotel_id());
	pstm.setInt(3, room_id);
	pstm.setString(4, start_date);
	pstm.setString(5, end_date);

	pstm.executeUpdate();

}

public static void insertRoom(Connection conn, HttpSession session, int price, String capacity, String view, String extended, String quality) throws SQLException {

	
	String sql1 = "SELECT MAX(room_id)+1 FROM room";
	PreparedStatement pstm1 = conn.prepareStatement(sql1);
	ResultSet rs = pstm1.executeQuery();
	String max_id = "";
	
	System.out.print("\n\n\n" + max_id);
	
	while (rs.next()) {
		max_id = rs.getString(1);
	}

	int max_id2 = Integer.parseInt(max_id);
	
	Employee emp = MyUtils.getLoginedEmployee(session);

	String sql2 = "Insert into room (room_id, hotel_id, price, capacity, room_view, can_be_extended, room_quality) values (?, ?, ?, ?, ?, ?, ?)";

	PreparedStatement pstm2 = conn.prepareStatement(sql2);
	pstm2.setInt(1, max_id2);
	pstm2.setInt(2, emp.getHotel_id());
	pstm2.setInt(3, price);
	pstm2.setString(4, capacity);
	pstm2.setString(5, view);
	pstm2.setString(6, extended);
	pstm2.setString(7, quality);

	pstm2.executeUpdate();
}


    
   
 
}