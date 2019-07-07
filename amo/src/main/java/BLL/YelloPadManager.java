package BLL;

import java.util.ArrayList;

import DAL.YelloPadDAL;
import Models.YelloPad.YelloPadModel;


public class YelloPadManager {
	public static ArrayList<YelloPadModel> getAllYelloPads(){
		return YelloPadDAL.getAllYelloPads();
	}
	
	public static ArrayList<YelloPadModel> getAllActiveYelloPads(){
		return YelloPadDAL.getAllActiveYelloPads();
	}
	
	public static ArrayList<YelloPadModel> getAllInActiveYelloPads(){
		return YelloPadDAL.getAllInActiveYelloPads();
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
