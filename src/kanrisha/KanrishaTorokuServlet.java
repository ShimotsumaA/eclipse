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
import sogo.ErrCheck;

@WebServlet("/KanrishaTorokuServlet")

public class KanrishaTorokuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッション領域を作成する
		HttpSession session = request.getSession(true);


		//submitの値を取り出し、リクエスト領域に預ける
		String submit = request.getParameter("submit");
		request.setAttribute("submit", submit);
		//デバッグ用
		System.out.println(submit+"KanrishaTorokuサーブレット");

		//Daoのインスタンス化
		KanrishaIdDao dao = new KanrishaIdDao();

		if (submit.equals("変更")) {
			String id = request.getParameter("radio");
			System.out.println(id);

			//ラジオボタンが選択されていない
			if (id == null) {
				request.setAttribute("message","対象を選択してください");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/kanrishaIchiranServlet?submit=1");
				dispatcher.forward(request, response);
			}

			//idをもとに個人情報を取り出し、セッション領域に預ける
			ArrayList<KanrishaBean> list = dao.joken(id);

			session.setAttribute("id", id);
			session.setAttribute("name", list.get(0).getName());
			session.setAttribute("postId", list.get(0).getPostId());
			session.setAttribute("pass", list.get(0).getPass());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=変更");
			dispatcher.forward(request, response);

		} else if(submit.equals("delete")) {

			String id = request.getParameter("radio");

			//ラジオボタンが選択されていない
			if (id == null){
				request.setAttribute("message", "対象を選択してください");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/kanrishaIchiranServlet?submit=1");
				dispatcher.forward(request, response);
			}

			//idをもとに個人情報を取り出し、セッション領域に預ける
			ArrayList<KanrishaBean> list = dao.joken(id);

			session.setAttribute("id", id);
			session.setAttribute("name", list.get(0).getName());
			session.setAttribute("postId", list.get(0).getPostId());
			session.setAttribute("pass", list.get(0).getPass());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffKakunin.jsp");
			dispatcher.forward(request, response);

		} else if(submit.equals("登録情報確認")) {

			//入力値を取得する
			String id = request.getParameter("id");
			System.out.println(id);
			String name = request.getParameter("name");
			String postId = request.getParameter("postId");
			String pass1 = request.getParameter("pass1");
			String pass2 = request.getParameter("pass2");

			if (id.equals("") || name.equals("") || pass1.equals("") || pass2.equals("")) {

				String message = "すべての項目を入力してください。";
				request.setAttribute("message", message);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=2");
				dispatcher.forward(request, response);
			}

			//エラーチェック
			ErrCheck err = new ErrCheck();

			//IDが正しく入力されているか
			if (err.checkId(id)) {
				System.out.println("id正しい入力");
			} else {
				String message = "IDは英数字、10文字以内で入力してください。";
				request.setAttribute("message", message);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=2");
				dispatcher.forward(request, response);
			}

				//管理者IDが既に存在するか
				if (err.existkId(id)) {
					String message = "IDが既に存在します。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=2");
					dispatcher.forward(request, response);

				} else {
					System.out.println("idは存在しない");
				}

				//パスワード
				if (err.checkPass(pass1)) {
					System.out.println("パスワード正しい入力");
				} else {
					String message = "パスワードは４文字以上15文字以内で、英数字を必ず含めてください。";
					System.out.println(message);
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=2");
					dispatcher.forward(request, response);
				}

				//２回入力したパスワードが一致するか。
				if (err.checkPassMaches(pass1, pass2)) {
					System.out.println("パスワードが一致");
				} else {
					String message = "パスワードが一致していません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=2");
					dispatcher.forward(request, response);
				}

			//登録情報が正しく入力されているので、セッション領域に預ける
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("pass", pass1);
			session.setAttribute("postId", postId);

			//postIdをpostNameに変換する
			String postName;
			if (postId.equals("1")) {
				postName = "社員";
			} else {
				postName = "アルバイト";
			}
			System.out.println(postName);
			session.setAttribute("postName", postName);


			//確認ページへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffKakunin.jsp?submit=登録情報確認");
			dispatcher.forward(request, response);


		} else if(submit.equals("変更情報確認")) {

			//入力値を取得する
			String id = (String)session.getAttribute("id");
			String name = request.getParameter("name");
			String postId = request.getParameter("postId");
			String pass1 = request.getParameter("pass1");
			String pass2 = request.getParameter("pass2");

			//入力項目に空白がある場合
			if ( name.equals("") || pass1.equals("") || pass2.equals("")) {

				String message = "すべての項目を入力してください。";
				request.setAttribute("message", message);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=3");
				dispatcher.forward(request, response);
			}


			//エラーチェック
			ErrCheck err = new ErrCheck();

				//パスワード
				if (err.checkPass(pass1)) {
					System.out.println("パスワード正しい入力");
				} else {
					String message = "パスワードは４文字以上１５文字以内で、英数字を必ず含めてください。";
					System.out.println(message);
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=3");
					dispatcher.forward(request, response);
				}

				//２回入力したパスワードが一致するか。
				if (err.checkPassMaches(pass1, pass2)) {
					System.out.println("パスワードが一致");
				} else {
					String message = "パスワードが一致していません。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=3");
					dispatcher.forward(request, response);
				}

				//正しく新しい情報が入力されているので、セッション領域に預ける
				session.setAttribute("name", name);
				session.setAttribute("postId", postId);
				session.setAttribute("pass", pass1);


				//変更確認ページへ
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffKakunin.jsp?submit=変更情報確認");
				dispatcher.forward(request, response);

		} else if(submit.equals("登録確定")) {

			//セッション領域から登録情報を取り出す
			String id = (String)session.getAttribute("id");
			String name = (String)session.getAttribute("name");
			String postId = (String)session.getAttribute("postId");
			String pass = (String)session.getAttribute("pass");

			//新しい管理者情報を登録する
			int kensu = dao.insert(id, name, postId, pass);
			System.out.println(kensu);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/idStaffMod.jsp?submit=登録確定");
			dispatcher.forward(request, response);

		} else if(submit.equals("変更確定")) {

			//セッション領域から登録情報を取り出す
			String id = (String)session.getAttribute("id");
			String name = (String)session.getAttribute("name");
			String postId = (String)session.getAttribute("postId");
			String pass = (String)session.getAttribute("pass");

			//新しい管理者情報を登録する
			int kensu = dao.update(id, name, postId, pass);
			System.out.println(kensu+"件変更しました。");

			request.setAttribute("message", "変更が完了しました。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/kanrishaIchiranServlet");
			dispatcher.forward(request, response);

		} else if(submit.equals("削除確定")) {

			//セッション領域から登録情報を取り出す
			String id = (String)session.getAttribute("id");

			//管理者情報を削除する
			int kensu = dao.delete(id);
			System.out.println(kensu+"件削除しました。");

			request.setAttribute("message", "削除が完了しました。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/kanrishaIchiranServlet");
			dispatcher.forward(request, response);

		}
	}
}
