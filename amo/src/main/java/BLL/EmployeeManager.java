package BLL;

import DAL.EmployeeDAL;
import Models.Data.DataArrayModel;
import Models.Data.DataModel;
import Models.Employee.EmployeeModel;

public class EmployeeManager {

	public static DataArrayModel<EmployeeModel> getAllParamedics(DataModel superSSN) {

		return EmployeeDAL.getAllParamedics(superSSN);
	}

	public static DataArrayModel<EmployeeModel> getActiveParamedics(DataModel superSSN) {

		return EmployeeDAL.getActiveParamedics(superSSN);
	}

	public static DataArrayModel<EmployeeModel> getInActiveParamedics(DataModel superSSN) {

		return EmployeeDAL.getInActiveParamedics(superSSN);
	}

	public static DataArrayModel<EmployeeModel> getAllDrivers(DataModel superSSN) {

		return EmployeeDAL.getAllDrivers(superSSN);
	}

	public static DataArrayModel<EmployeeModel> getActiveDrivers(DataModel superSSN) {

		return EmployeeDAL.getActiveDrivers(superSSN);
	}

	public static DataArrayModel<EmployeeModel> getInActiveDrivers(DataModel superSSN) {

		return EmployeeDAL.getInActiveDrivers(superSSN);
	}

}
