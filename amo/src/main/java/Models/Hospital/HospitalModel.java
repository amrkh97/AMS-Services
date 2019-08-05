package Models.Hospital;

public class HospitalModel {
	
	private Integer hospitalID;
	private String hospitalName;
	private String description;
	private String longitude;
	private String latitude;
	private Integer numberOfBeds;
	private Integer numberOfAvailableBeds;
	private Integer numberOfAvialbleICUBeds;
	private Integer numberOfAvailableBabyBeds;
	private Integer numberOfAvailableRegularBeds;
	private Integer numberOfICUBeds;
	private Integer numberOfBabyBeds;
	private Integer numberOfRegularBeds;
	private String hospitalStatus;
	
	public Integer getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(Integer hospitalID) {
		this.hospitalID = hospitalID;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}
	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	public Integer getNumberOfICUBeds() {
		return numberOfICUBeds;
	}
	public void setNumberOfICUBeds(Integer numberOfICUBeds) {
		this.numberOfICUBeds = numberOfICUBeds;
	}
	public Integer getNumberOfBabyBeds() {
		return numberOfBabyBeds;
	}
	public void setNumberOfBabyBeds(Integer numberOfBabyBeds) {
		this.numberOfBabyBeds = numberOfBabyBeds;
	}
	public Integer getNumberOfRegularBeds() {
		return numberOfRegularBeds;
	}
	public void setNumberOfRegularBeds(Integer numberOfRegularBeds) {
		this.numberOfRegularBeds = numberOfRegularBeds;
	}
	public Integer getNumberOfAvailableBeds() {
		return numberOfAvailableBeds;
	}
	public void setNumberOfAvailableBeds(Integer numberOfAvailableBeds) {
		this.numberOfAvailableBeds = numberOfAvailableBeds;
	}
	public Integer getNumberOfAvialbleICUBeds() {
		return numberOfAvialbleICUBeds;
	}
	public void setNumberOfAvialbleICUBeds(Integer numberOfAvialbleICUBeds) {
		this.numberOfAvialbleICUBeds = numberOfAvialbleICUBeds;
	}
	public Integer getNumberOfAvailableBabyBeds() {
		return numberOfAvailableBabyBeds;
	}
	public void setNumberOfAvailableBabyBeds(Integer numberOfAvailableBabyBeds) {
		this.numberOfAvailableBabyBeds = numberOfAvailableBabyBeds;
	}
	public Integer getNumberOfAvailableRegularBeds() {
		return numberOfAvailableRegularBeds;
	}
	public void setNumberOfAvailableRegularBeds(Integer numberOfAvailableRegularBeds) {
		this.numberOfAvailableRegularBeds = numberOfAvailableRegularBeds;
	}
	public String getHospitalStatus() {
		return hospitalStatus;
	}
	public void setHospitalStatus(String hospitalStatus) {
		this.hospitalStatus = hospitalStatus;
	}
	

}
