package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;

import java.util.ArrayList;
import Models.YelloPad.*;

public class YelloPadDAL {
	
	/**
	 * This Function returns all relevant data of the YelloPads
	 * which is: -YelloPad's Unique ID
	 * 			 -YelloPad's Status Name
	 * 			 -YelloPad's Status Code
	 * 			 -YelloPad's Network Card Number
	 * 			 -YelloPad's Picture
	 * @return JSONArray: Return A JSON Array of YelloPads 
	 */
	public static ArrayList<YelloPadModel> getYelloPads() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_SelectAll]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		//JSONArray jArray = new JSONArray();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	/*
			cstmt.registerOutParameter(1, Types.NVARCHAR); //YelloPadUniqueID
			cstmt.registerOutParameter(2, Types.NVARCHAR); //YelloPadStatus
			cstmt.registerOutParameter(3, Types.NVARCHAR); //YelloPadStatusCode
			cstmt.registerOutParameter(4, Types.NVARCHAR); //YelloPadNetworkCardNo
			cstmt.registerOutParameter(5, Types.NVARCHAR); //YelloPadPicture
	*/		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
//				JSONObject jObject= new JSONObject();
//		        jObject.put("yelloPadUniqueID",cstmt.getString(1));
//		        jObject.put("yelloPadStatus",cstmt.getString(2));
//		        jObject.put("yelloPadStatusCode",cstmt.getString(3));
//		        jObject.put("yelloPadNetworkCardNo",cstmt.getString(4));
//		        jObject.put("yelloPadPicture",cstmt.getString(5));
				
				YelloPadModel currentYelloPad= new YelloPadModel();
				currentYelloPad.setUniqueID(RS.getString("YelloPadUniqueID"));
				currentYelloPad.setStatus(RS.getString("StatusName"));
				currentYelloPad.setStatusCode(RS.getString("StatusNote"));		
				currentYelloPad.setNetworkCard(RS.getString("YellopadNetworkcardNo"));
		    	currentYelloPad.setPicture(RS.getString("YelloPadPicture"));
				
				allYelloPads.add(currentYelloPad);
			//	jArray.put(jObject);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	//	return jArray;
		return allYelloPads;
	}
	
	//-----------------------------------------------------------//
	/**
	 * This Function returns all relevant data of the YelloPad with the matching ID:
	 * 			 -YelloPad's Unique ID
	 * 			 -YelloPad's Status Name
	 * 			 -YelloPad's Status Code
	 * 			 -YelloPad's Network Card Number
	 *  		 -YelloPad's Picture
	 * 
	 * @param ID: Unique ID of YelloPad 
	 * @return JSONObject: Return the relevant data
	 *  concerning the yelloPad with the same ID
	 */
	public static YelloPadModel searchYelloPad(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Search] ?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad= new YelloPadModel();
		//JSONObject jsonObject = new JSONObject();
		ResultSet rs;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);

			rs=cstmt.executeQuery();
			rs.next();
			currentYelloPad.setUniqueID(rs.getString("YelloPadUniqueID"));
			currentYelloPad.setStatus(rs.getString("StatusName"));
			currentYelloPad.setStatusCode(rs.getString("StatusNote"));		
			currentYelloPad.setNetworkCard(rs.getString("YellopadNetworkcardNo"));
	    	currentYelloPad.setPicture(rs.getString("YelloPadPicture"));
			
//			jsonObject.put("yelloPadUniqueID",cstmt.getString(2));
//			jsonObject.put("yelloPadStatus",cstmt.getString(3));
//			jsonObject.put("yelloPadStatusCode",cstmt.getString(4));
//			jsonObject.put("yelloPadNetworkCardNo",cstmt.getString(5));
//			jsonObject.put("yelloPadPicture",cstmt.getString(6));
			
			
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
	
	//-----------------------------------------------------------//
	
	public static YelloPadModel getYelloPadStatus(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Status] ?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad= new YelloPadModel();
		//JSONObject jsonObject = new JSONObject();
		ResultSet rs;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			
			rs = cstmt.executeQuery();	
			
			rs.next();
			
			currentYelloPad.setStatus(rs.getString("StatusName"));
			System.out.println("StatusCode: "+ rs.getString("StatusName"));
			currentYelloPad.setStatusCode(rs.getString("StatusNote"));
			System.out.println("StatusCodeNote: "+ rs.getString("StatusNote"));
			
			//jsonObject.put("yelloPadStatus",cstmt.getString(2));
			//jsonObject.put("yelloPadStatusCode",cstmt.getString(3));
			
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
	
	//-----------------------------------------------------------//
	
	public static YelloPadModel getYelloPadNetworkCardNo(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_NetworkCard] ?,?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad= new YelloPadModel();
		//JSONObject jsonObject = new JSONObject();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			cstmt.registerOutParameter(2, Types.NVARCHAR); //YelloPadStatus
			cstmt.execute();
			
			currentYelloPad.setNetworkCard(cstmt.getString(2));
			System.out.println("NetworkCard: "+cstmt.getString(2));
			//jsonObject.put("yelloPadNetworkCardNo",cstmt.getString(2));
			
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

		//return jsonObject;
		return currentYelloPad;
	}
	
	
	

}
