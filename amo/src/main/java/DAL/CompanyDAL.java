package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import Models.ServerResponse;
import Models.Company.CompanyArray;
import Models.Company.CompanyModel;
import Models.Medicine.Medicine;
import Models.Medicine.MedicineArray;

public class CompanyDAL {

	public static CompanyArray getAllCompanies(Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectAll]";
		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<CompanyModel> allCompanies = new ArrayList<>();
		CompanyArray OBJ = new CompanyArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				CompanyModel currentCompany = new CompanyModel();
				currentCompany.setCompanyID(RS.getInt("CompanyID"));
				currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
				currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
				currentCompany.setCompanyName(RS.getString("CompanyName"));
				currentCompany.setCompanyStatus(RS.getString("CompanyStatus"));
				currentCompany.setCompanyPhoneNumber(RS.getString("CompanyPhone"));

				allCompanies.add(currentCompany);
			}
			RS.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setCompanyArray(allCompanies);
		return OBJ;
	}

	public static CompanyModel getCompanyByName(CompanyModel companyName, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Select] ?";
		ResultSet RS;
		Connection conn = intermediateConnection;

		CompanyModel currentCompany = new CompanyModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, companyName.getCompanyName());
			RS = cstmt.executeQuery();

			if(RS.next()) {
			currentCompany = new CompanyModel();
			currentCompany.setCompanyID(RS.getInt("CompanyID"));
			currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
			currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
			currentCompany.setCompanyName(RS.getString("CompanyName"));
			currentCompany.setCompanyStatus(RS.getString("CompanyStatus"));
			currentCompany.setCompanyPhoneNumber(RS.getString("CompanyPhone"));
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		
		return currentCompany;
	}

	public static CompanyModel getCompanyByID(CompanyModel companyID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectByID] ?";
		ResultSet RS;
		Connection conn = intermediateConnection;

		CompanyModel currentCompany = new CompanyModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, companyID.getCompanyID());
			RS = cstmt.executeQuery();

			if(RS.next()) {

			currentCompany = new CompanyModel();
			currentCompany.setCompanyID(RS.getInt("CompanyID"));
			currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
			currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
			currentCompany.setCompanyName(RS.getString("CompanyName"));
			currentCompany.setCompanyStatus(RS.getString("CompanyStatus"));
			currentCompany.setCompanyPhoneNumber(RS.getString("CompanyPhone"));
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return currentCompany;
	}

	public static CompanyArray getCompanyByStatus(CompanyModel companyStatus, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectBySts] ?";
		ResultSet RS;
		Connection conn = intermediateConnection;
		CompanyArray OBJ = new CompanyArray();
		ArrayList<CompanyModel> AllcurrentCompany = new ArrayList<CompanyModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, companyStatus.getCompanyStatus());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				CompanyModel currentCompany = new CompanyModel();

				currentCompany.setCompanyID(RS.getInt("CompanyID"));
				currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
				currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
				currentCompany.setCompanyName(RS.getString("CompanyName"));
				currentCompany.setCompanyStatus(RS.getString("CompanyStatus"));
				currentCompany.setCompanyPhoneNumber(RS.getString("CompanyPhone"));
				AllcurrentCompany.add(currentCompany);
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		
		OBJ.setCompanyArray(AllcurrentCompany);
		return OBJ;
	}

	public static ServerResponse addCompany(CompanyModel companyToBeAdded, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Insert] ?,?,?,?,?";
		String resultofQuery = "04";
		Connection conn = intermediateConnection;
		ServerResponse OBJ = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, companyToBeAdded.getCompanyName().toLowerCase());
			cstmt.setString(2, companyToBeAdded.getCompanyContactPerson());
			cstmt.setString(3, companyToBeAdded.getCompanyAddress());
			cstmt.setString(4, companyToBeAdded.getCompanyPhoneNumber());
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.execute();

			resultofQuery = cstmt.getString(5);

		} catch (SQLException e) {

			e.printStackTrace();
		} 
		
		OBJ.setResponseHexCode(resultofQuery);
		if (OBJ.getResponseHexCode().equals("00")) {
			OBJ.setResponseMsg("Insertion Success");
		} else if (OBJ.getResponseHexCode().equals("01")) {
			OBJ.setResponseMsg("Company Already Exists");
		} else {
			OBJ.setResponseMsg("Company Name was not sent correctly!");
		}
		return OBJ;
	}

	public static ServerResponse updateCompany(CompanyModel companyToBeAdded, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Update] ?,?,?,?,?,?";
		String resultofQuery = "04";
		Connection conn = intermediateConnection;
		ServerResponse OBJ = new ServerResponse();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, companyToBeAdded.getCompanyID());
			cstmt.setString(2, companyToBeAdded.getCompanyName().toLowerCase());
			cstmt.setString(3, companyToBeAdded.getCompanyContactPerson());
			cstmt.setString(4, companyToBeAdded.getCompanyAddress());
			cstmt.setString(5, companyToBeAdded.getCompanyPhoneNumber());
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.executeUpdate();

			resultofQuery = cstmt.getString(6);

		} catch (SQLException e) {

			e.printStackTrace();
		} 
		
		OBJ.setResponseHexCode(resultofQuery);
		if (OBJ.getResponseHexCode().equals("00")) {
			OBJ.setResponseMsg("Update Succesfull");
		} else {
			OBJ.setResponseMsg("Update Failed! Company Doesn't exist");
		}
		return OBJ;
	}

	public static ServerResponse deleteCompany(CompanyModel companyToBeDeleted, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Delete] ?,?";
		String resultofQuery = "04";
		Connection conn = intermediateConnection;
		ServerResponse OBJ = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, companyToBeDeleted.getCompanyID());
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.executeUpdate();

			resultofQuery = cstmt.getString(2);

		} catch (SQLException e) {

			e.printStackTrace();
		} 
		
		OBJ.setResponseHexCode(resultofQuery);
		if (OBJ.getResponseHexCode().equals("00")) {
			OBJ.setResponseMsg("Deletion Succesfull");
		} else {
			OBJ.setResponseMsg("Delete Failed!");
		}
		return OBJ;
	}

	public static MedicineArray getAllMedicinesbyCompany(Integer companyID,Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO; EXEC usp_PharmaCompany_SelectAllMedicines ?";
		Connection conn = intermediateConnection;
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, companyID);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				medicine = new Medicine();
				medicine.setBarCode(rs.getString("BarCode"));
				medicine.setPrice(rs.getString("Price"));
				medicine.setCountInStock(rs.getInt("CountInStock"));
				medicine.setImplications(rs.getString("Implications"));
				medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				medicine.setSideEffects(rs.getString("SideEffects"));
				medicine.setActiveComponent(rs.getString("ActiveComponent"));
				medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				medicine.setMedicineName(rs.getString("MedicineName"));
				medicineList.add(medicine);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

}