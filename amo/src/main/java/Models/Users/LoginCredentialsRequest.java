package Models.Users;

public class LoginCredentialsRequest {
	
	private String domain;
	private String emailOrPAN;
	private String password;
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
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
	
	

}
