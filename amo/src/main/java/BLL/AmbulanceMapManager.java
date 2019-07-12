package BLL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import DAL.AmbulanceMapDAL;
import DB.DBManager;
import Models.AmbulanceMap.AllAmbulanceMapDataModel;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.Data.DataModel;

public class AmbulanceMapManager {

	public static AmbulanceMapModel getAmbulanceCarMapByCarID(DataModel ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByCarID(ID.getSentID());
	}

	public static AmbulanceMapModel getAmbulanceCarMapByDriverID(DataModel ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByDriverID(ID.getSentID());
	}

	public static AmbulanceMapModel getAmbulanceCarMapByParamedicID(DataModel ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByParamedicID(ID.getSentID());
	}

	public static AmbulanceMapModel getAmbulanceCarMapByYelloPadID(DataModel ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByYelloPadID(ID.getSentID());
	}

	public static DataModel addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		return AmbulanceMapDAL.addAmbulanceMap(currentAmbulanceMap);
	}

	public static DataModel deleteAmbulanceMap(DataModel currentAmbulanceMap) {
		return AmbulanceMapDAL.deleteAmbulanceMap(currentAmbulanceMap.getSentID());
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

}
