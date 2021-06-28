package shohisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		// リクエストから郵便番号と住所を取得
		String post_code = (String) request.getParameter("post_code");
		String address = (String) request.getParameter("address");
		int kenId = Integer.parseInt(request.getParameter("chiikiselect"));
		System.out.println("けんIDは" + kenId);

		int gokei = (Integer) session.getAttribute("gokei");
		SoryoKeisan keisan = new SoryoKeisan();
		int soryo = keisan.soryoKen(kenId, gokei);

		int sokei = gokei + soryo;

		session.setAttribute("gokei", gokei);

		session.setAttribute("soryo", soryo);
		session.setAttribute("sokei", sokei);

		session.setAttribute("post_code", post_code);
		session.setAttribute("address", address);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/pay.jsp");
		rd.forward(request, response);

	}

}
