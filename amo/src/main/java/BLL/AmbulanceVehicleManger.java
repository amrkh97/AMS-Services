package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.AmbulanceVehicleDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.AmbulanceVehicle.AmbulanceArray;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;

public class AmbulanceVehicleManger {

	public static AmbulanceArray getAllCars() {
		return AmbulanceVehicleDAL.getAllCars();
	}
	
	public static AmbulanceArray getDeletedCars() {
		return AmbulanceVehicleDAL.getCarsBySts("FF");
	}

	public static AmbulanceArray getActivatedCars() {
		// ArrayList<AmbulanceVehicleModel> X = getCarsByStatus("00");
		// ArrayList<AmbulanceVehicleModel> X1 = getCarsByStatus("01");
		// X.addAll(X1);
		return getCarsByStatus("00");
	}

	public static AmbulanceArray getDeActivatedCars() {
		AmbulanceArray X = getCarsByStatus("02");

		return X;
	}

	public static AmbulanceArray getAssignedCars() {
		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceArray model = new AmbulanceArray();
		try {
			model = AmbulanceVehicleDAL.getAssignedCarsLoggedIn(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static AmbulanceArray getFreeCars() {
		return AmbulanceVehicleDAL.getCarsBySts("00");
	}

	public static AmbulanceArray getBusyCars() {
		return AmbulanceVehicleDAL.getCarsBySts("01");
	}

	public static AmbulanceVehicleModel getCarById(int i) {
		return AmbulanceVehicleDAL.getCarByID(i);
	}

	public static AmbulanceArray getCarsByBrand(String string) {
		return AmbulanceVehicleDAL.getCarsByBrand(string);
	}

	public static AmbulanceArray getCarsByStatus(String string) {
		return AmbulanceVehicleDAL.getCarsBySts(string);
	}

	public static ServerResponse insertCar(AmbulanceVehicleModel Car) {
		AmbulanceVehicleModel Array = new AmbulanceVehicleModel();
		Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());

		if (Array != null) {
			if (Array.getVehicleStatus().equals("FF")) {
				System.out.println(Array.getVehicleStatus());
				return AmbulanceVehicleDAL.UpdateCarStatus(Array.getVin(), "00");
			} else {
				ServerResponse S = new ServerResponse();
				S.setResponseHexCode("01");
				S.setResponseMsg("You already have this AmbulanceVehicl in database");
				return S;
			}
		}
		return AmbulanceVehicleDAL.insertCar(Car);
	}

	public static ServerResponse UpdateCar(AmbulanceVehicleModel Car) {
		AmbulanceVehicleModel Array = new AmbulanceVehicleModel();
		Array = AmbulanceVehicleDAL.getCarByID(Car.getVin());
		if (Array == null) {
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
			return S;
		}
		return AmbulanceVehicleDAL.UpdateCar(Car);
	}

	public static ServerResponse UpdateCarStatus(int Vin, String newStatus) {
		AmbulanceVehicleModel Array = new AmbulanceVehicleModel();
		Array = AmbulanceVehicleDAL.getCarByID(Vin);
		if (Array == null) {
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

		return UpdateCarStatus(Vin, "01");

	}

	public static ServerResponse SetCarMaintain(int Vin) {
		return UpdateCarStatus(Vin, "02");

	}

	public static ServerResponse SetCarAssigned(int Vin) {
		return UpdateCarStatus(Vin, "05");

	}

	public static ServerResponse DeleteCars(int vin) {
		AmbulanceVehicleModel Array = new AmbulanceVehicleModel();
		Array = AmbulanceVehicleDAL.getCarByID(vin);
		ServerResponse S = new ServerResponse();

		if (Array == null) {
			S.setResponseHexCode("FF");
			S.setResponseMsg("NOT FOUND AmbulanceVehicl in database");
			return S;
		}

		if (Array.getVehicleStatus().equals("01")) {
			S.setResponseHexCode("FF");
			S.setResponseMsg("this AmbulanceVehicl can not be deleted it is BUSY");
			return S;

		}
		if (Array.getVehicleStatus().equals("02")) {
			S.setResponseHexCode("FF");
			S.setResponseMsg("this AmbulanceVehicl can not be deleted it is in Maintainance");
			return S;

		}
		return AmbulanceVehicleDAL.DeleteCars(vin);
	}
	
	
	public static AmbulanceArray getAllAssignedNotInTripCars() {
		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceArray model = new AmbulanceArray();
		try {
			model = AmbulanceVehicleDAL.getAssignedNotInTripCars(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	
	
}
