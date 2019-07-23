package BLL;

import java.sql.Connection;
import java.sql.SQLException;
import DAL.CompanyDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.Company.CompanyArray;
import Models.Company.CompanyModel;
import Models.Medicine.MedicineArray;

public class CompanyManager {

	public static CompanyArray getAllCompanies() {
		return CompanyDAL.getAllCompanies();
	}

	public static CompanyModel getCompanyByName(CompanyModel companyName) {
		return CompanyDAL.getCompanyByName(companyName);
	}

	public static CompanyModel getCompanyByID(CompanyModel companyID) {
		return CompanyDAL.getCompanyByID(companyID);
	}

	public static CompanyArray getCompanyByStatus(CompanyModel companyStatus) {
		return CompanyDAL.getCompanyByStatus(companyStatus);
	}

	public static ServerResponse addCompany(CompanyModel companyToBeAdded) {
		return CompanyDAL.addCompany(companyToBeAdded);
	}

	public static ServerResponse updateCompany(CompanyModel companyToBeAdded) {
		return CompanyDAL.updateCompany(companyToBeAdded);
	}

	public static ServerResponse deleteCompany(CompanyModel companyToBeDeleted) {
		return CompanyDAL.deleteCompany(companyToBeDeleted);
	}

	public static MedicineArray getAllMedicinesbyCompany(CompanyModel companyID) {
		Connection intermediateConnection = DBManager.getDBConn();
		MedicineArray obj = new MedicineArray();
		try {
			obj = CompanyDAL.getAllMedicinesbyCompany(companyID.getCompanyID(), intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
		
	}
}
