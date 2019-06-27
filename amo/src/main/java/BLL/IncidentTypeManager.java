package BLL;

import java.util.ArrayList;

import DAL.IncidentTypeDAL;
import Models.IncidentType.*;

public class IncidentTypeManager {
	
	public static ArrayList<IncidentType> getIncidentType() {
		return IncidentTypeDAL.getIncidentType();
	}

}
