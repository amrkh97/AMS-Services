package BLL;

import DAL.PatientDAL;
import Models.ServerResponse;
import Models.Patient.PatientModel;

public class PatientManger {

	public static ServerResponse addNewPatient(PatientModel patientModel) {
		
		return PatientDAL.addNewPatient(patientModel);
	}

	public static ServerResponse updatePatientData(PatientModel patientModel) {
		
		return PatientDAL.updatePatientData(patientModel);
	}
	

	public static ServerResponse deletePatient(int PatientlID ) {
		
		return PatientDAL.deletePatient(PatientlID);
	}
	
	 
}