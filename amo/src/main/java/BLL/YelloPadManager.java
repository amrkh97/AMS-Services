package BLL;

import DAL.YelloPadDAL;
import Models.YelloPad.YelloPadArray;
import Models.YelloPad.YelloPadModel;

public class YelloPadManager {
	public static YelloPadArray getAllYelloPads() {
		return YelloPadDAL.getAllYelloPads();
	}

	public static YelloPadArray getAllActiveYelloPads() {
		return YelloPadDAL.getAllActiveYelloPads();
	}

	public static YelloPadArray getAllInActiveYelloPads() {
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
