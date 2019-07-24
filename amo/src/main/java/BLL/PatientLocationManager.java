package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.PatientLocationDAL;
import DB.DBManager;
import Models.Data.DataModel;
import Models.Locations.LocationArray;

public class PatientLocationManager {

	public static DataModel addPatientLocation(Integer nationalID, String addressPatient, String latitude, String longitude) {
		Connection intermediateConnection = DBManager.getDBConn();
		DataModel model = new DataModel();
		try {
			model = PatientLocationDAL.addPatientLocation(nationalID, addressPatient, latitude, longitude,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static LocationArray getAllPatientLocations(DataModel nationalID) {
		Connection intermediateConnection = DBManager.getDBConn();
		LocationArray model = new LocationArray();
		try {
			model = PatientLocationDAL.getAllPatientLocations((nationalID.getSentID()),intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
}
