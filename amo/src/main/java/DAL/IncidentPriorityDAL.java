package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.Priority.IncidentPriority;
import Models.Priority.IncidentPriorityJson;

public class IncidentPriorityDAL {

	public static IncidentPriorityJson getIncidentPriority() {

		String incidentSP = "EXEC usp_IncidentPriority_GetAll";
		Connection conn = DBManager.getDBConn();
		ArrayList<IncidentPriority> incidentPriorityArray = new ArrayList<IncidentPriority>();
		IncidentPriorityJson priorityJson = new IncidentPriorityJson();
		IncidentPriority incidentPriority;
		try {
			CallableStatement cstmt = conn.prepareCall(incidentSP);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				incidentPriority = new IncidentPriority();
				incidentPriority.setPriorityID(rs.getInt("PrioritYID"));
				incidentPriority.setPriorityName(rs.getString("PriorityName"));
				incidentPriorityArray.add(incidentPriority);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}
		priorityJson.setPriorityJson(incidentPriorityArray);
		return priorityJson;
	}
}
