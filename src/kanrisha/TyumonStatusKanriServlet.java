package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shohisha.OrderDao;

@WebServlet("/TyumonStatuKanriServlet")

public class TyumonStatusKanriServlet extends HttpServlet {

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

		String submit = request.getParameter("submit");
		System.out.println(submit);
		request.setAttribute("submit", submit);

		if (submit.equals("受注ステータス変更")) {
			if (request.getParameter("radio") == null) {
				request.setAttribute("message", "対象を選んでください");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatusIchiran.jsp");
				dispatcher.forward(request, response);

			} else {

				int statusId = Integer.parseInt(request.getParameter("statusId"));
				session.setAttribute("statusId", statusId);

				String orderId = request.getParameter("radio");
				session.setAttribute("orderId", orderId);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatusChange.jsp");
				dispatcher.forward(request, response);
			}
		} else if (submit.equals("変更確認")) {

			int newStatusId = Integer.parseInt(request.getParameter("radio"));

			session.setAttribute("newStatusId", newStatusId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatusKakunin.jsp");
			dispatcher.forward(request, response);

		} else if (submit.equals("変更確定")) {

			OrderDao dao = new OrderDao();

			String orderId =(String) session.getAttribute("orderId");
			int newStatusId =(Integer) session.getAttribute("newStatusId");


			int kensu = dao.update(orderId, newStatusId);

			if (kensu >= 1) {

				request.setAttribute("message", "変更が完了しました。");

			} else {

				request.setAttribute("message", "変更ができませんでした。");
			}

				RequestDispatcher dispatcher = request.getRequestDispatcher("/TyumonStatuIchiranServlet");
				dispatcher.forward(request, response);

		}
	}

}
