package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Models.ServerResponse;
import Models.AmbulanceMap.AllAmbulanceMapDataModel;
import Models.AmbulanceMap.AmbBatch;
import Models.AmbulanceMap.AmbulanceBatches;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.Data.DataModel;

public class AmbulanceMapDAL {

	public static AmbulanceMapModel getAmbulanceCarMapByCarID(Integer ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByCarID] ?";
		 
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			if(rs.next()) {
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return currentAmbulanceMap;
	}

	// ------------------------------------------------------------------------//

	public static AmbulanceMapModel getAmbulanceCarMapByDriverID(Integer ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByDriverID] ?";
		 
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			if(rs.next()) {
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return currentAmbulanceMap;
	}

	// ------------------------------------------------------------------------//

	public static AmbulanceMapModel getAmbulanceCarMapByParamedicID(Integer ID, Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByParamedicID] ?";
		 
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			if(rs.next()) {
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentAmbulanceMap;
	}

	// ------------------------------------------------------------------------//

	public static AmbulanceMapModel getAmbulanceCarMapByYelloPadID(Integer ID,Connection intermediateConnection) {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_getAmbulanceCarMapByYelloPadID] ?";
		 
		ResultSet rs;
		AmbulanceMapModel currentAmbulanceMap = new AmbulanceMapModel();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setInt(1, ID);
			rs = cstmt.executeQuery();
			if(rs.next()){
			currentAmbulanceMap.setVin(rs.getInt(1));
			currentAmbulanceMap.setParamedicID(rs.getInt(2));
			currentAmbulanceMap.setDriverID(rs.getInt(3));
			currentAmbulanceMap.setYellopadID(rs.getInt(4));
			currentAmbulanceMap.setStatusMap(rs.getString(5));
			currentAmbulanceMap.setBatchID(rs.getLong(6));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentAmbulanceMap;
	}

	// ------------------------------------------------------------------------//

	public static ServerResponse addAmbulanceMap(AmbulanceMapModel currentAmbulanceMap,Connection intermediateConnection) {
		ServerResponse _dataModel = new ServerResponse();
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_Insert] ?,?,?,?,?";
		 
		String addStatus = "FF";
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setInt(1, currentAmbulanceMap.getVin());
			cstmt.setInt(2, currentAmbulanceMap.getParamedicID());
			cstmt.setInt(3, currentAmbulanceMap.getDriverID());
			cstmt.setInt(4, currentAmbulanceMap.getYellopadID());
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.executeUpdate();
			addStatus = cstmt.getString(5);
		} catch (SQLException e) {
			e.printStackTrace();
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

	public static ServerResponse deleteAmbulanceMap(Integer currentAmbulanceMap,Connection intermediateConnection) {
		ServerResponse _ServerResponse = new ServerResponse();
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_deleteAmbulanceMap] ?,?";
		 
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setInt(1, currentAmbulanceMap);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.executeUpdate();
			_ServerResponse.setResponseHexCode(cstmt.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (_ServerResponse.getResponseHexCode().equals("00")) {
			_ServerResponse.setResponseMsg("Deleted Successfully");
		} else {
			_ServerResponse.setResponseMsg("Failed to delete as it doesn't exist");
		}

		return _ServerResponse;
	}

	public static AllAmbulanceMapDataModel getRelevantData(DataModel vin, Connection intermediateConnection) {
		 
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_getRelevantData] ?,?,?,?,?,?,?,?,?,?";
		AllAmbulanceMapDataModel obj = new AllAmbulanceMapDataModel();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

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

	public static AmbulanceBatches getAllbatches(Integer vin, Connection intermediateConnection) {
		 
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_getAllBatches] ?";
		AmbBatch ambBatch = new AmbBatch();
		AmbulanceBatches obj = new AmbulanceBatches();
		ArrayList<AmbBatch> batchs = new ArrayList<AmbBatch>();
		ResultSet resultSet;
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);

			cstmt.setInt(1, vin);
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
	
	public static ServerResponse updateAmbulanceMap(AmbulanceMapModel model,Connection intermediateConnection) {
		ServerResponse response = new ServerResponse();
		 
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_Update] ?,?,?,?,?,?";
		
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			
			cstmt.setInt(1, model.getVin());
			
			try {	
				cstmt.setInt(3, model.getDriverID());
				
			}catch(NullPointerException e) {
				model.setDriverID(0);
				
				cstmt.setInt(3, model.getDriverID());
			}
			
			try {	
				cstmt.setInt(2, model.getParamedicID());
				
				
			}catch(NullPointerException e) {
			
				model.setParamedicID(0);
				cstmt.setInt(2, model.getParamedicID());
			}
			
			try {	
				cstmt.setInt(4, model.getYellopadID());
			}catch(NullPointerException e) {
				model.setYellopadID(0);;
				cstmt.setInt(4, model.getYellopadID());
			}
			
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.executeUpdate();
			
			response.setResponseHexCode(cstmt.getString(5));
			response.setResponseMsg(cstmt.getString(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static ServerResponse exchangeAmbulanceMap(AmbulanceMapModel model,Connection intermediateConnection) {
		ServerResponse response = new ServerResponse();
		 
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_AmbulanceMap_Exchange] ?,?,?,?,?,?";
		
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			
			cstmt.setInt(1, model.getVin());
			
			try {	
				cstmt.setInt(3, model.getDriverID());
				
			}catch(NullPointerException e) {
				model.setDriverID(0);
				
				cstmt.setInt(3, model.getDriverID());
			}
			
			try {	
				cstmt.setInt(2, model.getParamedicID());
				
				
			}catch(NullPointerException e) {
			
				model.setParamedicID(0);
				cstmt.setInt(2, model.getParamedicID());
			}
			
			try {	
				cstmt.setInt(4, model.getYellopadID());
			}catch(NullPointerException e) {
				model.setYellopadID(0);;
				cstmt.setInt(4, model.getYellopadID());
			}
			
			cstmt.registerOutParameter(5, Types.NVARCHAR);
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.executeUpdate();
			
			response.setResponseHexCode(cstmt.getString(5));
			response.setResponseMsg(cstmt.getString(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}


}
