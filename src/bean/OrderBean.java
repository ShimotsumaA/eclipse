package bean;

import java.io.Serializable;

public class OrderBean implements Serializable{

	private String orderId;
	private String date;
	private String sId;
	private int statusId;
	private String oDetailId;

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getODetailId() {
		return oDetailId;
	}
	public void setODetailId(String oDetailId) {
		this.oDetailId = oDetailId;
	}


}
