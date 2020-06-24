package hotelChains.beans;

public class Booking {
	
	private int c_sin;
	private int room_id;
	private String start_date;
	private String end_date;
	
	public Booking(int c_sin, int room_id, String start_date, String end_date) {
		
		this.c_sin = c_sin;
		this.room_id = room_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public int getC_sin() {
		return c_sin;
	}
	public void setC_sin(int c_sin) {
		this.c_sin = c_sin;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	

}
