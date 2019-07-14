package Models.Feedback;

import DAL.FeedbackDAL;
import DAL.ReceiptsDAL;
import Models.ServerResponse;
import Models.Receipts.Receipt;

public class FeedbackManger {
	//1
	public static ServerResponse insertFeedback(FeedbackModel feedbackModel)
	 {
		return FeedbackDAL.insertFeedback(feedbackModel);
	}
	//2
	public static ServerResponse updateFeedback(FeedbackModel feedbackModel)
	 {
		return FeedbackDAL.updateFeedback(feedbackModel);
	}

	//3
	public static ServerResponse deleteFeedback(int  feedbackID)
	 {
		return FeedbackDAL.deleteFeedback(feedbackID);
	}
}
