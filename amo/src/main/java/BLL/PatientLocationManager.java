package BLL;

import DAL.PatientLocationDAL;
import Models.Data.DataModel;
import Models.Locations.LocationArray;

public class PatientLocationManager {

	public static DataModel addPatientLocation(int nationalID, String addressPatient, String latitude, String longitude) {

		return PatientLocationDAL.addPatientLocation(nationalID, addressPatient, latitude, longitude);
	}

	public static LocationArray getAllPatientLocations(DataModel nationalID) {
		return PatientLocationDAL.getAllPatientLocations((nationalID.getSentID()));
	}
}
