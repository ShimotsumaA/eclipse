package shohisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		KijiDao dao = new KijiDao();
		request.setAttribute("list",dao.selectAll());
		//forward先を指定
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
		dispatcher.forward(request, response);


		ShohinDao dao2 = new ShohinDao();
		request.setAttribute("list",dao2.selectAll());
		//forward先を指定
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
		dispatcher.forward(request, response);

		CategoryDao dao3 = new CategoryDao();
		request.setAttribute("list",dao3.selectAll());
		//forward先を指定
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/jsp/sogo/shohisha/shopping.jsp");
		dispatcher.forward(request, response);
	}



}
