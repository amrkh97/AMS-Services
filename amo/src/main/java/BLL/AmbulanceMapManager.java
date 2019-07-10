package BLL;

import DAL.AmbulanceMapDAL;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.Data.DataModel;

public class AmbulanceMapManager {

	public static AmbulanceMapModel getAmbulanceCarMapByCarID(Integer ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByCarID(ID);
	}

	public static AmbulanceMapModel getAmbulanceCarMapByDriverID(Integer ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByDriverID(ID);
	}

	public static AmbulanceMapModel getAmbulanceCarMapByParamedicID(Integer ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByParamedicID(ID);
	}

	public static AmbulanceMapModel getAmbulanceCarMapByYelloPadID(Integer ID) {
		return AmbulanceMapDAL.getAmbulanceCarMapByYelloPadID(ID);
	}

	public static DataModel addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		return AmbulanceMapDAL.addAmbulanceMap(currentAmbulanceMap);
	}

	public static DataModel deleteAmbulanceMap(Integer currentAmbulanceMap) {
		return AmbulanceMapDAL.deleteAmbulanceMap(currentAmbulanceMap);
	}

}
