package Models.Locations;

public class Location {
	private String freeFormatAddress;
	private String city;
	private String longitude;
	private String latitude;
	private String street;
	private String apartement;
	private String postalCode;
	private String floorLevel;
	private String houseNumber;
	private String encodedFFA;

	public String getFreeFormatAddress() {
		return freeFormatAddress;
	}

	public void setFreeFormatAddress(String freeFormatAddress) {
		this.freeFormatAddress = freeFormatAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getApartement() {
		return apartement;
	}

	public void setApartement(String apartement) {
		this.apartement = apartement;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(String floorLevel) {
		this.floorLevel = floorLevel;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getEncodedFFA() {
		return encodedFFA;
	}

	public void setEncodedFFA(String encodedFFA) {
		this.encodedFFA = encodedFFA;
	}

}
