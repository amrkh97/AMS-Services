package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.EquipmentDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.Equipment.AddEquipmentModel;
import Models.Equipment.EquipmentModel;
import Models.Equipment.EquipmentModelArray;

public class EquipmentManager {

	public static ServerResponse insertEquipment(EquipmentModel equipment) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = EquipmentDAL.insertEquipment(equipment,intermediateConnection);
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

	public static EquipmentModel getEquipmentByName(EquipmentModel equipment) {
		Connection intermediateConnection = DBManager.getDBConn();
		EquipmentModel model = new EquipmentModel();
		try {
			model = EquipmentDAL.getEquipmentByName(equipment,intermediateConnection);
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

	public static EquipmentModelArray getAllEquipment() {
		Connection intermediateConnection = DBManager.getDBConn();
		EquipmentModelArray model = new EquipmentModelArray();
		try {
			model = EquipmentDAL.getAllEquipment(intermediateConnection);
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

	public static ServerResponse assignEquipmentToAmbulance(AddEquipmentModel model) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse response = new ServerResponse();
		try {
			response = EquipmentDAL.assignEquipmentToAmbulance(model,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	public static EquipmentModelArray getEquipmentOnAmbulance(AddEquipmentModel equipment) {
		Connection intermediateConnection = DBManager.getDBConn();
		EquipmentModelArray model = new EquipmentModelArray();
		try {
			model = EquipmentDAL.getEquipmentOnAmbulance(equipment,intermediateConnection);
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

	public static ServerResponse deleteEquipmentOnAmbulance(AddEquipmentModel model) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse response = new ServerResponse();
		try {
			response = EquipmentDAL.deleteEquipmentOnAmbulance(model,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	
}
