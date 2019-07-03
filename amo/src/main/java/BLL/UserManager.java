package BLL;

import DAL.UserDAL;
import Models.Users.LoginResponse;
import Models.Users.SignUpResponse;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;

public class UserManager {
	public static LoginResponse login(String emailOrPAN, String Password) {
		LoginResponse res = new LoginResponse();
		if (Password.length() + 1 > 8) {
			if (isEmail(emailOrPAN) || isPAN(emailOrPAN) || isNationalID(emailOrPAN)) {
				return UserDAL.login(emailOrPAN, Password);
			}
			res.setResponseMsg("Wrong Email or PAN or National ID format");
			return res;
		} else {
			res.setResponseMsg("Password length less than 8");
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
