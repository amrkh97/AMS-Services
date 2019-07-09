package BLL;

import java.util.ArrayList;

import DAL.MedicalRecordDAL;
import DAL.PatientDAL;
import Models.ServerResponse;
import Models.Patient.PatientModel;

public class PatientManger {
	////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// GET///////////////////////////////////////
	//////////////////////////////////////////////////////////////////////

	//////// ALL

	public static ArrayList<PatientModel> getAllPatient() {

		return PatientDAL.getAllPatients();
	}

	/////////////////////////// NATIONAL ID
	public static ArrayList<PatientModel> getPatientByNId(String NID) {
		return PatientDAL.getPatientByNId(NID);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// INSERT////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse addNewPatient(PatientModel patientModel) {

		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		Array = PatientDAL.getPatientByNId(patientModel.getPatientNationalID());

		if (Array.size() != 0) {
			if (Array.get(0).getPatientStatus().equals("FF")) {
				Array.get(0).setPatientStatus("00");
				return PatientDAL.updatePatientData(Array.get(0));
			} else {
				ServerResponse S = new ServerResponse();
				S.setResponseHexCode("01");
				S.setResponseMsg("You already have this Patient with the same National ID in database");
				return S;
			}
		}
		return PatientDAL.addNewPatient(patientModel);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////// UPDATE//////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	public static ServerResponse updatePatientData(PatientModel patientModel) {

		return PatientDAL.updatePatientData(patientModel);
	}

//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////DELETE//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
	public static ServerResponse deletePatient(int PatientID) {

		ServerResponse X = PatientDAL.deletePatientLoc(PatientID);
		if (X.getResponseHexCode().equals("00"))
		{
			ServerResponse	Y= MedicalRecordDAL.deleteMedicalRecordByPatient(PatientID);
			if (Y.getResponseHexCode().contentEquals("00"))
			{
				return PatientDAL.deletePatient(PatientID);
			} 
	else 
			{
				return Y;
			}
		
		}

		else {
			return X;
		}

	}

}