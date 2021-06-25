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

import bean.ShohishaBean;

@WebServlet("/BuyControl")
public class BuyControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッションの取得
		HttpSession session = request.getSession(true);

		String forward = null;

		//ログインしているかどうかを判断
		if (session.getAttribute("login") != null) {

			//ログインしている状態でbuy.jspで住所入力ボタンが押されたら
			if (request.getParameter("submit").equals("jyusho")) {
				//Daoをインスタンス化
				ShohishaDao dao = new ShohishaDao();
				ArrayList<ShohishaBean> list = dao.joken((String) session.getAttribute("id"));
				//郵便番号と住所をセッションにセット
				session.setAttribute("post_code", list.get(0).getPost());
				session.setAttribute("adress", list.get(0).getAdress());

				//area.jspに遷移
				RequestDispatcher rd = request.getRequestDispatcher("/group2work/jsp/sogo/shohisha/jsp/area.jsp");
				rd.forward(request, response);

				//pay.jspで続行ボタンが押されたら
			} else if (request.getParameter("submit").equals("zokko")) {
				//エラーチェック
				/* ErrCheck err = new ErrCheck(); */
				/* String errmsg=err.existSId(request.getParameter("radio")); */
				if (request.getParameter("shiharai") == null) {
					//dispach戻る
					request.setAttribute("err", "押してください");
					//前のページに戻る(area.jsp)
					RequestDispatcher rd = request.getRequestDispatcher("/group2work/jsp/sogo/shohisha/area.jsp");
					rd.forward(request, response);

				} else {
					//もし今まで


					//OrderDao,ShohinDaoをインスタンス化

					/*
					 * String sId = (String) session.getAttribute("id");
					 *
					 * OrderDao dao = new OrderDao(); ShohinDao dao3 = new ShohinDao();
					 * OrderDetailDAO dao2 = new OrderDetailDAO();
					 *
					 * OrderDao dao1 = new OrderDao(); ArrayList<OrderBean> listOrder = new
					 * ArrayList<OrderBean>(); listOrder = dao1.jokenSIdStatus(sId, 0);//statusId
					 * 0:カート String orderId = listOrder.get(0).getOrderId(); //orderOd int statusId
					 * = listOrder.get(0).getStatusId(); //orderOd
					 *
					 * String oDetailId = listOrder.get(0).getODetailId();//oDetailIdの取得
					 *
					 * ArrayList<OrderDetailBean> listODetailList = new ArrayList<>();
					 * listODetailList = dao2.jouken(oDetailId);//商品と個数のリスト
					 *
					 * //セッション領域に注文テーブルの各情報をセット
					 *
					 * session.setAttribute("orderId", orderId); session.setAttribute("oDetailId",
					 * oDetailId); session.setAttribute("statusId", statusId);
					 *
					 * session.setAttribute("listOrder", listOrder);
					 * session.setAttribute("oDetailList", listODetailList); //orderKakunin.jspに遷移
					 */

					String shiharai;
					if(request.getParameter("shiharai").equals("hurikomi")) {
						shiharai="銀行振込";
					}else if(request.getParameter("shiharai").equals("credit_card")){
						shiharai="クレジットカード";
					}else {
						shiharai="代金引換";
					}

					session.setAttribute("shiharai", shiharai);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/orderKakunin.jsp");
					rd.forward(request, response);
				}


				//orderKakunin.jspで確認ボタンが押されたら
			} else if (request.getParameter("submit").equals("chumon")) {
				//OrderDaoをインスタンス化
				OrderDao dao = new OrderDao();
				String orderId=(String)session.getAttribute("orderId");
				int kensu=dao.update(orderId, 1); //statusId　注文完了

					if(kensu>=1) {
						session.setAttribute("tyumon", true);
					}else{
						session.setAttribute("tyumon", false);
					}
				//orderCollect.jspに遷移
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/orderCollect.jsp");
				rd.forward(request, response);

			} else {
			}

			//ログインしていない状態でbuy.jspで住所入力ボタンが押されたら
			//login.jspに遷移
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(request, response);
		}
	}

}
