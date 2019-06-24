package BLL;
import DAL.AmbulanceVehicleDAL;
import Models.AmbulanceVehicleModel;
import Models.ServerResponse;
public class AmbulanceVehicleManger {

	
	//Get all Cars
		 public AmbulanceVehicleModel[] getAllCars()
		 {
			 
			
			return AmbulanceVehicleDAL.getAllCars();
			 
		 }
		//Get all Car by ID
			 public AmbulanceVehicleModel getAllCars(int VIN)
			 {
				 
				
				return AmbulanceVehicleDAL.getCarByID(VIN);
				 
			 }
		 
		 //New Car insertion
		 public static ServerResponse insertCar(AmbulanceVehicleModel Car)
		 {
			 System.out.println("IM bll");
			 
			ServerResponse X=		 AmbulanceVehicleDAL.insertCar(Car);
			 System.out.println("IM 1");

			return X;
		 }
		 
		//Update  a Car insertion
		 public boolean UpdateCar (AmbulanceVehicleModel Car)
		 {
			 
			
			return AmbulanceVehicleDAL.UpdateCar(Car) ;
			 
		 }
		 //delete car
		 public boolean DeleteCars(int vin)
		 {
			 
			
			return AmbulanceVehicleDAL.DeleteCars( vin);
			 
		 }
		

}