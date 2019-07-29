package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.AlarmLevel.AlarmLevel;
import Models.AlarmLevel.AlarmLevelJson;

public class AlarmLevelDAL {

	public static AlarmLevelJson getAlarmLevels(Connection intermediateConnection) {

		String incidentSP = "EXEC usp_AlarmLevel_GetAll";
		 
		ArrayList<AlarmLevel> alarmLevelArray = new ArrayList<AlarmLevel>();
		AlarmLevelJson alarmJson = new AlarmLevelJson();
		AlarmLevel alarmLevel;
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(incidentSP);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				alarmLevel = new AlarmLevel();
				alarmLevel.setAlarmLevelID(rs.getInt("AlarmLevelID"));
				alarmLevel.setAlarmLevelName(rs.getString("AlarmLevelName"));
				alarmLevel.setAlarmLevelNote(rs.getString("AlarmLevelNote"));
				alarmLevelArray.add(alarmLevel);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		alarmJson.setAlarmJson(alarmLevelArray);
		return alarmJson;
	}

}
