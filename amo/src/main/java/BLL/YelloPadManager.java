package BLL;

import org.json.JSONArray;
import org.json.JSONObject;

import DAL.YelloPadDAL;


public class YelloPadManager {
	public static JSONArray getYelloPads(){
		return YelloPadDAL.getYelloPads();
	}
	
	public static JSONObject searchYelloPad(String ID) {
		return YelloPadDAL.searchYelloPad(ID);
	}

	public static JSONObject getYelloPadStatus(String ID) {
		return YelloPadDAL.getYelloPadStatus(ID);
	}
	
	public static JSONObject getYelloPadNetworkCardNo(String ID) {
	
		return YelloPadDAL.getYelloPadNetworkCardNo(ID);
	}

}
