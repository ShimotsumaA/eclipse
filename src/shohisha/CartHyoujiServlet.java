package shohisha;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
import bean.ShohishaBean;
import kanrisha.ShohinDao;
import sogo.ErrCheck;

/**
 * Servlet implementation class cartHyoujiServlet
 */
@WebServlet("/CartHyoujiServlet")
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

		// 注文はこちらボタンを押したときの処理→ログインしてなかったらログイン画面が表示されるようにする。

		if ((request.getParameter("submit") != null) && request.getParameter("submit").equals("tyumonhakotira")) {
			if (session.getAttribute("id") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/buy.jsp");
				dispatcher.forward(request, response);
			} else {

				// ログイン前の情報と明示
				session.setAttribute("loginid", false);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/login.jsp");
				dispatcher.forward(request, response);
			}

			// 注文はこちら以外のボタンを押したとき
		} else {

			// ログインしているかどうか
			if (session.getAttribute("id") != null) {

				String sId = (String) session.getAttribute("id");
				ErrCheck err = new ErrCheck();
				// カートに商品があるかどうか検索
				if (err.existOrderIdStatusId(sId, 0) || (session.getAttribute("cart") != null)) {
					// ログインせずにカートに登録していた情報があるとき
					// 消費者Idの取得
					String oDetailId;
					int cartcount = 0;
					OrderDao dao = new OrderDao();
					OrderDetailDAO dao2 = new OrderDetailDAO();

					// ログインカートに商品があるかつ、セッションカートに商品があるとき
					if (err.existOrderIdStatusId(sId, 0) && (session.getAttribute("cart") != null)) {
						// oDetailidの取得

						oDetailId = dao.jokenSIdStatus(sId, 0).get(0).getODetailId();
						// ログイン前カート商品・個数の取得
						Map<String, Integer> cart = new LinkedHashMap<>();
						cart = (Map<String, Integer>) session.getAttribute("cart");
						// 商品と個数の取り出し
						for (Map.Entry<String, Integer> entry : cart.entrySet()) {
							String shohinId = entry.getKey();
							int konyuKosu = entry.getValue();

							// oDetailIdとshohinIdに対応したリストの有無を取得→あるときはアップデート、ない時はインサート
							if (dao2.joukenShohin(oDetailId, shohinId).size() != 0) {
								cartcount = dao2.update(oDetailId, shohinId, konyuKosu);
							} else {
								cartcount = dao2.insert(oDetailId, shohinId, konyuKosu);
							}

							session.removeAttribute("cart");

						}

						// ログインカートに商品がないかつ、セッションカートに商品があるとき
					} else if (err.existOrderIdStatusId(sId, 0) == false && session.getAttribute("cart") != null&&((Map<String, Integer>)session.getAttribute("cart")).size()>0) {

						String orderId;
						String date;

						// may be better to use timeStamp
						Calendar c1 = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
						date = sdf.format(c1.getTime());

						orderId = String.valueOf(dao.selectAll().size() + 1);
						oDetailId = orderId;

						dao.insert(orderId, date, sId, 0, oDetailId);

						// ログイン前カート商品・個数の取得
						Map<String, Integer> cart = new LinkedHashMap<>();
						cart = (Map<String, Integer>) session.getAttribute("cart");
						// 商品と個数の取り出し
						for (Map.Entry<String, Integer> entry : cart.entrySet()) {
							String shohinId = entry.getKey();
							int konyuKosu = entry.getValue();

							// oDetailIdとshohinIdに対応したリストの有無を取得→あるときはアップデート、ない時はインサート
							if (dao2.joukenShohin(oDetailId, shohinId).size() != 0) {
								cartcount = dao2.update(oDetailId, shohinId, konyuKosu);
							} else {
								cartcount = dao2.insert(oDetailId, shohinId, konyuKosu);
							}

							session.removeAttribute("cart");

						}

					} else {

					}

					sId = (String) session.getAttribute("id");

					OrderDao dao1 = new OrderDao();
					OrderDetailDAO dao4 = new OrderDetailDAO();
					ShohinDao dao3 = new ShohinDao();

					ArrayList<OrderBean> listOrder = new ArrayList<OrderBean>();
					listOrder = dao1.jokenSIdStatus(sId, 0);// statusId 0:カート
					String orderId = listOrder.get(0).getOrderId(); // orderIdの取得

					oDetailId = listOrder.get(0).getODetailId();// oDetailIdの取得

					ArrayList<OrderDetailBean> listODetailList = new ArrayList<>();
					listODetailList = dao4.jouken(oDetailId);// 商品と個数のリスト

					// 合計金額の取得
					BigDecimal gokei = BigDecimal.valueOf(0);
					for (int i = 1; i <= listODetailList.size(); i++) {
						String shohinid = listODetailList.get(i - 1).getShohinId();
						int kazuKonyu = listODetailList.get(i - 1).getKazuKonyu();
						java.math.BigDecimal value = dao3.joken(shohinid).get(0).getValue();
						java.math.BigDecimal shokei = BigDecimal.valueOf(kazuKonyu).multiply(value);
						gokei = gokei.add(shokei).setScale(0, BigDecimal.ROUND_HALF_UP);
					}

					int gokei2 = gokei.intValue();

					// 送料の計算
					SoryoKeisan keisan = new SoryoKeisan();
					int soryo = keisan.soryo(sId, gokei2);

					// 総計の計算
					int sokei = gokei2 + soryo;

					// セッション領域に注文テーブルの各情報をセット

					// 注文番号と注文詳細番号
					session.setAttribute("order", orderId);
					session.setAttribute("oDetailId", oDetailId);

					// 注文と、注文詳細
					session.setAttribute("listOrder", listOrder);
					session.setAttribute("oDetailList", listODetailList);

					// 合計、送料、総計
					session.setAttribute("gokei", gokei2);
					session.setAttribute("soryo", soryo);
					session.setAttribute("sokei", sokei);

					if (listODetailList.size() > 0) {
						cartflag = true;
					} else {
						cartflag = false;
					}

				} else {
					cartflag = false;
				}
				// ログインしておらずカート情報があるとき
			} else if (session.getAttribute("cart") != null
					&& ((Map<String, Integer>) session.getAttribute("cart")).size() > 0) {
				Map<String, Integer> cart = new LinkedHashMap<>();
				cart = (Map<String, Integer>) session.getAttribute("cart");

				BigDecimal gokei = BigDecimal.valueOf(0);
				for (Map.Entry<String, Integer> entry : cart.entrySet()) {
					String shohinId = entry.getKey();
					int konyuKosu = entry.getValue();
					ShohinDao dao = new ShohinDao();
					BigDecimal tanka = dao.joken(shohinId).get(0).getValue();

					BigDecimal shokei = BigDecimal.valueOf(konyuKosu).multiply(tanka);
					gokei = gokei.add(shokei).setScale(0, BigDecimal.ROUND_HALF_UP);
				}
				int gokei2 = gokei.intValue();
				session.setAttribute("gokei", gokei2);

				cartflag = true;
			} else {
				cartflag = false;
			}

			if (request.getAttribute("cancel") != null) {
				request.setAttribute("cancel", request.getAttribute("cancel"));
			}

			request.setAttribute("cartflag", cartflag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/cart.jsp");
			dispatcher.forward(request, response);

		}
	}

}
