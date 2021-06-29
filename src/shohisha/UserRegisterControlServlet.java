package shohisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sogo.ErrCheck;

/**
 * Servlet implementation class userRegisterControlServlet
 */
@WebServlet("/UserRegisterControl")
public class UserRegisterControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegisterControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// セッションの取得
		HttpSession session = request.getSession(true);
		String errmsg = "IDは英数字かつ10文字以内で登録してください。";
		String errmsg2 = "パスワードは英数字を組み合わせ、4文字以上15文字以内で登録してください。";
		String errmsg3 = "パスワードが一致していません。";

		// ErrCheckをインスタンス化
		ErrCheck err = new ErrCheck();

		// user.jspで登録ボタンが押された際の処理
		if (request.getParameter("submit").equals("登録")) {

			// ErrCheckでtrueの際の処理
			if (err.checkId(request.getParameter("sId")) && err.checkPass(request.getParameter("sPass"))
					&& err.checkPassMaches(request.getParameter("sPass"), request.getParameter("sPassK"))) {
				session.setAttribute("sId", request.getParameter("sId"));
				session.setAttribute("sName", request.getParameter("sName"));
				session.setAttribute("dateBirth", request.getParameter("dateBirth"));
				session.setAttribute("postCode", request.getParameter("postCode"));
				session.setAttribute("address", request.getParameter("address"));
				session.setAttribute("tel", request.getParameter("tel"));
				session.setAttribute("mailAddress", request.getParameter("mailAddress"));
				session.setAttribute("sPass", request.getParameter("sPass"));


				request.setAttribute("submit", "toroku");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/userKakunin.jsp");

				dispatcher.forward(request, response);

				// ErrCheckでfalseの際の処理
			} else {
				session.setAttribute("sId", request.getParameter("sId"));
				session.setAttribute("sName", request.getParameter("sName"));
				session.setAttribute("dateBirth", request.getParameter("dateBirth"));
				session.setAttribute("postCode", request.getParameter("postCode"));
				session.setAttribute("address", request.getParameter("address"));
				session.setAttribute("tel", request.getParameter("tel"));
				session.setAttribute("mailAddress", request.getParameter("mailAddress"));
				session.setAttribute("sPass", request.getParameter("sPass"));

				if (err.checkId(request.getParameter("sId")) == false) {
					request.setAttribute("errmsg", errmsg);
				}
				if ( err.checkPass(request.getParameter("sPass"))== false) {
					request.setAttribute("errmsg2", errmsg2);
				}
				if (err.checkPassMaches(request.getParameter("sPass"), request.getParameter("sPassK"))== false) {
					request.setAttribute("errmsg3", errmsg3);

				}


				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/user.jsp?no=1");
				dispatcher.forward(request, response);
			}

			// userKakunin.jspから変更ボタンが押された際の処理
		} else if (request.getParameter("submit").equals("変更")) {
			if (request.getParameter("mod") != null) {

				String sName = (String) session.getAttribute("sName");
				String dateBirth = (String) session.getAttribute("dateBirth");
				String postCode = (String) session.getAttribute("postCode");
				String address = (String) session.getAttribute("address");
				String tel = (String) session.getAttribute("tel");
				String mailAddress = (String) session.getAttribute("mailAddress");
				String sId = (String) session.getAttribute("sId");
				/* String sPass = (String) session.getAttribute("sPass"); */
				// 一回目に変更ボタンを押したとき

				request.setAttribute("1kaime", true);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/user.jsp?no=2");
				dispatcher.forward(request, response);
			} else {

				// 変更を二回目に押したとき
				if (err.checkPass(request.getParameter("sPass"))
						&& err.checkPassMaches(request.getParameter("sPass"), request.getParameter("sPassK"))) {

					session.setAttribute("sName", request.getParameter("sName"));
					session.setAttribute("dateBirth", request.getParameter("dateBirth"));
					session.setAttribute("postCode", request.getParameter("postCode"));
					session.setAttribute("address", request.getParameter("address"));
					session.setAttribute("tel", request.getParameter("tel"));
					session.setAttribute("mailAddress", request.getParameter("mailAddress"));
					session.setAttribute("sPass", request.getParameter("sPass"));



					System.out.println("aa");
					System.out.println((String)session.getAttribute("address"));
					System.out.println((String)session.getAttribute("sId"));

					//
					request.setAttribute("2kaime", true);
					request.setAttribute("submit", "toroku");



					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/userKakunin.jsp");

					dispatcher.forward(request, response);

					// ErrCheckでfalseの際の処理
				} else {

					session.setAttribute("sName", request.getParameter("sName"));
					session.setAttribute("dateBirth", request.getParameter("dateBirth"));
					session.setAttribute("postCode", request.getParameter("postCode"));
					session.setAttribute("address", request.getParameter("address"));
					session.setAttribute("tel", request.getParameter("tel"));
					session.setAttribute("mailAddress", request.getParameter("mailAddress"));
					session.setAttribute("sPass", request.getParameter("sPass"));



					if ( err.checkPass(request.getParameter("sPass"))== false) {
						request.setAttribute("errmsg2", errmsg2);
					}
					if (err.checkPassMaches(request.getParameter("sPass"), request.getParameter("sPassK"))== false) {
						request.setAttribute("errmsg3", errmsg3);

					}


					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/user.jsp?no=2");
					dispatcher.forward(request, response);
				}

			}
			// 変更ボタンを押した際には、まだデータベースに登録せず、確認画面へ遷移する
			// DAOをインスタンス化
			/*
			 * ShohishaDao dao= new ShohishaDao(); int rs =dao.update(sName, dateBirth,
			 * postCode, address, tel, mailAddress, sId, sPass); System.out.println(rs);
			 * request.setAttribute("compmsg", "変更が完了しました");
			 */
			// 遷移先→確認画面を表示するフラグをセット
			// 一回目の変更押していた時確認にtrueをセット

			// userKakunin.jspから確定ボタンが押された際の処理
		} else if (request.getParameter("submit").equals("確定")) {
			String sName = (String) session.getAttribute("sName");
			String dateBirth = (String) session.getAttribute("dateBirth");
			String postCode = (String) session.getAttribute("postCode");
			String address = (String) session.getAttribute("address");
			String tel = (String) session.getAttribute("tel");
			String mailAddress = (String) session.getAttribute("mailAddress");
			String sId = (String) session.getAttribute("sId");
			String sPass = (String) session.getAttribute("sPass");
			System.out.println(sId+";"+sName+";"+dateBirth+";"+postCode+";"+address+";"+tel+";"+mailAddress+";"+sId+";"+sPass);

			// DAOをインスタンス化
			ShohishaDao dao2 = new ShohishaDao();
			if (request.getParameter("kakunin") == null) {
				int rs = dao2.insert(sId, sName, dateBirth, postCode, address, tel, mailAddress, sPass);
				System.out.println(rs);
				if(rs>=1) {
					session.setAttribute("id", sId);
				}

				request.setAttribute("compmsg", "登録が完了しました");
			} else {
				int rs = dao2.update(sId, sName, dateBirth, postCode, address, tel, mailAddress, sPass);
				System.out.println(rs);
				System.out.println("ここまで");
				if(rs>=1) {
					session.setAttribute("id", sId);
				}

				request.setAttribute("compmsg", "変更が完了しました");
			}

			// 遷移先
			if (session.getAttribute("notFirstloginflag") != null) {

				//カート表示サーブレットにリダイレクト
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/area.jsp");
				dispatcher.forward(request, response);

			} else {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/userKakunin.jsp");
				dispatcher.forward(request, response);

			}

		} else {

		}

	}
}
