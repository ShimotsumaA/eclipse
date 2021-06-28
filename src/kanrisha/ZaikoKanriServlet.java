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

import bean.ShohinBean;

/**
 * Servlet implementation class ZaikoKanriServlet
 */
@WebServlet("/ZaikoKanriServlet")
public class ZaikoKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String submit = request.getParameter("submit");
		int zaiko;
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		System.out.println(submit);

		// セッションの取得
		HttpSession session = request.getSession(true);

		if (submit.equals("入庫")) {

			if (request.getParameter("radio") == null) {

				request.setAttribute("message", "対象を選んでください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ZaikoIchiranServlet");
				dispatcher.forward(request, response);

			} else {

			ShohinDao dao = new ShohinDao();

			list = dao.joken(request.getParameter("radio"));
			zaiko=list.get(0).getZaiko();
			System.out.println(zaiko);



			session.setAttribute("shohinId", list.get(0).getShohinId());
			session.setAttribute("shohinName", list.get(0).getShohinName());
			session.setAttribute("zaiko",zaiko);


			System.out.println( list.get(0).getShohinId()+list.get(0).getShohinName()+list.get(0).getZaiko());

			request.setAttribute("nyukoHenko", "nyuko");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoMod.jsp");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ！");

			}

		} else if (submit.equals("変更")) {

			if (request.getParameter("radio") == null) {

				request.setAttribute("message", "対象を選んでください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ZaikoIchiranServlet");
				dispatcher.forward(request, response);

			} else {

				ShohinDao dao = new ShohinDao();
				list = dao.joken(request.getParameter("radio"));
				zaiko=list.get(0).getZaiko();


				session.setAttribute("shohinId", list.get(0).getShohinId());
				session.setAttribute("shohinName", list.get(0).getShohinName());
				session.setAttribute("zaiko",zaiko);

				// フォワード

				request.setAttribute("nyukoHenko", "henko");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoMod.jsp");
				dispatcher.forward(request, response);

			}

		} else if (submit.equals("確認")) {
			if(request.getParameter("nyuko")!=null) {

				int nyuko=Integer.parseInt(request.getParameter("nyuko"));
				session.setAttribute("nyukoHenko", "nyuko");
				session.setAttribute("nyuko", nyuko);

			}else if(request.getParameter("shinki")!=null){

				int sinki=Integer.parseInt(request.getParameter("sinki"));
				session.setAttribute("nyukoHenko", "henko");
				session.setAttribute("sinki", sinki);
			}

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoKanriKakunin.jsp");
			dispatcher.forward(request, response);

		} else if (submit.equals("確定")) {
			// フォワード
			if(session.getAttribute("nyukoHenko")!=null) {
				String sId= (String)session.getAttribute("sId");
				ShohinDao dao=new ShohinDao();
				int kensu=0;

				if(session.getAttribute("nyukoHenko").equals("nyuko")) {
					int nyuko=(Integer)session.getAttribute("nyuko");
					kensu=dao.nyukoUpdate(sId, nyuko);
				}else if(session.getAttribute("nyukoHenko").equals("henko")) {
					int shinki=(Integer)session.getAttribute("sinki");
					kensu=dao.zaikoUpdate(sId, shinki);
				}
				System.out.println(kensu);
				Boolean zaikoflag=false;
				if(kensu>=1) {
					zaikoflag=true;
				}else {
					zaikoflag=false;
				}
				request.setAttribute("zaikoflag", zaikoflag);

			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/zaiko.jsp");
			dispatcher.forward(request, response);

		}
	}
}
