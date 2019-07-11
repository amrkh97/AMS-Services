package BLL;

import DAL.CompanyDAL;
import Models.Company.CompanyModel;
import Models.Data.DataArrayModel;
import Models.Data.DataModel;

public class CompanyManager {

	public static DataArrayModel<CompanyModel> getAllCompanies() {
		return CompanyDAL.getAllCompanies();
	}

	public static CompanyModel getCompanyByName(DataModel companyName) {
		return CompanyDAL.getCompanyByName(companyName);
	}

	public static CompanyModel getCompanyByID(DataModel companyID) {
		return CompanyDAL.getCompanyByID(companyID);
	}
	
	public static DataArrayModel<CompanyModel> getCompanyByStatus(DataModel companyStatus) {
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
