package BLL;

import DAL.UserDAL;
import Models.Users.LoginResponse;
import Models.Users.SignUpResponse;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;

public class UserManager {
	public static LoginResponse login(String emailOrPAN, String Password) {
		return UserDAL.login(emailOrPAN, Password);
	}
	
	public static SignUpResponse signup(SignUp user) {
		return UserDAL.signup(user);
	}
	
	public static LogoutResponse logout(String token) {
		return UserDAL.logout(token);
	}
}
