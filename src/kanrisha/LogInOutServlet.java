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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// セッション領域を作成する
		HttpSession session = request.getSession(true);

		// submitの値によってログインかログアウト
		String submit = request.getParameter("submit");
		System.out.println(submit);

		// ログインする
		if (submit.equals("ログイン")) {

			// 管理者かお客様か。
			String zokusei = request.getParameter("zokusei");
			System.out.println(zokusei);

			ErrCheck err = new ErrCheck();

			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			System.out.println(id + pass);

			// 管理者エラーチェック
			if (zokusei.equals("shain") || zokusei.equals("aru")) {

				// 管理者IDが存在するか。
				if (err.existkId(id)) {
					System.out.println("存在");
				} else {
					String message = "IDが存在しません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/login.jsp?no=2");
					dispatcher.forward(request, response);
				}

				// 管理者IDとパスワードが一致するか。
				if (err.kPassCollect(id, pass)) {
					System.out.println("一致");
				} else {
					String message = "IDとパスワードが一致しません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/login.jsp?no=3");
					dispatcher.forward(request, response);
				}

				// IDパスワードが正しいので、IDをセッション領域に預ける
				session.setAttribute("id", id);

				// 社員、アルバイトの属性をセッション領域に預ける
				session.setAttribute("zokusei", zokusei);

				// 管理者総合メニューへ遷移する
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/menu.jsp");
				dispatcher.forward(request, response);

				// 消費者（お客様）エラーチェック
			} else {

				// 消費者IDが存在するか。
				if (err.existSId(id)) {

				} else {
					String message = "IDが存在しません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/login.jsp?no=2");
					dispatcher.forward(request, response);
				}

				// 消費者IDとパスワードが一致するか。
				if (err.sPassCollect(id, pass)) {

				} else {
					String message = "IDとパスワードが一致しません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/login.jsp?no=3");
					dispatcher.forward(request, response);
				}

				// IDパスワードが正しいので、IDをセッション領域に預ける
				session.setAttribute("id", id);

				if (session.getAttribute("loginid") != null) {
					session.removeAttribute("loginid");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/CartHyoujiServlet");
					dispatcher.forward(request, response);
				} else {
					// ショッピングへ遷移する
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ECHyoujiServlet");
					dispatcher.forward(request, response);
//			HttpServletResponse#sendRedirect(URL);
				}
			}

		} else {

			// ログアウトする
			session.removeAttribute("id");
			/* session.removeAttribute("pass"); */

			// トップページへ遷移する
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/top.jsp");
			dispatcher.forward(request, response);
		}
	}

}
