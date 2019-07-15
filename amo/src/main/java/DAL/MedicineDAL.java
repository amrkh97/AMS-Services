package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.Medicine.Medicine;
import Models.Medicine.MedicineArray;

public class MedicineDAL {

	public static MedicineArray getAllMedicines() {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicines_SelectAll";
		Connection conn = DBManager.getDBConn();
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				medicine = new Medicine();
				medicine.setBarCode(rs.getString("BarCode"));
				medicine.setPrice(rs.getString("Price"));
				medicine.setCountInStock(rs.getInt("CountInStock"));
				medicine.setImplications(rs.getString("Implications"));
				medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				medicine.setSideEffects(rs.getString("SideEffects"));
				medicine.setActiveComponent(rs.getString("ActiveComponent"));
				medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				medicine.setMedicineName(rs.getString("MedicineName"));
				medicineList.add(medicine);
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

		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

	public static Medicine getMedicineByBC(String BarCode, Connection conn) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByBCode ?";
		
		//Check To Diffrentiate Between internal Calls and External Calls To This API Happened
		if(conn == null)
		{
			conn = DBManager.getDBConn();
		}
		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, BarCode);

			ResultSet resultSet = cstmt.executeQuery();

			// If There Is At least 1 Entry
			if (resultSet.next()) {
				medicine.setBarCode(resultSet.getString("BarCode"));
				medicine.setPrice(resultSet.getString("Price"));
				medicine.setCountInStock(resultSet.getInt("CountInStock"));
				medicine.setImplications(resultSet.getString("Implications"));
				medicine.setMedicineUsage(resultSet.getString("MedicineUsage"));
				medicine.setSideEffects(resultSet.getString("SideEffects"));
				medicine.setActiveComponent(resultSet.getString("ActiveComponent"));
				medicine.setMedicineStatus(resultSet.getString("MedicineStatus"));
				medicine.setMedicineName(resultSet.getString("MedicineName"));
			} else {
				// At This Point I Know That There Is No Entries at the database
				// TODO return an Error Indicating there was no data returned
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(!conn.equals(null))
				{
					conn.close();
					System.out.println("Connention Closed");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}

		return medicine;
	}

	public static ServerResponse insertMedicine(Medicine medicine) {

		String SPsql = "EXEC usp_Medicine_Insert ?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse serverResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, medicine.getBarCode());
			cstmt.setString(2, medicine.getMedicineName());
			cstmt.setInt(3, medicine.getCountInStock());
			cstmt.setNString(4, medicine.getPrice());
			cstmt.setString(5, medicine.getImplications());
			cstmt.setString(6, medicine.getMedicineUsage());
			cstmt.setString(7, medicine.getSideEffects());
			cstmt.setString(8, medicine.getActiveComponent());

			cstmt.registerOutParameter(9, Types.NVARCHAR);
			cstmt.registerOutParameter(10, Types.NVARCHAR);
			cstmt.execute();

			serverResponse.setResponseHexCode(cstmt.getString("responseCode"));
			serverResponse.setResponseMsg(cstmt.getString("responseMessage"));

			System.out.println("Insertion Result: " + cstmt.getString(10));

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
		return serverResponse;

	}

	public static ServerResponse UpdateMedicine(Medicine medicine) {

		String SPsql = "EXEC usp_Medicine_Update ?,?,?,?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse serverResponse = new ServerResponse();

		// check if the medicine with this bar code exists
		Medicine medicineSearchedByBC = getMedicineByBC(medicine.getBarCode(), conn);
		
		if (medicineSearchedByBC.equals(null)) {
			serverResponse = new ServerResponse();
			serverResponse.setResponseHexCode("FF");
			serverResponse.setResponseMsg("Medicine was Not found in database");
			return serverResponse;
		}
		
		// At this point the if condition tells me that the search was not null
		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, medicine.getBarCode());
			cstmt.setString(2, medicine.getMedicineName());
			cstmt.setInt(3, medicine.getCountInStock());
			cstmt.setNString(4, medicine.getPrice());
			cstmt.setString(5, medicine.getImplications());
			cstmt.setString(6, medicine.getMedicineUsage());
			cstmt.setString(7, medicine.getSideEffects());
			cstmt.setString(8, medicine.getActiveComponent());

			cstmt.registerOutParameter(9, Types.NVARCHAR);
			cstmt.registerOutParameter(10, Types.NVARCHAR);
			cstmt.execute();

