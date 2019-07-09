package BLL;

import java.util.ArrayList;

import Models.Priority.*;
import DAL.IncidentPriorityDAL;

public class IncidentPriorityManager {
	public static IncidentPriorityJson getIncidentPriority() {
		return IncidentPriorityDAL.getIncidentPriority();
	}

}
