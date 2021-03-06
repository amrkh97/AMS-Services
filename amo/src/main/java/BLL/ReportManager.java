package BLL;

import DAL.ReportsDal;
import Models.ServerResponse;
import Models.Reports.Report;
import Models.Reports.ReportList;

public class ReportManager {
	public static ReportList selectByReportTitle(String reportTitle) {
		System.out.println("Manager");
		return ReportsDal.selectByReportTitle(reportTitle);

	}

	public static ReportList selectByReportStatus(String reportStatus) {
		return ReportsDal.selectByReportStatus(reportStatus);
	}

	public static ReportList selectByReportIssueTime(String reportIssueTime) {
		return ReportsDal.selectByReportIssueTime(reportIssueTime);
	}

	public static ReportList selectByPatientId(int patientId) {
		return ReportsDal.selectByPatientId(patientId);
	}

	public static ReportList selectByReportTitleAndStatus(String ReportTitle, String ReportStatus) {
		return ReportsDal.selectByReportTitleAndStatus(ReportTitle, ReportStatus);
	}

	public static ServerResponse deleteReport(int reportId) {
		return ReportsDal.deleteReport(reportId);

	}

	public static ServerResponse insertReport(Report reportIN) {
		return ReportsDal.insertReport(reportIN);

	}
}
