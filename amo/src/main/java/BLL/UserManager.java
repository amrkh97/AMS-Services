package BLL;

import DAL.UserDAL;
import Models.Users.LoginResponse;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;
import Models.Users.SignUpResponse;

public class UserManager {
	public static LoginResponse login(String emailOrPAN, String Password) {
		LoginResponse res = new LoginResponse();
		if (isEmail(emailOrPAN) || isPAN(emailOrPAN) || isNationalID(emailOrPAN)) {
			return UserDAL.login(emailOrPAN, Password);
		} else {
			res.setResponseMsg("Wrong Email or PAN or National ID format");
			res.setResponseHexCode("FA");
			return res;
		}
	}
	
	public static LoginResponse loginFrontend(String emailOrPAN, String Password) {
		LoginResponse res = new LoginResponse();
		if (isEmail(emailOrPAN) || isPAN(emailOrPAN) || isNationalID(emailOrPAN)) {
			return UserDAL.loginFrontend(emailOrPAN, Password);
		} else {
			res.setResponseMsg("Wrong Email or PAN or National ID format");
			res.setResponseHexCode("FA");
			return res;
		}
	}
	
	public static LoginResponse loginAndroid(String emailOrPAN, String Password, String yelloPadUniqueID) {
		LoginResponse res = new LoginResponse();
		if (isEmail(emailOrPAN) || isPAN(emailOrPAN) || isNationalID(emailOrPAN)) {
			return UserDAL.loginAndroid(emailOrPAN, Password,yelloPadUniqueID);
		} else {
			res.setResponseMsg("Wrong Email or PAN or National ID format");
			res.setResponseHexCode("FA");
			return res;
		}
	}

	public static SignUpResponse signup(SignUp user) {

		return UserDAL.signup(user);
	}

	public static LogoutResponse logout(String token) {
		// Decode token
		String[] tokenSplitted = token.split(",");
		return UserDAL.logout(tokenSplitted[0]);
	}

	private static boolean isEmail(String email) {
		return (email.matches(".+[@].+[.].+")) ? true : false;
	}

	private static boolean isPAN(String PAN) {
		return (PAN.matches("[0-9]{16,20}")) ? true : false;
	}

	private static boolean isNationalID(String NID) {
		return (NID.matches("[0-9]{14}")) ? true : false;
	}
}
