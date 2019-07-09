package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.AlarmLevel.AlarmLevel;
import Models.AlarmLevel.AlarmLevelJson;

public class AlarmLevelDAL {
	
	public static AlarmLevelJson  getAlarmLevels()
	 {
		 
		 String incidentSP = "EXEC usp_AlarmLevel_GetAll";
		 Connection conn = DBManager.getDBConn();
		ArrayList<AlarmLevel> alarmLevelArray = new ArrayList<AlarmLevel>()  ;
		AlarmLevelJson alarmJson = new AlarmLevelJson();
		AlarmLevel alarmLevel;
			try {
					CallableStatement cstmt  = conn.prepareCall(incidentSP);
			        ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	alarmLevel = new AlarmLevel();
			        	alarmLevel.setAlarmLevelID(rs.getInt("AlarmLevelID"));
			        	alarmLevel.setAlarmLevelName(rs.getString("AlarmLevelName"));
			        	alarmLevelArray.add(alarmLevel);
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
			alarmJson.setAlarmJson(alarmLevelArray);
			return alarmJson;
		}

}
