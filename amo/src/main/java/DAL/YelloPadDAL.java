package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.Data.DataArrayModel;
import Models.YelloPad.YelloPadModel;

public class YelloPadDAL {

	/**
	 * This Function returns all relevant data of the YelloPads which is:
	 * -YelloPad's Unique ID -YelloPad's Status Name -YelloPad's Status Code
	 * -YelloPad's Network Card Number -YelloPad's Picture
	 * 
	 * @return ArrayList<YelloPadModel>: Return an ArrayList of YelloPads
	 */
	public static DataArrayModel<YelloPadModel> getAllYelloPads() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_SelectAll]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		DataArrayModel<YelloPadModel>OBJ = new 	DataArrayModel<YelloPadModel>()  ;
	
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setUniqueID(RS.getString(2));
				currentYelloPad.setNetworkCard(RS.getString(3));
				currentYelloPad.setStatus(RS.getString(14));
				currentYelloPad.setPicture(RS.getString(15));

				allYelloPads.add(currentYelloPad);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		OBJ.set_ArrayList(allYelloPads);
		return OBJ;
	}

	// -----------------------------------------------------------//

	public static DataArrayModel<YelloPadModel> getAllActiveYelloPads() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_selectActive]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		DataArrayModel<YelloPadModel>OBJ = new 	DataArrayModel<YelloPadModel>()  ;
	
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setUniqueID(RS.getString(2));
				currentYelloPad.setNetworkCard(RS.getString(3));
				currentYelloPad.setStatus(RS.getString(14));
				currentYelloPad.setPicture(RS.getString(15));

				allYelloPads.add(currentYelloPad);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		OBJ.set_ArrayList(allYelloPads);
		return OBJ;
	}

	// -----------------------------------------------------------//

	public static DataArrayModel<YelloPadModel> getAllInActiveYelloPads() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_selectInActive]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		DataArrayModel<YelloPadModel>OBJ = new 	DataArrayModel<YelloPadModel>();
	
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setUniqueID(RS.getString(2));
				currentYelloPad.setNetworkCard(RS.getString(3));
				currentYelloPad.setStatus(RS.getString(14));
				currentYelloPad.setPicture(RS.getString(15));

				allYelloPads.add(currentYelloPad);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		OBJ.set_ArrayList(allYelloPads);
		return OBJ;
	}

	// -----------------------------------------------------------//
	/**
	 * This Function returns all relevant data of the YelloPad with the matching ID:
	 * -YelloPad's Unique ID -YelloPad's Status Name -YelloPad's Status Code
	 * -YelloPad's Network Card Number -YelloPad's Picture
	 * 
	 * @param ID: Unique ID of YelloPad
	 * @return YelloPadModel: Return the relevant data concerning the yelloPad with
	 *         the same ID
	 */
	public static YelloPadModel searchYelloPad(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Search] ?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad = new YelloPadModel();
		ResultSet RS;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, ID);

			RS = cstmt.executeQuery();
			RS.next();
			currentYelloPad.setYelloPadID(RS.getInt(1));
			currentYelloPad.setUniqueID(RS.getString(2));
			currentYelloPad.setNetworkCard(RS.getString(3));
			currentYelloPad.setStatus(RS.getString(14));
			currentYelloPad.setPicture(RS.getString(15));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return currentYelloPad;
	}

	// -----------------------------------------------------------//

	public static YelloPadModel getYelloPadStatus(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Status] ?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad = new YelloPadModel();
		ResultSet RS;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, ID);

			RS = cstmt.executeQuery();

			RS.next();

			currentYelloPad.setStatus(RS.getString(1));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return currentYelloPad;
	}

	// -----------------------------------------------------------//

	public static YelloPadModel getYelloPadNetworkCardNo(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_NetworkCard] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet RS;
		YelloPadModel currentYelloPad = new YelloPadModel();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, ID);
			RS = cstmt.executeQuery();
			RS.next();
			currentYelloPad.setNetworkCard(RS.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return currentYelloPad;
	}

}
