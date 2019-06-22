package BLL;

import DAL.LocationsDAL;
import Models.ServerResponse;
import Models.Locations.*;

public class LocationManager {
	public static ServerResponse addLocation(Location loc) {
		return LocationsDAL.addLocation(loc);
	}


	public static Location getLocation(int id) {
		
		return null;
	}
}
