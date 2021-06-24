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

      //user.jspで登録ボタンが押された際の処理
        	if(request.getParameter("submit").equals("登録")){
        		/*String errmsg="IDは英数字かつ10文字以内で登録してください。";
    			String errmsg2="パスワードは英数字を組み合わせ、4文字以上15文字以内で登録してください。";
    			String errmsg3="パスワードが一致していません。";
    			Errcheck err = new Errcheck();
    			errmsg = err.checkId(request.getParameter("id"));
    			errmsg2= err.checkPass(request.getParameter("kPass1"));
    			errmsg3= err.checkPassMaches(request.getParameter("kPass1"),request.getParameter("kPass2"));

    			if(errmsg==null && errmsg2==null && errmsg3==null){
    				session.setAttribute("sId", request.getParameter("sId"));
    				session.setAttribute("sName", request.getParameter("sName"));
    				session.setAttribute("dateBirth", request.getParameter("dateBirth"));
    				session.setAttribute("postCode", request.getParameter("postCode"));
    				session.setAttribute("adress", request.getParameter("adress"));
    				session.setAttribute("tel", request.getParameter("tel"));
    				session.setAttribute("mailAdress", request.getParameter("mailAdress"));
    				session.setAttribute("sPass", request.getParameter("sPass"));
    				forward="/group2work/jsp/sogo/shohisha/userKakunin.jsp?no=2";
    			}else{
    				session.setAttribute("sId", request.getParameter("sId"));
    				session.setAttribute("sName", request.getParameter("sName"));
    				session.setAttribute("dateBirth", request.getParameter("dateBirth"));
    				session.setAttribute("postCode", request.getParameter("postCode"));
    				session.setAttribute("adress", request.getParameter("adress"));
    				session.setAttribute("tel", request.getParameter("tel"));
    				session.setAttribute("mailAdress", request.getParameter("mailAdress"));
    				session.setAttribute("sPass", request.getParameter("sPass"));
    				//入力画面に戻した際の画面表示の設定
    				request.setAttribute("errmsg", errmsg);
    				request.setAttribute("errmsg2", errmsg2);
    				forward="/group2work/jsp/sogo/shohisha/user.jsp?no=1";*/
    			}




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
				forward="/group2work/jsp/sogo/shohisha/user.jsp?no=2";
			}else{

			}


	 //userKakunin.jspから確定ボタンが押された際の処理
			if(request.getParameter("submit").equals("確定")){
				String sName = (String)session.getAttribute("s_name");
				String dateBirth =(String)session.getAttribute("date_birth");
				String postCode = (String) session.getAttribute("postcode");
				String adress = (String) session.getAttribute("adress");
				String tel = (String) session.getAttribute("tel");
				String mailAdress = (String) session.getAttribute("mailadress");
				String sId = (String) session.getAttribute("s_id");
				String  sPass= (String) session.getAttribute("s_pass");

				//DAOをインスタンス化
				ShohishaDao dao2= new ShohishaDao();
				int rs =dao2.insert(sName, dateBirth, postCode, adress, tel, mailAdress, sId, sPass);
				System.out.println(rs);
				request.setAttribute("compmsg", "登録が完了しました");
				forward="/groupu2work/jsp/sogo/shohisha/area.jsp";
			}

	}

}







