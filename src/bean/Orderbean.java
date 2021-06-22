package bean;

import java.io.Serializable;

public class Orderbean implements Serializable{

	private String orderId;
	private String date;
	private String sId;
	private int statusId;
	private String odetailId;

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String date) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setData(String date) {
		this.date = date;
	}
	public String getSId() {
		return sId;
	}
	public void setSId(String sId) {
		this.sId = sId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setstatusId(int statsuId) {
		this.statusId = statusId;
	}
}
