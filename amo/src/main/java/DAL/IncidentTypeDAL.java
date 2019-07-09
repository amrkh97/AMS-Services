package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.IncidentType.IncidentType;
import Models.IncidentType.IncidentTypeJson;

public class IncidentTypeDAL {

	 public static IncidentTypeJson  getIncidentType()
	 {
		 
		 String incidentSP = "EXEC usp_IncidentType_GetAll";
		 Connection conn = DBManager.getDBConn();
		ArrayList<IncidentType> incidentTypeArray = new ArrayList<IncidentType>()  ;
		 	
		IncidentTypeJson typeJson = new IncidentTypeJson();
		IncidentType incidentType;
			try {
					CallableStatement cstmt  = conn.prepareCall(incidentSP);
			        ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	incidentType = new IncidentType();
			        	incidentType.setTypeID(rs.getInt("IncidentTypeID"));
			        	incidentType.setTypeName(rs.getString("TypeName"));
			        	incidentType.setTypeNote(rs.getString("TypeNote"));
			        	incidentTypeArray.add(incidentType);
			        }
		         }catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					
					
					e.printStackTrace();
				}
			}
			typeJson.setIncidentTypeJson(incidentTypeArray);
			return typeJson;
		}
}
