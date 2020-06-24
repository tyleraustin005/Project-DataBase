package hotelChains.beans;



public class HotelChains {
	
	private int chain_id;
	private int address_id;
	private int num_hotels;
	private String contact_emails;
	private String contact_numbers;
	private String chain_name;


public HotelChains(int chain_id, int address_id) {
	this.chain_id = chain_id;
	this.address_id = address_id;
	
}

public HotelChains(int chain_id, int address_id, int num_hotels, String contact_emails,String contact_numbers, String chain_name) {
	this.chain_id = chain_id;
	this.address_id = address_id;
	this.num_hotels = num_hotels;
	this.contact_emails = contact_emails;
	this.contact_numbers = contact_numbers;
	this.chain_name = chain_name;
	
}

public HotelChains() {
	// TODO Auto-generated constructor stub
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

public int getNum_hotels() {
	return num_hotels;
}

public void setNum_hotels(int num_hotels) {
	this.num_hotels = num_hotels;
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

public String getChain_name() {
	return chain_name;
}

public void setChain_name(String chain_name) {
	this.chain_name = chain_name;
}








}
