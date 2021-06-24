package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TyumonStatuKanriServlet")

public class TyumonStatusKanriServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String submit = request.getParameter("submit");
		System.out.println(submit);
		request.setAttribute("submit", submit);

		if (submit.equals("受注ステータス変更")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatusChange.jsp");
			dispatcher.forward(request, response);

		} else if (submit.equals("変更確認")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatusKakunin.jsp");
			dispatcher.forward(request, response);

		} else if (submit.equals("変更確定")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinStatus.jsp");
			dispatcher.forward(request, response);
		}
	}

}
