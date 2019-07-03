package BLL;
import java.util.ArrayList;

import DAL.AmbulanceVehicleDAL;
import DAL.MedicineDAL;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Medicine.Medicine;
import Models.ServerResponse;
public class AmbulanceVehicleManger {

	
//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// GET ALL CARs /////////////////////////////////////////////
		 
	public static ArrayList<AmbulanceVehicleModel> getAllCars()
		 {
			return AmbulanceVehicleDAL.getAllCars();	 
		 }

//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// GET CAR BY VIN //////////////////////////////////////////
	
	public static ArrayList<AmbulanceVehicleModel> getCarById(int VIN)
			 {			
				return AmbulanceVehicleDAL.getCarByID(VIN);
			 }
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET CAR BY Brand //////////////////////////////////////////

	 public static ArrayList<AmbulanceVehicleModel>  getCarsByBrand(String Brand)
	 {
		 return AmbulanceVehicleDAL.getCarsByBrand(Brand);
	 }
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET CAR BY Status //////////////////////////////////////////

	 public static ArrayList<AmbulanceVehicleModel>  getCarsBySts(String Sts)
	 {
		 return AmbulanceVehicleDAL.getCarsBySts(Sts);
	 }
	 
//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// INSERT ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	 public static ServerResponse insertCar(AmbulanceVehicleModel Car)
		 {
			 ArrayList<AmbulanceVehicleModel> Array =new ArrayList<AmbulanceVehicleModel>();
			 Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());
				 
			if (Array.size()!= 0)
			{
				if (Array.get(0).getVehicleStatus().equals("FF"))
				{ System.out.println(Array.get(0).getVehicleStatus());
					return AmbulanceVehicleDAL.UpdateCarStatus(Array.get(0).getVin(), "00");
				}
				else
				{
				ServerResponse S =new ServerResponse(); 
				S.setResponseHexCode("01");
				S.setResponseMsg("You already have this AmbulanceVehicl in database");
				return S;
				}	
			}	
			return AmbulanceVehicleDAL.insertCar(Car);
		 }
	 
//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// UPDATE ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

		 public static ServerResponse UpdateCar (AmbulanceVehicleModel Car)
		 {
			 ArrayList<AmbulanceVehicleModel> Array =new ArrayList<AmbulanceVehicleModel>();
			 Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());
			if (Array.size()==0)
			{
				ServerResponse S =new ServerResponse(); 
				S.setResponseHexCode("01");
				S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
				return S;		
			}
			return AmbulanceVehicleDAL.UpdateCar(Car) ;
		 }
		 
//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// DELETE ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

		 public static ServerResponse DeleteCars(int vin)
		 {
			 ArrayList<AmbulanceVehicleModel> Array =new ArrayList<AmbulanceVehicleModel>();
			 Array = AmbulanceVehicleDAL.getCarByID(vin);
			if (Array.size()==0)
			{
				ServerResponse S =new ServerResponse(); 
				S.setResponseHexCode("01");
				S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
				return S;		
		}		
			return AmbulanceVehicleDAL.DeleteCars( vin);	 
		}
}
	
