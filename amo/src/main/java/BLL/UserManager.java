package BLL;



import DAL.UserDAL;
import Models.Users.LoginResponse;

public class UserManager {
	public static LoginResponse login(String emailOrPAN, String Password) {
		return UserDAL.login(emailOrPAN, Password);
	}


}
