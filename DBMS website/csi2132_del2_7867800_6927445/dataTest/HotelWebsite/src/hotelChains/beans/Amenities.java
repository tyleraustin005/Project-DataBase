package hotelChains.beans;

public class Amenities {
	
	private int amen_id;
	private int romm_id;
	private String amenity;
	
	public Amenities(int amen_id, int romm_id, String amenity) {
		
		this.amen_id = amen_id;
		this.romm_id = romm_id;
		this.amenity = amenity;
	}

	public int getAmen_id() {
		return amen_id;
	}

	public void setAmen_id(int amen_id) {
		this.amen_id = amen_id;
	}

	public int getRomm_id() {
		return romm_id;
	}

	public void setRomm_id(int romm_id) {
		this.romm_id = romm_id;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}
	
	
	
	

}
