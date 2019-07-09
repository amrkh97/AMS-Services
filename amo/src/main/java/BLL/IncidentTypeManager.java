package BLL;

import java.util.ArrayList;

import DAL.IncidentTypeDAL;
import Models.IncidentType.*;

public class IncidentTypeManager {
	
	public static IncidentTypeJson getIncidentType() {
		return IncidentTypeDAL.getIncidentType();
	}

}
