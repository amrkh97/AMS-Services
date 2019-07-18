package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.ServerResponseIntOutput;
import Models.MedicalRecord.MedicalRecord;
import Models.MedicalRecord.MedicalRecordArray;

public class MedicalRecordDAL {

	public static ServerResponseIntOutput addMedicalRecord(MedicalRecord MedicalRecorda) {

		String SPsql = "EXEC usp_MedicalRecord_Insert ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponseIntOutput _ServerResponse = new ServerResponseIntOutput();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, MedicalRecorda.getRespSQN());
			cstmt.setInt(2, MedicalRecorda.getPatientID());
			cstmt.setString(3, MedicalRecorda.getBloodType());
			cstmt.setString(4, MedicalRecorda.getBloodPressure());
			cstmt.setString(5, MedicalRecorda.getDiabetes());
			cstmt.setString(6, MedicalRecorda.getRespiratoryDiseases());
			cstmt.setString(7, MedicalRecorda.getCancer());
			cstmt.setString(8, MedicalRecorda.getCardiovascularDiseases());
			cstmt.setString(9, MedicalRecorda.getcOPD());
			cstmt.setString(10, MedicalRecorda.getPregnancy());
			cstmt.setString(11, MedicalRecorda.getOther());
			cstmt.setString(12, MedicalRecorda.getDead());
			cstmt.setString(13, MedicalRecorda.getConsciousness());
			cstmt.setString(14, MedicalRecorda.getBreathing());
			cstmt.setString(15, MedicalRecorda.getCapillaries());
			cstmt.setString(16, MedicalRecorda.getPulse());
			cstmt.setString(17, MedicalRecorda.getBloodPressureLevel());
			cstmt.setString(18, MedicalRecorda.getDiabetesLevel());
			cstmt.setString(19, MedicalRecorda.getBodyTemp());
			cstmt.setString(20, MedicalRecorda.getBreathingRate());
			cstmt.setString(21, MedicalRecorda.getCapillariesLevel());
			cstmt.setString(22, MedicalRecorda.getInjury());
			cstmt.setString(23, MedicalRecorda.getPhysicalExaminationImage());
			cstmt.setString(24, MedicalRecorda.getMedicineApplied());
			cstmt.setString(25, MedicalRecorda.getProcedureDoneInCar());
			cstmt.setString(26, MedicalRecorda.getRecommendedProcedure());
			cstmt.setString(27, MedicalRecorda.getmRStatus());

			cstmt.registerOutParameter(28, Types.NVARCHAR);
			cstmt.registerOutParameter(29, Types.NVARCHAR);
			cstmt.registerOutParameter(30, Types.INTEGER);
			cstmt.execute();
			_ServerResponse.setMedicalRecordID(cstmt.getInt(30));
			_ServerResponse.setResponseHexCode(cstmt.getString(28));
			_ServerResponse.setResponseMsg(cstmt.getString(29));

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

	public static MedicalRecordArray getAllMedicalRecords() {

		String SPsql = "EXEC usp_MedicalRecord_SelectAll";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<MedicalRecord> allMedicalRecords = new ArrayList<>();
		MedicalRecordArray OBJ = new MedicalRecordArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				MedicalRecord currentMedicalRecord = new MedicalRecord();
				currentMedicalRecord.setBloodPressure(RS.getNString("BloodPressure"));
				currentMedicalRecord.setBloodPressureLevel(RS.getNString("BloodPressureLevel"));
				currentMedicalRecord.setBloodType(RS.getNString("bloodType"));
				currentMedicalRecord.setBodyTemp(RS.getNString("bodyTemp"));
				currentMedicalRecord.setBreathing(RS.getNString("breathing"));
				currentMedicalRecord.setBreathingRate(RS.getNString("breathingRate"));
				currentMedicalRecord.setCancer(RS.getNString("cancer"));
				currentMedicalRecord.setCapillaries(RS.getNString("capillaries"));
				currentMedicalRecord.setCapillariesLevel(RS.getNString("capillariesLevel"));
				currentMedicalRecord.setCardiovascularDiseases(RS.getNString("cardiovascularDiseases"));
				currentMedicalRecord.setConsciousness(RS.getNString("consciousness"));
				currentMedicalRecord.setcOPD(RS.getNString("cOPD"));
				currentMedicalRecord.setDead(RS.getNString("dead"));
				currentMedicalRecord.setDiabetes(RS.getNString("diabetes"));
				currentMedicalRecord.setDiabetesLevel(RS.getNString("diabetesLevel"));
				currentMedicalRecord.setInjury(RS.getNString("injury"));
				currentMedicalRecord.setMedicalRecordID(RS.getInt("medicalRecordID"));
				currentMedicalRecord.setMedicineApplied(RS.getNString("medicineApplied"));
				currentMedicalRecord.setmRStatus(RS.getNString("mRStatus"));
				currentMedicalRecord.setOther(RS.getNString("other"));
				currentMedicalRecord.setPatientID(RS.getInt("patientID"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPregnancy(RS.getNString("pregnancy"));
				currentMedicalRecord.setProcedureDoneInCar(RS.getNString("procedureDoneInCar"));
				currentMedicalRecord.setPulse(RS.getNString("pulse"));
				currentMedicalRecord.setRecommendedProcedure(RS.getNString("recommendedProcedure"));
				currentMedicalRecord.setRespiratoryDiseases(RS.getNString("respiratoryDiseases"));
				currentMedicalRecord.setRespSQN(RS.getInt("respSQN"));

				allMedicalRecords.add(currentMedicalRecord);
			}
			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OBJ.setMedicalRecordArray(allMedicalRecords);
		return OBJ;

	}

	public static MedicalRecordArray getMedicalRecordByPatientID(Integer PatientID) {
		String SPsql = "EXEC usp_MedicalRecord_SelectByPatient ?";

		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<MedicalRecord> allMedicalRecords = new ArrayList<>();
		MedicalRecordArray OBJ = new MedicalRecordArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, PatientID);
			RS = cstmt.executeQuery();

			while (RS.next()) {
				MedicalRecord currentMedicalRecord = new MedicalRecord();
				currentMedicalRecord.setBloodPressure(RS.getNString("BloodPressure"));
				currentMedicalRecord.setBloodPressureLevel(RS.getNString("BloodPressureLevel"));
				currentMedicalRecord.setBloodType(RS.getNString("bloodType"));
				currentMedicalRecord.setBodyTemp(RS.getNString("bodyTemp"));
				currentMedicalRecord.setBreathing(RS.getNString("breathing"));
				currentMedicalRecord.setBreathingRate(RS.getNString("breathingRate"));
				currentMedicalRecord.setCancer(RS.getNString("cancer"));
				currentMedicalRecord.setCapillaries(RS.getNString("capillaries"));
				currentMedicalRecord.setCapillariesLevel(RS.getNString("capillariesLevel"));
				currentMedicalRecord.setCardiovascularDiseases(RS.getNString("cardiovascularDiseases"));
				currentMedicalRecord.setConsciousness(RS.getNString("consciousness"));
				currentMedicalRecord.setcOPD(RS.getNString("cOPD"));
				currentMedicalRecord.setDead(RS.getNString("dead"));
				currentMedicalRecord.setDiabetes(RS.getNString("diabetes"));
				currentMedicalRecord.setDiabetesLevel(RS.getNString("diabetesLevel"));
				currentMedicalRecord.setInjury(RS.getNString("injury"));
				currentMedicalRecord.setMedicalRecordID(RS.getInt("medicalRecordID"));
				currentMedicalRecord.setMedicineApplied(RS.getNString("medicineApplied"));
				currentMedicalRecord.setmRStatus(RS.getNString("mRStatus"));
				currentMedicalRecord.setOther(RS.getNString("other"));
				currentMedicalRecord.setPatientID(RS.getInt("patientID"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPregnancy(RS.getNString("pregnancy"));
				currentMedicalRecord.setProcedureDoneInCar(RS.getNString("procedureDoneInCar"));
				currentMedicalRecord.setPulse(RS.getNString("pulse"));
				currentMedicalRecord.setRecommendedProcedure(RS.getNString("recommendedProcedure"));
				currentMedicalRecord.setRespiratoryDiseases(RS.getNString("respiratoryDiseases"));
				currentMedicalRecord.setRespSQN(RS.getInt("respSQN"));

				allMedicalRecords.add(currentMedicalRecord);

			}
			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OBJ.setMedicalRecordArray(allMedicalRecords);
		return OBJ;

	}

	public static MedicalRecordArray getMedicalRecordByID(Integer MedicalRecordID) {
		String SPsql = "EXEC usp_MedicalRecord_SelectByID ?";

		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<MedicalRecord> allMedicalRecords = new ArrayList<>();
		MedicalRecordArray OBJ = new MedicalRecordArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, MedicalRecordID);
			RS = cstmt.executeQuery();

			while (RS.next()) {
				MedicalRecord currentMedicalRecord = new MedicalRecord();
				currentMedicalRecord.setBloodPressure(RS.getNString("BloodPressure"));
				currentMedicalRecord.setBloodPressureLevel(RS.getNString("BloodPressureLevel"));
				currentMedicalRecord.setBloodType(RS.getNString("bloodType"));
				currentMedicalRecord.setBodyTemp(RS.getNString("bodyTemp"));
				currentMedicalRecord.setBreathing(RS.getNString("breathing"));
				currentMedicalRecord.setBreathingRate(RS.getNString("breathingRate"));
				currentMedicalRecord.setCancer(RS.getNString("cancer"));
				currentMedicalRecord.setCapillaries(RS.getNString("capillaries"));
				currentMedicalRecord.setCapillariesLevel(RS.getNString("capillariesLevel"));
				currentMedicalRecord.setCardiovascularDiseases(RS.getNString("cardiovascularDiseases"));
				currentMedicalRecord.setConsciousness(RS.getNString("consciousness"));
				currentMedicalRecord.setcOPD(RS.getNString("cOPD"));
				currentMedicalRecord.setDead(RS.getNString("dead"));
				currentMedicalRecord.setDiabetes(RS.getNString("diabetes"));
				currentMedicalRecord.setDiabetesLevel(RS.getNString("diabetesLevel"));
				currentMedicalRecord.setInjury(RS.getNString("injury"));
				currentMedicalRecord.setMedicalRecordID(RS.getInt("medicalRecordID"));
				currentMedicalRecord.setMedicineApplied(RS.getNString("medicineApplied"));
				currentMedicalRecord.setmRStatus(RS.getNString("mRStatus"));
				currentMedicalRecord.setOther(RS.getNString("other"));
				currentMedicalRecord.setPatientID(RS.getInt("patientID"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPregnancy(RS.getNString("pregnancy"));
				currentMedicalRecord.setProcedureDoneInCar(RS.getNString("procedureDoneInCar"));
				currentMedicalRecord.setPulse(RS.getNString("pulse"));
				currentMedicalRecord.setRecommendedProcedure(RS.getNString("recommendedProcedure"));
				currentMedicalRecord.setRespiratoryDiseases(RS.getNString("respiratoryDiseases"));
				currentMedicalRecord.setRespSQN(RS.getInt("respSQN"));

				allMedicalRecords.add(currentMedicalRecord);

			}
			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OBJ.setMedicalRecordArray(allMedicalRecords);
		return OBJ;

	}

	public static MedicalRecordArray getMedicalRecordByStatus(String medicalRecordStatus) {
		String SPsql = "EXEC usp_MedicalRecord_SelectByStatus ?";

		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<MedicalRecord> allMedicalRecords = new ArrayList<>();
		MedicalRecordArray OBJ = new MedicalRecordArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setNString(1, medicalRecordStatus);
			RS = cstmt.executeQuery();

			while (RS.next()) {
				MedicalRecord currentMedicalRecord = new MedicalRecord();
				currentMedicalRecord.setBloodPressure(RS.getNString("BloodPressure"));
				currentMedicalRecord.setBloodPressureLevel(RS.getNString("BloodPressureLevel"));
				currentMedicalRecord.setBloodType(RS.getNString("bloodType"));
				currentMedicalRecord.setBodyTemp(RS.getNString("bodyTemp"));
				currentMedicalRecord.setBreathing(RS.getNString("breathing"));
				currentMedicalRecord.setBreathingRate(RS.getNString("breathingRate"));
				currentMedicalRecord.setCancer(RS.getNString("cancer"));
				currentMedicalRecord.setCapillaries(RS.getNString("capillaries"));
				currentMedicalRecord.setCapillariesLevel(RS.getNString("capillariesLevel"));
				currentMedicalRecord.setCardiovascularDiseases(RS.getNString("cardiovascularDiseases"));
				currentMedicalRecord.setConsciousness(RS.getNString("consciousness"));
				currentMedicalRecord.setcOPD(RS.getNString("cOPD"));
				currentMedicalRecord.setDead(RS.getNString("dead"));
				currentMedicalRecord.setDiabetes(RS.getNString("diabetes"));
				currentMedicalRecord.setDiabetesLevel(RS.getNString("diabetesLevel"));
				currentMedicalRecord.setInjury(RS.getNString("injury"));
				currentMedicalRecord.setMedicalRecordID(RS.getInt("medicalRecordID"));
				currentMedicalRecord.setMedicineApplied(RS.getNString("medicineApplied"));
				currentMedicalRecord.setmRStatus(RS.getNString("mRStatus"));
				currentMedicalRecord.setOther(RS.getNString("other"));
				currentMedicalRecord.setPatientID(RS.getInt("patientID"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPhysicalExaminationImage(RS.getNString("physicalExaminationImage"));
				currentMedicalRecord.setPregnancy(RS.getNString("pregnancy"));
				currentMedicalRecord.setProcedureDoneInCar(RS.getNString("procedureDoneInCar"));
				currentMedicalRecord.setPulse(RS.getNString("pulse"));
				currentMedicalRecord.setRecommendedProcedure(RS.getNString("recommendedProcedure"));
				currentMedicalRecord.setRespiratoryDiseases(RS.getNString("respiratoryDiseases"));
				currentMedicalRecord.setRespSQN(RS.getInt("respSQN"));

				allMedicalRecords.add(currentMedicalRecord);

			}
			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OBJ.setMedicalRecordArray(allMedicalRecords);
		return OBJ;

	}

	public static ServerResponse updateMedicalRecord(MedicalRecord MedicalRecorda) {
		String SPsql = "EXEC usp_MedicalRecord_Update ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		ServerResponse _ServerResponse = new ServerResponse();
		Connection conn = DBManager.getDBConn();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, MedicalRecorda.getMedicalRecordID());
			cstmt.setInt(2, MedicalRecorda.getRespSQN());
			cstmt.setInt(3, MedicalRecorda.getPatientID());
			cstmt.setString(4, MedicalRecorda.getBloodType());
			cstmt.setString(5, MedicalRecorda.getBloodPressure());
			cstmt.setString(6, MedicalRecorda.getDiabetes());
			cstmt.setString(7, MedicalRecorda.getRespiratoryDiseases());
			cstmt.setString(8, MedicalRecorda.getCancer());
			cstmt.setString(9, MedicalRecorda.getCardiovascularDiseases());
			cstmt.setString(10, MedicalRecorda.getcOPD());
			cstmt.setString(11, MedicalRecorda.getPregnancy());
			cstmt.setString(12, MedicalRecorda.getOther());
			cstmt.setString(13, MedicalRecorda.getDead());
			cstmt.setString(14, MedicalRecorda.getConsciousness());
			cstmt.setString(15, MedicalRecorda.getBreathing());
			cstmt.setString(16, MedicalRecorda.getCapillaries());
			cstmt.setString(17, MedicalRecorda.getPulse());
			cstmt.setString(18, MedicalRecorda.getBloodPressureLevel());
			cstmt.setString(19, MedicalRecorda.getDiabetesLevel());
			cstmt.setString(20, MedicalRecorda.getBodyTemp());
			cstmt.setString(21, MedicalRecorda.getBreathingRate());
			cstmt.setString(22, MedicalRecorda.getCapillariesLevel());
			cstmt.setString(23, MedicalRecorda.getInjury());
			cstmt.setString(24, MedicalRecorda.getPhysicalExaminationImage());
			cstmt.setString(25, MedicalRecorda.getMedicineApplied());
			cstmt.setString(26, MedicalRecorda.getProcedureDoneInCar());
			cstmt.setString(27, MedicalRecorda.getRecommendedProcedure());
			cstmt.setString(28, MedicalRecorda.getmRStatus());

			cstmt.registerOutParameter(29, Types.NVARCHAR);
			cstmt.registerOutParameter(30, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(29));
			_ServerResponse.setResponseMsg(cstmt.getString(30));

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

		return _ServerResponse;
	}

	public static ServerResponse deleteMedicalRecord(Integer medicalRecordID) {
		String SPsql = "EXEC usp_MedicalRecord_Delete ?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, medicalRecordID);
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

	public static ServerResponse deleteMedicalRecordByPatient(Integer patientID) throws Exception {
		String SPsql = "EXEC usp_MedicalRecord_DeleteByPatient ?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, patientID);
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
