package BLL;

import DAL.CompanyDAL;
import Models.Company.CompanyArray;
import Models.Company.CompanyModel;
import Models.Data.DataModel;

public class CompanyManager {

	public static CompanyArray getAllCompanies() {
		return CompanyDAL.getAllCompanies();
	}

	public static CompanyModel getCompanyByName(DataModel companyName) {
		return CompanyDAL.getCompanyByName(companyName);
	}

	public static CompanyModel getCompanyByID(DataModel companyID) {
		return CompanyDAL.getCompanyByID(companyID);
	}
	
	public static CompanyArray getCompanyByStatus(DataModel companyStatus) {
		return CompanyDAL.getCompanyByStatus(companyStatus);
	}

	public static DataModel addCompany(CompanyModel companyToBeAdded) {
		return CompanyDAL.addCompany(companyToBeAdded);
	}

	public static DataModel updateCompany(CompanyModel companyToBeAdded) {
		return CompanyDAL.updateCompany(companyToBeAdded);
	}

	public static DataModel deleteCompany(DataModel companyToBeDeleted) {
		return CompanyDAL.deleteCompany(companyToBeDeleted);
	}
}
