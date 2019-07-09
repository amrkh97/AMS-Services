package BLL;

import DAL.IncidentTypeDAL;
import Models.IncidentType.IncidentTypeJson;

public class IncidentTypeManager {

	public static IncidentTypeJson getIncidentType() {
		return IncidentTypeDAL.getIncidentType();
	}

}
