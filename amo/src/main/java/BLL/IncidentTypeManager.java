package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.IncidentTypeDAL;
import DB.DBManager;
import Models.IncidentType.IncidentTypeJson;

public class IncidentTypeManager {

	public static IncidentTypeJson getIncidentType() {
		Connection intermediateConnection = DBManager.getDBConn();
		IncidentTypeJson model = new IncidentTypeJson();
		try {
			model = IncidentTypeDAL.getIncidentType(intermediateConnection);
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
