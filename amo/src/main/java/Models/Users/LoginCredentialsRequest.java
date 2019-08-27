package Models.Users;

public class LoginCredentialsRequest {

	// private String domain;
	private String emailOrPAN;
	private String password;
	private String yelloPadUniqueID;

	/**
	 * @return the emailOrPAN
	 */
	public String getEmailOrPAN() {
		return emailOrPAN;
	}

	/**
	 * @param emailOrPAN the emailOrPAN to set
	 */
	public void setEmailOrPAN(String emailOrPAN) {
		this.emailOrPAN = emailOrPAN;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getYelloPadUniqueID() {
		return yelloPadUniqueID;
	}

	public void setYelloPadUniqueID(String yelloPadUniqueID) {
		this.yelloPadUniqueID = yelloPadUniqueID;
	}

}
