package BLL;

import java.util.ArrayList;
import DAL.MedicineDAL;
import Models.ServerResponse;
import Models.Medicine.Medicine;

public class MedicineManager {
	 public static ArrayList<Medicine> getAllMedicines()
	 {
		 
		
		return MedicineDAL.getAllMedicines();
		 
	 }
	//Get all Car by ID
	 public static Medicine getMedicineByBC(String BarCode)
	 {
		 
			
			return MedicineDAL.getMedicineByBC(BarCode);
			 
		 }
	 
	 public static ServerResponse insertMedicine(Medicine MED)
	 {
		
		

		return MedicineDAL.insertMedicine(MED);
	 }
	 
	//Update  a Car insertion
	 public static ServerResponse UpdateMedicine (Medicine MED)
	 {
		 
		
		return MedicineDAL.UpdateMedicine(MED);
		 
	 }
	 //delete car
	 public static ServerResponse DeleteMedicine(String BarCode)
	 {
		 
		 return MedicineDAL.DeleteMedicine(BarCode);
	 }
	 public static  ArrayList<Medicine>  getMedicineByActiveComponent(String ActiveComponent)
	 {
		 return MedicineDAL.getMedicineByActiveComponent(ActiveComponent);
	 }

	 public static ArrayList<Medicine>    getMedicineByCompanyName(String CompanyName)
	 {
		 return MedicineDAL.getMedicineByCompanyName(CompanyName);
	 }

	 public static ArrayList<Medicine>    getMedicineByCompanyStatus(String CompanyStatus)
	 {
		 return MedicineDAL.getMedicineByCompanyStatus(CompanyStatus);
	 }
	 public static ArrayList<Medicine>    getMedicineByContactPerson(String ContactPerson)
	 {
		 return MedicineDAL.getMedicineByContactPerson(ContactPerson);
	 }
	 public static ArrayList<Medicine>    getMedicineByName(String Name)
	 {
		 return MedicineDAL.getMedicineByName(Name);
	 }
	 public static ArrayList<Medicine>    getMedicineByStatus(String Status)
	 {
		 return MedicineDAL.getMedicineByStatus(Status);
	 }


}
