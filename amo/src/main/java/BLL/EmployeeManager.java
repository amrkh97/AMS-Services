package BLL;

import DAL.EmployeeDAL;
import Models.Employee.EmployeeArray;
import Models.Employee.EmployeeModel;
import Models.Employee.EmployeeSentModel;

public class EmployeeManager {

	
	public static EmployeeArray getAllEmployees(EmployeeSentModel superSSN) {

		return EmployeeDAL.getAllEmployees(superSSN);
	}
	
	public static EmployeeArray getAllParamedics(EmployeeSentModel superSSN) {

		return EmployeeDAL.getAllParamedics(superSSN);
	}

	public static EmployeeArray getActiveParamedics(EmployeeSentModel superSSN) {

		return EmployeeDAL.getActiveParamedics(superSSN);
	}

	public static EmployeeArray getInActiveParamedics(EmployeeSentModel superSSN) {

		return EmployeeDAL.getInActiveParamedics(superSSN);
	}

	public static EmployeeArray getAllDrivers(EmployeeSentModel superSSN) {

		return EmployeeDAL.getAllDrivers(superSSN);
	}

	public static EmployeeArray getActiveDrivers(EmployeeSentModel superSSN) {

		return EmployeeDAL.getActiveDrivers(superSSN);
	}

	public static EmployeeArray getInActiveDrivers(EmployeeSentModel superSSN) {

		return EmployeeDAL.getInActiveDrivers(superSSN);
	}
	
	public static EmployeeModel getDatabyEmployeeID(EmployeeSentModel EID) {
		
		return EmployeeDAL.getDatabyEmployeeID(EID);
	}

}
