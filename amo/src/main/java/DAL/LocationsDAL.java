package DAL;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import Models.Locations.Location;
import Models.Locations.LocationResponse;

public class LocationsDAL {
	public static LocationResponse addLocation(Location loc, Connection conn) {

		String SPsql = "EXEC usp_InsertNewLocation ?,?,?,?,?,?,?,?,?,?,?,?,?";
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
			cstmt.setString(10, URLEncoder.encode(loc.getFreeFormatAddress(),"UTF-8"));
			cstmt.registerOutParameter(11, Types.NVARCHAR);
			cstmt.registerOutParameter(12, Types.NVARCHAR);
			cstmt.registerOutParameter(13, Types.INTEGER);
			cstmt.executeUpdate();
			locResponse.setReturnHex(cstmt.getString(11));
			locResponse.setResponseMessage(cstmt.getString(12));
			locResponse.setLocationID(cstmt.getInt(13));
		} catch (SQLException | UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return locResponse;
	}

}
