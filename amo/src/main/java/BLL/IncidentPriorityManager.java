package BLL;

import DAL.IncidentPriorityDAL;
import Models.Priority.IncidentPriorityJson;

public class IncidentPriorityManager {
	public static IncidentPriorityJson getIncidentPriority() {
		return IncidentPriorityDAL.getIncidentPriority();
	}

}
