package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.Company.CompanyArray;
import Models.Company.CompanyModel;
import Models.Data.DataModel;

public class CompanyDAL {

	public static CompanyArray getAllCompanies() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectAll]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
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

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.setCompanyArray(allCompanies);
		return OBJ;
	}

	public static CompanyModel getCompanyByName(DataModel companyName) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Select] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();

		CompanyModel currentCompany = new CompanyModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, companyName.getSentStatus());
			RS = cstmt.executeQuery();

			RS.next();

			currentCompany = new CompanyModel();
			currentCompany.setCompanyID(RS.getInt("CompanyID"));
			currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
			currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
			currentCompany.setCompanyName(RS.getString("CompanyName"));
			currentCompany.setCompanyStatus(RS.getString("CompanyStatus"));
			currentCompany.setCompanyPhoneNumber(RS.getString("CompanyPhone"));

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return currentCompany;
	}

	public static CompanyModel getCompanyByID(DataModel companyID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectByID] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();

		CompanyModel currentCompany = new CompanyModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, companyID.getSentID());
			RS = cstmt.executeQuery();

			RS.next();

			currentCompany = new CompanyModel();
			currentCompany.setCompanyID(RS.getInt("CompanyID"));
			currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
			currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
			currentCompany.setCompanyName(RS.getString("CompanyName"));
			currentCompany.setCompanyStatus(RS.getString("CompanyStatus"));
			currentCompany.setCompanyPhoneNumber(RS.getString("CompanyPhone"));

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return currentCompany;
	}

	public static CompanyArray getCompanyByStatus(DataModel companyStatus) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectBySts] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		CompanyArray OBJ = new CompanyArray();
		ArrayList<CompanyModel> AllcurrentCompany = new ArrayList<CompanyModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, companyStatus.getSentStatus());
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

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.setCompanyArray(AllcurrentCompany);
		return OBJ;
	}

	public static DataModel addCompany(CompanyModel companyToBeAdded) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Insert] ?,?,?,?,?";
		String resultofQuery = "04";
		Connection conn = DBManager.getDBConn();
		DataModel OBJ = new DataModel();
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
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.setSentStatus(resultofQuery);
		return OBJ;
	}

	public static DataModel updateCompany(CompanyModel companyToBeAdded) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Update] ?,?,?,?,?,?";
		String resultofQuery = "04";
		Connection conn = DBManager.getDBConn();
		DataModel OBJ = new DataModel();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, companyToBeAdded.getCompanyID());
			cstmt.setString(2, companyToBeAdded.getCompanyName().toLowerCase());
			cstmt.setString(3, companyToBeAdded.getCompanyContactPerson());
			cstmt.setString(4, companyToBeAdded.getCompanyAddress());
			cstmt.setString(5, companyToBeAdded.getCompanyPhoneNumber());
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.execute();

			resultofQuery = cstmt.getString(6);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.setSentStatus(resultofQuery);
		return OBJ;
	}

	public static DataModel deleteCompany(DataModel companyToBeDeleted) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Delete] ?,?";
		String resultofQuery = "04";
		Connection conn = DBManager.getDBConn();
		DataModel OBJ = new DataModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, companyToBeDeleted.getSentID());
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.execute();

			resultofQuery = cstmt.getString(2);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.setSentStatus(resultofQuery);
		return OBJ;
	}

}