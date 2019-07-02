package BLL;

import java.util.ArrayList;

import DAL.MedicalRecordDAL;
import Models.ServerResponse;
import Models.MedicalRecord.MedicalRecord;


public class MedicalRecordManager {

	/*
	 * public static ArrayList<MedicalRecord> getAllMedicalRecords(){ return
	 * MedicalRecordDAL.getAllMedicalRecords(); }
	 */
	
	/*
	 * public static ArrayList<MedicalRecord> getMedicalRecordByTitle(String
	 * MedicalRecordTitle) { return
	 * MedicalRecordDAL.getMedicalRecordByTitle(MedicalRecordTitle); }
	 * 
	 * public static ArrayList<MedicalRecord> getMedicalRecordByStatus(String
	 * MedicalRecordStatus) { return
	 * MedicalRecordDAL.getMedicalRecordByStatus(MedicalRecordStatus); }
	 */
	  
	  public static ServerResponse addMedicalRecord(MedicalRecord MedicalRecorda) 
	  {
		  return MedicalRecordDAL.addMedicalRecord(MedicalRecorda);
	  }
	/*
	 * public static ServerResponse updateMedicalRecord(MedicalRecord
	 * MedicalRecorda) { return
	 * MedicalRecordDAL.updateMedicalRecord(MedicalRecorda); }
	 * 
	 * public static ServerResponse deleteMedicalRecord(String MedicalRecordID) {
	 * return MedicalRecordDAL.deleteMedicalRecord(MedicalRecordID); }
	 */
}

