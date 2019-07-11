package BLL;

import DAL.MedicalRecordDAL;
import Models.ServerResponse;
import Models.ServerResponseIntOutput;
import Models.MedicalRecord.MedicalRecord;
import Models.MedicalRecord.MedicalRecordArray;

public class MedicalRecordManager {

	public static MedicalRecordArray getAllMedicalRecords() {
		return MedicalRecordDAL.getAllMedicalRecords();
	}

	public static MedicalRecordArray getMedicalRecordByID(Integer MedicalRecordID) {
		return MedicalRecordDAL.getMedicalRecordByID(MedicalRecordID);
	}

	public static MedicalRecordArray getMedicalRecordByStatus(String MedicalRecordStatus) {
		return MedicalRecordDAL.getMedicalRecordByStatus(MedicalRecordStatus);

	}

	public static ServerResponseIntOutput addMedicalRecord(MedicalRecord MedicalRecorda) {
		return MedicalRecordDAL.addMedicalRecord(MedicalRecorda);
	}

	public static ServerResponse updateMedicalRecord(MedicalRecord MedicalRecorda) {

		return MedicalRecordDAL.updateMedicalRecord(MedicalRecorda);
	}

	public static ServerResponse deleteMedicalRecord(Integer MedicalRecordID) {
		return MedicalRecordDAL.deleteMedicalRecord(MedicalRecordID);
	}

	public static MedicalRecordArray getMedicalRecordByPatientID(Integer PatientID) {
		return MedicalRecordDAL.getMedicalRecordByPatientID(PatientID);
	}
}
