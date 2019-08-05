package DAL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Models.ServerResponse;
import Models.Employee.AttendanceTimeArray;
import Models.Employee.AttendanceTimeModel;
import Models.Employee.EmployeeArray;
import Models.Employee.EmployeeModel;
import Models.Employee.EmployeeSentModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class EmployeeDAL {

	public static EmployeeArray getAllEmployees(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getAll] ?,?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getAllParamedics(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllParamedics] ?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getActiveParamedics(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Paramedics] ?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getInActiveParamedics(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveParamedics] ?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	// ------------------------------------------------------------//

	public static EmployeeArray getAllDrivers(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AllDrivers] ?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getActiveDrivers(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_Drivers] ?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	public static EmployeeArray getInActiveDrivers(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_InActiveDrivers] ?";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}
		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

	// -----------------------------------------------------------------------------//

	public static EmployeeModel getDatabyEmployeeID(EmployeeSentModel superSSN, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getDatabyEmployeeID] ?";
		ResultSet RS;
		 
		EmployeeModel currentEmployee = new EmployeeModel();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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

			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return currentEmployee;
	}

	// -----------------------------------------------------------------------------//

	public static AttendanceTimeArray getAllAttendanceTimes(EmployeeSentModel employeeID,
			Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getLogTimes] ?";
		ResultSet RS;
		 
		ArrayList<AttendanceTimeModel> allAttendanceTimes = new ArrayList<AttendanceTimeModel>();
		AttendanceTimeArray OBJ = new AttendanceTimeArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setInt(1, employeeID.getSentID());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				AttendanceTimeModel attendanceTimes = new AttendanceTimeModel();

				String logDate = RS.getString(1);
				String arrayStrings[] = logDate.split(" ");
				attendanceTimes.setLogInDate(arrayStrings[0]);
				String arrayLogInStrings[] = arrayStrings[1].split("\\.");
				
				String lengthLog = arrayLogInStrings[0];
				
				if(lengthLog.length() < 8) {
					lengthLog = "0"+lengthLog;
				}
				attendanceTimes.setLogInTime(lengthLog);

				logDate = RS.getString(2);
				arrayStrings = logDate.split(" ");
				attendanceTimes.setLogOutDate(arrayStrings[0]);
				arrayLogInStrings = arrayStrings[1].split("\\.");
				
				lengthLog = arrayLogInStrings[0];
				
				if(lengthLog.length() < 8) {
					lengthLog = "0"+lengthLog;
				}
				
				attendanceTimes.setLogOutTime(lengthLog);
				
				if(attendanceTimes.getLogInTime().equals(attendanceTimes.getLogOutTime())) {
					attendanceTimes.setLogOutTime("Still Active");
				}
				
				
				Integer inMinutes = Integer.parseInt(RS.getString(3));

				Double inHours = (double) (inMinutes / 60.0);
				Integer workHours = (int) Math.floor(inHours);
				
				Integer workMinutes = (int)(Math.ceil((inHours - Math.floor(inHours)) * 60.0));
				
				String hoursInString = workHours.toString();
				String minutesInString = workMinutes.toString();
				
				if(hoursInString.length() == 1) {
					hoursInString = "0" + hoursInString;
				}
				
				if(minutesInString.length() == 1) {
					minutesInString = "0" + minutesInString;
				}
				attendanceTimes.setWorkingHours(hoursInString);
				attendanceTimes.setWorkingMinutes(minutesInString);
				attendanceTimes.setWorkingTime(attendanceTimes.getWorkingHours() + ":" + attendanceTimes.getWorkingMinutes());
				allAttendanceTimes.add(attendanceTimes);
			}
			RS.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		OBJ.setAttendanceArray(allAttendanceTimes);
		return OBJ;

	}

	public static ServerResponse printEmployeeLogsByID(EmployeeSentModel employeeID,
			Connection intermediateConnection) {

		ServerResponse response = new ServerResponse();
		try {
			ArrayList<AttendanceTimeModel> arrayList = new ArrayList<AttendanceTimeModel>();

			arrayList = EmployeeDAL.getAllAttendanceTimes(employeeID, intermediateConnection).getAttendanceArray();
			System.out.println("Recieved Response: " + arrayList.get(0).getLogInTime());

			JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(arrayList);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("AttendanceDataSource", itemsJRBean);
			String path = new File("C:\\Users\\amrkh\\Desktop\\AttendanceReport.pdf").getAbsolutePath();
			JasperReport reportJas = JasperCompileManager
					.compileReport("C:\\\\Users\\\\amrkh\\\\Desktop\\\\attendanceRecords.jrxml");
			JasperPrint filledreport = JasperFillManager.fillReport(reportJas, parameters, new JREmptyDataSource());
			OutputStream outputStream = new FileOutputStream(new File(path));
			JasperExportManager.exportReportToPdfStream(filledreport, outputStream);
			outputStream.close();

			response.setResponseHexCode("00");
			response.setResponseMsg("Printed Successfully.");
		} catch (NullPointerException | JRException | IOException e) {
			e.printStackTrace();

			response.setResponseHexCode("01");
			response.setResponseMsg("Error In Printing!");

		}

		return response;
	}

	public static EmployeeArray getUnverifiedEmployees(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getUnverified]";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allUnverified = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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

				allUnverified.add(currentEmployee);
			}
			RS.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		OBJ.setEmployeeArray(allUnverified);
		return OBJ;
	}

	public static ServerResponse verifyEmployee(EmployeeSentModel employeeToBeVerified, Connection intermediateConnection) {
		
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Employee_Verify] ?,?,?";
		ServerResponse response = new ServerResponse();
		 
		try {
			
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setInt(1,  employeeToBeVerified.getSentID());
			cstmt.setInt(2,  employeeToBeVerified.getSuperSSN());
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.executeUpdate();
			
			response.setResponseHexCode(cstmt.getString(3));
			if(response.getResponseHexCode().equals("00"))
				response.setResponseMsg("Verified Succesfully!");
			else
				response.setResponseMsg("User Already Verified!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return response;
	}

	public static EmployeeArray getEmployeeWithPassword(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_getEmployeeWithPassword]";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allUnverified = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
				currentEmployee.setLogInStatus(RS.getString(15));
				currentEmployee.setPassword(RS.getString(16));

				allUnverified.add(currentEmployee);
			}
			RS.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		OBJ.setEmployeeArray(allUnverified);
		return OBJ;
	}

	public static EmployeeArray getAssignedParamedics(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_AssignedParamedics] ";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}
	
	public static EmployeeArray getNotAssignedParamedics(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[get_Employee_NotAssignedParamedics] ";
		ResultSet RS;
		 
		ArrayList<EmployeeModel> allParamedics = new ArrayList<EmployeeModel>();
		EmployeeArray OBJ = new EmployeeArray();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
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
		}

		OBJ.setEmployeeArray(allParamedics);
		return OBJ;
	}

}
