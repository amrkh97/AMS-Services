package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.Company.*;

public class CompanyDAL {

public static ArrayList<CompanyModel> getAllCompanies() {
		
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectAll]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<CompanyModel> allCompanies = new ArrayList<>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				CompanyModel currentCompany= new CompanyModel();
				currentCompany.setCompanyID(RS.getInt("CompanyID"));
				currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
				currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
				currentCompany.setCompanyName(RS.getString("CompanyName"));
				currentCompany.setCompanyStatus(RS.getInt("CompanyStatus"));
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
		
		
		
		return allCompanies;
	}
		
public static CompanyModel getCompanyByName(String companyName) {
		
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Select] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		
		CompanyModel currentCompany= new CompanyModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);	
			cstmt.setString(1, companyName);
			RS=cstmt.executeQuery();
			
			RS.next();
				
				currentCompany= new CompanyModel();
				currentCompany.setCompanyID(RS.getInt("CompanyID"));
				currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
				currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
				currentCompany.setCompanyName(RS.getString("CompanyName"));
				currentCompany.setCompanyStatus(RS.getInt("CompanyStatus"));
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

public static CompanyModel getCompanyByID(Integer companyID) {
	
	String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectByID] ?";
	ResultSet RS;
	Connection conn = DBManager.getDBConn();
	
	CompanyModel currentCompany= new CompanyModel();
	try {
		CallableStatement cstmt = conn.prepareCall(SPsql);	
		cstmt.setInt(1, companyID);
		RS=cstmt.executeQuery();
		
		RS.next();
			
			currentCompany= new CompanyModel();
			currentCompany.setCompanyID(RS.getInt("CompanyID"));
			currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
			currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
			currentCompany.setCompanyName(RS.getString("CompanyName"));
			currentCompany.setCompanyStatus(RS.getInt("CompanyStatus"));
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

public static CompanyModel getCompanyByStatus(Integer companyStatus) {
	
	String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_SelectBySts] ?";
	ResultSet RS;
	Connection conn = DBManager.getDBConn();
	
	CompanyModel currentCompany= new CompanyModel();
	try {
		CallableStatement cstmt = conn.prepareCall(SPsql);	
		cstmt.setInt(1, companyStatus);
		RS=cstmt.executeQuery();
		
		RS.next();
			
			currentCompany= new CompanyModel();
			
			currentCompany.setCompanyID(RS.getInt("CompanyID"));
			currentCompany.setCompanyAddress(RS.getString("CompanyAddress"));
			currentCompany.setCompanyContactPerson(RS.getString("ContactPerson"));
			currentCompany.setCompanyName(RS.getString("CompanyName"));
			currentCompany.setCompanyStatus(RS.getInt("CompanyStatus"));
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

public static String addCompany(CompanyModel companyToBeAdded) {
	
	String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Insert] ?,?,?,?,?";
	String resultofQuery = "04";
	Connection conn = DBManager.getDBConn();
	
	try {
		CallableStatement cstmt = conn.prepareCall(SPsql);	
		
		cstmt.setString(1,companyToBeAdded.getCompanyName().toLowerCase());
		cstmt.setString(2,companyToBeAdded.getCompanyContactPerson());
		cstmt.setString(3,companyToBeAdded.getCompanyAddress());
		cstmt.setString(4,companyToBeAdded.getCompanyPhoneNumber());
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
	
	
	
	return resultofQuery;
	}

public static String updateCompany(CompanyModel companyToBeAdded) {
	
	String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Update] ?,?,?,?,?,?";
	String resultofQuery = "04";
	Connection conn = DBManager.getDBConn();

	try {
		CallableStatement cstmt = conn.prepareCall(SPsql);	
		cstmt.setInt(1,   companyToBeAdded.getCompanyID());
		cstmt.setString(2,companyToBeAdded.getCompanyName().toLowerCase());
		cstmt.setString(3,companyToBeAdded.getCompanyContactPerson());
		cstmt.setString(4,companyToBeAdded.getCompanyAddress());
		cstmt.setString(5,companyToBeAdded.getCompanyPhoneNumber());
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
	
	
	
	return resultofQuery;
	}

public static String deleteCompany(Integer companyToBeDeleted) {
	
	String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_PharmaCompany_Delete] ?,?";
	String resultofQuery = "04";
	Connection conn = DBManager.getDBConn();
	
	try {
		CallableStatement cstmt = conn.prepareCall(SPsql);	
		
		cstmt.setInt(1,companyToBeDeleted);
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
	
	
	
	return resultofQuery;
	}

}