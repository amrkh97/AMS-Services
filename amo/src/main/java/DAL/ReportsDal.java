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
import Models.Reports.Report;
import Models.Reports.ReportList;

public class ReportsDal {

	// ---------------------------------------------------------------------
	public static ServerResponse deleteReport(int reportId) {
		String SPsql = "EXEC usp_Reports_Delete ?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setInt(1, reportId);
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
	// ---------------------------------------------------------------------

	// ---------------------------------------------------------------------
	public static ServerResponse insertReport(Report reportIN) {
		String SPsql = "EXEC usp_Report_Insert ?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();

		try {

			CallableStatement cstmt = conn.prepareCall(SPsql);

			cstmt.setString(1, reportIN.getReportTitle());
			cstmt.setInt(2, reportIN.getPatientId());
			cstmt.setString(3, reportIN.getReportDestination());
			cstmt.registerOutParameter(4, Types.NVARCHAR);
			cstmt.registerOutParameter(5, Types.NVARCHAR);
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

	// ---------------------------------------------------------------------
	public static ReportList selectByReportTitle(String reportTitle) {
		System.out.println("Dal");
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Reports_SelectByReportTitle] ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Report> R = new ArrayList<Report>();
		ReportList RepList = new ReportList();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, reportTitle);
			ResultSet resultSet = cstmt.executeQuery();
			while (resultSet.next()) {
				Report _r = new Report();
				_r.setReportId(resultSet.getInt("ReportID"));
				_r.setPatientId(resultSet.getInt("PatientID"));
				_r.setReportDestination(resultSet.getString("ReportDestination"));
				_r.setReportIssueTime(resultSet.getString("ReportIssueTime"));
				_r.setReportStatus(resultSet.getString("ReportStatus"));
				_r.setReportTitle(resultSet.getString("ReportTitle"));
				R.add(_r);
			}
			resultSet.close();
			RepList.setListOfReports(R);
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
		return RepList;

	}

	public static ReportList selectByReportStatus(String reportStatus) {
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Reports_SelectByReportStatus] ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Report> R = new ArrayList<Report>();
		ReportList RepList = new ReportList();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, reportStatus);
			ResultSet resultSet = cstmt.executeQuery();
			while (resultSet.next()) {
				Report _r = new Report();
				_r.setReportId(resultSet.getInt("ReportID"));
				_r.setPatientId(resultSet.getInt("PatientID"));
				_r.setReportDestination(resultSet.getString("ReportDestination"));
				_r.setReportIssueTime(resultSet.getString("ReportIssueTime"));
				_r.setReportStatus(resultSet.getString("ReportStatus"));
				_r.setReportTitle(resultSet.getString("ReportTitle"));
				R.add(_r);
			}
			resultSet.close();
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
		RepList.setListOfReports(R);
		return RepList;

	}

	public static ReportList selectByReportIssueTime(String reportIssueTime) {
		if (reportIssueTime.length() >= 16) {
			String[] Time = reportIssueTime.split("\\s");
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
					ArrayList<Report> R = new ArrayList<Report>();
					ReportList RepList = new ReportList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Report _r = new Report();
							_r.setReportId(rs.getInt("ReportID"));
							_r.setPatientId(rs.getInt("PatientID"));
							_r.setReportDestination(rs.getString("ReportDestination"));
							_r.setReportIssueTime(rs.getString("ReportIssueTime"));
							_r.setReportStatus(rs.getString("ReportStatus"));
							_r.setReportTitle(rs.getString("ReportTitle"));
							R.add(_r);
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
					RepList.setListOfReports(R);
					return RepList;
				} else if (Date[2].equals("00")) {

					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year_Month] ?,?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Report> R = new ArrayList<Report>();
					ReportList RepList = new ReportList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						cstmt.setInt(2, Integer.valueOf(Date[1]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Report _r = new Report();
							_r.setReportId(rs.getInt("ReportID"));
							_r.setPatientId(rs.getInt("PatientID"));
							_r.setReportDestination(rs.getString("ReportDestination"));
							_r.setReportIssueTime(rs.getString("ReportIssueTime"));
							_r.setReportStatus(rs.getString("ReportStatus"));
							_r.setReportTitle(rs.getString("ReportTitle"));
							R.add(_r);
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
					RepList.setListOfReports(R);
					return RepList;

				} else if (Time[0].equals("00")) {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year_Month_Day] ?,?,?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Report> R = new ArrayList<Report>();
					ReportList RepList = new ReportList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						cstmt.setInt(2, Integer.valueOf(Date[1]));
						cstmt.setInt(3, Integer.valueOf(Date[2]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Report _r = new Report();
							_r.setReportId(rs.getInt("ReportID"));
							_r.setPatientId(rs.getInt("PatientID"));
							_r.setReportDestination(rs.getString("ReportDestination"));
							_r.setReportIssueTime(rs.getString("ReportIssueTime"));
							_r.setReportStatus(rs.getString("ReportStatus"));
							_r.setReportTitle(rs.getString("ReportTitle"));
							R.add(_r);
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
					RepList.setListOfReports(R);
					return RepList;
				} else if (Time[1].equals("00")) {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Year_Month_Day_Hour] ?,?,?,?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Report> R = new ArrayList<Report>();
					ReportList RepList = new ReportList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						cstmt.setInt(1, Integer.valueOf(Date[0]));
						cstmt.setInt(2, Integer.valueOf(Date[1]));
						cstmt.setInt(3, Integer.valueOf(Date[2]));
						cstmt.setInt(4, Integer.valueOf(Date[3]));
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Report _r = new Report();
							_r.setReportId(rs.getInt("ReportID"));
							_r.setPatientId(rs.getInt("PatientID"));
							_r.setReportDestination(rs.getString("ReportDestination"));
							_r.setReportIssueTime(rs.getString("ReportIssueTime"));
							_r.setReportStatus(rs.getString("ReportStatus"));
							_r.setReportTitle(rs.getString("ReportTitle"));
							R.add(_r);
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
					RepList.setListOfReports(R);
					return RepList;
				} else {
					String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Receipt_By_Full_Time] ?";
					Connection conn = DBManager.getDBConn();
					ArrayList<Report> R = new ArrayList<Report>();
					ReportList RepList = new ReportList();
					try {
						CallableStatement cstmt = conn.prepareCall(SPsql);
						Timestamp T = Timestamp.valueOf(reportIssueTime);
						cstmt.setTimestamp(1, T);
						ResultSet rs = cstmt.executeQuery();
						while (rs.next()) {
							Report _r = new Report();
							_r.setReportId(rs.getInt("ReportID"));
							_r.setPatientId(rs.getInt("PatientID"));
							_r.setReportDestination(rs.getString("ReportDestination"));
							_r.setReportIssueTime(rs.getString("ReportIssueTime"));
							_r.setReportStatus(rs.getString("ReportStatus"));
							_r.setReportTitle(rs.getString("ReportTitle"));
							R.add(_r);
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
					RepList.setListOfReports(R);
					return RepList;
				}
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public static ReportList selectByPatientId(int patientId) {
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Reports_SelectByPatientID] ?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Report> R = new ArrayList<Report>();
		ReportList RepList = new ReportList();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setInt(1, patientId);
			ResultSet resultSet = cstmt.executeQuery();
			while (resultSet.next()) {
				Report _r = new Report();
				_r.setReportId(resultSet.getInt("ReportID"));
				_r.setPatientId(resultSet.getInt("PatientID"));
				_r.setReportDestination(resultSet.getString("ReportDestination"));
				_r.setReportIssueTime(resultSet.getString("ReportIssueTime"));
				_r.setReportStatus(resultSet.getString("ReportStatus"));
				_r.setReportTitle(resultSet.getString("ReportTitle"));
				R.add(_r);
			}
			resultSet.close();
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
		RepList.setListOfReports(R);
		return RepList;

	}

	public static ReportList selectByReportTitleAndStatus(String ReportTitle, String ReportStatus) {
		String SPsql = "use KAN_AMO; EXEC [dbo].[usp_Reports_SelectByReportTitleAndStatus] ?,?";
		Connection conn = DBManager.getDBConn();
		ArrayList<Report> R = new ArrayList<Report>();
		ReportList RepList = new ReportList();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, ReportTitle);
			cstmt.setString(2, ReportStatus);
			ResultSet resultSet = cstmt.executeQuery();
			while (resultSet.next()) {
				Report _r = new Report();
				_r.setReportId(resultSet.getInt("ReportID"));
				_r.setPatientId(resultSet.getInt("PatientID"));
				_r.setReportDestination(resultSet.getString("ReportDestination"));
				_r.setReportIssueTime(resultSet.getString("ReportIssueTime"));
				_r.setReportStatus(resultSet.getString("ReportStatus"));
				_r.setReportTitle(resultSet.getString("ReportTitle"));
				R.add(_r);
			}
			resultSet.close();
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
		RepList.setListOfReports(R);
		return RepList;

	}
}
