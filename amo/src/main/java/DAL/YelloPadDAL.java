package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.json.JSONArray;
import org.json.JSONObject;

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
	public static JSONArray getYelloPads() {

		String SPsql = "EXEC usp_YelloPads_SelectAll";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		//ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		JSONArray jArray = new JSONArray();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.registerOutParameter(1, Types.NVARCHAR); //YelloPadUniqueID
			cstmt.registerOutParameter(2, Types.NVARCHAR); //YelloPadStatus
			cstmt.registerOutParameter(3, Types.NVARCHAR); //YelloPadStatusCode
			cstmt.registerOutParameter(4, Types.NVARCHAR); //YelloPadNetworkCardNo
			
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				JSONObject jObject= new JSONObject();
		        jObject.put("yelloPadUniqueID",cstmt.getString(1));
		        jObject.put("yelloPadStatus",cstmt.getString(2));
		        jObject.put("yelloPadStatusCode",cstmt.getString(3));
		        jObject.put("yelloPadNetworkCardNo",cstmt.getString(4));
		        jObject.put("yelloPadPicture",cstmt.getString(5));
				
			//	YelloPadModel currentYelloPad= new YelloPadModel();
			//	currentYelloPad.setUniqueID(cstmt.getString(1));
			//	currentYelloPad.setStatus(cstmt.getString(2));
		    //	currentYelloPad.setStatusCode(cstmt.getString(3));
			//	currentYelloPad.setNetworkCard(cstmt.getString(4));
		    //  currentYelloPad.setPicture(cstmt.getString(5));
				
			//	allYelloPads.add(currentYelloPad);
				jArray.put(jObject);
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

		return jArray;
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
	public static JSONObject searchYelloPad(String ID) {

		String SPsql = "EXEC usp_YelloPads_Search";
		Connection conn = DBManager.getDBConn();
		//YelloPadModel currentYelloPad= new YelloPadModel();
		JSONObject jsonObject = new JSONObject();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			cstmt.registerOutParameter(2, Types.NVARCHAR); //YelloPadUniqueID
			cstmt.registerOutParameter(3, Types.NVARCHAR); //YelloPadStatus
			cstmt.registerOutParameter(4, Types.NVARCHAR); //YelloPadStatusCode
			cstmt.registerOutParameter(5, Types.NVARCHAR); //YelloPadNetworkCardNo
			cstmt.registerOutParameter(6, Types.NVARCHAR); //YelloPadPicture
			
			if(cstmt.execute()) {	
		//	currentYelloPad.setUniqueID(cstmt.getString(2));
		//	currentYelloPad.setStatus(cstmt.getString(3));
		//	currentYelloPad.setStatusCode(cstmt.getString(4));		
		//	currentYelloPad.setNetworkCard(cstmt.getString(5));
	    //	currentYelloPad.setPicture(cstmt.getString(6));
			
			jsonObject.put("yelloPadUniqueID",cstmt.getString(2));
			jsonObject.put("yelloPadStatus",cstmt.getString(3));
			jsonObject.put("yelloPadStatusCode",cstmt.getString(4));
			jsonObject.put("yelloPadNetworkCardNo",cstmt.getString(5));
			jsonObject.put("yelloPadPicture",cstmt.getString(6));
			
			}else {
				System.out.println("Statement Execute Returned False!");
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
	
		return jsonObject;
	}
	
	//-----------------------------------------------------------//
	
	public static JSONObject getYelloPadStatus(String ID) {

		String SPsql = "EXEC usp_YelloPads_Status";
		Connection conn = DBManager.getDBConn();
		//YelloPadModel currentYelloPad= new YelloPadModel();
		JSONObject jsonObject = new JSONObject();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			cstmt.registerOutParameter(2, Types.NVARCHAR); //YelloPadStatus
			cstmt.registerOutParameter(3, Types.NVARCHAR); //YelloPadStatusCode
	
			if(cstmt.execute()) {	
			//currentYelloPad.setStatus(cstmt.getString(2));
			jsonObject.put("yelloPadStatus",cstmt.getString(2));
			jsonObject.put("yelloPadStatusCode",cstmt.getString(3));
			}else {
				System.out.println("Statement Execute Returned False!");
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

		return jsonObject;
	}
	
	//-----------------------------------------------------------//
	
	public static JSONObject getYelloPadNetworkCardNo(String ID) {

		String SPsql = "EXEC usp_YelloPads_NetworkCard";
		Connection conn = DBManager.getDBConn();
		//YelloPadModel currentYelloPad= new YelloPadModel();
		JSONObject jsonObject = new JSONObject();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			cstmt.registerOutParameter(2, Types.NVARCHAR); //YelloPadStatus
	
			if(cstmt.execute()) {	
		//	currentYelloPad.setStatus(cstmt.getString(2));
			jsonObject.put("yelloPadNetworkCardNo",cstmt.getString(2));
			}else {
				System.out.println("Statement Execute Returned False!");
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

		return jsonObject;
	}
	
	
	

}
