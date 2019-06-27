package Models.PatientLocation;

import java.math.BigDecimal;

public class PatientLoc {
	int nationalID;
	String address;
	BigDecimal latitude;
	BigDecimal longitude;
	
	public int getNationalID() {
		return nationalID;
	}
	public void setNationalID(int nationalID) {
		this.nationalID = nationalID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
}
