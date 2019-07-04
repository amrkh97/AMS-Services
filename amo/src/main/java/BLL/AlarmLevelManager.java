package BLL;

import java.util.ArrayList;

import DAL.AlarmLevelDAL;
import Models.AlarmLevel.*;

public class AlarmLevelManager {
	public static ArrayList<AlarmLevel> getAlarmLevel() {
		return AlarmLevelDAL.getAlarmLevels();
	}

}
