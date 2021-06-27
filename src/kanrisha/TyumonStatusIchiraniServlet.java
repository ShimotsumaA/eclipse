package kanrisha;

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
import bean.ShohinBean;
import bean.ShohishaBean;
import bean.TyumonBean;
import shohisha.OrderDao;
import shohisha.OrderDetailDAO;
import shohisha.ShohishaDao;

@WebServlet("/TyumonStatuIchiranServlet")

public class TyumonStatusIchiraniServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		ArrayList<TyumonBean> listAll = new ArrayList<TyumonBean>();

		OrderDao dao = new OrderDao();
		ArrayList<OrderBean> orderList = dao.selectAll();

		ArrayList<OrderBean> orderListJoken;

		ShohishaDao dao2 = new ShohishaDao();
		ArrayList<ShohishaBean> shohishaList;

		OrderDetailDAO dao3 = new OrderDetailDAO();
		ArrayList<OrderDetailBean> orderDetailList;

		ShohinDao dao4 = new ShohinDao();
		ArrayList<ShohinBean> shohinList;

		for (int i = 0; i < orderList.size(); i++) {

			int statusId = orderList.get(i).getStatusId();

			if (statusId >= 1) {

				String sId = orderList.get(i).getSId();

				String oDetailId = orderList.get(i).getODetailId();
				String orderId = orderList.get(i).getOrderId();

				shohishaList = dao2.joken(sId);
				orderDetailList = dao3.jouken(oDetailId);
				orderListJoken = dao.joken(orderId);

				/*
				 * for(int j=0;j<orderDetailList.size();j++) { String
				 * shohinId=orderDetailList.get(j).getShohinId();
				 * shohinList=dao4.joken(shohinId);
				 *
				 * }
				 */

				TyumonBean bean = new TyumonBean();
				bean.setOderList(orderListJoken);
				bean.setODetailList(orderDetailList);
				bean.setShohishaList(shohishaList);
				listAll.add(bean);
			}
		}

		session.setAttribute("tyumonListAll", listAll);

		request.setAttribute("submit", "メニュー");


		if (request.getAttribute("message") != null) {

			request.setAttribute("message", request.getAttribute("message"));
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatus.jsp?no=1");
		dispatcher.forward(request, response);
	}

}
