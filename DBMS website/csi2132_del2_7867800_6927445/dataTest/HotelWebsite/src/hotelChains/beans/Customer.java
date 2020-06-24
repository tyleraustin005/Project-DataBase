package hotelChains.beans;

public class Customer {
	
	private int sin;
	private String full_name;
	private int address_id;
	private String registration_date;
	private String password;

	public Customer(int sin, String full_name, int address_id, String registration_date, String password) {
		
		this.sin = sin;
		this.full_name = full_name;
		this.address_id = address_id;
		this.registration_date = registration_date;
		this.password = password;
	}

	public Customer() {
	
	}
		

	public int getSin() {
		return sin;
	}

	public void setSin(int sin) {
		this.sin = sin;
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

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