			serverResponse.setResponseHexCode(cstmt.getString("responseCode"));
			serverResponse.setResponseMsg(cstmt.getString("responseMessage"));

		} catch (SQLException e) {
			System.out.println("i have an error");
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
		return serverResponse;

	}

	public static ServerResponse DeleteMedicine(String barCode) {

		System.out.println(barCode);

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_Delete ?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse serverResponse = new ServerResponse();

		// check if the medicine with this bar code exists
		Medicine medicineSearchedByBC = getMedicineByBC(barCode, conn);
		if (medicineSearchedByBC.equals(null)) {
			serverResponse = new ServerResponse();
			serverResponse.setResponseHexCode("FF");
			serverResponse.setResponseMsg("Not found medicine in database");
			return serverResponse;
		}
		
		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, barCode);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.execute();
			serverResponse.setResponseHexCode(cstmt.getString(2));
			serverResponse.setResponseMsg(cstmt.getString(3));

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
		return serverResponse;

	}

	public static MedicineArray getMedicineByActiveComponent(String activeComponent) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByActiveComponent ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, activeComponent);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				medicine = new Medicine();
				medicine.setBarCode(rs.getString("BarCode"));
				medicine.setPrice(rs.getString("Price"));
				medicine.setCountInStock(rs.getInt("CountInStock"));
				medicine.setImplications(rs.getString("Implications"));
				medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				medicine.setSideEffects(rs.getString("SideEffects"));
				medicine.setActiveComponent(rs.getString("ActiveComponent"));
				medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				medicine.setMedicineName(rs.getString("MedicineName"));
				medicineList.add(medicine);
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

		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

	public static MedicineArray getMedicineByCompanyName(String companyName) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByCompanyName ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, companyName);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				medicine = new Medicine();
				medicine.setBarCode(rs.getString("BarCode"));
				medicine.setPrice(rs.getString("Price"));
				medicine.setCountInStock(rs.getInt("CountInStock"));
				medicine.setImplications(rs.getString("Implications"));
				medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				medicine.setSideEffects(rs.getString("SideEffects"));
				medicine.setActiveComponent(rs.getString("ActiveComponent"));
				medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				medicine.setMedicineName(rs.getString("MedicineName"));
				medicineList.add(medicine);
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

		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

	public static MedicineArray getMedicineByCompanyStatus(String companyStatus) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByCompanyStatus ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, companyStatus);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				medicine = new Medicine();
				medicine.setBarCode(rs.getString("BarCode"));
				medicine.setPrice(rs.getString("Price"));
				medicine.setCountInStock(rs.getInt("CountInStock"));
				medicine.setImplications(rs.getString("Implications"));
				medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				medicine.setSideEffects(rs.getString("SideEffects"));
				medicine.setActiveComponent(rs.getString("ActiveComponent"));
				medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				medicine.setMedicineName(rs.getString("MedicineName"));
				medicineList.add(medicine);
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

		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

	public static MedicineArray getMedicineByContactPerson(String contactPerson) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByContactPerson ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, contactPerson);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				medicine = new Medicine();
				medicine.setBarCode(rs.getString("BarCode"));
				medicine.setPrice(rs.getString("Price"));
				medicine.setCountInStock(rs.getInt("CountInStock"));
				medicine.setImplications(rs.getString("Implications"));
				medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				medicine.setSideEffects(rs.getString("SideEffects"));
				medicine.setActiveComponent(rs.getString("ActiveComponent"));
				medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				medicine.setMedicineName(rs.getString("MedicineName"));
				medicineList.add(medicine);
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

		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

	public static Medicine getMedicineByName(String name) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByName ?";
		Connection conn = DBManager.getDBConn();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, name);
			ResultSet resultSet = cstmt.executeQuery();

			if (resultSet.next()) {
				medicine.setBarCode(resultSet.getString("BarCode"));
				medicine.setPrice(resultSet.getString("Price"));
				medicine.setCountInStock(resultSet.getInt("CountInStock"));
				medicine.setImplications(resultSet.getString("Implications"));
				medicine.setMedicineUsage(resultSet.getString("MedicineUsage"));
				medicine.setSideEffects(resultSet.getString("SideEffects"));
				medicine.setActiveComponent(resultSet.getString("ActiveComponent"));
				medicine.setMedicineStatus(resultSet.getString("MedicineStatus"));
				medicine.setMedicineName(resultSet.getString("MedicineName"));
			} else {
				// TODO Handle What To Return if No Single Row Was Found
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

		return medicine;
	}

	public static MedicineArray getMedicineByStatus(String status) {

		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectBySts ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		MedicineArray medicineArray = new MedicineArray();

		Medicine medicine = new Medicine();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, status);
			ResultSet resultSet = cstmt.executeQuery();

			while (resultSet.next()) {
				medicine = new Medicine();
				medicine.setBarCode(resultSet.getString("BarCode"));
				medicine.setPrice(resultSet.getString("Price"));
				medicine.setCountInStock(resultSet.getInt("CountInStock"));
				medicine.setImplications(resultSet.getString("Implications"));
				medicine.setMedicineUsage(resultSet.getString("MedicineUsage"));
				medicine.setSideEffects(resultSet.getString("SideEffects"));
				medicine.setActiveComponent(resultSet.getString("ActiveComponent"));
				medicine.setMedicineStatus(resultSet.getString("MedicineStatus"));
				medicine.setMedicineName(resultSet.getString("MedicineName"));
				medicineList.add(medicine);
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

		medicineArray.setMedicineArray(medicineList);
		return medicineArray;
	}

	public static ServerResponse UpdateMedicineStatus(String barcode, String newStatus) {
		String SPsql = "USE KAN_AMO; EXEC usp_Medicine_UpdateStatus ?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse serverResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(2, barcode);
			cstmt.setString(1, newStatus);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.registerOutParameter(4, Types.NVARCHAR);

			cstmt.execute();

			serverResponse.setResponseHexCode(cstmt.getString(3));
			serverResponse.setResponseMsg(cstmt.getString(4));

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
		return serverResponse;
	}

}
