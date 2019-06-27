package BLL;

import DAL.UserDAL;
import Models.Users.LoginResponse;
import Models.Users.SignUpResponse;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;

public class UserManager {
	public static LoginResponse login(String emailOrPAN, String Password) {
		LoginResponse res = new LoginResponse();
		if (Password.length() > 8) {
			if (!emailOrPAN.matches(".+[@].+[.].+")) 
			{
				if (!emailOrPAN.matches("[0-9]{14}"))
				{
					if (!emailOrPAN.matches("[0-9]{16,20}")) {
						res.setResponseMsg("Wrong Email or PAN or National ID format");
						return res;
					} else {
						// PAN
						return UserDAL.login(emailOrPAN, Password);
					}
				} else {
					// National ID
					return UserDAL.login(emailOrPAN, Password);
				}
			} else {
				// Email
				return UserDAL.login(emailOrPAN, Password);
			}
		} else {
			res.setResponseMsg("Password length less than 8");
			return res;
		}
	}

	public static SignUpResponse signup(SignUp user) {
		return UserDAL.signup(user);
	}

	public static LogoutResponse logout(String token) {
		return UserDAL.logout(token);
	}
}
