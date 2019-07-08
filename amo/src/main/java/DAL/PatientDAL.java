package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.ServerResponse;
import Models.Patient.PatientModel;

public class PatientDAL {
	
	 
	public static ServerResponse addNewPatient(PatientModel patientModel) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_add_New_Patient] ?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		 
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			
			CallableStatement cstmt = conn.prepareCall(SPsql);
						
		    cstmt.setString(1, patientModel.getPatientFName());
	        cstmt.setString(2, patientModel.getPatientLName());
	        cstmt.setInt(3, patientModel.getGender());
	        cstmt.setString(4, patientModel.getAge());
	        cstmt.setString(5, patientModel.getPhone());
	        cstmt.setString(6, patientModel.getLastBenifitedTime());
	        cstmt.setString(7, patientModel.getFirstBenifitedTime());
	        cstmt.setString(8, patientModel.getNextOfKenName());
	        cstmt.setString(9, patientModel.getNextOfKenAddress());
	        cstmt.setString(10, patientModel.getNextOfKenPhone());
	        cstmt.setString(11, patientModel.getPatientStatus());
	        cstmt.setInt(11, patientModel.getPatientNationalID());

	        cstmt.registerOutParameter(12, Types.NVARCHAR);
	        cstmt.registerOutParameter(13, Types.NVARCHAR);
		    cstmt.execute();

			      _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
			      
			       _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
						
				   System.out.println(cstmt.getString(10));   
			       
		         }catch (SQLException e) {
		        	 System.out.println("i hav error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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


	public static ServerResponse updatePatientData(PatientModel patientModel) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Update_Patient] ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		 
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			
			CallableStatement cstmt = conn.prepareCall(SPsql);
			
			cstmt.setInt(1, patientModel.getPatientID());
		    cstmt.setString(2, patientModel.getPatientFName());
	        cstmt.setString(3, patientModel.getPatientLName());
	        cstmt.setInt(4, patientModel.getGender());
	        cstmt.setString(5, patientModel.getAge());
	        cstmt.setString(6, patientModel.getPhone());
	        cstmt.setString(7, patientModel.getLastBenifitedTime());
	        cstmt.setString(8, patientModel.getFirstBenifitedTime());
	        cstmt.setString(9, patientModel.getNextOfKenName());
	        cstmt.setString(10, patientModel.getNextOfKenAddress());
	        cstmt.setString(11, patientModel.getNextOfKenPhone());
	        cstmt.setString(12, patientModel.getPatientStatus());
	        cstmt.setInt(13, patientModel.getPatientNationalID());

	        cstmt.registerOutParameter(14, Types.NVARCHAR);
	        cstmt.registerOutParameter(15, Types.NVARCHAR);
		    cstmt.execute();

	        _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
		      
	        _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
						
		    System.out.println(cstmt.getString(10));   
			       
	        }catch (SQLException e) {
		        	 System.out.println("i hav error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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

	
	public static ServerResponse deletePatient(int PatientID ) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Delete_Patient] ?,?,?,?,?";
		System.out.println("PatientID :"+ PatientID);
			Connection conn = DBManager.getDBConn();
			ServerResponse _ServerResponse = new ServerResponse();

			try {
				CallableStatement cstmt  = conn.prepareCall(SPsql);
 
			    cstmt.setInt(1, PatientID);
		        cstmt.registerOutParameter(2, Types.NVARCHAR);
			    cstmt.registerOutParameter(3, Types.NVARCHAR);
		        cstmt.execute();
		        _ServerResponse.setResponseHexCode(cstmt.getString(2));
			    _ServerResponse.setResponseMsg(cstmt.getString(3));
						      
		         }catch (SQLException e) {
		        		// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
