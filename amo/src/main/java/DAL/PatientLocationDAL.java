package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.Data.DataModel;
import Models.Locations.Location;
import Models.Locations.LocationArray;

public class PatientLocationDAL {

	public static DataModel addPatientLocation(int nationalID, String addressPatient, String latitude,
			String longitude) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Patient_Locations] ?,?,?,?,?";
		String Result = "";
		Connection conn = DBManager.getDBConn();
		DataModel OBJ = new DataModel();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, nationalID);
			cstmt.setString(2, addressPatient);
			cstmt.setString(3, latitude);
			cstmt.setString(4, longitude);
			cstmt.registerOutParameter(5, Types.NVARCHAR);

			// RS = cstmt.executeQuery();
			cstmt.execute();

			Result = cstmt.getString(5);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		System.out.println("Result is:" + Result);
		OBJ.setSentStatus(Result);
		return OBJ;
	}

	public static LocationArray getAllPatientLocations(int nationalID) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Patient_getAllLocations] ?";
		ResultSet RS = null;
		Connection conn = DBManager.getDBConn();
		ArrayList<Location> patientLocations = new ArrayList<>();
		Location _location = new Location();
		LocationArray OBJ = new LocationArray();
		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, nationalID);
			RS = cstmt.executeQuery();

			while (RS.next()) {
				_location = new Location();
				_location.setFreeFormatAddress(RS.getString("FreeFormatAddress"));
				_location.setCity(RS.getString("City"));
				_location.setLatitude(RS.getString("Latitude"));
				_location.setLongitude(RS.getString("Longitude"));
				patientLocations.add(_location);
			}
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.setLocationArray(patientLocations);
		return OBJ;
	}
}
