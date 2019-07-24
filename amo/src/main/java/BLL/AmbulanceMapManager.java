package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.AmbulanceMapDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.AmbulanceMap.AllAmbulanceMapDataModel;
import Models.AmbulanceMap.AmbulanceBatches;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.Data.DataModel;

public class AmbulanceMapManager {

	public static AmbulanceMapModel getAmbulanceCarMapByCarID(DataModel ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceMapModel model = new AmbulanceMapModel();
		try {
			model = AmbulanceMapDAL.getAmbulanceCarMapByCarID(ID.getSentID(), intermediateConnection);
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

	public static AmbulanceMapModel getAmbulanceCarMapByDriverID(DataModel ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceMapModel model = new AmbulanceMapModel();
		try {
			model = AmbulanceMapDAL.getAmbulanceCarMapByDriverID(ID.getSentID(), intermediateConnection);
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

	public static AmbulanceMapModel getAmbulanceCarMapByParamedicID(DataModel ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceMapModel model = new AmbulanceMapModel();
		try {
			model = AmbulanceMapDAL.getAmbulanceCarMapByParamedicID(ID.getSentID(), intermediateConnection);
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

	public static AmbulanceMapModel getAmbulanceCarMapByYelloPadID(DataModel ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceMapModel model = new AmbulanceMapModel();
		try {
			model = AmbulanceMapDAL.getAmbulanceCarMapByYelloPadID(ID.getSentID(), intermediateConnection);
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

	public static ServerResponse addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = AmbulanceMapDAL.addAmbulanceMap(currentAmbulanceMap, intermediateConnection);
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

	public static ServerResponse deleteAmbulanceMap(DataModel currentAmbulanceMap) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = AmbulanceMapDAL.deleteAmbulanceMap(currentAmbulanceMap.getSentID(), intermediateConnection);
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

	public static AllAmbulanceMapDataModel getRelevantData(DataModel vin) {
		Connection intermediateConnection = DBManager.getDBConn();
		AllAmbulanceMapDataModel obj = new AllAmbulanceMapDataModel();
		try {
			obj = AmbulanceMapDAL.getRelevantData(vin, intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	public static AmbulanceBatches getAllBatches(DataModel vin) {

		Connection intermediateConnection = DBManager.getDBConn();
		AmbulanceBatches obj = new AmbulanceBatches();
		try {
			obj = AmbulanceMapDAL.getAllbatches(vin.getSentID(), intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}
	
	public static ServerResponse updateAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = AmbulanceMapDAL.updateAmbulanceMap(currentAmbulanceMap, intermediateConnection);
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
