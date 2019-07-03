package BLL;

import java.util.ArrayList;

import Models.Priority.*;
import DAL.IncidentPriorityDAL;

public class IncidentPriorityManager {
	public static ArrayList<IncidentPriority> getIncidentPriority() {
		return IncidentPriorityDAL.getIncidentPriority();
	}

}
