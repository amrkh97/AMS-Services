package BLL;

import java.sql.Connection;

import DAL.FeedbackDAL;
import DAL.ReceiptsDAL;
import DB.DBManager;
import Models.CustomClass;
import Models.ServerResponse;
import Models.ServerResponse_ID;
import Models.Feedback.FeedbackModel;
import Models.Receipts.Receipt;

public class FeedbackManger {
	//1
	public static ServerResponse insertFeedback(FeedbackModel feedbackModel)
	 {
		ServerResponse S = new ServerResponse();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {
			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			return S;

		}
		try {

		S= FeedbackDAL.insertFeedback(feedbackModel,conn);
		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return S;
		}
	//2
	public static ServerResponse updateFeedback(FeedbackModel feedbackModel)
	 {
		ServerResponse S = new ServerResponse();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {
			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			return S;

		}
		try {

		S= FeedbackDAL.updateFeedback(feedbackModel,conn);
		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return S;
	}

	//3
	public static ServerResponse deleteFeedback(int  feedbackID)
	 {ServerResponse S = new ServerResponse();
		CustomClass<Connection, Boolean> connbool = DBManager.getDBConn1();
		Connection conn = connbool.getFirst();
		if (!connbool.getSecond()) {
			S.setResponseHexCode("01");
			S.setResponseMsg("Can Not open the database");
			return S;

		}
		try {

		S= FeedbackDAL.deleteFeedback(feedbackID,conn);
		} catch (Exception e) {
			System.out.println("i hav error");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
				System.out.println("Connention Closed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return S;
		 
	}
}
