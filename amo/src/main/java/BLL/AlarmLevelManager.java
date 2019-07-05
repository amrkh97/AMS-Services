package BLL;

import java.util.ArrayList;

import DAL.AlarmLevelDAL;
import Models.AlarmLevel.*;

public class AlarmLevelManager {
	public static AlarmLevelJson getAlarmLevel() {
		return AlarmLevelDAL.getAlarmLevels();
	}

}
