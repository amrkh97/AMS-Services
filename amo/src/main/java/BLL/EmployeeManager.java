package BLL;

import java.util.ArrayList;

import DAL.EmployeeDAL;
import Models.Employee.EmployeeModel;

public class EmployeeManager {

	public static ArrayList<EmployeeModel> getParamedics() {
	
		return EmployeeDAL.getParamedics();
	}
	
	public static ArrayList<EmployeeModel> getDrivers() {
		
		return EmployeeDAL.getDrivers();
	}
}
