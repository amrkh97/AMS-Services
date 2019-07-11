package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.Data.DataArrayModel;
import Models.Data.DataModel;
import Models.Employee.EmployeeModel;

public class EmployeeDAL {

	public static DataArrayModel<EmployeeModel> getAllParamedics(DataModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllParamedics] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		DataArrayModel<EmployeeModel> OBJ = new DataArrayModel<EmployeeModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
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
		OBJ.set_ArrayList(allParamedics);
		return OBJ;
	}

	public static DataArrayModel<EmployeeModel> getActiveParamedics(DataModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Paramedics] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		DataArrayModel<EmployeeModel> OBJ = new DataArrayModel<EmployeeModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
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
		OBJ.set_ArrayList(allParamedics);
		return OBJ;
	}

	public static DataArrayModel<EmployeeModel> getInActiveParamedics(DataModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveParamedics] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		DataArrayModel<EmployeeModel> OBJ = new DataArrayModel<EmployeeModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
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
		OBJ.set_ArrayList(allParamedics);
		return OBJ;
	}

	// ------------------------------------------------------------//

	public static DataArrayModel<EmployeeModel> getAllDrivers(DataModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllDrivers] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		DataArrayModel<EmployeeModel> OBJ = new DataArrayModel<EmployeeModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
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
		OBJ.set_ArrayList(allParamedics);
		return OBJ;
	}

	public static DataArrayModel<EmployeeModel> getActiveDrivers(DataModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Drivers] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		DataArrayModel<EmployeeModel> OBJ = new DataArrayModel<EmployeeModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
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
		OBJ.set_ArrayList(allParamedics);
		return OBJ;
	}

	public static DataArrayModel<EmployeeModel> getInActiveDrivers(DataModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveDrivers] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		DataArrayModel<EmployeeModel> OBJ = new DataArrayModel<EmployeeModel>();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
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
		OBJ.set_ArrayList(allParamedics);
		return OBJ;
	}

}
