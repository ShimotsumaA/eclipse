package shohisha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KijiBean;
import bean.ShohinBean;
import kanrisha.ShohinDao;

/**
 * Servlet implementation class ShohinHyojiServlet
 */
@WebServlet("/ShohinHyojiServlet")
public class ShohinHyojiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinHyojiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//セッションの取得
		HttpSession session = request.getSession(true);
		String shohinId=request.getParameter("shohin_id");

		//商品詳細の検索
		ShohinDao dao= new ShohinDao();
		ArrayList<ShohinBean> listShohinShosai=new ArrayList<ShohinBean>();
		listShohinShosai=dao.joken(shohinId);

		String kijiId=listShohinShosai.get(0).getKijiId();
		KijiDao dao2=new KijiDao();
		ArrayList<KijiBean> listShohinKiji=new ArrayList<KijiBean>();
		listShohinKiji=dao2.joken(kijiId);


		//セッションに商品情報をセット
		session.setAttribute("Shohin_shosai", listShohinShosai);
		session.setAttribute("Kiji_shosai", listShohinKiji);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/shohisha/shohin.jsp");
		dispatcher.forward(request, response);



	}

}
