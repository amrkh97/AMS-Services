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
	 * @return ArrayList<YelloPadModel>: Return an ArrayList of YelloPads 
	 */
	public static ArrayList<YelloPadModel> getYelloPads() {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_SelectAll]";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<YelloPadModel> allYelloPads = new ArrayList<YelloPadModel>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				YelloPadModel currentYelloPad= new YelloPadModel();
				currentYelloPad.setUniqueID(RS.getString("YelloPadUniqueID"));
				currentYelloPad.setStatus(RS.getString("YelloPadStatus"));		
				currentYelloPad.setNetworkCard(RS.getString("YellopadNetworkcardNo"));
		    	currentYelloPad.setPicture(RS.getString("YelloPadPicture"));
				
				allYelloPads.add(currentYelloPad);
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
	 * @return YelloPadModel: Return the relevant data
	 *  concerning the yelloPad with the same ID
	 */
	public static YelloPadModel searchYelloPad(String ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_Search] ?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad= new YelloPadModel();
		ResultSet rs;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);

			rs=cstmt.executeQuery();
			rs.next();
			currentYelloPad.setUniqueID(rs.getString("YelloPadUniqueID"));
			currentYelloPad.setStatus(rs.getString("YelloPadStatus"));		
			currentYelloPad.setNetworkCard(rs.getString("YellopadNetworkcardNo"));
	    	currentYelloPad.setPicture(rs.getString("YelloPadPicture"));
			
			
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
		ResultSet rs;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			
			rs = cstmt.executeQuery();	
			
			rs.next();
			
			currentYelloPad.setStatus(rs.getString("YelloPadStatus"));	
			
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

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_YelloPads_NetworkCard] ?";
		Connection conn = DBManager.getDBConn();
		YelloPadModel currentYelloPad= new YelloPadModel();
		ResultSet RS;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setString(1, ID);
			RS=cstmt.executeQuery();
			RS.next();
			currentYelloPad.setNetworkCard(RS.getString("YellopadNetworkcardNo"));
		
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
