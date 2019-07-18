package Models.Feedback;

public class FeedbackModel {
	private int feedbackID;
	private int sequenceNumber;
	private float rating;
	private String driverNote;
	private String paramedicNote;
	private String feedbackStatus;

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDriverNote() {
		return driverNote;
	}

	public void setDriverNote(String driverNote) {
		this.driverNote = driverNote;
	}

	public String getParamedicNote() {
		return paramedicNote;
	}

	public void setParamedicNote(String paramedicNote) {
		this.paramedicNote = paramedicNote;
	}

	public String getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
}
