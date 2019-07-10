package BLL;

import DAL.AlarmLevelDAL;
import Models.AlarmLevel.AlarmLevelJson;

public class AlarmLevelManager {
	public static AlarmLevelJson getAlarmLevel() {
		return AlarmLevelDAL.getAlarmLevels();
	}

}
