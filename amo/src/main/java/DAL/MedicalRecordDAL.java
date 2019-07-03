package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.ServerResponse;
import Models.MedicalRecord.MedicalRecord;

public class MedicalRecordDAL {
	
	
	public static ServerResponse addMedicalRecord(MedicalRecord MedicalRecorda) {

		String SPsql = "EXEC usp_MedicalRecord_Insert ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1,MedicalRecorda.getMedicalRecordID());
			cstmt.setString(2,MedicalRecorda.getRespSQN());
			cstmt.setInt(3,MedicalRecorda.getPatientID());
			cstmt.setString(4,MedicalRecorda.getBloodType());
			cstmt.setString(5,MedicalRecorda.getBloodPressure());
			cstmt.setString(6,MedicalRecorda.getDiabetes());
			cstmt.setString(7,MedicalRecorda.getRespiratoryDiseases());
			cstmt.setString(8,MedicalRecorda.getCancer());
			cstmt.setString(9,MedicalRecorda.getCardiovascularDiseases());
			cstmt.setString(10,MedicalRecorda.getcOPD());
			cstmt.setString(11,MedicalRecorda.getPregnancy());
			cstmt.setString(12,MedicalRecorda.getOther());
			cstmt.setString(13,MedicalRecorda.getDead());
			cstmt.setString(14,MedicalRecorda.getConsciousness());
			cstmt.setString(15,MedicalRecorda.getBreathing());
			cstmt.setString(16,MedicalRecorda.getCapillaries());
			cstmt.setString(17,MedicalRecorda.getPulse());
			cstmt.setString(18,MedicalRecorda.getBloodPressureLevel());
			cstmt.setString(19,MedicalRecorda.getDiabetesLevel());
			cstmt.setString(20,MedicalRecorda.getBodyTemp());
			cstmt.setString(21,MedicalRecorda.getBreathingRate());
			cstmt.setString(22,MedicalRecorda.getCapillariesLevel());
			cstmt.setString(23,MedicalRecorda.getInjury());
			cstmt.setString(24,MedicalRecorda.getPhysicalExaminationImage());
			cstmt.setString(25,MedicalRecorda.getMedicineApplied());
			cstmt.setString(26,MedicalRecorda.getProcedureDoneInCar());
			cstmt.setString(27,MedicalRecorda.getRecommendedProcedure());
			cstmt.setString(28,MedicalRecorda.getmRStatus());
			
			cstmt.registerOutParameter(29, Types.NVARCHAR);
			cstmt.registerOutParameter(30, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(29));
			_ServerResponse.setResponseMsg(cstmt.getString(30));

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

