package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sogo.ErrCheck;

@WebServlet("/LogInOutServlet")
public class LogInOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッション領域を作成する
		HttpSession session = request.getSession(true);

		//submitの値によってログインかログアウト
		String submit = request.getParameter("submit");

		//ログインする
		if (submit.equals("ログイン")) {

			//管理者かお客様か。
			String zokusei = request.getParameter("zokusei");

			//管理者エラーチェック
			if (zokusei.equals("kanrisya")) {

				ErrCheck err = new ErrCheck();

				//IDが存在するか。
				String id = request.getParameter("id");
				if (err.existkId(id)) {

				} else {
					String message = "IDが存在しません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/login.jsp");
					dispatcher.forward(request, response);

				}

			//IDとパスワードが一致するか。
			String pass = request.getParameter("pass");
		}

			//IDをセッション領域に預ける
			session.setAttribute("id",id);

			//管理者総合メニューへ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/menu.jsp");
			dispatcher.forward(request, response);

		} else {

			//ログアウトする
			session.removeAttribute("id");
			session.removeAttribute("pass");

			//トップページへ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/top.jsp");
			dispatcher.forward(request, response);
		}
	}

}
