package shohisha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import bean.ShohishaBean;
import sogo.ErrCheck;

	@WebServlet("/BuyControlServlet")
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
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//文字コードの設定
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			//セッションの取得
			HttpSession session = request.getSession(true);

			 String forward=null;

			//ログインしているかどうかを判断


			//ログインしている状態でbuy.jspで住所入力ボタンが押されたら
				if(request.getParameter("submit").equals("jyusho")) {
				//Daoをインスタンス化
					ShohishaDao dao=new ShohishaDao();
					ArrayList<ShohishaBean> list=dao.joken(request.getParameter("sId"));
				//郵便番号と住所をセッションにセット
					session.setAttribute("postcode", list.get(0).getPost());
					session.setAttribute("adress", list.get(0).getAdress());

					//area.jspに遷移
					forward="/jsp/area.jsp";

			//ログインしていない状態でbuy.jspで住所入力ボタンが押されたら
					//login.jspに遷移
					forward="/jsp/login.jsp";
				}

			//pay.jspで続行ボタンが押されたら
				if(request.getParameter("submit").equals("zokko")) {
					//エラーチェック
					ErrCheck err = new ErrCheck();
					String errmsg=err.existSId(request.getParameter("radio"));

					//エラーがなかった場合
					if(errmsg=null) {
						//OrderDaoをインスタンス化
						OrderDao dao=new OrderDao();
						ArrayList<OrderBean> list=dao.joken(request.getParameter("radio"));
						//セッション領域に注文テーブルの各情報をセット
						session.setAttribute("order_id", list.get(0).getOrderId());
						session.setAttribute("date", list.get(0).getDate());
						session.setAttribute("s_id", list.get(0).getSId());
						session.setAttribute("status_id", list.get(0).getStatusId());
						session.setAttribute("o_detail_id", list.get(0).getODetailId());
					}

					//orderKakunin.jspに遷移
						forward="jsp/orderKakunin.jsp";
				}

			//orderKakunin.jspで確認ボタンが押されたら
				if(request.getParameter("submit").equals("chumon")) {
					//OrderDaoをインスタンス化
					OrderDao dao=new OrderDao();
					ArrayList<OrderBean> list=dao.joken(request.getParameter("order_id"));

					//セッション領域に注文テーブルの各情報をセット
					session.setAttribute("order_id", list.get(0).getOrderId());
					session.setAttribute("date", list.get(0).getDate());
					session.setAttribute("s_id", list.get(0).getSId());
					session.setAttribute("status_id", list.get(0).getStatusId());
					session.setAttribute("o_detail_id", list.get(0).getODetailId());

					//注文ステータス変更メソッドを呼び出し
					int kensu=dao.update(String orderId, int statusId);

					//orderCollect.jspに遷移
					forward="jsp/orderCollect.jsp";
				}

		}

	}


