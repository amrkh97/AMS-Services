package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.EmployeeDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.Employee.AttendanceTimeArray;
import Models.Employee.EmployeeArray;
import Models.Employee.EmployeeModel;
import Models.Employee.EmployeeSentModel;

public class EmployeeManager {

	public static AttendanceTimeArray getAllAttendanceTimes(EmployeeSentModel employeeID) {
		Connection intermediateConnection = DBManager.getDBConn();
		AttendanceTimeArray model = new AttendanceTimeArray();
		try {
			model = EmployeeDAL.getAllAttendanceTimes(employeeID,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getAllEmployees(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getAllEmployees(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getAllParamedics(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getAllParamedics(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getActiveParamedics(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getActiveParamedics(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getInActiveParamedics(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getInActiveParamedics(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getAllDrivers(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getAllDrivers(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getActiveDrivers(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getActiveDrivers(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getInActiveDrivers(EmployeeSentModel superSSN) {

		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getInActiveDrivers(superSSN,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeModel getDatabyEmployeeID(EmployeeSentModel EID) {
		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeModel model = new EmployeeModel();
		try {
			model = EmployeeDAL.getDatabyEmployeeID(EID,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static ServerResponse printEmployeeLogsByID(EmployeeSentModel employeeID) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = EmployeeDAL.printEmployeeLogsByID(employeeID,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getUnverifiedEmployees() {
		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getUnverifiedEmployees(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	
	}

	public static ServerResponse verifyEmployee(EmployeeSentModel employeeToBeVerified) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = EmployeeDAL.verifyEmployee(employeeToBeVerified,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static EmployeeArray getEmployeeWithPassword() {
		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getEmployeeWithPassword(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	
	
	}

	public static EmployeeArray getAssignedParamedics() {
		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getAssignedParamedics(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	public static EmployeeArray getNotAssignedParamedics() {
		Connection intermediateConnection = DBManager.getDBConn();
		EmployeeArray model = new EmployeeArray();
		try {
			model = EmployeeDAL.getNotAssignedParamedics(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

}
