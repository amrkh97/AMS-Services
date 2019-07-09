package BLL;

import java.util.ArrayList;

import DAL.CompanyDAL;
import Models.Company.CompanyModel;

public class CompanyManager {

	public static ArrayList<CompanyModel> getAllCompanies() {
		return CompanyDAL.getAllCompanies();
	}

	public static CompanyModel getCompanyByName(String companyName) {
		return CompanyDAL.getCompanyByName(companyName);
	}

	public static CompanyModel getCompanyByID(Integer companyID) {
		return CompanyDAL.getCompanyByID(companyID);
	}

	public static CompanyModel getCompanyByStatus(Integer companyStatus) {
		return CompanyDAL.getCompanyByStatus(companyStatus);
	}

	public static String addCompany(CompanyModel companyToBeAdded) {
		return CompanyDAL.addCompany(companyToBeAdded);
	}

	public static String updateCompany(CompanyModel companyToBeAdded) {
		return CompanyDAL.updateCompany(companyToBeAdded);
	}

	public static String deleteCompany(Integer companyToBeDeleted) {
		return CompanyDAL.deleteCompany(companyToBeDeleted);
	}
}
