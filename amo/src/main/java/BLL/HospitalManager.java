package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.HospitalDAL;
import DB.DBManager;
import Models.Hospital.HospitalArrayModel;

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

}
