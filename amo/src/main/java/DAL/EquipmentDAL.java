package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Models.ServerResponse;
import Models.Equipment.EquipmentModel;
import Models.Equipment.EquipmentModelArray;

public class EquipmentDAL {

	public static ServerResponse insertEquipment(EquipmentModel equipment, Connection intermediateConnection) {
			String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Equipment_Add] ?,?,?,?";
			 
			ServerResponse OBJ = new ServerResponse();

			try {
				CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
				cstmt.setString(1, equipment.getEquipmentName());
				cstmt.setString(2, equipment.getEquipmentDescription());
				
				cstmt.registerOutParameter(3, Types.NVARCHAR);
				cstmt.registerOutParameter(4, Types.NVARCHAR);
				cstmt.executeUpdate();
				
				OBJ.setResponseHexCode(cstmt.getString(4));
				OBJ.setResponseMsg(cstmt.getString(5));
				
			
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return OBJ;
		}

	public static EquipmentModelArray getAllEquipment(Connection intermediateConnection) {
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Equipment_getAll]";
		ResultSet RS;
		 
		ArrayList<EquipmentModel> allEquipment = new ArrayList<EquipmentModel>();
		EquipmentModelArray OBJ = new EquipmentModelArray();

		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				EquipmentModel currentEquipment = new EquipmentModel();
				currentEquipment.setEquipmentName(RS.getString(1));
				currentEquipment.setEquipmentDescription(RS.getString(2));
				
				allEquipment.add(currentEquipment);
			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		OBJ.setArrayOfEquipment(allEquipment);
		return OBJ;
	}

	public static EquipmentModel getEquipmentByName(EquipmentModel equipment, Connection intermediateConnection) {
		
		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Equipment_getByName] ?";
		ResultSet RS;
		EquipmentModel currentEquipment = new EquipmentModel();
		try {
			CallableStatement cstmt = intermediateConnection.prepareCall(SPsql);
			cstmt.setString(1, equipment.getEquipmentName());
			RS = cstmt.executeQuery();

			while (RS.next()) {

				
				currentEquipment.setEquipmentName(RS.getString(1));
				currentEquipment.setEquipmentDescription(RS.getString(2));

			}
			RS.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return currentEquipment;
	}
	
	
	}

