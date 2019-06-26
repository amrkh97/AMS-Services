package BLL;
import java.util.ArrayList;

import DAL.AmbulanceVehicleDAL;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.ServerResponse;
public class AmbulanceVehicleManger {

	
	//Get all Cars
		 public static ArrayList<AmbulanceVehicleModel> getAllCars()
		 {
			 
			
			return AmbulanceVehicleDAL.getAllCars();
			 
		 }
		//Get all Car by ID
			 public static AmbulanceVehicleModel getCarById(int VIN)
			 {
				 
				
				return AmbulanceVehicleDAL.getCarByID(VIN);
				 
			 }
		 
		 //New Car insertion
		 public static ServerResponse insertCar(AmbulanceVehicleModel Car)
		 {
			
			 
			ServerResponse X=		 AmbulanceVehicleDAL.insertCar(Car);
			

			return X;
		 }
		 
		//Update  a Car insertion
		 public static ServerResponse UpdateCar (AmbulanceVehicleModel Car)
		 {
			 
			
			return AmbulanceVehicleDAL.UpdateCar(Car) ;
			 
		 }
		 //delete car
		 public static ServerResponse DeleteCars(int vin)
		 {
			 
			
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
		 
		
