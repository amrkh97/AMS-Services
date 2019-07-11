package BLL;
import java.util.ArrayList;

import DAL.ReceiptsDAL;
import Models.ServerResponse;
import Models.Receipts.*;
import Models.Reports.Report;
public class ReceiptsManager {
	//1
	public static ServerResponse insertReceipt(Receipt receiptIN)
	 {
		return ReceiptsDAL.insertReceipt(receiptIN);
	}
	//2
	public static ServerResponse deleteReceipt(int receiptId)
	 { return ReceiptsDAL.deleteReceipt(receiptId);
	 
	 }
	//3
	 public static ReceiptList getRecByCasheirSSN(int casheirSSN)
	 {
		 System.out.println("BLL");
		 return ReceiptsDAL.getRecByCasheirSSN(casheirSSN);
	 }
	 //4
	 public static ReceiptList getRecByRespSQN(String RespSQN){
		 return ReceiptsDAL.getRecByRespSQN(RespSQN);
	 }
	 //5
	 public static ReceiptList getRecByFTPFileLocation(String FTPFileLocation){
		 return ReceiptsDAL.getRecByFTPFileLocation(FTPFileLocation);
	 }
	 //6
	 public static ReceiptList getRecByReceiptStatus(String receiptStatus)
	 {
		 return  ReceiptsDAL.getRecByReceiptStatus(receiptStatus);
	 }
	 //7
	 public static ReceiptList getRecByCost(String cost)
	 {
		 return ReceiptsDAL.getRecByCost(cost);
	 }
	 //8
	 public static ReceiptList getRecByPaymentMethod(String paymentMethod)
	 {
		 return ReceiptsDAL.getRecByPaymentMethod(paymentMethod);
	 }
	 public static ReceiptList selectByReceiptCreationTime( String ReceiptCreationTime)
	 {
		 System.out.println("manager");
		 return ReceiptsDAL.selectByReceiptCreationTime(ReceiptCreationTime);
	 }
}
