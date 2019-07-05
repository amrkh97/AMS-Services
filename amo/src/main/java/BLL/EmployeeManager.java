package BLL;

import java.util.ArrayList;

import DAL.EmployeeDAL;
import Models.Employee.EmployeeModel;

public class EmployeeManager {

	public static ArrayList<EmployeeModel> getAllParamedics(Integer superSSN) {
		
		return EmployeeDAL.getAllParamedics(superSSN);
	}
	
	public static ArrayList<EmployeeModel> getActiveParamedics(Integer superSSN) {
	
		return EmployeeDAL.getActiveParamedics(superSSN);
	}
	
	
	public static ArrayList<EmployeeModel> getInActiveParamedics(Integer superSSN) {
		
		return EmployeeDAL.getInActiveParamedics(superSSN);
	}
	
	public static ArrayList<EmployeeModel> getAllDrivers(Integer superSSN) {
		
		return EmployeeDAL.getAllDrivers(superSSN);
	}
	
	public static ArrayList<EmployeeModel> getActiveDrivers(Integer superSSN) {
	
		return EmployeeDAL.getActiveDrivers(superSSN);
	}
	
	
	public static ArrayList<EmployeeModel> getInActiveDrivers(Integer superSSN) {
		
		return EmployeeDAL.getInActiveDrivers(superSSN);
	}
	
}
