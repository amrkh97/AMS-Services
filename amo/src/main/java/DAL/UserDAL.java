package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.Users.LoginResponse;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;
import Models.Users.SignUpResponse;

public class UserDAL {

	public static LoginResponse login(String emailOrPAN, String Password) {
		// ResultSet RS = null;
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Employee_Login] ?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		LoginResponse _LoginResponse = new LoginResponse();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, emailOrPAN);
			cstmt.setString(2, Password);
			cstmt.registerOutParameter(3, Types.NVARCHAR); // Hex
			cstmt.registerOutParameter(4, Types.NVARCHAR); // Response
			cstmt.registerOutParameter(5, Types.INTEGER); // JobID
			cstmt.registerOutParameter(6, Types.NVARCHAR); // JobTitle
			cstmt.registerOutParameter(7, Types.INTEGER); // EmployeeID
			cstmt.registerOutParameter(8, Types.NVARCHAR); // UserPhoto

			cstmt.executeUpdate();
			_LoginResponse.setResponseHexCode(cstmt.getString(3));
			_LoginResponse.setResponseMsg(cstmt.getString(4));
			if (cstmt.getString(3).equals("00")) {
				_LoginResponse.setJobID(cstmt.getInt(5));
				_LoginResponse.setTitle(cstmt.getString(6));
				_LoginResponse.setEmployeeID(cstmt.getInt(7));
				_LoginResponse.setUserPhoto(cstmt.getString(8));
				// Tokenize
				// Dummy token
				_LoginResponse.setToken(emailOrPAN + "," + Password);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return _LoginResponse;
	}
	
	public static LoginResponse loginFrontend(String emailOrPAN, String Password) {
		// ResultSet RS = null;
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Employee_Login_Frontend] ?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		LoginResponse _LoginResponse = new LoginResponse();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, emailOrPAN);
			cstmt.setString(2, Password);
			cstmt.registerOutParameter(3, Types.NVARCHAR); // Hex
			cstmt.registerOutParameter(4, Types.NVARCHAR); // Response
			cstmt.registerOutParameter(5, Types.INTEGER); // JobID
			cstmt.registerOutParameter(6, Types.NVARCHAR); // JobTitle
			cstmt.registerOutParameter(7, Types.INTEGER); // EmployeeID
			cstmt.registerOutParameter(8, Types.NVARCHAR); // UserPhoto

			cstmt.executeUpdate();
			_LoginResponse.setResponseHexCode(cstmt.getString(3));
			_LoginResponse.setResponseMsg(cstmt.getString(4));
			if (cstmt.getString(3).equals("00")) {
				_LoginResponse.setJobID(cstmt.getInt(5));
				_LoginResponse.setTitle(cstmt.getString(6));
				_LoginResponse.setEmployeeID(cstmt.getInt(7));
				_LoginResponse.setUserPhoto(cstmt.getString(8));
				// Tokenize
				// Dummy token
				_LoginResponse.setToken(emailOrPAN + "," + Password);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return _LoginResponse;
	}
	
	public static LoginResponse loginAndroid(String emailOrPAN, String Password, String yelloPadUniqueID) {
		// ResultSet RS = null;
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Employee_Login_Android] ?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		LoginResponse _LoginResponse = new LoginResponse();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, emailOrPAN);
			cstmt.setString(2, Password);
			cstmt.setString(3, yelloPadUniqueID);
			cstmt.registerOutParameter(4, Types.NVARCHAR); // Hex
			cstmt.registerOutParameter(5, Types.NVARCHAR); // Response
			cstmt.registerOutParameter(6, Types.INTEGER); // JobID
			cstmt.registerOutParameter(7, Types.NVARCHAR); // JobTitle
			cstmt.registerOutParameter(8, Types.INTEGER); // EmployeeID
			cstmt.registerOutParameter(9, Types.NVARCHAR); // UserPhoto

			cstmt.executeUpdate();
			_LoginResponse.setResponseHexCode(cstmt.getString(4));
			_LoginResponse.setResponseMsg(cstmt.getString(5));
			if (cstmt.getString(3).equals("00")) {
				_LoginResponse.setJobID(cstmt.getInt(6));
				_LoginResponse.setTitle(cstmt.getString(7));
				_LoginResponse.setEmployeeID(cstmt.getInt(8));
				_LoginResponse.setUserPhoto(cstmt.getString(9));
				// Tokenize
				// Dummy token
				_LoginResponse.setToken(emailOrPAN + "," + Password);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return _LoginResponse;
	}

	public static SignUpResponse signup(SignUp user) {
		// ResultSet RS;
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Employee_SignUp] ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		SignUpResponse _SignUpResponse = new SignUpResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, user.getFirstName());
			cstmt.setString(2, user.getLastName());
			cstmt.setString(3, user.getDateOfBirth());
			cstmt.setString(4, user.getEmail());
			cstmt.setString(5, user.getPassword());
			cstmt.setString(6, user.getGender());
			cstmt.setString(7, user.getContactNumber());
			cstmt.setString(8, user.getCountry());
			cstmt.setString(9, user.getCity());
			cstmt.setString(10, user.getState());
			cstmt.setString(11, user.getStreet());
			cstmt.setString(12, user.getPostalCode());
			cstmt.setString(13, user.getPan());
			cstmt.setString(14, user.getNationalID());
			cstmt.setInt(15, user.getJobID());
			cstmt.setString(16, user.getPhoto());
			cstmt.registerOutParameter(17, Types.NVARCHAR);
			cstmt.registerOutParameter(18, Types.NVARCHAR);
			cstmt.execute();

			_SignUpResponse.setResponseHexCode(cstmt.getString(17));
			_SignUpResponse.setResponseMsg(cstmt.getString(18));

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return _SignUpResponse;
	}

	public static LogoutResponse logout(String token) {
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Employee_Logout] ?,?,?";
		Connection conn = DBManager.getDBConn();
		LogoutResponse _LogoutResponse = new LogoutResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, token);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.executeUpdate();
			_LogoutResponse.setResponseHexCode(cstmt.getString(2));
			_LogoutResponse.setResponseMsg(cstmt.getString(3));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return _LogoutResponse;
	}
}
