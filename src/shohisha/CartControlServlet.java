package shohisha;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.OrderDetailBean;
import bean.ShohishaBean;
import shohisha.OrderDao;
import shohisha.OrderDetailDAO;

/**
 * Servlet implementation class CartControlServlet
 */
@WebServlet("/CartControlServlet")
public class CartControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartControlServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 譁�蟄励さ繝ｼ繝峨�ｮ險ｭ螳�
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		//ログイン情報を持ったユーザーの商品購入

		// 商品ページからカートに追加

		// ログイン情報を持ったユーザーの商品購入

		HttpSession session = request.getSession(true);


		OrderDao dao = new OrderDao();
		String shohinId = request.getParameter("shohin_id");
		int kazuKonyu = Integer.parseInt(request.getParameter("kazu_konyu"));
		// ログイン情報の取得

		if (session.getAttribute("login") != null) {
			// loginからユーザーIDを取得
			ArrayList<ShohishaBean> list1 = new ArrayList<>();
			list1 = (ArrayList<ShohishaBean>) session.getAttribute("login");
			// idの取得
			String sId = list1.get(0).getId();
			String oDetailId;

			// 注文ステータスがカートの商品があるかどうかチェックする
			if (dao.jokenSIdStatus(sId, 1).size() != 0) {
				// 存在するとき
				oDetailId = dao.jokenSIdStatus(sId, 1).get(0).getODetailId();
			} else {
				// 存在しないとき新しく注文番号を取得
				String orderId;
				String date;

				// may be better to use timeStamp
				Calendar c1 = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				date = sdf.format(c1.getTime());

				orderId = String.valueOf(dao.selectAll().size() + 1);
				oDetailId = orderId;

				dao.insert(orderId, date, sId, 1, oDetailId);
			}

			// カートに商品があるかないかの判別
			OrderDetailDAO dao2 = new OrderDetailDAO();

			if (dao2.joukenShohin(oDetailId, shohinId).size() != 0) {
				dao2.update(oDetailId, shohinId, kazuKonyu);
			} else {
				dao2.insert(oDetailId, shohinId, kazuKonyu);
			}


		} else {
			// カート情報があるとき
			if (session.getAttribute("cart") != null) {
				Map<String, Integer> cart = new HashMap<>();
				cart = (Map<String, Integer>) session.getAttribute("cart");

				if (cart.containsKey(shohinId)) {
					int kazu = cart.get(shohinId) + kazuKonyu;
					cart.put(shohinId, kazu);
				} else {
					cart.put(shohinId, kazuKonyu);

				}session.setAttribute("cart", cart);
				// カート情報がない時
			} else {

				Map<String, Integer> cart = new HashMap<>();

				cart.put(shohinId, kazuKonyu);
				session.setAttribute("cart", cart);
			}


		}


		session.setAttribute("shohin_id", shohinId);
		session.setAttribute("AddedToCart", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work/jsp/sogo/shohisha/shohin.jsp");
		dispatcher.forward(request, response);


	}

}
