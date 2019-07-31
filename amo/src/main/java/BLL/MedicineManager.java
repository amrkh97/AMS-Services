package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.MedicineDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.Medicine.Medicine;
import Models.Medicine.MedicineArray;


public class MedicineManager {

	public static MedicineArray getAllMedicines() {

		return MedicineDAL.getAllMedicines();
	}

	public static Medicine getMedicineByBC(String BarCode) {
		return MedicineDAL.getMedicineByBC(BarCode, null);
	}

	public static Medicine getMedicineByName(String Name) {
		return MedicineDAL.getMedicineByName(Name);
	}

	public static MedicineArray getMedicineByStatus(String Status) {
		return MedicineDAL.getMedicineByStatus(Status);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// GET Medicines by Active Component
	////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////

	public static MedicineArray getMedicineByActiveComponent(String ActiveComponent) {
		return MedicineDAL.getMedicineByActiveComponent(ActiveComponent);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// GET Medicines by Company Name
	////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////

	public static MedicineArray getMedicineByCompanyName(String CompanyName) {
		return MedicineDAL.getMedicineByCompanyName(CompanyName);
	}

	public static MedicineArray getMedicineByCompanyStatus(String CompanyStatus) {
		return MedicineDAL.getMedicineByCompanyStatus(CompanyStatus);
	}

	public static MedicineArray getMedicineByContactPerson(String ContactPerson) {
		return MedicineDAL.getMedicineByContactPerson(ContactPerson);
	}

	public static ServerResponse insertMedicine(Medicine MED) {
		Medicine Array = new Medicine();
		// TODO 2morrow
		Array = MedicineDAL.getMedicineByBC(MED.getBarCode(), null);
		if (Array != null) {
			if (Array.getMedicineStatus().equals("FF")) {
				return MedicineDAL.UpdateMedicineStatus(Array.getBarCode(), "00");
			}
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("01");
			S.setResponseMsg("You already have this medicine in database");
			return S;
		}
		return MedicineDAL.insertMedicine(MED);
	}

	public static ServerResponse UpdateMedicine(Medicine MED) {

		return MedicineDAL.UpdateMedicine(MED);
	}

	public static ServerResponse DeleteMedicine(String BarCode) {

		return MedicineDAL.DeleteMedicine(BarCode);
	}

	public static MedicineArray getMedicinesWithThreshold(Integer count) {
		Connection intermediateConnection = DBManager.getDBConn();
		MedicineArray model = new MedicineArray();
		try {
			model = MedicineDAL.getMedicinesWithThreshold(count,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

}
