package BLL;

import java.util.ArrayList;

import DAL.MedicalRecordDAL;
import DAL.PatientDAL;
import Models.ServerResponse;
import Models.Patient.PatientArray;
import Models.Patient.PatientModel;

public class PatientManger {
	public static PatientArray getAllPatient() {

		return PatientDAL.getAllPatients();
	}

	public static PatientArray getPatientByNId(String NID) {
		return PatientDAL.getPatientByNId(NID);
	}

	public static ServerResponse addNewPatient(PatientModel patientModel) {

		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		Array = PatientDAL.getPatientByNId(patientModel.getPatientNationalID()).getPatientArray();

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

	public static ServerResponse updatePatientData(PatientModel patientModel) {

		return PatientDAL.updatePatientData(patientModel);
	}

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