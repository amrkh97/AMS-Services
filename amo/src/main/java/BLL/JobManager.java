package BLL;

import DAL.JobDAL;
import Models.ServerResponse;
import Models.Data.DataArrayModel;
import Models.Job.Job;

public class JobManager {

	public static DataArrayModel<Job> getAllJobs() {
		return JobDAL.getAllJobs();
	}

	public static DataArrayModel<Job> getJobByTitle(String JobTitle) {
		return JobDAL.getJobByTitle(JobTitle);
	}

	public static DataArrayModel<Job> getJobByStatus(String JobStatus) {
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
