package shohisha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import bean.ShohishaBean;
/**
 * Servlet implementation class CartControlServlet
 */
@WebServlet("/CartControlServlet")
public class CartControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControlServlet() {
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
		//譁�蟄励さ繝ｼ繝峨�ｮ險ｭ螳�
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		//ログイン情報を持ったユーザーの商品購入
		HttpSession session = request.getSession(true);
		//ログイン情報の取得
		if(session.getAttribute("login")!=null) {
			//loginからユーザーIDを取得
			ArrayList<ShohishaBean> list=new ArrayList<>();
			list=(ArrayList<ShohishaBean>) session.getAttribute("login");
			list.get
		}
		
		
	}



}
