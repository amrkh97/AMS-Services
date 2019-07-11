package Models.Receipts;
public class Receipt {
	private int receiptID;
	private String respSQN;
	private int casheirSSN;
	private String receiptCreationTime;
	private String	FTPFileLocation;
	private String receiptStatus;
	private String cost;
	private String paymentMethod;
	public int getReceiptID() {
		return receiptID;
	}
	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}
	public String getRespSQN() {
		return respSQN;
	}
	public void setRespSQN(String respSQN) {
		this.respSQN = respSQN;
	}
	public int getCasheirSSN() {
		return casheirSSN;
	}
	public void setCasheirSSN(int casheirSSN) {
		this.casheirSSN = casheirSSN;
	}
	public String getReceiptCreationTime() {
		return receiptCreationTime;
	}
	public void setReceiptCreationTime(String receiptCreationTime) {
		this.receiptCreationTime = receiptCreationTime;
	}
	public String getFTPFileLocation() {
		return FTPFileLocation;
	}
	public void setfTPFileLocation(String FTPFileLocation) {
		this.FTPFileLocation = FTPFileLocation;
	}
	public String getReceiptStatus() {
		return receiptStatus;
	}
	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
