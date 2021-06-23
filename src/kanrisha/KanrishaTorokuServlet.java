package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/KanrishaTorokuServlet")

public class KanrishaTorokuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//submitの値を取り出し、リクエスト領域に預ける
		String submit = request.getParameter("submit");
		request.setAttribute("submit", submit);
		//デバッグ用
		System.out.println(submit+"KanrishaTorokuサーブレット");


		if (submit.equals("変更")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("削除")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffKakunin.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("登録情報確認")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffKakunin.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("変更情報確認")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffKakunin.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("登録確定")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("変更確定")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shainIchiran.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("削除確定")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shainIchiran.jsp");
			dispatcher.forward(request, response);

		}
	}
}
