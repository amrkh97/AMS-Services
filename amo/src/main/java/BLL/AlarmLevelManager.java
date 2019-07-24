package BLL;

import java.sql.Connection;
import java.sql.SQLException;
import DAL.AlarmLevelDAL;
import DB.DBManager;
import Models.AlarmLevel.AlarmLevelJson;

public class AlarmLevelManager {
	public static AlarmLevelJson getAlarmLevel() {
		Connection intermediateConnection = DBManager.getDBConn();
		AlarmLevelJson model = new AlarmLevelJson();
		try {
			model = AlarmLevelDAL.getAlarmLevels(intermediateConnection);
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
