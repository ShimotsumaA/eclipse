package kanrisha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderBean;
import shohisha.OrderDao;

@WebServlet("/TyumonStatuIchiranServlet")

public class TyumonStatusIchiraniServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		OrderDao dao = new OrderDao();
		ArrayList<OrderBean> list = dao.selectAll();



		request.setAttribute("submit", "メニュー");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatus.jsp?no=1");
		dispatcher.forward(request, response);
	}

}
