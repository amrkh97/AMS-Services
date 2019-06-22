package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.ServerResponse;
import Models.Locations.Location;

public class LocationsDAL {
	public static ServerResponse addLocation(Location loc)
	{
        
		String SPsql = "EXEC usp_Locations_Insert ?,?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
				CallableStatement cstmt  = conn.prepareCall(SPsql);
		        cstmt.setString(1, loc.getFreeFormatAddress());
		        cstmt.setString(2, loc.getCity());
		        cstmt.setBigDecimal(3, loc.getLongitude());
		        cstmt.setBigDecimal(4, loc.getLatitude());
		        cstmt.setString(5, loc.getStreet());
		        cstmt.setString(6, loc.getApartement());
		        cstmt.setString(7, loc.getPostalCode());
		        cstmt.setString(8, loc.getFloorLevel());
		        cstmt.setString(9, loc.getHouseNumber());
		        cstmt.registerOutParameter(10, Types.INTEGER);
		        cstmt.registerOutParameter(11, Types.NVARCHAR);
		        cstmt.execute();
		        _ServerResponse.setResponseHexCode(cstmt.getString(10));
		        _ServerResponse.setResponseMsg(cstmt.getString(11));
						
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
			
		
		return _ServerResponse;
	}

}
