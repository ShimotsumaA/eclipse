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
 * Servlet implementation class zaikoIchiranServlet
 */
@WebServlet("/ZaikoIchiranServlet")
public class ZaikoIchiranServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		//商品DAOから全件検索
		ShohinDao dao=new ShohinDao();
		ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
		request.setAttribute("list",dao.selectAll());

		//セッション領域にリストを保存
		HttpSession session=request.getSession(true);
		session.setAttribute("list", list);

		if (request.getAttribute("message") != null) {

			request.setAttribute("message", request.getAttribute("message"));
		}


		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/sogo/kanrisha/zaiko.jsp");
		dispatcher.forward(request, response);
	}

}
