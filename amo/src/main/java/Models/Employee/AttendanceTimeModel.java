package Models.Employee;

public class AttendanceTimeModel {

	private String logInDate;
	private String logInTime;
	private String logOutDate;
	private String logOutTime;
	private String workingHours;
	private String workingMinutes;

	public String getLogInDate() {
		return logInDate;
	}

	public void setLogInDate(String logInDate) {
		this.logInDate = logInDate;
	}

	public String getLogInTime() {
		return logInTime;
	}

	public void setLogInTime(String logInTime) {
		this.logInTime = logInTime;
	}

	public String getLogOutDate() {
		return logOutDate;
	}

	public void setLogOutDate(String logOutDate) {
		this.logOutDate = logOutDate;
	}

	public String getLogOutTime() {
		return logOutTime;
	}

	public void setLogOutTime(String logOutTime) {
		this.logOutTime = logOutTime;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getWorkingMinutes() {
		return workingMinutes;
	}

	public void setWorkingMinutes(String workingMinutes) {
		this.workingMinutes = workingMinutes;
	}
}
