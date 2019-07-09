package Models.Locations;

public class LocationResponse {
	private int locationID;
	private String responseMessage;
	private String returnHex;

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getReturnHex() {
		return returnHex;
	}

	public void setReturnHex(String returnHex) {
		this.returnHex = returnHex;
	}

}
