package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.LocationsDAL;
import DB.DBManager;
import Models.Locations.Location;
import Models.Locations.LocationArray;
import Models.Locations.LocationResponse;

public class LocationManager {
	public static LocationResponse addLocation(Location loc) {
		LocationResponse response = new LocationResponse();
		Connection conn = DBManager.getDBConn();
		try {
			response = LocationsDAL.addLocation(loc,conn);
		}finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return response;
	}

	public static Location getLocation(int id) {

		return null;
	}

	public static LocationArray getAllLocations() {
		LocationArray response = new LocationArray();
		Connection conn = DBManager.getDBConn();
		try {
			response = LocationsDAL.getAllLocations(conn);
		}finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return response;
	}
}
