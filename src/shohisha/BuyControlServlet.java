package shohisha;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッションの取得
		HttpSession session = request.getSession(true);


		//ログインしているかどうかを判断
		if (session.getAttribute("id") != null) {

			//ログインしている状態でbuy.jspで住所入力ボタンが押されたら
			if (request.getParameter("submit").equals("jyusho")) {
				//Daoをインスタンス化
				ShohishaDao dao = new ShohishaDao();
				ArrayList<ShohishaBean> list = dao.joken((String) session.getAttribute("id"));
				//郵便番号と住所をセッションにセット
				session.setAttribute("post_code", list.get(0).getPost());
				session.setAttribute("address", list.get(0).getAddress());

				//area.jspに遷移
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/area.jsp");
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
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/area.jsp");
					rd.forward(request, response);

				} else {

					String shiharai;
					if(request.getParameter("shiharai").equals("hurikomi")) {
						shiharai="銀行振込";
					}else if(request.getParameter("shiharai").equals("credit_card")){
						shiharai="クレジットカード";
					}else {
						shiharai="代金引換";
					}




					session.setAttribute("shiharai", shiharai);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/orderKakunin.jsp");
					rd.forward(request, response);
				}


				//orderKakunin.jspで確認ボタンが押されたら
			} else if (request.getParameter("submit").equals("chumon")) {
				//OrderDaoをインスタンス化
				OrderDao dao = new OrderDao();
				ShohishaDao dao2=new ShohishaDao();
				String orderId=(String)session.getAttribute("order");
				int kensu=dao.update(orderId, 1); //statusId　注文完了



				Calendar c1 = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String date = sdf.format(c1.getTime());

				int dateUpdate=dao.updateDate(date, orderId);

				String sId=(String)session.getAttribute("id");//ログインidの取得
				String address=(String)session.getAttribute("address");
				String postCode=(String)session.getAttribute("post_code");

				String mailAddress=dao2.joken(sId).get(0).getMail();


				int kensu2=dao2.updateCyumon(sId, postCode,address);
				session.setAttribute("mailAddress", mailAddress);
				session.setAttribute("date", date);
				session.setAttribute("id", sId);



					if(kensu>=1) {
						session.setAttribute("tyumon", true);
					}else{
						session.setAttribute("tyumon", false);
					}


				//orderCollect.jspに遷移
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/orderCollect.jsp");
				rd.forward(request, response);

			} else {
			}

			//ログインしていない状態でbuy.jspで住所入力ボタンが押されたら
			//login.jspに遷移
		} else {
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			 * rd.forward(request, response);
			 */
		}
	}

}
