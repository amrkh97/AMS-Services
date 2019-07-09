package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.AmbulanceMap.AmbulanceMapModel;

public class AmbulanceMapDAL {

	public static AmbulanceMapModel getAmbulanceCarMapByCarID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByCarID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap= new AmbulanceMapModel();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			rs.next();
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			
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

		return currentAmbulanceMap;
	}
	
	//------------------------------------------------------------------------//
	
	public static AmbulanceMapModel getAmbulanceCarMapByDriverID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByDriverID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap= new AmbulanceMapModel();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			rs.next();
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			
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

		return currentAmbulanceMap;
	}
	
	//------------------------------------------------------------------------//
	
	public static AmbulanceMapModel getAmbulanceCarMapByParamedicID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByParamedicID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap= new AmbulanceMapModel();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			rs.next();
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			
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

		return currentAmbulanceMap;
	}

	//------------------------------------------------------------------------//
	
	public static AmbulanceMapModel getAmbulanceCarMapByYelloPadID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByYelloPadID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap= new AmbulanceMapModel();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			rs.next();
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			
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

		return currentAmbulanceMap;
	}

	//------------------------------------------------------------------------//

	public static String addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_Insert] ?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		String addStatus = "FF";
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, currentAmbulanceMap.getVin());
			cstmt.setInt(2, currentAmbulanceMap.getParamedicID());
			cstmt.setInt(3, currentAmbulanceMap.getDriverID());
			cstmt.setInt(4, currentAmbulanceMap.getYellopadID());
			cstmt.registerOutParameter(5,Types.NVARCHAR);
			cstmt.executeUpdate();
			addStatus = cstmt.getString(5);
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

		return addStatus;
	}
	
	//-------------------------------------------------------------------//
	
	public static Integer deleteAmbulanceMap(Integer currentAmbulanceMap) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_deleteAmbulanceMap] ?";
		Connection conn = DBManager.getDBConn();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
	
			cstmt.setInt(1, currentAmbulanceMap);
			cstmt.executeUpdate();
			
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

		return currentAmbulanceMap;
	}
	
	
	
}
