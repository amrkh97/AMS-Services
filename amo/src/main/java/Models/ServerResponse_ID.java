package Models;

import java.util.List;

public class ServerResponse_ID {

	protected String responseHexCode;
	protected String responseMsg;
	protected List<Errors> errors;
	private int Id;

	/**
	 * @return the responseHexCode
	 */
	public String getResponseHexCode() {
		return responseHexCode;
	}

	/**
	 * @param responseHexCode the responseHexCode to set
	 */
	public void setResponseHexCode(String responseHexCode) {
		this.responseHexCode = responseHexCode;
	}

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
	 * @return the errors
	 */
	public List<Errors> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}
