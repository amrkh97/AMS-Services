package Models.YelloPad;

public class YelloPadModel {
	private Integer yelloPadID;
	private String yelloPadUniqueID;
	private String yelloPadStatus;
	private String yelloPadStatusCode;
	private String yelloPadNetwrokCard;
	private String yelloPadPicture;

	/**
	 * 
	 * @return YelloPad's Unique ID.
	 */
	public String getUniqueID() {

		return yelloPadUniqueID;
	}

	/**
	 * 
	 * @return YelloPad's Picture.
	 */
	public String getPicture() {

		return yelloPadPicture;
	}

	/**
	 * 
	 * @return YelloPad's Status.
	 */
	public String getStatus() {
		return yelloPadStatus;
	}

	/**
	 * 
	 * @return YelloPad's Status Code.
	 */
	public String getStatusCode() {
		return yelloPadStatusCode;
	}

	/**
	 * 
	 * @return Number of YelloPad's Network Card.
	 */
	public String getNetwrokCardNo() {
		return yelloPadNetwrokCard;
	}

	/**
	 * 
	 * @param ID: ID of current YelloPad
	 */
	public void setUniqueID(String ID) {
		yelloPadUniqueID = ID;
	}

	/**
	 * 
	 * @param Status: Status of current YelloPad
	 */
	public void setStatus(String Status) {
		yelloPadStatus = Status;
	}

	/**
	 * 
	 * @param Status: Status of current YelloPad
	 */
	public void setStatusCode(String StatusCode) {
		yelloPadStatusCode = StatusCode;
	}

	/**
	 * 
	 * @param Num: Number of current YelloPad's Network Card
	 */
	public void setNetworkCard(String Num) {
		yelloPadNetwrokCard = Num;
	}

	/**
	 * 
	 * @param Picture:Picture of current YelloPad
	 */
	public void setPicture(String Picture) {
		yelloPadPicture = Picture;
	}

	public Integer getYelloPadID() {
		return yelloPadID;
	}

	public void setYelloPadID(Integer yelloPadID) {
		this.yelloPadID = yelloPadID;
	}

}
