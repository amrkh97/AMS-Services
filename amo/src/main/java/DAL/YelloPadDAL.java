package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBManager;
import Models.YelloPad.YelloPadArray;
import Models.YelloPad.YelloPadModel;

public class YelloPadDAL {

	/**
	 * This Function returns all relevant data of the YelloPads which is:
	 * -YelloPad's Unique ID -YelloPad's Status Name -YelloPad's Status Code
	 * -YelloPad's Network Card Number -YelloPad's Picture
	 * @param intermediateConnection 
	 * 
	 * @return ArrayList<YelloPadModel>: Return an ArrayList of YelloPads
	 */
	public static YelloPadArray getAllYelloPads(Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_SelectAll]";
		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

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
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setYelloPadArray(allYelloPads);
		return OBJ;
	}

	// -----------------------------------------------------------//

	public static YelloPadArray getAllActiveYelloPads(Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_selectActive]";
		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

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
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		OBJ.setYelloPadArray(allYelloPads);
		return OBJ;
	}

	// -----------------------------------------------------------//

	public static YelloPadArray getAllInActiveYelloPads(Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_selectInActive]";
		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

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
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setYelloPadArray(allYelloPads);
		return OBJ;
	}

	// -----------------------------------------------------------//
	/**
	 * This Function returns all relevant data of the YelloPad with the matching ID:
	 * -YelloPad's Unique ID -YelloPad's Status Name -YelloPad's Status Code
	 * -YelloPad's Network Card Number -YelloPad's Picture
	 * @param intermediateConnection 
	 * 
	 * @param ID: Unique ID of YelloPad
	 * @return YelloPadModel: Return the relevant data concerning the yelloPad with
	 *         the same ID
	 */
	public static YelloPadModel searchYelloPad(String ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Search] ?";
		Connection conn = intermediateConnection;
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
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return currentYelloPad;
	}

	// -----------------------------------------------------------//

	public static YelloPadModel getYelloPadStatus(String ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Status] ?";
		Connection conn = intermediateConnection;
		YelloPadModel currentYelloPad = new YelloPadModel();
		ResultSet RS;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, ID);

			RS = cstmt.executeQuery();

			RS.next();

			currentYelloPad.setStatus(RS.getString(1));
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentYelloPad;
	}

	// -----------------------------------------------------------//

	public static YelloPadModel getYelloPadNetworkCardNo(String ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_NetworkCard] ?";
		Connection conn = intermediateConnection;
		ResultSet RS;
		YelloPadModel currentYelloPad = new YelloPadModel();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, ID);
			RS = cstmt.executeQuery();
			RS.next();
			currentYelloPad.setNetworkCard(RS.getString(1));
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return currentYelloPad;
	}

}
