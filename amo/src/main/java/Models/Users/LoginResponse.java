package Models.Users;

import Models.ServerResponse;

public class LoginResponse extends ServerResponse {
	private String token;
	private Integer employeeID;
	private Integer jobID;
	private String title;
	private String userPhoto;
	/**
	 * @return the responseMsg
	 */
	@Override
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg the responseMsg to set
	 */
	@Override
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	public Integer getJobID() {
		return jobID;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
