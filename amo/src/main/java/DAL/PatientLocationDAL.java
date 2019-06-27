package DAL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.math.BigDecimal;

import DB.DBManager;
import Models.Locations.Location;

import java.util.ArrayList;

public class PatientLocationDAL {
	
	public static String AddPatientLocation(int nationalID,String addressPatient,BigDecimal Latitude, BigDecimal Longitude) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Patient_Locations] ?,?,?,?,?";
		//ResultSet RS;
		String Result = "";
		Connection conn = DBManager.getDBConn();
		try {
			
			CallableStatement cstmt = conn.prepareCall(SPsql);
			
			cstmt.setInt(1, nationalID);
			cstmt.setString(2, addressPatient);
			cstmt.setBigDecimal(3, Latitude);
			cstmt.setBigDecimal(4, Longitude);
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
				_location.setLongitude(RS.getString("longitude"));
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
