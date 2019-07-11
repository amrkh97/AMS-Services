package BLL;

import java.util.ArrayList;

import DAL.AmbulanceVehicleDAL;
import DAL.MedicalRecordDAL;
import DAL.PatientDAL;
import Models.ServerResponse;
import Models.ServerResponse_ID;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Patient.PatientArray;
import Models.Patient.PatientModel;

public class PatientManger {
	public static PatientArray getAllPatient() {

		return PatientDAL.getAllPatients();
	}

	public static PatientArray getPatientByNId(String NID) {
		return PatientDAL.getPatientByNId(NID);
	}

	public static ServerResponse_ID addNewPatient(PatientModel patientModel) {

		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		Array = PatientDAL.getPatientByNId(patientModel.getPatientNationalID()).getPatientArray();

		if (Array.size() != 0) {
			if (Array.get(0).getPatientStatus().equals("FF")) {
				Array.get(0).setPatientStatus("00");
				ServerResponse update = PatientDAL.updatePatientData(Array.get(0));
				ServerResponse_ID S = new ServerResponse_ID();
				S.setResponseHexCode(update.getResponseHexCode());
				S.setResponseMsg(update.getResponseMsg());
				S.setId(Array.get(0).getPatientID());
				return S;
			} else {
				ServerResponse_ID S = new ServerResponse_ID();
				S.setResponseHexCode("01");
				S.setResponseMsg("You already have this Patient with the same National ID in database");
				S.setId(Array.get(0).getPatientID());
				return S;
			}
		}
		return PatientDAL.addNewPatient(patientModel);
	}

	public static ServerResponse updatePatientData(PatientModel patientModel) {

		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		Array = PatientDAL.getPatientByNId(patientModel.getPatientNationalID()).getPatientArray();

		if (Array.size() == 0) {
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND Patient in database");
			return S;
		}
		return PatientDAL.updatePatientData(patientModel);
	}

	public static ServerResponse deletePatient(PatientModel patient ) {
		int PatientID =patient.getPatientID();
		ArrayList<PatientModel> Array = new ArrayList<PatientModel>();
		Array = PatientDAL.getPatientByNId(patient.getPatientNationalID()).getPatientArray();

		if (Array.size() == 0) {
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND Patient in database");
			return S;
		} else {
			ServerResponse X = PatientDAL.deletePatientLoc(PatientID);
			if (X.getResponseHexCode().equals("00")) {
				ServerResponse Y = MedicalRecordDAL.deleteMedicalRecordByPatient(PatientID);
				if (Y.getResponseHexCode().contentEquals("00")) {
					return PatientDAL.deletePatient(PatientID);
				} else {
					return Y;
				}

			}

			else {
				return X;
			}
		}
	}

}