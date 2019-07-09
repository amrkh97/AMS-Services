package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.Patient.PatientModel;

public class PatientDAL {
///////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET/////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

	////////ALL	
	public static ArrayList<PatientModel> getAllPatients() {

		String SPsql = "USE KAN_AMO; EXEC usp_Patient_getAll";
		Connection conn = DBManager.getDBConn();
		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();

		PatientModel patient = new PatientModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {

				patient = new PatientModel();
				patient.setPatientID(rs.getInt("patientID"));
				patient.setPatientFName(rs.getString("patientFName"));
				patient.setPatientLName(rs.getString("patientLName"));
				patient.setGender(rs.getString("gender"));
				patient.setAge(rs.getString("age"));
				patient.setPhone(rs.getString("phone"));
				patient.setLastBenifitedTime(rs.getString("lastBenifitedTime"));
				patient.setFirstBenifitedTime(rs.getString("firstBenifitedTime"));
				patient.setNextOfKenName(rs.getString("nextOfKenName"));
				patient.setNextOfKenPhone(rs.getString("nextOfKenPhone"));
				patient.setNextOfKenAddress(rs.getString("nextOfKenAddress"));
				patient.setPatientStatus(rs.getString("patientStatus"));
				patient.setPatientNationalID(rs.getString("patientNationalID"));

				Array.add(patient);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return Array;
	}
	
	//////by NATIONAL ID
	public static ArrayList<PatientModel> getPatientByNId(String NID) {

		String SPsql = "USE KAN_AMO; EXEC usp_Patient_getByNID ?";
		Connection conn = DBManager.getDBConn();
		
		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();

		PatientModel patient = new PatientModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, NID);
			
			ResultSet rs = cstmt.executeQuery();
			
			while (rs.next()) {

				patient = new PatientModel();
				patient.setPatientID(rs.getInt("patientID"));
				patient.setPatientFName(rs.getString("patientFName"));
				patient.setPatientLName(rs.getString("patientLName"));
				patient.setGender(rs.getString("gender"));
				patient.setAge(rs.getString("age"));
				patient.setPhone(rs.getString("phone"));
				patient.setLastBenifitedTime(rs.getString("lastBenifitedTime"));
				patient.setFirstBenifitedTime(rs.getString("firstBenifitedTime"));
				patient.setNextOfKenName(rs.getString("nextOfKenName"));
				patient.setNextOfKenPhone(rs.getString("nextOfKenPhone"));
				patient.setNextOfKenAddress(rs.getString("nextOfKenAddress"));
				patient.setPatientStatus(rs.getString("patientStatus"));
				patient.setPatientNationalID(rs.getString("patientNationalID"));

				Array.add(patient);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return Array;
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// INSERT////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse addNewPatient(PatientModel patientModel) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_add_New_Patient] ?,?,?,?,?,?,?,?,?,?,?,?,?,?";

		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, patientModel.getPatientFName());
			cstmt.setString(1, patientModel.getPatientFName());
			cstmt.setString(2, patientModel.getPatientLName());
			cstmt.setString(3, patientModel.getGender());
			cstmt.setString(4, patientModel.getAge());
			cstmt.setString(5, patientModel.getPhone());
			cstmt.setString(6, patientModel.getLastBenifitedTime());
			cstmt.setString(7, patientModel.getFirstBenifitedTime());
			cstmt.setString(8, patientModel.getNextOfKenName());
			cstmt.setString(9, patientModel.getNextOfKenAddress());
			cstmt.setString(10, patientModel.getNextOfKenPhone());
			cstmt.setString(11, patientModel.getPatientStatus());
			cstmt.setString(12, patientModel.getPatientNationalID());

			cstmt.registerOutParameter(13, Types.NVARCHAR);
			cstmt.registerOutParameter(14, Types.NVARCHAR);
			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString(13));

			_ServerResponse.setResponseMsg(cstmt.getString(14));

		

		} catch (SQLException e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _ServerResponse;
	}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////UPDATE//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

	public static ServerResponse updatePatientData(PatientModel patientModel) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Update_Patient] ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, patientModel.getPatientID());
			cstmt.setString(2, patientModel.getPatientFName());
			cstmt.setString(3, patientModel.getPatientLName());
			cstmt.setString(4, patientModel.getGender());
			cstmt.setString(5, patientModel.getAge());
			cstmt.setString(6, patientModel.getPhone());
			cstmt.setString(7, patientModel.getLastBenifitedTime());
			cstmt.setString(8, patientModel.getFirstBenifitedTime());
			cstmt.setString(9, patientModel.getNextOfKenName());
			cstmt.setString(10, patientModel.getNextOfKenAddress());
			cstmt.setString(11, patientModel.getNextOfKenPhone());
			cstmt.setString(12, patientModel.getPatientStatus());
			cstmt.setString(13, patientModel.getPatientNationalID());

			cstmt.registerOutParameter(14, Types.NVARCHAR);
			cstmt.registerOutParameter(15, Types.NVARCHAR);
			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString(14));

			_ServerResponse.setResponseMsg(cstmt.getString(15));

		} catch (SQLException e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _ServerResponse;
	}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////DELETE//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

	public static ServerResponse deletePatient(int PatientID) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Delete_Patient] ?,?,?";
		System.out.println("PatientID :" + PatientID);
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, PatientID);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(2));
			_ServerResponse.setResponseMsg(cstmt.getString(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _ServerResponse;
	}

}
