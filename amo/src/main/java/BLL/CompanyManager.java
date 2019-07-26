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
		Connection intermediateConnection = DBManager.getDBConn();
		CompanyArray obj = new CompanyArray();
		try {
			obj = CompanyDAL.getAllCompanies(intermediateConnection);
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

	public static CompanyModel getCompanyByName(CompanyModel companyName) {
		Connection intermediateConnection = DBManager.getDBConn();
		CompanyModel obj = new CompanyModel();
		try {
			obj = CompanyDAL.getCompanyByName(companyName, intermediateConnection);
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

	public static CompanyModel getCompanyByID(CompanyModel companyID) {
		Connection intermediateConnection = DBManager.getDBConn();
		CompanyModel obj = new CompanyModel();
		try {
			obj = CompanyDAL.getCompanyByID(companyID, intermediateConnection);
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

	public static CompanyArray getCompanyByStatus(CompanyModel companyStatus) {
		Connection intermediateConnection = DBManager.getDBConn();
		CompanyArray obj = new CompanyArray();
		try {
			obj = CompanyDAL.getCompanyByStatus(companyStatus, intermediateConnection);
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

	public static ServerResponse addCompany(CompanyModel companyToBeAdded) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse obj = new ServerResponse();
		try {
			obj = CompanyDAL.addCompany(companyToBeAdded, intermediateConnection);
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

	public static ServerResponse updateCompany(CompanyModel companyToBeAdded) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse obj = new ServerResponse();
		try {
			obj = CompanyDAL.updateCompany(companyToBeAdded, intermediateConnection);
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

	public static ServerResponse deleteCompany(CompanyModel companyToBeDeleted) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse obj = new ServerResponse();
		try {
			obj = CompanyDAL.deleteCompany(companyToBeDeleted, intermediateConnection);
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
