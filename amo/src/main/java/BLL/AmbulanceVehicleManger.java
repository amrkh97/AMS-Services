package BLL;
import java.util.ArrayList;

import DAL.AmbulanceVehicleDAL;
import DAL.MedicineDAL;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Medicine.Medicine;
import Models.ServerResponse;
public class AmbulanceVehicleManger {

	
	//Get all Cars
		 public static ArrayList<AmbulanceVehicleModel> getAllCars()
		 {
			 
			
			return AmbulanceVehicleDAL.getAllCars();
			 
		 }
		//Get all Car by ID
			 public static ArrayList<AmbulanceVehicleModel> getCarById(int VIN)
			 {
				 
				
				return AmbulanceVehicleDAL.getCarByID(VIN);
				 
			 }
		 
		 //New Car insertion
		 public static ServerResponse insertCar(AmbulanceVehicleModel Car)
		 {
			
			 ArrayList<AmbulanceVehicleModel> Array =new ArrayList<AmbulanceVehicleModel>();
			 Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());
			System.out.println(Array.size()); 
			if (Array.size()!= 0)
			{
				return null;
			}
			ServerResponse X=		 AmbulanceVehicleDAL.insertCar(Car);
			

			return X;
		 }
		 
		//Update  a Car insertion
		 public static ServerResponse UpdateCar (AmbulanceVehicleModel Car)
		 {
			 ArrayList<AmbulanceVehicleModel> Array =new ArrayList<AmbulanceVehicleModel>();
			 Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());
			if (Array.size()==0)
			{
				return null;
			}
			
			return AmbulanceVehicleDAL.UpdateCar(Car) ;
			 
		 }
		 //delete car
		 public static ServerResponse DeleteCars(int vin)
		 {
			 ArrayList<AmbulanceVehicleModel> Array =new ArrayList<AmbulanceVehicleModel>();
			 Array = AmbulanceVehicleDAL.getCarByID(vin);
			if (Array.size()==0)
			{
				return null;
			}
			
			return AmbulanceVehicleDAL.DeleteCars( vin);
			 
		 }
		 public static ArrayList<AmbulanceVehicleModel>  getCarsByBrand(String Brand)
		 {
			 return AmbulanceVehicleDAL.getCarsByBrand(Brand);
		 }

		 public static ArrayList<AmbulanceVehicleModel>  getCarsBySts(String Sts)
		 {
			 return AmbulanceVehicleDAL.getCarsBySts(Sts);
		 }
		 
		 }
		 
		
