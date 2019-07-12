package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.AmbulanceMap.AllAmbulanceMapDataModel;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.Data.DataModel;

public class AmbulanceMapDAL {

	public static AmbulanceMapModel getAmbulanceCarMapByCarID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByCarID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

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

	// ------------------------------------------------------------------------//

	public static AmbulanceMapModel getAmbulanceCarMapByDriverID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByDriverID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

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

	// ------------------------------------------------------------------------//

	public static AmbulanceMapModel getAmbulanceCarMapByParamedicID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByParamedicID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

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

	// ------------------------------------------------------------------------//

	public static AmbulanceMapModel getAmbulanceCarMapByYelloPadID(Integer ID) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByYelloPadID] ?";
		Connection conn = DBManager.getDBConn();
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

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

	// ------------------------------------------------------------------------//

	public static DataModel addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		DataModel _dataModel = new DataModel();
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_Insert] ?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		String addStatus = "FF";
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, currentAmbulanceMap.getVin());
			cstmt.setInt(2, currentAmbulanceMap.getParamedicID());
			cstmt.setInt(3, currentAmbulanceMap.getDriverID());
			cstmt.setInt(4, currentAmbulanceMap.getYellopadID());
			cstmt.registerOutParameter(5, Types.NVARCHAR);
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
		_dataModel.setSentStatus(addStatus);
		return _dataModel;
	}

	// -------------------------------------------------------------------//

	public static DataModel deleteAmbulanceMap(Integer currentAmbulanceMap) {
		DataModel _dataModel = new DataModel();
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
		_dataModel.setSentID(currentAmbulanceMap);
		return _dataModel;
	}

	public static AllAmbulanceMapDataModel getRelevantData(DataModel vin,Connection intermediateConnection) {
		Connection conn = intermediateConnection;
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_getRelevantData] ?,?,?,?,?,?,?,?,?,?";
		AllAmbulanceMapDataModel obj = new AllAmbulanceMapDataModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, vin.getSentID());
			cstmt.registerOutParameter(2, Types.NVARCHAR); //License Plate
			cstmt.registerOutParameter(3, Types.NVARCHAR); //Make
			cstmt.registerOutParameter(4, Types.NVARCHAR); //ParamedicFName
			cstmt.registerOutParameter(5, Types.NVARCHAR); //ParamedicLName
			cstmt.registerOutParameter(6, Types.INTEGER); //ParamedicID
			cstmt.registerOutParameter(7, Types.NVARCHAR); //DriverFName
			cstmt.registerOutParameter(8, Types.NVARCHAR); //DriverLName
			cstmt.registerOutParameter(9, Types.INTEGER); //DriverID
			cstmt.registerOutParameter(10, Types.NVARCHAR); //YelloPadUniqueID
			
			cstmt.executeUpdate();
			
			obj.setVin(vin.getSentID());
			obj.setLicensePlate(cstmt.getString(2));
			obj.setMake(cstmt.getString(3));
			obj.setParamedicName(cstmt.getString(4)+" "+cstmt.getString(5));
			obj.setParamedicID(cstmt.getInt(6));
			obj.setDriverName(cstmt.getString(7)+" "+cstmt.getString(8));
			obj.setDriverID(cstmt.getInt(9));
			obj.setYelloPadUniqueID(cstmt.getString(10));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
