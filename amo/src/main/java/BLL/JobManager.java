package BLL;

import java.sql.Connection;
import java.sql.SQLException;
import DAL.JobDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.Job.Job;
import Models.Job.JobArray;

public class JobManager {

	public static JobArray getAllJobs() {
		Connection intermediateConnection = DBManager.getDBConn();
		JobArray obj = new JobArray();
		try {
			obj = JobDAL.getAllJobs(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	public static JobArray getJobByTitle(String JobTitle) {
		Connection intermediateConnection = DBManager.getDBConn();
		JobArray obj = new JobArray();
		try {
			obj = JobDAL.getJobByTitle(JobTitle, intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	public static JobArray getJobByStatus(String JobStatus) {
		Connection intermediateConnection = DBManager.getDBConn();
		JobArray obj = new JobArray();
		try {
			obj = JobDAL.getJobByStatus(JobStatus, intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	public static ServerResponse addJob(Job Joba) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse obj = new ServerResponse();
		try {
			obj = JobDAL.addJob(Joba, intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	public static ServerResponse updateJob(Job Joba) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse obj = new ServerResponse();
		try {
			obj = JobDAL.updateJob(Joba, intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

	public static ServerResponse deleteJob(String JobID) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse obj = new ServerResponse();
		try {
			obj = JobDAL.deleteJob(JobID, intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}
}
