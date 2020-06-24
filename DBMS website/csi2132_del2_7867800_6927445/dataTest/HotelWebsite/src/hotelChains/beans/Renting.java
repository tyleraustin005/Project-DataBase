package hotelChains.beans;

public class Renting {

	private int c_sin;
	private int e_sin;
	private int room_id;
	private String start_date;
	private String end_date;
	
	public Renting(int c_sin, int e_sin, int room_id, String start_date, String end_date) {
	
		this.c_sin = c_sin;
		this.e_sin = e_sin;
		this.room_id = room_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	
	public int getC_sin() {
		return c_sin;
	}
	public void setC_sin(int c_sin) {
		this.c_sin = c_sin;
	}
	public int getE_sin() {
		return e_sin;
	}
	public void setE_sin(int e_sin) {
		this.e_sin = e_sin;
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
