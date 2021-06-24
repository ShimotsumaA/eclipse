package shohisha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import bean.OrderDetailBean;
import kanrisha.ShohinDao;
import sogo.ErrCheck;

/**
 * Servlet implementation class cartHyoujiServlet
 */
@WebServlet("/cartHyoujiServlet")
public class CartHyoujiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartHyoujiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		 //buy.jspからご注文はこちらボタンが押された際の処理
  			//ログインしていかどうか
		HttpSession session=request.getSession(true);
		Boolean cartflag;
		if(session.getAttribute("login")!=null) {
			String sId=(String)session.getAttribute("login_id");
			ErrCheck err=new ErrCheck();
			//カートに商品があるかどうか検索
			if(err.existOrderIdStatusId(sId, 0)) {

				 sId=(String)session.getAttribute("login_id");


				OrderDao dao1=new OrderDao();
				OrderDetailDAO dao2=new OrderDetailDAO();
				ShohinDao dao3=new ShohinDao();




				ArrayList<OrderBean> listOrder=new ArrayList<OrderBean>();
				listOrder=dao1.jokenSIdStatus(sId, 0);//statusId 0:カート
				String orderId=listOrder.get(0).getOrderId(); //orderOd
				int statusId =listOrder.get(0).getStatusId(); //orderOd

				String oDetailId=listOrder.get(0).getODetailId();//oDetailIdの取得



				ArrayList<OrderDetailBean> listODetailList=new ArrayList<>();
				listODetailList=dao2.jouken(oDetailId);//商品と個数のリスト



				//セッション領域に注文テーブルの各情報をセット

				session.setAttribute("order", orderId);
				session.setAttribute("oDetailId", oDetailId);
				session.setAttribute("statusId", statusId);


				session.setAttribute("listOrder", listOrder);
				session.setAttribute("oDetailList", listODetailList);

				cartflag=true;



			}else {
				cartflag=false;
			}



		}else if(session.getAttribute("cart")!=null){
			cartflag=true;
		}else {
			cartflag=false;
		}

		session.setAttribute("cartflag", cartflag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/group2work/jsp/sogo/shohisha/cart.jsp");
		dispatcher.forward(request, response);

	}


}
