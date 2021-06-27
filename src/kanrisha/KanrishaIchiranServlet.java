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

import bean.KanrishaBean;

@WebServlet("/kanrishaIchiranServlet")

public class KanrishaIchiranServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		KanrishaIdDao dao = new KanrishaIdDao();
		ArrayList<KanrishaBean> list = dao.selectAll();

		//セッション領域に預ける
		HttpSession session = request.getSession(true);
		session.setAttribute("list", list);

		//submitによって遷移を変更する
		String submit = request.getParameter("submit");
		System.out.println(submit);

		if (submit.equals("2")){

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shainIchiran.jsp?submit=変更確定");
			dispatcher.forward(request, response);

		} else {

			String message = (String)request.getAttribute("message");
			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shainIchiran.jsp?submit=変更削除");
			dispatcher.forward(request, response);
		}

	}
}