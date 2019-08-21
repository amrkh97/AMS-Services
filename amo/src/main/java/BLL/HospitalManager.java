package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.HospitalDAL;
import DB.DBManager;
import Models.Hospital.HospitalArrayModel;
import Models.Hospital.HospitalModel;

public class HospitalManager {

	public static HospitalArrayModel getAllHospitals() {
		Connection intermediateConnection = DBManager.getDBConn();
		HospitalArrayModel model = new HospitalArrayModel();
		try {
			model = HospitalDAL.getAllHospitals(intermediateConnection);
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

	public static HospitalModel getHospitalByName(HospitalModel hospital) {
		Connection intermediateConnection = DBManager.getDBConn();
		HospitalModel model = new HospitalModel();
		try {
			model = HospitalDAL.getHospitalByName(hospital.getHospitalName(),intermediateConnection);
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
