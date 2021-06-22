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

public class KanrishIchiranServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		KanrishaIdDao dao = new KanrishaIdDao();
		ArrayList<KanrishaBean> list = dao.selectAll();


		HttpSession session = request.getSession(true);
		session.setAttribute("list", list);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work//shainIchiran.jsp");
		dispatcher.forward(request, response);
	}

}