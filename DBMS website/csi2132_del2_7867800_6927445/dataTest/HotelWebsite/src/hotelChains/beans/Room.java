package hotelChains.beans;

public class Room {
	
	private int room_id;
	private int hotel_id;
	private int max_price;
	private int min_price;
	private int price;
	private String capacity;
	private String room_view;
	private String can_be_extended;
	private String room_quality;
	
	public Room() {
		
	}
	
	public Room(int room_id, int hotel_id, int max_price,int min_price,int price, String capacity, String room_view, String can_be_extended,
			String room_quality) {
		
		this.room_id = room_id;
		this.hotel_id = hotel_id;
		this.max_price = max_price;
		this.min_price = min_price;
		this.capacity = capacity;
		this.room_view = room_view;
		this.can_be_extended = can_be_extended;
		this.room_quality = room_quality;
		this.price = price;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getMin_price() {
		return min_price;
	}

	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	
	public int getMax_price() {
		return max_price;
	}

	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRoom_view() {
		return room_view;
	}

	public void setRoom_view(String room_view) {
		this.room_view = room_view;
	}

	public String getCan_be_extended() {
		return can_be_extended;
	}

	public void setCan_be_extended(String can_be_extended) {
		this.can_be_extended = can_be_extended;
	}

	public String getRoom_quality() {
		return room_quality;
	}

	public void setRoom_quality(String room_quality) {
		this.room_quality = room_quality;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	

}
