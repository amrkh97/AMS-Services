package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.Employee.EmployeeModel;

public class EmployeeDAL {
	
	public static ArrayList<EmployeeModel> getAllParamedics() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllParamedics]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				EmployeeModel currentEmployee= new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				
				
				 allParamedics.add(currentEmployee);
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

		return allParamedics;
	}
	
	public static ArrayList<EmployeeModel> getActiveParamedics() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Paramedics]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				EmployeeModel currentEmployee= new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				
				
				 allParamedics.add(currentEmployee);
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

		return allParamedics;
	}
	
	public static ArrayList<EmployeeModel> getInActiveParamedics() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveParamedics]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				EmployeeModel currentEmployee= new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				
				
				 allParamedics.add(currentEmployee);
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

		return allParamedics;
	}
	
	//------------------------------------------------------------//
	
	public static ArrayList<EmployeeModel> getAllDrivers() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllDrivers]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				EmployeeModel currentEmployee= new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				
				
				 allParamedics.add(currentEmployee);
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

		return allParamedics;
	}
	
	public static ArrayList<EmployeeModel> getActiveDrivers() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Drivers]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				EmployeeModel currentEmployee= new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				
				
				 allParamedics.add(currentEmployee);
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

		return allParamedics;
	}
	
	public static ArrayList<EmployeeModel> getInActiveDrivers() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveDrivers]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				EmployeeModel currentEmployee= new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				
				
				 allParamedics.add(currentEmployee);
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

		return allParamedics;
	}
	
}
