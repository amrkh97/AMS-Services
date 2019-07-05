package Models.Users;

import Models.ServerResponse;

public class LoginResponse extends ServerResponse {
	private String token;
	private Integer jobID;
	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg the responseMsg to set
	 */
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
}
