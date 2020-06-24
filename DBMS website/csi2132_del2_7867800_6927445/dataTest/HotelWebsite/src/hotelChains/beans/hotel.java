package hotelChains.beans;

public class hotel {

	private int hotel_id;
	private int chain_id;
	private int address_id;
	private String contact_emails;
	private String contact_numbers;
	private int num_rooms;
	private int rating;
	private String hotel_name;
	
	
	public hotel(int hotel_id, int chain_id, int address_id, String contact_emails, String contact_numbers,
			int num_rooms, int rating, String hotel_name) {
		
		this.hotel_id = hotel_id;
		this.chain_id = chain_id;
		this.address_id = address_id;
		this.contact_emails = contact_emails;
		this.contact_numbers = contact_numbers;
		this.num_rooms = num_rooms;
		this.rating = rating;
		this.hotel_name = hotel_name;
	}


	public hotel() {
		// TODO Auto-generated constructor stub
	}


	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}


	public int getChain_id() {
		return chain_id;
	}


	public void setChain_id(int chain_id) {
		this.chain_id = chain_id;
	}


	public int getAddress_id() {
		return address_id;
	}


	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	public String getContact_emails() {
		return contact_emails;
	}


	public void setContact_emails(String contact_emails) {
		this.contact_emails = contact_emails;
	}


	public String getContact_numbers() {
		return contact_numbers;
	}


	public void setContact_numbers(String contact_numbers) {
		this.contact_numbers = contact_numbers;
	}


	public int getNum_rooms() {
		return num_rooms;
	}


	public void setNum_rooms(int num_rooms) {
		this.num_rooms = num_rooms;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getHotel_name() {
		return hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	
	
	
	
	
	
	
}
