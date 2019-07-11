package BLL;

import DAL.PatientLocationDAL;
import Models.Data.DataArrayModel;
import Models.Data.DataModel;
import Models.Locations.Location;

public class PatientLocationManager {

	public static DataModel addPatientLocation(int nationalID, String addressPatient, String latitude, String longitude) {

		return PatientLocationDAL.addPatientLocation(nationalID, addressPatient, latitude, longitude);
	}

	public static DataArrayModel<Location> getAllPatientLocations(DataModel nationalID) {
		return PatientLocationDAL.getAllPatientLocations((nationalID.getSentID()));
	}
}
