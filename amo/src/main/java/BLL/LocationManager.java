package BLL;

import DAL.LocationsDAL;
import Models.Locations.Location;
import Models.Locations.LocationResponse;

public class LocationManager {
	public static LocationResponse addLocation(Location loc) {
		return LocationsDAL.addLocation(loc);
	}


	public static Location getLocation(int id) {
		
		return null;
	}
}
