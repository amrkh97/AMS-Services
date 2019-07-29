package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.IncidentType.IncidentType;
import Models.IncidentType.IncidentTypeJson;

public class IncidentTypeDAL {

	public static IncidentTypeJson getIncidentType(Connection intermediateConnection) {

		String incidentSP = "EXEC usp_IncidentType_GetAll";
		ArrayList<IncidentType> incidentTypeArray = new ArrayList<IncidentType>();

		IncidentTypeJson typeJson = new IncidentTypeJson();
		IncidentType incidentType;
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(incidentSP);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				incidentType = new IncidentType();
				incidentType.setTypeID(rs.getInt("IncidentTypeID"));
				incidentType.setTypeName(rs.getString("TypeName"));
				incidentType.setTypeNote(rs.getString("TypeNote"));
				incidentTypeArray.add(incidentType);
			}
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		typeJson.setIncidentTypeJson(incidentTypeArray);
		return typeJson;
	}
}
