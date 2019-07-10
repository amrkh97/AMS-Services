package Models;

public class Errors {

	private String userMessage;
	private String internalMessage;
	private int code;
	private String moreInfo;

	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * @param userMessage the userMessage to set
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * @return the internalMessage
	 */
	public String getInternalMessage() {
		return internalMessage;
	}

	/**
	 * @param internalMessage the internalMessage to set
	 */
	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * @param moreInfo the moreInfo to set
	 */
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

}
