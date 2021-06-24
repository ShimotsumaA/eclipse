package shohisha;

import java.util.ArrayList;

import bean.BuyBean;
import bean.OrderBean;

public class BuyMethod {

	public ArrayList<BuyBean> buyDisplay(String sId){
		OrderDao dao1=new OrderDao();
		ArrayList<OrderBean> listOrder=new ArrayList<OrderBean>();
		listOrder=dao1.jokenSIdStatus(sId, 0);//statusId 0:カート
		String oDetailid=listOrder.get(0).getODetailId();//oDetailIdの取得

		OrderDetailDAO dao2=new OrderDetailDAO();
		ArrayList<OrderDetailBean> listODetail=new ArrayList<>();
		listODetail=dao2.jouken(oDetailid)






	}
}
