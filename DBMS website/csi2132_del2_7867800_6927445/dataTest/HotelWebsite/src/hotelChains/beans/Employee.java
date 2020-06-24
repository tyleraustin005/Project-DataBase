package hotelChains.beans;

public class Employee {

	
	private int sin;
	private int hotel_id;
	private String full_name;
	private int address_id;
	private String em_position;
	private String password;
	
	public Employee(int sin, int hotel_id, String full_name, int address_id, String em_position, String password) {
		
		this.sin = sin;
		this.hotel_id = hotel_id;
		this.full_name = full_name;
		this.address_id = address_id;
		this.em_position = em_position;
		this.password = password;
	}
	
	
	public int getSin() {
		return sin;
	}
	public void setSin(int sin) {
		this.sin = sin;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getEm_position() {
		return em_position;
	}
	public void setEm_position(String em_position) {
		this.em_position = em_position;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
