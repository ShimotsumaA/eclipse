package shohisha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myPageServlet
 */
@WebServlet("/myPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String no=null;
		String forward=null;

		if(request.getParameter("no")!=null){
			no=request.getParameter("no");
		}
		if(request.getAttribute("no")!=null){
			no=(String)request.getAttribute("no");
		}

    //myPage.jspでユーザ情報確認(リンク)が押された際の処理
        if(no.equals("1")){
        	ShohishaDao dao = new ShohishaDao();
			request.setAttribute("list",dao.selectAll());
			//userKakunin.jspの画面を決める値をセット
			request.setAttribute("no","3");
			//forward先を指定
			forward="/jsp/shohisha/userKakunin.jsp";
		}

     //myPage.jspで購入履歴確認(リンク)が押された際の処理
        if(no.equals("")){
        	ShohishaDao dao = new ShohishaDao();
			request.setAttribute("list",dao.selectAll());
			//userKakunin.jspの画面を決める値をセット
			//request.setAttribute("no","3");
			//forward先を指定
			forward="/jsp/shohisha/rireki.jsp";
		}

	}


}
