package Models.Users;

import Models.ServerResponse;

public class LogoutResponse extends ServerResponse {
	private String userID;

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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
