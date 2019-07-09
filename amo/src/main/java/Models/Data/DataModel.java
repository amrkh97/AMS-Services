package Models.Data;

public class DataModel {
	
	private Integer sentID;
	private String stringID;
	private String sentStatus;
	
	
	public String getSentStatus() {
		return sentStatus;
	}
	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}
	public Integer getSentID() {
		return sentID;
	}
	public void setSentID(Integer sentID) {
		this.sentID = sentID;
	}
	public String getStringID() {
		return stringID;
	}
	public void setStringID(String stringID) {
		this.stringID = stringID;
	}
	

}
