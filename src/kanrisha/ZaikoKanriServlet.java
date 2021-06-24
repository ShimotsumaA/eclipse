package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ZaikoKanriServlet
 */
@WebServlet("/ZaikoKanriServlet")
public class ZaikoKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッションの取得
        HttpSession session = request.getSession(true);

        if(request.getParameter("submit").equals("入庫")) {
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoMod.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("ディスパッチ！");
        }
        if(request.getParameter("submit").equals("変更")) {
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoMod.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("ディスパッチ！！");
        }
        if(request.getParameter("submit").equals("確認")) {
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoKanriKakunin.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("ディスパッチ！！！");
        }
        if(request.getParameter("submit").equals("確定")) {
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaiko.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("ディスパッチ！！！！");
        }
	}
}
