package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import Models.ServerResponse;
import Models.Feedback.FeedbackModel;

public class FeedbackDAL {
	public static ServerResponse insertFeedback(FeedbackModel feedbackModel, Connection conn) throws Exception {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Feedback_Insert] ?,?,?,?,?,?";

		ServerResponse serverResponse = new ServerResponse();

		CallableStatement cstmt = conn.prepareCall(SPsql);

		cstmt.setInt(1, feedbackModel.getSequenceNumber());
		cstmt.setFloat(2, feedbackModel.getRating());
		cstmt.setString(3, feedbackModel.getDriverNote());
		cstmt.setString(4, feedbackModel.getParamedicNote());

		cstmt.registerOutParameter(5, Types.NVARCHAR);
		cstmt.registerOutParameter(6, Types.NVARCHAR);
		cstmt.execute();

		serverResponse.setResponseHexCode(cstmt.getString(5));
		serverResponse.setResponseMsg(cstmt.getString(6));

		System.out.println("Insertion Result: " + cstmt.getString(5));

		return serverResponse;
	}

	public static ServerResponse updateFeedback(FeedbackModel feedbackModel, Connection conn) throws Exception {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Feedback_Update] ?,?,?,?,?,?,?";

		ServerResponse serverResponse = new ServerResponse();

		CallableStatement cstmt = conn.prepareCall(SPsql);

		cstmt.setInt(1, feedbackModel.getFeedbackID());
		cstmt.setInt(2, feedbackModel.getSequenceNumber());
		cstmt.setFloat(3, feedbackModel.getRating());
		cstmt.setString(4, feedbackModel.getDriverNote());
		cstmt.setString(5, feedbackModel.getParamedicNote());

		cstmt.registerOutParameter(6, Types.NVARCHAR);
		cstmt.registerOutParameter(7, Types.NVARCHAR);
		cstmt.execute();

		serverResponse.setResponseHexCode(cstmt.getString(6));
		serverResponse.setResponseMsg(cstmt.getString(7));

		System.out.println("Insertion Result: " + cstmt.getString(7));

		return serverResponse;
	}

	public static ServerResponse deleteFeedback(int feedbackID, Connection conn) throws Exception {

		String SPsql = "USE KAN_AMO;  EXEC [dbo].[usp_Feedback_Delete] ?,?,?";

		ServerResponse serverResponse = new ServerResponse();

		CallableStatement cstmt = conn.prepareCall(SPsql);

		cstmt.setInt(1, feedbackID);

		cstmt.registerOutParameter(2, Types.NVARCHAR);
		cstmt.registerOutParameter(3, Types.NVARCHAR);
		cstmt.execute();

		serverResponse.setResponseHexCode(cstmt.getString(2));
		serverResponse.setResponseMsg(cstmt.getString(3));

		System.out.println("Insertion Result: " + cstmt.getString(3));

		return serverResponse;
	}
}
