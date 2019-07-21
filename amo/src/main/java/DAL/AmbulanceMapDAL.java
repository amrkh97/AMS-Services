package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.AmbulanceMap.AllAmbulanceMapDataModel;
import Models.AmbulanceMap.AmbBatch;
import Models.AmbulanceMap.AmbulanceBatches;
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
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			rs.close();
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
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			rs.close();
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
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			rs.close();
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
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			rs.close();
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

	public static ServerResponse addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap) {
		ServerResponse _dataModel = new ServerResponse();
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
		_dataModel.setResponseHexCode(addStatus);
		if (_dataModel.getResponseHexCode().equals("00")) {
			_dataModel.setResponseMsg("Insertion Successful");
		} else if (_dataModel.getResponseHexCode().equals("01")) {
			_dataModel.setResponseMsg("Failed To insert because the car already has resources assigned");
		} else {
			_dataModel.setResponseMsg("Failed to insert because car is already assigned elsewhere");
		}

		return _dataModel;
	}

	// -------------------------------------------------------------------//

	public static ServerResponse deleteAmbulanceMap(Integer currentAmbulanceMap) {
		ServerResponse _ServerResponse = new ServerResponse();
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_deleteAmbulanceMap] ?,?";
		Connection conn = DBManager.getDBConn();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, currentAmbulanceMap);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.executeUpdate();
			_ServerResponse.setResponseHexCode(cstmt.getString(2));

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
		if (_ServerResponse.getResponseHexCode().equals("00")) {
			_ServerResponse.setResponseMsg("Deleted Successfully");
		} else {
			_ServerResponse.setResponseMsg("Failed to delete as it doesn't exist");
		}

		return _ServerResponse;
	}

	public static AllAmbulanceMapDataModel getRelevantData(DataModel vin, Connection intermediateConnection) {
		Connection conn = intermediateConnection;
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_getRelevantData] ?,?,?,?,?,?,?,?,?,?";
		AllAmbulanceMapDataModel obj = new AllAmbulanceMapDataModel();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, vin.getSentID());
			cstmt.registerOutParameter(2, Types.NVARCHAR); // License Plate
			cstmt.registerOutParameter(3, Types.NVARCHAR); // Make
			cstmt.registerOutParameter(4, Types.NVARCHAR); // ParamedicFName
			cstmt.registerOutParameter(5, Types.NVARCHAR); // ParamedicLName
			cstmt.registerOutParameter(6, Types.INTEGER); // ParamedicID
			cstmt.registerOutParameter(7, Types.NVARCHAR); // DriverFName
			cstmt.registerOutParameter(8, Types.NVARCHAR); // DriverLName
			cstmt.registerOutParameter(9, Types.INTEGER); // DriverID
			cstmt.registerOutParameter(10, Types.NVARCHAR); // YelloPadUniqueID

			cstmt.executeUpdate();

			obj.setVin(vin.getSentID());
			obj.setLicensePlate(cstmt.getString(2));
			obj.setMake(cstmt.getString(3));
			obj.setParamedicName(cstmt.getString(4) + " " + cstmt.getString(5));
			obj.setParamedicID(cstmt.getInt(6));
			obj.setDriverName(cstmt.getString(7) + " " + cstmt.getString(8));
			obj.setDriverID(cstmt.getInt(9));
			obj.setYelloPadUniqueID(cstmt.getString(10));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static AmbulanceBatches getAllbatches(DataModel vin, Connection intermediateConnection) {
		Connection conn = intermediateConnection;
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_getAllBatches] ?";
		AmbBatch ambBatch = new AmbBatch();
		AmbulanceBatches obj = new AmbulanceBatches();
		ArrayList<AmbBatch> batchs = new ArrayList<AmbBatch>();
		ResultSet resultSet;
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, vin.getSentID());
			resultSet = cstmt.executeQuery();

			while(resultSet.next()){
				ambBatch = new AmbBatch();
				ambBatch.setBatchID(resultSet.getLong(1));
				
				batchs.add(ambBatch);
			}
			
			resultSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		obj.setArrayOfBatches(batchs);
		return obj;
	}

}
