package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.IncidentPriorityDAL;
import DB.DBManager;
import Models.Priority.IncidentPriorityJson;

public class IncidentPriorityManager {
	public static IncidentPriorityJson getIncidentPriority() {
		Connection intermediateConnection = DBManager.getDBConn();
		IncidentPriorityJson model = new IncidentPriorityJson();
		try {
			model = IncidentPriorityDAL.getIncidentPriority(intermediateConnection);
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
