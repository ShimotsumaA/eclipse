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
import bean.ShohishaBean;
import kanrisha.ShohinDao;

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
			 if(session.getAttribute("login")!=null) {



			//ログインしている状態でbuy.jspで住所入力ボタンが押されたら
				if(request.getParameter("submit").equals("jyusho")) {
				//Daoをインスタンス化
					ShohishaDao dao=new ShohishaDao();
					ArrayList<ShohishaBean> list=dao.joken(request.getParameter("sId"));
				//郵便番号と住所をセッションにセット
					session.setAttribute("postcode", list.get(0).getPost());
					session.setAttribute("adress", list.get(0).getAdress());

					//area.jspに遷移
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/area.jsp");
					rd.forward(request, response);

			//ログインしていない状態でbuy.jspで住所入力ボタンが押されたら
					//login.jspに遷移
				}else {
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/login.jsp");
					rd.forward(request, response);
				}

			//pay.jspで続行ボタンが押されたら
				if(request.getParameter("submit").equals("zokko")) {
					//エラーチェック
					/* ErrCheck err = new ErrCheck(); */
					/* String errmsg=err.existSId(request.getParameter("radio")); */
					if(request.getParameter("radio")==null) {
						//dispach戻る
						request.setAttribute("err","押してください");
						//前のページに戻る(area.jsp)
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/area.jsp");
						rd.forward(request, response);

					}else {
						//OrderDao,ShohinDaoをインスタンス化

						String sId=(String)session.getAttribute("login_id");


						OrderDao dao=new OrderDao();
						ShohinDao dao3=new ShohinDao();
						OrderDetailDAO dao2=new OrderDetailDAO();


						OrderDao dao1=new OrderDao();
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

					}

					//orderKakunin.jspに遷移
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/orderKakunin.jsp");
					rd.forward(request, response);
				}

			//orderKakunin.jspで確認ボタンが押されたら
				if(request.getParameter("submit").equals("chumon")) {
					//OrderDaoをインスタンス化
					OrderDao dao=new OrderDao();
					ArrayList<OrderBean> list=dao.joken(request.getParameter("order_id"));
					String orderId=(String)session.getAttribute("");
					int statusId=(Integer)session.getAttribute("statusId");


					//注文ステータス変更メソッドを呼び出し

					session.setAttribute("status_id",dao.update(orderId,statusId));

					//orderCollect.jspに遷移
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/orderCollect.jsp");
					rd.forward(request, response);
				}

			 }
		}
	}


