package BLL;

import DAL.EmployeeDAL;
import Models.Data.DataModel;
import Models.Employee.EmployeeArray;
import Models.Employee.EmployeeModel;

public class EmployeeManager {

	public static EmployeeArray getAllParamedics(DataModel superSSN) {

		return EmployeeDAL.getAllParamedics(superSSN);
	}

	public static EmployeeArray getActiveParamedics(DataModel superSSN) {

		return EmployeeDAL.getActiveParamedics(superSSN);
	}

	public static EmployeeArray getInActiveParamedics(DataModel superSSN) {

		return EmployeeDAL.getInActiveParamedics(superSSN);
	}

	public static EmployeeArray getAllDrivers(DataModel superSSN) {

		return EmployeeDAL.getAllDrivers(superSSN);
	}

	public static EmployeeArray getActiveDrivers(DataModel superSSN) {

		return EmployeeDAL.getActiveDrivers(superSSN);
	}

	public static EmployeeArray getInActiveDrivers(DataModel superSSN) {

		return EmployeeDAL.getInActiveDrivers(superSSN);
	}
	
	public static EmployeeModel getDatabyEmployeeID(DataModel EID) {
		
		return EmployeeDAL.getDatabyEmployeeID(EID);
	}

}
