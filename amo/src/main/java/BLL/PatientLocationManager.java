package BLL;

import java.util.ArrayList;

import DAL.PatientLocationDAL;
import Models.Locations.Location;

public class PatientLocationManager {

	public static String addPatientLocation(int nationalID,String addressPatient,String latitude, String longitude) {
		
		return PatientLocationDAL.addPatientLocation(nationalID, addressPatient, latitude, longitude);
	}
	
	
public static ArrayList<Location> getAllPatientLocations(String nationalID) {
		return PatientLocationDAL.getAllPatientLocations(Integer.parseInt((nationalID)));
	}
}
