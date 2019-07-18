package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
//---------------------------------------------------------------
import java.sql.ResultSet;
import java.sql.SQLException;
//---This Data type is the one that works with DATETIME in SQL---
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.Receipts.Receipt;
import Models.Receipts.ReceiptList;

public class ReceiptsDAL {
	// -------------------1--------------------------------------------------
	public static ServerResponse deleteReceipt(int receiptId) {
		String SPsql = "EXEC usp_Receipt_Delete ?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, receiptId);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));

			_ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));

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

	// --------------------2-------------------------------------------------
	// ---------------------------------------------------------------------
	public static ServerResponse insertReceipt(Receipt receiptIN) {
		String SPsql = "EXEC usp_Receipt_Insert ?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

//RespSQN,CasheirSSN,FTPFileLocation,ReceiptStatus,Cost,PaymentMethod
			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, receiptIN.getRespSQN());
			cstmt.setInt(2, receiptIN.getCasheirSSN());
			cstmt.setString(3, receiptIN.getFTPFileLocation());
			cstmt.setString(4, receiptIN.getCost());
			cstmt.setString(5, receiptIN.getPaymentMethod());
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.registerOutParameter(7, Types.NVARCHAR);
			cstmt.execute();

			_ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));

			_ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));

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

	// ---------------------3------------------------------------------------
	// ---------------------------------------------------------------------
	public static ReceiptList getRecByRespSQN(String respSQN) {

		System.out.println("DAL");
		String SPsql = "USE KAN_AMO; EXEC usp_Receipt_SelectByRespSQN ?,?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Receipt> Array = new ArrayList<Receipt>();
		ReceiptList R = new ReceiptList();

		Receipt _Receipt = new Receipt();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, respSQN);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
				_Receipt.setCost(rs.getString("Cost"));
				_Receipt.setRespSQN(rs.getString("RespSQN"));
				_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
				_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
				_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
				_Receipt.setReceiptID(rs.getInt("ReceiptID"));
				_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
				Array.add(_Receipt);

			}

			rs.close();

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
		R.setReceiptArr(Array);
		return R;
	}

	// ----------------------4-----------------------------------------------
	// ---------------------------------------------------------------------
	public static ReceiptList getRecByCasheirSSN(int casheirSSN) {

		String SPsql = "USE KAN_AMO; EXEC usp_Receipt_SelectByCasheirSSN ?,?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Receipt> Array = new ArrayList<Receipt>();
		ReceiptList R = new ReceiptList();

		Receipt _Receipt = new Receipt();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, casheirSSN);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
				_Receipt.setCost(rs.getString("Cost"));
				_Receipt.setRespSQN(rs.getString("RespSQN"));
				_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
				_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
				_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
				_Receipt.setReceiptID(rs.getInt("ReceiptID"));
				_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
				Array.add(_Receipt);
			}

			rs.close();

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

		R.setReceiptArr(Array);
		return R;
	}

	// -----------------------5----------------------------------------------
	// ---------------------------------------------------------------------
	public static ReceiptList getRecByFTPFileLocation(String FTPFileLocation) {

		String SPsql = "USE KAN_AMO; EXEC usp_Receipt_SelectByFTPFileLocation  ?,?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Receipt> Array = new ArrayList<Receipt>();
		ReceiptList R = new ReceiptList();

		Receipt _Receipt = new Receipt();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			System.out.println(FTPFileLocation);
			cstmt.setString(1, FTPFileLocation);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
				_Receipt.setCost(rs.getString("Cost"));
				_Receipt.setRespSQN(rs.getString("RespSQN"));
				_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
				_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
				_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
				_Receipt.setReceiptID(rs.getInt("ReceiptID"));
				_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
				Array.add(_Receipt);
			}

			rs.close();

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

		R.setReceiptArr(Array);
		return R;
	}

	// ------------------------6---------------------------------------------
	// ---------------------------------------------------------------------
	public static ReceiptList getRecByReceiptStatus(String receiptStatus) {

		String SPsql = "USE KAN_AMO; EXEC usp_Receipt_SelectByReceiptStatus ?,?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Receipt> Array = new ArrayList<Receipt>();
		ReceiptList R = new ReceiptList();

		Receipt _Receipt = new Receipt();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			System.out.println(receiptStatus);
			cstmt.setString(1, receiptStatus);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			ResultSet rs = cstmt.executeQuery();
			System.out.println(receiptStatus);
			while (rs.next()) {
				_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
				_Receipt.setCost(rs.getString("Cost"));
				_Receipt.setRespSQN(rs.getString("RespSQN"));
				_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
				_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
				_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
				_Receipt.setReceiptID(rs.getInt("ReceiptID"));
				_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
				Array.add(_Receipt);
			}

			rs.close();

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

		R.setReceiptArr(Array);
		return R;
	}

	// -------------------------7--------------------------------------------
	// ---------------------------------------------------------------------
	public static ReceiptList getRecByCost(String cost) {

		String SPsql = "USE KAN_AMO; EXEC usp_Receipt_SelectByCost ?,?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Receipt> Array = new ArrayList<Receipt>();
		ReceiptList R = new ReceiptList();

		Receipt _Receipt = new Receipt();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, cost);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
				_Receipt.setCost(rs.getString("Cost"));
				_Receipt.setRespSQN(rs.getString("RespSQN"));
				_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
				_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
				_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
				_Receipt.setReceiptID(rs.getInt("ReceiptID"));
				_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
				Array.add(_Receipt);
			}

			rs.close();

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

		R.setReceiptArr(Array);
		return R;
	}

	// --------------------------8-------------------------------------------
	// ---------------------------------------------------------------------
	public static ReceiptList getRecByPaymentMethod(String paymentMethod) {

		String SPsql = "USE KAN_AMO; EXEC usp_Receipt_SelectByPaymentMethod ?,?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Receipt> Array = new ArrayList<Receipt>();
		ReceiptList R = new ReceiptList();

		Receipt _Receipt = new Receipt();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, paymentMethod);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
				_Receipt.setCost(rs.getString("Cost"));
				_Receipt.setRespSQN(rs.getString("RespSQN"));
				_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
				_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
				_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
				_Receipt.setReceiptID(rs.getInt("ReceiptID"));
				_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
				Array.add(_Receipt);
			}

			rs.close();

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

		R.setReceiptArr(Array);
		return R;
	}

	// -------------------------9--------------------------------------------------------
	public static ReceiptList selectByReceiptCreationTime(String ReceiptCreationTime) {
		// --------------------------------------------------------
		// --------------------------------------------------------
		if (ReceiptCreationTime.length() >= 16) {
			String[] Time = ReceiptCreationTime.split("\\s");
			int m = Time.length;
			int n;
			String[] Date;
			Date = Time[0].split("-");
			if (m > 1) {
				Time = Time[1].split(":");
			}
			n = Date.length;
			m = Time.length;
			System.out.println(n);
			System.out.println(m);
			// --------------------------------------------------------
			// --------------------------------------------------------
			if (!(Date[0].equals("0000"))) {

				if (Date[1].equals("00")) {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year] ?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Receipt> R = new ArrayList<Receipt>();
					ReceiptList Arr = new ReceiptList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Receipt _Receipt = new Receipt();
							_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
							_Receipt.setCost(rs.getString("Cost"));
							_Receipt.setRespSQN(rs.getString("RespSQN"));
							_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
							_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
							_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
							_Receipt.setReceiptID(rs.getInt("ReceiptID"));
							_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
							R.add(_Receipt);
						}
						rs.close();
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
					Arr.setReceiptArr(R);
					return Arr;
				} else if (Date[2].equals("00")) {

					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year_Month] ?,?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Receipt> R = new ArrayList<Receipt>();
					ReceiptList Arr = new ReceiptList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						cstmt.setInt(2, Integer.valueOf(Date[1]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Receipt _Receipt = new Receipt();
							_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
							_Receipt.setCost(rs.getString("Cost"));
							_Receipt.setRespSQN(rs.getString("RespSQN"));
							_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
							_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
							_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
							_Receipt.setReceiptID(rs.getInt("ReceiptID"));
							_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
							R.add(_Receipt);
						}
						rs.close();
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
					Arr.setReceiptArr(R);
					return Arr;

				} else if (Time[0].equals("00")) {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year_Month_Day] ?,?,?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Receipt> R = new ArrayList<Receipt>();
					ReceiptList Arr = new ReceiptList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						cstmt.setInt(2, Integer.valueOf(Date[1]));
						cstmt.setInt(3, Integer.valueOf(Date[2]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Receipt _Receipt = new Receipt();
							_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
							_Receipt.setCost(rs.getString("Cost"));
							_Receipt.setRespSQN(rs.getString("RespSQN"));
							_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
							_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
							_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
							_Receipt.setReceiptID(rs.getInt("ReceiptID"));
							_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
							R.add(_Receipt);
						}
						rs.close();
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
					Arr.setReceiptArr(R);
					return Arr;
				} else if (Time[1].equals("00")) {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year_Month_Day_Hour] ?,?,?,?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Receipt> R = new ArrayList<Receipt>();
					ReceiptList Arr = new ReceiptList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						cstmt.setInt(2, Integer.valueOf(Date[1]));
						cstmt.setInt(3, Integer.valueOf(Date[2]));
						cstmt.setInt(4, Integer.valueOf(Date[3]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Receipt _Receipt = new Receipt();
							_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
							_Receipt.setCost(rs.getString("Cost"));
							_Receipt.setRespSQN(rs.getString("RespSQN"));
							_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
							_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
							_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
							_Receipt.setReceiptID(rs.getInt("ReceiptID"));
							_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
							R.add(_Receipt);
						}
						rs.close();
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
					Arr.setReceiptArr(R);
					return Arr;
				} else {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Full_Time] ?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Receipt> R = new ArrayList<Receipt>();
					ReceiptList Arr = new ReceiptList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						Timestamp T = Timestamp.valueOf(ReceiptCreationTime);
						cstmt.setTimestamp(1, T);
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Receipt _Receipt = new Receipt();
							_Receipt.setCasheirSSN(rs.getInt("CasheirSSN"));
							_Receipt.setCost(rs.getString("Cost"));
							_Receipt.setRespSQN(rs.getString("RespSQN"));
							_Receipt.setfTPFileLocation(rs.getString("FTPFileLocation"));
							_Receipt.setPaymentMethod(rs.getString("PaymentMethod"));
							_Receipt.setReceiptCreationTime(rs.getString("ReceiptCreationTime"));
							_Receipt.setReceiptID(rs.getInt("ReceiptID"));
							_Receipt.setReceiptStatus(rs.getString("ReceiptStatus"));
							R.add(_Receipt);
						}
						rs.close();
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
					Arr.setReceiptArr(R);
					return Arr;
				}
			} else {
				return null;
			}

		} else {
			return null;
		}
	}
}
