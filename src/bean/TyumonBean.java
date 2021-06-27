package bean;

import java.util.ArrayList;

public class TyumonBean {
	private ArrayList<OrderBean> orderList;
	private ArrayList<OrderDetailBean> oDetailList;
	private ArrayList<ShohishaBean > shohishaList;
	private ArrayList<ShohinBean> shohinList;

	public ArrayList getOrderList() {
		return orderList;
	}

	public void setOderList(ArrayList<OrderBean> orderList) {
		this.orderList =orderList ;
	}

	public ArrayList getODetailList() {
		return oDetailList;
	}

	public void setODetailList(ArrayList<OrderDetailBean> oDetailList) {
		this.oDetailList =oDetailList ;
	}

	public ArrayList getShohishaList() {
		return shohishaList;
	}

	public void setShohishaList(ArrayList<ShohishaBean> shohishaList) {
		this.shohishaList=shohishaList;
	}

	public ArrayList getShohinList() {
		return shohinList;
	}

	public void setShohinList(ArrayList<ShohinBean> shohinList) {
		this.shohinList=shohinList;
	}


}
