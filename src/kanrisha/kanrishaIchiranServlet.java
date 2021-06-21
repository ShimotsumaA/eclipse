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

import bean.kanrishaBean;

@WebServlet("/kanrishaIchiranServlet")

public class kanrishaIchiranServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//インスタンス化し、すべての社員情報をリストに入れる
		kanrishaIdDao dao = new kanrishaIdDao();
		ArrayList<kanrishaBean> list = dao.selectAll();

		//セッション領域を作成し、listを預ける
		HttpSession session = request.getSession(true);
		session.setAttribute("list", list);

		//社員情報変更・削除ページに飛ぶ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work//shainIchiran.jsp");
		dispatcher.forward(request, response);
	}

}
