package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RequestLogDAL {

	public static void insertRequestData(String ipAddress, String requestURL, Connection intermediateConnection) {
		
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[Insert_Into_Log] ?,?";
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setString(1, ipAddress);
			cstmt.setString(2, requestURL);
			cstmt.executeUpdate();
			
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
