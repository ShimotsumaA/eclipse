package shohisha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ShohishaBean;

/**
 * Servlet implementation class userRegisterControlServlet
 */
@WebServlet("/userRegisterControlServlet")
public class UserRegisterControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterControlServlet() {
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

	//セッションの取得
        HttpSession session = request.getSession(true);

        String forward=null;

      //userKakunin.jspから変更ボタンが押された際の処理
      		if(request.getParameter("submit").equals("変更")){
      		//DAOをインスタンス化
      			ShohishaDao dao= new ShohishaDao();
      			ArrayList<ShohishaBean> list =dao.joken(request.getParameter("sId"));

      			session.setAttribute("s_id",list.get(0).getId());
				session.setAttribute("s_name",list.get(0).getName());
				session.setAttribute("date_birth",list.get(0).getBirth());
				session.setAttribute("postcode",list.get(0).getPost());
				session.setAttribute("adress",list.get(0).getAdress());
				session.setAttribute("tel",list.get(0).getTel());
				session.setAttribute("mailadress",list.get(0).getMail());
				session.setAttribute("s_pass",list.get(0).getPass());
				//遷移先
				forward="/jsp.user.jsp?no=2";
			}else{

			}

		 }


 }






