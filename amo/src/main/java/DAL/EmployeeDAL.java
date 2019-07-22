package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.Employee.AttendanceTimeArray;
import Models.Employee.AttendanceTimeModel;
import Models.Employee.EmployeeArray;
import Models.Employee.EmployeeModel;
import Models.Employee.EmployeeSentModel;

public class EmployeeDAL {

	public static EmployeeArray getAllEmployees(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getAll] ?,?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			cstmt.setInt(2, superSSN.getJobID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EmployeeModel currentEmployee = new EmployeeModel();
				currentEmployee.setEid(RS.getInt(1));
				currentEmployee.setFullName(RS.getString(2) + " " + RS.getString(3));
				currentEmployee.setFirstName(RS.getString(2));
				currentEmployee.setLastName(RS.getString(3));
				currentEmployee.setEmail(RS.getString(4));
				currentEmployee.setContactNumber(RS.getString(5));
				currentEmployee.setPan(RS.getString(6));
				currentEmployee.setNationalID(RS.getString(7));
				currentEmployee.setEmployeeStatus(RS.getString(8));
				currentEmployee.setPhoto(RS.getString(9));
				currentEmployee.setAge(RS.getString(10));
				currentEmployee.setGender(RS.getString(11));
				currentEmployee.setCity(RS.getString(12));
				currentEmployee.setJobID(RS.getInt(13));
				currentEmployee.setJobTitle(RS.getString(14));

				allParamedics.add(currentEmployee);
			}
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getAllParamedics(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllParamedics] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
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
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getActiveParamedics(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Paramedics] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
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
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getInActiveParamedics(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveParamedics] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
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
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	// ------------------------------------------------------------//

	public static EmployeeArray getAllDrivers(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllDrivers] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
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
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getActiveDrivers(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Drivers] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
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
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getInActiveDrivers(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveDrivers] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
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
			RS.close();

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
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	// -----------------------------------------------------------------------------//

	public static EmployeeModel getDatabyEmployeeID(EmployeeSentModel superSSN) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getDatabyEmployeeID] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		EmployeeModel currentEmployee = new EmployeeModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, superSSN.getSentID());
			RS = cstmt.executeQuery();

			RS.next();

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
			currentEmployee.setGender(RS.getString(11));
			currentEmployee.setBirthDate(RS.getString(12));
			currentEmployee.setCountry(RS.getString(13));
			currentEmployee.setCity(RS.getString(14));
			currentEmployee.setSubscriptionDate(RS.getString(15));
			currentEmployee.setLogInStamp(RS.getString(16));
			currentEmployee.setLogInGPS(RS.getString(17));
			currentEmployee.setSuperSSN(RS.getInt(18));
			currentEmployee.setJobID(RS.getInt(19));
			currentEmployee.setLogOutStamp(RS.getString(20));
			currentEmployee.setLogInStatus(RS.getString(21));

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
		return currentEmployee;
	}

	// -----------------------------------------------------------------------------//

	public static AttendanceTimeArray getAllAttendanceTimes(EmployeeSentModel employeeID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getLogTimes] ?";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<AttendanceTimeModel> allAttendanceTimes = new ArrayList<AttendanceTimeModel>();
		AttendanceTimeArray OBJ = new AttendanceTimeArray();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, employeeID.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				AttendanceTimeModel attendanceTimes = new AttendanceTimeModel();

				String logDate = RS.getString(1);
				String arrayStrings[] = logDate.split(" ");

				attendanceTimes.setLogInDate(arrayStrings[0]);
				attendanceTimes.setLogInTime(arrayStrings[1]);

				logDate = RS.getString(2);
				arrayStrings = logDate.split(" ");

				attendanceTimes.setLogOutDate(arrayStrings[0]);
				attendanceTimes.setLogOutTime(arrayStrings[1]);

				Integer inMinutes = Integer.parseInt(RS.getString(3));

				Double inHours = (double) (inMinutes / 60.0);
				Integer workHours = (int) Math.floor(inHours);
				Double workMinutes = (inHours - Math.floor(inHours)) * 60.0;
				attendanceTimes.setWorkingHours(workHours.toString());
				attendanceTimes.setWorkingMinutes(workMinutes.toString());
				attendanceTimes.setWorkingTime(attendanceTimes.getWorkingHours()+":"+attendanceTimes.getWorkingMinutes());
				allAttendanceTimes.add(attendanceTimes);
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
		OBJ.setAttendanceArray(allAttendanceTimes);
		return OBJ;

	}

}
