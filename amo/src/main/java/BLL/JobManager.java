package BLL;

import java.util.ArrayList;

import DAL.JobDAL;
import Models.ServerResponse;
import Models.Job.Job;

public class JobManager {

	public static ArrayList<Job> getAllJobs() {
		return JobDAL.getAllJobs();
	}

	public static ArrayList<Job> getJobByTitle(String JobTitle) {
		return JobDAL.getJobByTitle(JobTitle);
	}

	public static ArrayList<Job> getJobByStatus(String JobStatus) {
		return JobDAL.getJobByStatus(JobStatus);
	}

	public static ServerResponse addJob(Job Joba) {
		return JobDAL.addJob(Joba);
	}

	public static ServerResponse updateJob(Job Joba) {
		return JobDAL.updateJob(Joba);
	}

	public static ServerResponse deleteJob(String JobID) {
		return JobDAL.deleteJob(JobID);
	}
}
