package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.Users.LoginResponse;

public class UserDAL {
	
	public static LoginResponse login(String emailOrPAN,String Password)
	{
        
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Employee_Login] ?,?,?,?";
		Connection conn = DBManager.getDBConn();
		LoginResponse _LoginResponse = new LoginResponse ();
		try {
				CallableStatement cstmt  = conn.prepareCall(SPsql);
		        cstmt.setString(1, emailOrPAN);
		        cstmt.setString(2, Password);
		        cstmt.registerOutParameter(3, Types.NVARCHAR);
		        cstmt.registerOutParameter(4, Types.NVARCHAR);
		        cstmt.execute();
		        
		        _LoginResponse.setResponseHexCode(cstmt.getString(3));
		        _LoginResponse.setResponseMsg(cstmt.getString(4));
						
	         }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		return _LoginResponse;
	}

}
