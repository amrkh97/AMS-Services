package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;

import Models.Job.Job;

public class JobDAL {

	public static ArrayList<Job> getAllJobs() {
		String SPsql = "EXEC usp_Jobs_SelectAll";
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<Job> allJobs = new ArrayList<>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				
				Job currentJob= new Job();
				currentJob.setJobStatus(RS.getNString("JobStatus"));
				currentJob.setJobDescription(RS.getNString("JobDescription"));
				currentJob.setNote(RS.getNString("Note"));
				currentJob.setTitle(RS.getNString("Title"));
				currentJob.setJobID(RS.getNString("JobID")); ;
				
				
				
			
				
				allJobs.add(currentJob);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return allJobs;


	}

	public static ArrayList<Job> getJobByTitle(String jobTitle) {
		String SPsql = "EXEC usp_Job_SelectByTitle ?";
		
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<Job> allJobs = new ArrayList<>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			cstmt.setString(1,jobTitle );
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				Job currentJob= new Job();	
		
				currentJob.setJobStatus(RS.getNString("JobStatus"));
				currentJob.setJobDescription(RS.getNString("JobDescription"));
				currentJob.setNote(RS.getNString("Note"));
				currentJob.setTitle(RS.getNString("Title"));
				currentJob.setJobID(RS.getNString("JobID")); ;
				
				
				
			allJobs.add(currentJob);
				
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return allJobs;

	}

	public static ArrayList<Job> getJobByStatus(String jobStatus) {
		String SPsql = "EXEC usp_Job_SelectByJobStatus ?";
		
		ResultSet RS;
		Connection conn = DBManager.getDBConn();
		ArrayList<Job> allJobs = new ArrayList<>();
		
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);		
			cstmt.setString(1,jobStatus);
			RS=cstmt.executeQuery();
			
			
			while(RS.next()) {
				Job currentJob= new Job();	
		
				currentJob.setJobStatus(RS.getNString("JobStatus"));
				currentJob.setJobDescription(RS.getNString("JobDescription"));
				currentJob.setNote(RS.getNString("Note"));
				currentJob.setTitle(RS.getNString("Title"));
				currentJob.setJobID(RS.getNString("JobID")); ;
				
				
				
			allJobs.add(currentJob);
				
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return allJobs;
	
	}

	public static ServerResponse addJob(Job Joba) {

		String SPsql = "EXEC usp_Job_Insert ?,?,?,?,?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1,Joba.getJobID() );
			cstmt.setString(2,Joba.getTitle());
			cstmt.setString(3,Joba.getNote());
			cstmt.setString(4,Joba.getJobDescription());
			cstmt.setString(5,Joba.getJobStatus());
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.registerOutParameter(7, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(6));
			_ServerResponse.setResponseMsg(cstmt.getString(7));

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

	public static ServerResponse updateJob(Job Joba) {
		String SPsql = "EXEC usp_Job_Update ?,?,?,?,?,?,?";
		ServerResponse _ServerResponse = new ServerResponse();
		Connection conn = DBManager.getDBConn();

		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1,Joba.getJobID() );
			cstmt.setString(2,Joba.getTitle());
			cstmt.setString(3,Joba.getNote());
			cstmt.setString(4,Joba.getJobDescription());
			cstmt.setString(5,"02");
			cstmt.registerOutParameter(6, Types.NVARCHAR);
			cstmt.registerOutParameter(7, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(6));
			_ServerResponse.setResponseMsg(cstmt.getString(7));


			


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
		
		
		
		return _ServerResponse;
	}

	public static ServerResponse deleteJob(String jobID) {
		
		String SPsql = "EXEC usp_Job_Delete ?,?,?";
		Connection conn = DBManager.getDBConn();
		ServerResponse _ServerResponse = new ServerResponse();
		try {
			CallableStatement cstmt = conn.prepareCall(SPsql);
			cstmt.setString(1,jobID);
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NVARCHAR);
			cstmt.execute();
			_ServerResponse.setResponseHexCode(cstmt.getString(2));
			_ServerResponse.setResponseMsg(cstmt.getString(3));

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
