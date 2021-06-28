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

import bean.CategoryBean;
import bean.ShohinBean;
import shohisha.CategoryDao;

/**
 * Servlet implementation class ShohinIchiranServlet
 */
@WebServlet("/ShohinIchiranServlet")
public class ShohinIchiranServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		//商品DAOから全件検索
		ShohinDao dao=new ShohinDao();
		ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();

		CategoryDao dao2=new CategoryDao();
		ArrayList<CategoryBean> list2=new ArrayList<CategoryBean>();

		list=dao.selectAll();
<<<<<<< HEAD
		System.out.println(list.get(0).getShohinId());

=======
		list2=dao2.selectAll();

		//request.setAttribute("list",dao.selectAll());
	System.out.println(list.get(0).getShohinId());
>>>>>>> refs/remotes/origin/master
		//セッション領域にリストを保存
		HttpSession session=request.getSession(true);
		session.setAttribute("list", list);
		session.setAttribute("listCategory", list2);

		//エラーメッセージがある場合
		if (request.getAttribute("message") != null) {
			request.setAttribute("message", request.getAttribute("message"));
		}

		//フォワード
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
		dispatcher.forward(request, response);
		System.out.println("サーブレットに到達！！！");

	}
}
