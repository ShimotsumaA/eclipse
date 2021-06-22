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
 * Servlet implementation class ShohinIchiranServlet
 */
@WebServlet("/ShohinIchiranServlet")
public class ShohinIchiranServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		//商品DAOから全件検索
		ShohinDao dao=new ShohinDao();
		ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
		request.setAttribute("list",dao.selectAll());

		//セッション領域にリストを保存
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		
		//フォワード
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/jsp/sogo/kanrisya/shohinKanriIchiran.jsp");
		dispatcher.forward(request, response);
	}


}
