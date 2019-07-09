package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.Locations.Location;
import Models.Locations.LocationResponse;

public class LocationsDAL 
{
	public static LocationResponse addLocation(Location loc) {

		String SPsql = "EXEC usp_InsertNewLocation ?,?,?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		LocationResponse locResponse = new LocationResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, loc.getFreeFormatAddress());
			cstmt.setString(2, loc.getCity());
			cstmt.setString(3, loc.getLongitude());
			cstmt.setString(4, loc.getLatitude());
			cstmt.setString(5, loc.getStreet());
			cstmt.setString(6, loc.getApartement());
			cstmt.setString(7, loc.getPostalCode());
			cstmt.setString(8, loc.getFloorLevel());
			cstmt.setString(9, loc.getHouseNumber());
			cstmt.registerOutParameter(10, Types.NVARCHAR);
			cstmt.registerOutParameter(11, Types.NVARCHAR);
			cstmt.registerOutParameter(12, Types.INTEGER);
			cstmt.execute();
			locResponse.setLocationID(cstmt.getInt(12));
			locResponse.setResponseMessage(cstmt.getString(11));
			locResponse.setReturnHex(cstmt.getString(10));
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

		return locResponse;
	}

}
