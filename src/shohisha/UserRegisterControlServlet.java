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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッションの取得
		HttpSession session = request.getSession(true);

		//user.jspで登録ボタンが押された際の処理
		if (request.getParameter("submit").equals("登録")) {
			String errmsg = "IDは英数字かつ10文字以内で登録してください。";
			String errmsg2 = "パスワードは英数字を組み合わせ、4文字以上15文字以内で登録してください。";
			String errmsg3 = "パスワードが一致していません。";

			//ErrCheckをインスタンス化
			ErrCheck err = new ErrCheck();
			//ErrCheckでtrueの際の処理
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

				//ErrCheckでfalseの際の処理
			} else {
				session.setAttribute("sId", request.getParameter("sId"));
				session.setAttribute("sName", request.getParameter("sName"));
				session.setAttribute("dateBirth", request.getParameter("dateBirth"));
				session.setAttribute("postCode", request.getParameter("postCode"));
				session.setAttribute("address", request.getParameter("address"));
				session.setAttribute("tel", request.getParameter("tel"));
				session.setAttribute("mailAddress", request.getParameter("mailAddress"));
				session.setAttribute("sPass", request.getParameter("sPass"));

				if (err.checkId("sId") == false) {
					request.setAttribute("errmsg", errmsg);
				}
				if (err.checkPass("sPass") == false) {
					request.setAttribute("errmsg2", errmsg2);
				}
				if (err.checkPassMaches("sPass", "sPassK") == false) {
					request.setAttribute("errmsg3", errmsg3);

				}
				System.out.println(err.checkId("sId"));
				System.out.println(err.checkPass("sPass"));
				System.out.println(err.checkPass("sPass"));

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/jsp/sogo/shohisha/user.jsp?no=1");
				dispatcher.forward(request, response);
			}

			//userKakunin.jspから変更ボタンが押された際の処理
		} else if (request.getParameter("submit").equals("変更")) {
				String sName = (String) session.getAttribute("sName");
				String dateBirth = (String) session.getAttribute("dateBirth");
				String postCode = (String) session.getAttribute("postCode");
				String address = (String) session.getAttribute("address");
				String tel = (String) session.getAttribute("tel");
				String mailAddress = (String) session.getAttribute("mailAddress");
				String sId = (String) session.getAttribute("sId");
				String sPass = (String) session.getAttribute("sPass");

			//DAOをインスタンス化
				ShohishaDao dao= new ShohishaDao();
				int rs =dao.update(sName, dateBirth, postCode, address, tel, mailAddress, sId, sPass);
				System.out.println(rs);
				request.setAttribute("compmsg", "変更が完了しました");
			//遷移先
				request.setAttribute("kakunin",true );
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/user.jsp?no=2");
				dispatcher.forward(request, response);

			//userKakunin.jspから確定ボタンが押された際の処理
		} else if (request.getParameter("submit").equals("確定")) {
				String sName = (String) session.getAttribute("s_name");
				String dateBirth = (String) session.getAttribute("date_birth");
				String postCode = (String) session.getAttribute("postcode");
				String address = (String) session.getAttribute("address");
				String tel = (String) session.getAttribute("tel");
				String mailAddress = (String) session.getAttribute("mailAddress");
				String sId = (String) session.getAttribute("s_id");
				String sPass = (String) session.getAttribute("s_pass");

			//DAOをインスタンス化
				ShohishaDao dao2 = new ShohishaDao();
				int rs = dao2.insert(sName, dateBirth, postCode, address, tel, mailAddress, sId, sPass);
				System.out.println(rs);
				request.setAttribute("compmsg", "登録が完了しました");

			//遷移先
				if(session.getAttribute("loginflag")!=null) {

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/area.jsp");
					dispatcher.forward(request, response);

				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
					dispatcher.forward(request, response);

				}

		} else {

		}

	}
}
