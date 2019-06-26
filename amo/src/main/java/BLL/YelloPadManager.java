package BLL;

import java.util.ArrayList;

import DAL.YelloPadDAL;
import Models.YelloPad.YelloPadModel;


public class YelloPadManager {
	public static ArrayList<YelloPadModel> getYelloPads(){
		return YelloPadDAL.getYelloPads();
	}
	
	public static YelloPadModel searchYelloPad(String ID) {
		return YelloPadDAL.searchYelloPad(ID);
	}

	public static YelloPadModel getYelloPadStatus(String ID) {
		return YelloPadDAL.getYelloPadStatus(ID);
	}
	
	public static YelloPadModel getYelloPadNetworkCardNo(String ID) {
	
		return YelloPadDAL.getYelloPadNetworkCardNo(ID);
	}

}
