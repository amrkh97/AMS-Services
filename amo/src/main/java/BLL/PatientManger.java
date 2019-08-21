package BLL;

import java.sql.Connection;
import java.util.ArrayList;

import DAL.MedicalRecordDAL;
import DAL.PatientDAL;
import DB.DBManager;
import Models.CustomClass;
import Models.ServerResponse;
import Models.ServerResponse_ID;
import Models.Patient.PatientArray;
import Models.Patient.PatientModel;

public class PatientManger {
	public static CustomClass<PatientArray, ServerResponse> getAllPatient() {

		PatientArray patientArray = new PatientArray();
		ServerResponse S = new ServerResponse();
		CustomClass<PatientArray, ServerResponse> response = new CustomClass<PatientArray, ServerResponse>();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {

			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			response.setFirst(null);
			response.setSecond(S);
			return response;
		}
		try {

			patientArray = PatientDAL.getAllPatients(conn);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		response.setFirst(patientArray);
		response.setSecond(null);
		return response;

	}

	// -----------------------------------------------------------------------------------------------------//

	public static CustomClass<PatientArray, ServerResponse> getPatientByNId(String NID) {

		PatientArray patientArray = new PatientArray();
		ServerResponse S = new ServerResponse();
		CustomClass<PatientArray, ServerResponse> response = new CustomClass<PatientArray, ServerResponse>();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {

			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			response.setFirst(null);
			response.setSecond(S);

			return response;
		}

		try {

			patientArray = PatientDAL.getPatientByNId(NID, conn);

		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		response.setFirst(patientArray);
		response.setSecond(null);

		return response;

	}
	// -----------------------------------------------------------------------------------------------------//

	public static CustomClass<PatientArray, ServerResponse> getPatientById(int ID) {

		PatientArray patientArray = new PatientArray();
		ServerResponse S = new ServerResponse();
		CustomClass<PatientArray, ServerResponse> response = new CustomClass<PatientArray, ServerResponse>();
		CustomClass<Connection, Boolean> connBool = DBManager.getDBConn1();
		Connection conn = connBool.getFirst();
		if (!connBool.getSecond()) {

			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			response.setFirst(null);
			response.setSecond(S);

			return response;
		}

		try {

			patientArray = PatientDAL.getPatientById(ID, conn);

		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		response.setFirst(patientArray);
		response.setSecond(null);

		return response;

	}

	// ---------------------------------------------------------------Insert-------------------------------------------------------//

	public static ServerResponse_ID addNewPatient(PatientModel patientModel) {

		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		ServerResponse_ID S = new ServerResponse_ID();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {
			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			return S;

		}
		try {

			Array = PatientDAL.getPatientByNId(patientModel.getPatientNationalID(), conn).getPatientArray();

			if (Array.size() != 0) {
				if (Array.get(0).getPatientStatus().equals("FF")) {
					Array.get(0).setPatientStatus("00");
					ServerResponse update = PatientDAL.updatePatientData(Array.get(0), conn);
					S.setResponseHexCode(update.getResponseHexCode());
					S.setResponseMsg(update.getResponseMsg());
					S.setId(Array.get(0).getPatientID());
					return S;
				} else {
					S.setResponseHexCode("01");
					S.setResponseMsg("You already have this Patient with the same National ID in database");
					S.setId(Array.get(0).getPatientID());
					return S;
				}
			}

			S = PatientDAL.addNewPatient(patientModel, conn);
		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return S;

	}
	// ---------------------------------------------------------------delete-------------------------------------------------------//

	public static ServerResponse updatePatientData(PatientModel patientModel) {
		ServerResponse S = new ServerResponse();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {
			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			return S;

		}
		try {
			S = PatientDAL.updatePatientData(patientModel, conn);
		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return S;
	}

	// ---------------------------------------------------------------delete-------------------------------------------------------//

	public static ServerResponse deletePatient(PatientModel patient) {
		int PatientID = patient.getPatientID();
		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		ServerResponse S = new ServerResponse();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {
			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			return S;

		}
		try {
			Array = PatientDAL.getPatientById(patient.getPatientID(), conn).getPatientArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Array.size() == 0) {

			S.setResponseHexCode("FF");
			S.setResponseMsg("Patient NOT FOUND in database");
			return S;
		} else {
			ServerResponse deleteLoc = null;
			try {
				deleteLoc = PatientDAL.deletePatientLoc(PatientID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (deleteLoc.getResponseHexCode().equals("00")) {
				ServerResponse deleteMedical = null;
				try {
					deleteMedical = MedicalRecordDAL.deleteMedicalRecordByPatient(PatientID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (deleteMedical.getResponseHexCode().contentEquals("00")) {
					try {
						return PatientDAL.deletePatient(PatientID);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

				}
				return deleteMedical;
			}

			else {
				return deleteLoc;
			}
		}

	}

	public static PatientModel getDataByID(Integer patientID) {

		Connection conn = DBManager.getDBConn();
		PatientModel response = new PatientModel();
		try {

			response = PatientDAL.getDataByID(patientID, conn);

		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return response;

	}
}
