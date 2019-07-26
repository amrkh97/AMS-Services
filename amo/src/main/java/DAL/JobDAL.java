package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import Models.ServerResponse;
import Models.Job.Job;
import Models.Job.JobArray;

public class JobDAL {

	public static JobArray getAllJobs(Connection intermediateConnection) {
		String SPsql = "EXEC usp_Jobs_SelectAll";
		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<Job> allJobs = new ArrayList<>();
		JobArray OBJ = new JobArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			RS = cstmt.executeQuery();

			while (RS.next()) {

				Job currentJob = new Job();
				currentJob.setJobStatus(RS.getNString("JobStatus"));
				currentJob.setJobDescription(RS.getNString("JobDescription"));
				currentJob.setNote(RS.getNString("Note"));
				currentJob.setTitle(RS.getNString("Title"));
				currentJob.setJobID(RS.getNString("JobID"));
				;

				allJobs.add(currentJob);
			}
			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		OBJ.setJobArray(allJobs);
		return OBJ;

	}

	public static JobArray getJobByTitle(String jobTitle, Connection intermediateConnection) {
		String SPsql = "EXEC usp_Job_SelectByTitle ?";

		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<Job> allJobs = new ArrayList<>();
		JobArray OBJ = new JobArray();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, jobTitle);
			RS = cstmt.executeQuery();

			while (RS.next()) {
				Job currentJob = new Job();

				currentJob.setJobStatus(RS.getNString("JobStatus"));
				currentJob.setJobDescription(RS.getNString("JobDescription"));
				currentJob.setNote(RS.getNString("Note"));
				currentJob.setTitle(RS.getNString("Title"));
				currentJob.setJobID(RS.getNString("JobID"));
				;

				allJobs.add(currentJob);

			}

			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		OBJ.setJobArray(allJobs);
		return OBJ;

	}

	public static JobArray getJobByStatus(String jobStatus, Connection intermediateConnection) {
		String SPsql = "EXEC usp_Job_SelectByJobStatus ?";

		ResultSet RS;
		Connection conn = intermediateConnection;
		ArrayList<Job> allJobs = new ArrayList<>();
		JobArray OBJ = new JobArray();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, jobStatus);
			RS = cstmt.executeQuery();

			while (RS.next()) {
				Job currentJob = new Job();

				currentJob.setJobStatus(RS.getNString("JobStatus"));
				currentJob.setJobDescription(RS.getNString("JobDescription"));
				currentJob.setNote(RS.getNString("Note"));
				currentJob.setTitle(RS.getNString("Title"));
				currentJob.setJobID(RS.getNString("JobID"));
				;

				allJobs.add(currentJob);

			}

			RS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		OBJ.setJobArray(allJobs);
		return OBJ;

	}

	public static ServerResponse addJob(Job Joba, Connection intermediateConnection) {

		String SPsql = "EXEC usp_Job_Insert ?,?,?,?,?,?,?";
		Connection conn = intermediateConnection;
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, Joba.getJobID());
			cstmt.setString(2, Joba.getTitle());
			cstmt.setString(3, Joba.getNote());
			cstmt.setString(4, Joba.getJobDescription());
			cstmt.setString(5, Joba.getJobStatus());
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.registerOutParameter(7, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(6));
			_ServerResponse.setResponseMsg(cstmt.getString(7));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return _ServerResponse;

	}

	public static ServerResponse updateJob(Job Joba, Connection intermediateConnection) {
		String SPsql = "EXEC usp_Job_Update ?,?,?,?,?,?,?";
		ServerResponse _ServerResponse = new ServerResponse();
		Connection conn = intermediateConnection;

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, Joba.getJobID());
			cstmt.setString(2, Joba.getTitle());
			cstmt.setString(3, Joba.getNote());
			cstmt.setString(4, Joba.getJobDescription());
			cstmt.setString(5, "02");
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.registerOutParameter(7, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(6));
			_ServerResponse.setResponseMsg(cstmt.getString(7));

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return _ServerResponse;
	}

	public static ServerResponse deleteJob(String jobID, Connection intermediateConnection) {

		String SPsql = "EXEC usp_Job_Delete ?,?,?";
		Connection conn = intermediateConnection;
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1, jobID);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(2));
			_ServerResponse.setResponseMsg(cstmt.getString(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return _ServerResponse;

	}
}
