package BLL;

import java.math.BigDecimal;
import java.util.ArrayList;

import DAL.PatientLocationDAL;
import Models.Locations.Location;

public class PatientLocationManager {

	public static String AddPatientLocation(int nationalID,String addressPatient,BigDecimal Latitude, BigDecimal Longitude) {
		
		return PatientLocationDAL.AddPatientLocation(nationalID, addressPatient, Latitude, Longitude);
	}
	
	
public static ArrayList<Location> getAllPatientLocations(String nationalID) {
		return PatientLocationDAL.getAllPatientLocations(Integer.parseInt((nationalID)));
	}
}
