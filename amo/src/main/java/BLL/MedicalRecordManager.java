package BLL;

import DAL.MedicalRecordDAL;
import Models.ServerResponse;
import Models.ServerResponseIntOutput;
import Models.Data.DataArrayModel;
import Models.MedicalRecord.MedicalRecord;

public class MedicalRecordManager {

	public static DataArrayModel<MedicalRecord> getAllMedicalRecords() {
		return MedicalRecordDAL.getAllMedicalRecords();
	}

	public static DataArrayModel<MedicalRecord> getMedicalRecordByID(Integer MedicalRecordID) {
		return MedicalRecordDAL.getMedicalRecordByID(MedicalRecordID);
	}

	public static DataArrayModel<MedicalRecord> getMedicalRecordByStatus(String MedicalRecordStatus) {
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

	public static DataArrayModel<MedicalRecord> getMedicalRecordByPatientID(Integer PatientID) {
		return MedicalRecordDAL.getMedicalRecordByPatientID(PatientID);
	}
}
