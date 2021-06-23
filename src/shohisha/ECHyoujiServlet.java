package shohisha;

import java.io.IOException;

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

		String forward=null;

		KijiDao dao = new KijiDao();
		request.setAttribute("list",dao.selectAll());
		//forward先を指定
		forward="/shohisha/shopping.jsp";

		ShohinDao dao2 = new ShohinDao();
		request.setAttribute("list",dao2.selectAll());
		//forward先を指定
		forward="/shohisha/shopping.jsp";

		CategoryDao dao3 = new CategoryDao();
		request.setAttribute("list",dao3.selectAll());
		//forward先を指定
		forward="/shohisha/shopping.jsp";
	}



}
