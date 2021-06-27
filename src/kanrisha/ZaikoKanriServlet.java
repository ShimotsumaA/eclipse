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
	     String submit=request.getParameter("submit");
	     ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
	        System.out.println(submit);

		//セッションの取得
        HttpSession session = request.getSession(true);

        if(submit.equals("入庫")) {
        	ShohinDao dao = new ShohinDao();

        	list =dao.joken(request.getParameter("radio"));

        	session.setAttribute("shohinId", list.get(0).getShohinId());
        	session.setAttribute("shohinName",list.get(0).getShohinName());
        	session.setAttribute("zaiko",list.get(0).getZaiko());
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoMod.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("ディスパッチ！");
        }
        if(submit.equals("変更")) {
        	ShohinDao dao = new ShohinDao();
        	list =dao.joken(request.getParameter("radio"));

          	session.setAttribute("shohinId", list.get(0).getShohinId());
        	session.setAttribute("shohinName",list.get(0).getShohinName());
        	session.setAttribute("zaiko",list.get(0).getZaiko());
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoMod.jsp");
    		dispatcher.forward(request, response);

        }
        if(submit.equals("確認")) {
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaikoKanriKakunin.jsp");
    		dispatcher.forward(request, response);

        }
        if(submit.equals("確定")) {
        	//フォワード
    		RequestDispatcher dispatcher=
    				request.getRequestDispatcher("/jsp/sogo/kanrisha/zaiko.jsp");
    		dispatcher.forward(request, response);

        }
	}
}
