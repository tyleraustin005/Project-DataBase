package hotelChains.beans;

public class Address {

	private int  address_id;
	private String street;
	private String city;
	private String country;
	
	public Address(int address_id, String street, String city, String country) {

		this.address_id = address_id;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}

