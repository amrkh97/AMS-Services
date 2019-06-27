package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.IncidentType.*;

public class IncidentTypeDAL {

	 public static ArrayList<IncidentType>  getIncidentType()
	 {
		 
		 String SPsql = "EXEC usp_Incident_GetAll";
		 Connection conn = DBManager.getDBConn();
		ArrayList<IncidentType> Array = new ArrayList<IncidentType>()  ;
		 	
	
		IncidentType incidentType;
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
			        ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	incidentType = new IncidentType();
			        	incidentType.setTypeID(rs.getInt("IncidentTypeID"));
			        	incidentType.setTypeName(rs.getString("TypeName"));
			        	Array.add(incidentType);
			        }
		         }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
			return Array;
		}
}
