package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Priority.IncidentPriority;
import Models.Priority.IncidentPriorityJson;

public class IncidentPriorityDAL {

	public static IncidentPriorityJson getIncidentPriority(Connection intermediateConnection) {

		String incidentSP = "EXEC usp_IncidentPriority_GetAll";
		
		ArrayList<IncidentPriority> incidentPriorityArray = new ArrayList<IncidentPriority>();
		IncidentPriorityJson priorityJson = new IncidentPriorityJson();
		IncidentPriority incidentPriority;
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(incidentSP);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				incidentPriority = new IncidentPriority();
				incidentPriority.setPriorityID(rs.getInt("PrioritYID"));
				incidentPriority.setPriorityName(rs.getString("PriorityName"));
				incidentPriorityArray.add(incidentPriority);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		priorityJson.setPriorityJson(incidentPriorityArray);
		return priorityJson;
	}
}
