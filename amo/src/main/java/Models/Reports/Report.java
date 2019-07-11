package Models.Reports;
//---This Data type is the one that works with DATETIME in SQL---
//import java.sql.Timestamp;
//---------------------------------------------------------------

public class Report {
	private int reportId;
	private String reportTitle;
	private String reportIssueTime;
	private int patientId;
	private String reportDestination;
    private String reportStatus;
 	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportIssueTime() {
		return reportIssueTime;
	}

	public void setReportIssueTime(String reportIssueTime) {
		this.reportIssueTime = reportIssueTime;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getReportDestination() {
		return reportDestination;
	}

	public void setReportDestination(String reportDestination) {
		this.reportDestination = reportDestination;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
		
}
