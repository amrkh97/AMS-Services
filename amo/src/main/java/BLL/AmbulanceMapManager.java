package BLL;

import DAL.AmbulanceMapDAL;
import Models.AmbulanceMap.AmbulanceMapModel;

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
	
	public static String addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		return AmbulanceMapDAL.addAmbulanceMap(currentAmbulanceMap);
	}
	
	public static Integer deleteAmbulanceMap(Integer currentAmbulanceMap) {
		 return AmbulanceMapDAL.deleteAmbulanceMap(currentAmbulanceMap);
	}
	
}
