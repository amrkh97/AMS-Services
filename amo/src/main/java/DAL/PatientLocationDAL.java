package DAL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.Locations.Location;

import java.util.ArrayList;

public class PatientLocationDAL {
	
	public static String addPatientLocation(int nationalID,String addressPatient,String latitude, String longitude) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Patient_Locations] ?,?,?,?,?";
		//ResultSet RS;
		String Result = "";
		Connection conn = DBManager.getDBConn();
		try {
			
			CallableStatement cstmt = conn.prepareCall(SPsql);
			
			cstmt.setInt(1, nationalID);
			cstmt.setString(2, addressPatient);
			cstmt.setString(3, latitude);
			cstmt.setString(4, longitude);
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			
			//RS = cstmt.executeQuery();
			cstmt.execute();
			
			Result = cstmt.getString(5);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			}
		
		System.out.println("Result is:"+ Result);
		return Result;
	}

	
	public static ArrayList<Location> getAllPatientLocations(int nationalID) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Patient_getAllLocations] ?";
		ResultSet RS = null;
		Connection conn = DBManager.getDBConn();
		ArrayList<Location> patientLocations = new ArrayList<>();
		Location _location = new Location();
		try {
			
			CallableStatement cstmt = conn.prepareCall(SPsql);	
			cstmt.setInt(1, nationalID);
			RS = cstmt.executeQuery();
			
			while(RS.next()) {
				_location = new Location();
				_location.setFreeFormatAddress(RS.getString("FreeFormatAddress"));
				_location.setCity(RS.getString("City"));
				_location.setLatitude(RS.getString("Latitude"));
				_location.setLongitude(RS.getString("Longitude"));
				patientLocations.add(_location);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return patientLocations;
	}
}
