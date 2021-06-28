package shohisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kanrisha.ShohinDao;

/**
 * Servlet implementation class ECHyoujiServlet
 */
@WebServlet("/ECHyoujiServlet")
public class ECHyoujiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ECHyoujiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//譁�蟄励さ繝ｼ繝峨�ｮ險ｭ螳�
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession(true);
		KijiDao dao = new KijiDao();
		session.setAttribute("listKiji",dao.selectAll());
		//forward蜈医ｒ謖�螳�
		/*
		 * RequestDispatcher dispatcher=
		 * request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
		 * dispatcher.forward(request, response);
		 */


		ShohinDao dao2 = new ShohinDao();



		//カテゴリ検索の実装
		if(request.getParameter("category_id")!=null) {
			session.setAttribute("listShohin",dao2.categoryjoken(request.getParameter("category_id")));
		}else if(request.getParameter("kiji_id")!=null){
			session.setAttribute("listShohin",dao2.kijijoken(request.getParameter("kiji_id")));
		}else {
			session.setAttribute("listShohin",dao2.selectAll());
		}


		//生地検索の実装

		/*
		 * //forward蜈医ｒ謖�螳� RequestDispatcher dispatcher=
		 * request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
		 * dispatcher.forward(request, response);
		 */
		CategoryDao dao3 = new CategoryDao();
		session.setAttribute("listCategory",dao3.selectAll());
		//forward蜈医ｒ謖�螳�

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
		dispatcher.forward(request, response);
	}



}
