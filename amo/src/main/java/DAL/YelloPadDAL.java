package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Models.ServerResponse;
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
		 
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setYelloPadUniqueID(RS.getString(2));
				currentYelloPad.setYelloPadNetworkCard(RS.getString(3));
				currentYelloPad.setYelloPadStatus(RS.getString(14));
				currentYelloPad.setYelloPadPicture(RS.getString(15));

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
		 
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setYelloPadUniqueID(RS.getString(2));
				currentYelloPad.setYelloPadNetworkCard(RS.getString(3));
				currentYelloPad.setYelloPadStatus(RS.getString(14));
				currentYelloPad.setYelloPadPicture(RS.getString(15));

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
		 
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setYelloPadUniqueID(RS.getString(2));
				currentYelloPad.setYelloPadNetworkCard(RS.getString(3));
				currentYelloPad.setYelloPadStatus(RS.getString(14));
				currentYelloPad.setYelloPadPicture(RS.getString(15));

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
		 
		YelloPadModel currentYelloPad = new YelloPadModel();
		ResultSet RS;
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setString(1, ID);

			RS = cstmt.executeQuery();
			if(RS.next()) {
			currentYelloPad.setYelloPadID(RS.getInt(1));
			currentYelloPad.setYelloPadUniqueID(RS.getString(2));
			currentYelloPad.setYelloPadNetworkCard(RS.getString(3));
			currentYelloPad.setYelloPadStatus(RS.getString(14));
			currentYelloPad.setYelloPadPicture(RS.getString(15));
			}
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return currentYelloPad;
	}

	// -----------------------------------------------------------//

	public static YelloPadModel getYelloPadStatus(String ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Status] ?";
		 
		YelloPadModel currentYelloPad = new YelloPadModel();
		ResultSet RS;
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setString(1, ID);

			RS = cstmt.executeQuery();

			if(RS.next())
			currentYelloPad.setYelloPadStatus(RS.getString(1));
			
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentYelloPad;
	}

	// -----------------------------------------------------------//

	public static YelloPadModel getYelloPadNetworkCardNo(String ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_NetworkCard] ?";
		 
		ResultSet RS;
		YelloPadModel currentYelloPad = new YelloPadModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setString(1, ID);
			RS = cstmt.executeQuery();
			if(RS.next())
			currentYelloPad.setYelloPadNetworkCard(RS.getString(1));
			
			RS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return currentYelloPad;
	}

	public static YelloPadArray getNotAssignedYelloPads(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_selectNotAssigned]";
		ResultSet RS;
		 
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setYelloPadUniqueID(RS.getString(2));
				currentYelloPad.setYelloPadNetworkCard(RS.getString(3));
				currentYelloPad.setYelloPadStatus(RS.getString(14));
				currentYelloPad.setYelloPadPicture(RS.getString(15));

				allYelloPads.add(currentYelloPad);
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setYelloPadArray(allYelloPads);
		return OBJ;
	}
	
	public static YelloPadArray getAssignedYelloPads(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_selectAssigned]";
		ResultSet RS;
		 
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		YelloPadArray OBJ = new YelloPadArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				YelloPadModel currentYelloPad = new YelloPadModel();
				currentYelloPad.setYelloPadID(RS.getInt(1));
				currentYelloPad.setYelloPadUniqueID(RS.getString(2));
				currentYelloPad.setYelloPadNetworkCard(RS.getString(3));
				currentYelloPad.setYelloPadStatus(RS.getString(14));
				currentYelloPad.setYelloPadPicture(RS.getString(15));

				allYelloPads.add(currentYelloPad);
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setYelloPadArray(allYelloPads);
		return OBJ;
	}

	public static ServerResponse insertYelloPad(YelloPadModel yelloPad, Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Insert] ?,?,?,?,?";
		 
		ServerResponse OBJ = new ServerResponse();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setString(1, yelloPad.getYelloPadUniqueID());
			cstmt.setString(2, yelloPad.getYelloPadNetworkCard());
			cstmt.setString(3, yelloPad.getYelloPadMaintenanceNote());
			cstmt.registerOutParameter(4, Types.NVARCHAR);
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.executeUpdate();
			
			OBJ.setResponseHexCode(cstmt.getString(4));
			OBJ.setResponseMsg(cstmt.getString(5));
			
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return OBJ;
	}
	
	public static ServerResponse updateYelloPadLocation(YelloPadModel yelloPad, Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_UpdateLocation] ?,?,?,?,?";
		 
		ServerResponse OBJ = new ServerResponse();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setString(1, yelloPad.getYelloPadUniqueID());
			cstmt.setString(2, yelloPad.getYelloPadLatitude());
			cstmt.setString(3, yelloPad.getYelloPadLongitude());
			cstmt.registerOutParameter(4, Types.NVARCHAR);
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.executeUpdate();
			
			OBJ.setResponseHexCode(cstmt.getString(4));
			OBJ.setResponseMsg(cstmt.getString(5));
			
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return OBJ;
	}

}
