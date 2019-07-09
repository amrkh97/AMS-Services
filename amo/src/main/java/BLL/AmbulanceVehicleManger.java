package BLL;

import java.util.ArrayList;

import DAL.AmbulanceVehicleDAL;
import Models.ServerResponse;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;

public class AmbulanceVehicleManger {

//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// GET Deleted CARs /////////////////////////////////////////////

	public static ArrayList<AmbulanceVehicleModel> getDeletedCars() {
		return AmbulanceVehicleDAL.getCarsBySts("FF");
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET Activated CARs /////////////////////////////////////////////

	public static ArrayList<AmbulanceVehicleModel> getActivatedCars() {

		ArrayList<AmbulanceVehicleModel> X = getCarsByStatus("00");
		ArrayList<AmbulanceVehicleModel> X1 = getCarsByStatus("02");

		X.addAll(X1);
		return X;

	}

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET DeActivated CARs /////////////////////////////////////////////

	public static ArrayList<AmbulanceVehicleModel> getDeActivatedCars() {
		return AmbulanceVehicleDAL.getCarsBySts("01");
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// GET CAR BY VIN //////////////////////////////////////////

	public static ArrayList<AmbulanceVehicleModel> getCarById(int VIN) {
		return AmbulanceVehicleDAL.getCarByID(VIN);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET CAR BY Brand //////////////////////////////////////////

	public static ArrayList<AmbulanceVehicleModel> getCarsByBrand(String Brand) {
		return AmbulanceVehicleDAL.getCarsByBrand(Brand);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET CAR BY Status //////////////////////////////////////////

	public static ArrayList<AmbulanceVehicleModel> getCarsByStatus(String Sts) {
		return AmbulanceVehicleDAL.getCarsBySts(Sts);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// INSERT ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse insertCar(AmbulanceVehicleModel Car) {
		ArrayList<AmbulanceVehicleModel> Array = new ArrayList<AmbulanceVehicleModel>();
		Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());

		if (Array.size() != 0) {
			if (Array.get(0).getVehicleStatus().equals("FF")) {
				System.out.println(Array.get(0).getVehicleStatus());
				return AmbulanceVehicleDAL.UpdateCarStatus(Array.get(0).getVin(), "00");
			} else {
				ServerResponse S = new ServerResponse();
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

	public static ServerResponse UpdateCar(AmbulanceVehicleModel Car) {
		ArrayList<AmbulanceVehicleModel> Array = new ArrayList<AmbulanceVehicleModel>();
		Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());
		if (Array.size() == 0) {
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
			return S;
		}
		return AmbulanceVehicleDAL.UpdateCar(Car);
	}

///////////////////////////////// Status

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////GET CAR BY Status //////////////////////////////////////////

	public static ServerResponse UpdateCarStatus(int Vin, String newStatus) {
		ArrayList<AmbulanceVehicleModel> Array = new ArrayList<AmbulanceVehicleModel>();
		Array = AmbulanceVehicleDAL.getCarByID(Vin);
		if (Array.size() == 0) {
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
			return S;
		}
		return AmbulanceVehicleDAL.UpdateCarStatus(Vin, newStatus);

	}

	public static ServerResponse SetCarFree(int Vin) {
		return UpdateCarStatus(Vin, "00");
	}

	public static ServerResponse SetCarBusy(int Vin) {

		return UpdateCarStatus(Vin, "02");

	}

	public static ServerResponse SetCarMaintain(int Vin) {
		return UpdateCarStatus(Vin, "01");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// DELETE ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse DeleteCars(int vin) {
		ArrayList<AmbulanceVehicleModel> Array = new ArrayList<AmbulanceVehicleModel>();
		Array = AmbulanceVehicleDAL.getCarByID(vin);
		ServerResponse S = new ServerResponse();

		if (Array.size() == 0) {
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
			return S;
		}

		if (Array.get(0).getVehicleStatus().equals("02")) {
			S.setResponseHexCode("FF");
			S.setResponseMsg("this AmbulanceVehicl can not be deleted it is BUSY");
			return S;

		}
		if (Array.get(0).getVehicleStatus().equals("01")) {
			S.setResponseHexCode("FF");
			S.setResponseMsg("this AmbulanceVehicl can not be deleted it is in Maintainance");
			return S;

		}
		return AmbulanceVehicleDAL.DeleteCars(vin);
	}
}
