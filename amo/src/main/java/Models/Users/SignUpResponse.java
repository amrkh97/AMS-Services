package Models.Users;

import Models.ServerResponse;

public class SignUpResponse extends ServerResponse {
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
}
