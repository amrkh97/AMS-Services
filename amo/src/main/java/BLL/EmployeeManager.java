package BLL;

import java.util.ArrayList;

import DAL.EmployeeDAL;
import Models.Employee.EmployeeModel;

public class EmployeeManager {

	public static ArrayList<EmployeeModel> getAllParamedics() {
		
		return EmployeeDAL.getAllParamedics();
	}
	
	public static ArrayList<EmployeeModel> getActiveParamedics() {
	
		return EmployeeDAL.getActiveParamedics();
	}
	
	
	public static ArrayList<EmployeeModel> getInActiveParamedics() {
		
		return EmployeeDAL.getInActiveParamedics();
	}
	
	public static ArrayList<EmployeeModel> getAllDrivers() {
		
		return EmployeeDAL.getAllDrivers();
	}
	
	public static ArrayList<EmployeeModel> getActiveDrivers() {
	
		return EmployeeDAL.getActiveDrivers();
	}
	
	
	public static ArrayList<EmployeeModel> getInActiveDrivers() {
		
		return EmployeeDAL.getInActiveDrivers();
	}
	
}
