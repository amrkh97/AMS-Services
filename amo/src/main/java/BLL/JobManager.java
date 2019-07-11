package BLL;

import DAL.JobDAL;
import Models.ServerResponse;
import Models.Job.Job;
import Models.Job.JobArray;

public class JobManager {

	public static JobArray getAllJobs() {
		return JobDAL.getAllJobs();
	}

	public static JobArray getJobByTitle(String JobTitle) {
		return JobDAL.getJobByTitle(JobTitle);
	}

	public static JobArray getJobByStatus(String JobStatus) {
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
