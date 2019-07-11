package BLL;

import DAL.YelloPadDAL;
import Models.Data.DataArrayModel;
import Models.YelloPad.YelloPadModel;

public class YelloPadManager {
	public static DataArrayModel<YelloPadModel> getAllYelloPads() {
		return YelloPadDAL.getAllYelloPads();
	}

	public static DataArrayModel<YelloPadModel> getAllActiveYelloPads() {
		return YelloPadDAL.getAllActiveYelloPads();
	}

	public static DataArrayModel<YelloPadModel> getAllInActiveYelloPads() {
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
