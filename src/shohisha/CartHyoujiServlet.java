package shohisha;

import java.io.IOException;
import java.math.BigDecimal;
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
import bean.ShohinBean;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession(true);
		Boolean cartflag;

		//注文はこちらボタンを押したときの処理→ログインしてなかったらログイン画面が表示されるようにする。

		if ((session.getAttribute("submit") != null) && session.getAttribute("submit").equals("tyumonhakotira")) {
			if(session.getAttribute("login")!=null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work/jsp/sogo/buy.jsp");
				dispatcher.forward(request, response);
			}else {

				//ログイン前の情報と明示
				session.setAttribute("loginflag",false);


				RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work/jsp/sogo/login.jsp");
				dispatcher.forward(request, response);
			}
		} else {

			// ログインしているかどうか
			if (session.getAttribute("login") != null) {
				String sId = (String) session.getAttribute("login_id");
				ErrCheck err = new ErrCheck();
				// カートに商品があるかどうか検索
				if (err.existOrderIdStatusId(sId, 0)) {

					sId = (String) session.getAttribute("login_id");

					OrderDao dao1 = new OrderDao();
					OrderDetailDAO dao2 = new OrderDetailDAO();
					ShohinDao dao3 = new ShohinDao();

					ArrayList<OrderBean> listOrder = new ArrayList<OrderBean>();
					listOrder = dao1.jokenSIdStatus(sId, 0);// statusId 0:カート
					String orderId = listOrder.get(0).getOrderId(); // orderIdの取得

					String oDetailId = listOrder.get(0).getODetailId();// oDetailIdの取得

					ArrayList<OrderDetailBean> listODetailList = new ArrayList<>();
					listODetailList = dao2.jouken(oDetailId);// 商品と個数のリスト

					// 合計金額の取得
					BigDecimal gokei = BigDecimal.valueOf(0);
					for (int i = 1; i <= listODetailList.size(); i++) {
						String shohinid = listODetailList.get(i - 1).getShohinId();
						int kazuKonyu = listODetailList.get(i - 1).getKazuKonyu();
						java.math.BigDecimal value = dao3.joken(shohinid).get(i - 1).getValue();
						java.math.BigDecimal shokei = BigDecimal.valueOf(kazuKonyu).multiply(value);
						gokei = gokei.add(shokei).setScale(0, BigDecimal.ROUND_HALF_UP);
					}

					int gokei2 = gokei.intValue();


					//送料の計算
					SoryoKeisan keisan=new SoryoKeisan();
					int soryo=keisan.soryo(sId,gokei2);

					//総計の計算
					int sokei=gokei2+soryo;

					// セッション領域に注文テーブルの各情報をセット

					//注文番号と注文詳細番号
					session.setAttribute("order", orderId);
					session.setAttribute("oDetailId", oDetailId);

					//注文と、注文詳細
					session.setAttribute("listOrder", listOrder);
					session.setAttribute("oDetailList", listODetailList);

					//合計、送料、総計
					session.setAttribute("gokei", gokei2);
					session.setAttribute("soryo", soryo);
					session.setAttribute("sokei", sokei);


					cartflag = true;

				} else {
					cartflag = false;
				}
				//ログインしておらずカート情報があるとき
			} else if (session.getAttribute("cart") != null) {
				cartflag = true;
			} else {
				cartflag = false;
			}

			session.setAttribute("cartflag", cartflag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work/jsp/sogo/shohisha/cart.jsp");
			dispatcher.forward(request, response);

		}
	}

}
