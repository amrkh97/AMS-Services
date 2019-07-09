package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.Medicine.CompanyMedicineMap;

public class CompanyMedicineMapDAL {

//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// GET ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList<CompanyMedicineMap> getCompanyMedicineMap(CompanyMedicineMap Map) {

		String SPsql = "USE KAN_AMO; EXEC usp_CompanyMedicineMap_Select  ?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<CompanyMedicineMap> Array = new ArrayList<CompanyMedicineMap>();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, Map.getCompID());
			cstmt.setString(2, Map.getMedBCode());
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				CompanyMedicineMap _Map = new CompanyMedicineMap();

				_Map.setCompID(rs.getInt("CompID"));
				_Map.setMedBCode(rs.getString("MedBCode"));
				_Map.setMapStatus(rs.getString("MapStatus"));
				Array.add(_Map);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}

		return Array;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////INSERT ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse insertRelation(CompanyMedicineMap Map) {

		String SPsql = "EXEC usp_CompanyMedicineMap_Insert  ?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, Map.getCompID());
			cstmt.setString(2, Map.getMedBCode());

			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.registerOutParameter(4, Types.NVARCHAR);
			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString(3));

			_ServerResponse.setResponseMsg(cstmt.getString(4));

		} catch (SQLException e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _ServerResponse;

	}

//////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////// UPDATE STATUS ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse UpdateRelationStatus(CompanyMedicineMap Map, String NewStatus) {
		String SPsql = "USE KAN_AMO; EXEC usp_CompanyMedicineMap_UpdateStatus ?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, Map.getCompID());
			cstmt.setString(2, Map.getMedBCode());
			cstmt.setString(3, NewStatus);

			cstmt.registerOutParameter(4, Types.NVARCHAR);
			cstmt.registerOutParameter(5, Types.NVARCHAR);

			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString(4));
			_ServerResponse.setResponseMsg(cstmt.getString(5));

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _ServerResponse;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////// DELETE ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse DeleteRelation(CompanyMedicineMap Map) {
		String SPsql = "USE KAN_AMO; EXEC usp_CompanyMedicineMap_DELETE ?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, Map.getCompID());
			cstmt.setString(2, Map.getMedBCode());
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.registerOutParameter(4, Types.NVARCHAR);

			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString(3));
			_ServerResponse.setResponseMsg(cstmt.getString(4));

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _ServerResponse;
	}

}
