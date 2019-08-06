package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Hospital.HospitalArrayModel;
import Models.Hospital.HospitalModel;

public class HospitalDAL {

	public static HospitalArrayModel getAllHospitals(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Hospital_getAll]";
		ResultSet RS;
		 
		ArrayList<HospitalModel> allHospitals = new ArrayList<HospitalModel>();
		HospitalArrayModel OBJ = new HospitalArrayModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				HospitalModel currentHospital  = new HospitalModel();
				currentHospital.setHospitalID(RS.getInt(1));
				currentHospital.setHospitalName(RS.getString(2));
				currentHospital.setDescription(RS.getString(3));
				currentHospital.setLatitude(RS.getString(4));
				currentHospital.setLongitude(RS.getString(5));
				currentHospital.setHospitalStatus(RS.getString(6));
				currentHospital.setNumberOfBeds(RS.getInt(7));
				currentHospital.setNumberOfAvailableBeds(RS.getInt(8));
				currentHospital.setNumberOfICUBeds(RS.getInt(9));
				currentHospital.setNumberOfAvialbleICUBeds(RS.getInt(10));
				currentHospital.setNumberOfRegularBeds(RS.getInt(11));
				currentHospital.setNumberOfAvailableRegularBeds(RS.getInt(12));
				currentHospital.setNumberOfBabyBeds(RS.getInt(13));
				currentHospital.setNumberOfAvailableBabyBeds(RS.getInt(14));
				
				
				allHospitals.add(currentHospital);
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setHospitalArray(allHospitals);
		return OBJ;
	}

	public static HospitalModel getHospitalByName(String hospitalName, Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Hospital_getByName] ?";
		ResultSet RS;
		 
		
		HospitalModel currentHospital  = new HospitalModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setString(1, hospitalName);
			RS = cstmt.executeQuery();

			if (RS.next()) {

				
				currentHospital.setHospitalID(RS.getInt(1));
				currentHospital.setHospitalName(RS.getString(2));
				currentHospital.setDescription(RS.getString(3));
				currentHospital.setLatitude(RS.getString(4));
				currentHospital.setLongitude(RS.getString(5));
				currentHospital.setHospitalStatus(RS.getString(6));
				currentHospital.setNumberOfBeds(RS.getInt(7));
				currentHospital.setNumberOfAvailableBeds(RS.getInt(8));
				currentHospital.setNumberOfICUBeds(RS.getInt(9));
				currentHospital.setNumberOfAvialbleICUBeds(RS.getInt(10));
				currentHospital.setNumberOfRegularBeds(RS.getInt(11));
				currentHospital.setNumberOfAvailableRegularBeds(RS.getInt(12));
				currentHospital.setNumberOfBabyBeds(RS.getInt(13));
				currentHospital.setNumberOfAvailableBabyBeds(RS.getInt(14));
				
				
				
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return currentHospital;
	}

}
