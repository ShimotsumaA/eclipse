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

import bean.ShohishaBean;

/**
 * Servlet implementation class myPageServlet
 */
@WebServlet("/MyPageServlet")
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

		String no=null;

		if(request.getParameter("no")!=null){
			no=request.getParameter("no");
		}
		if(request.getAttribute("no")!=null){
			no=(String)request.getAttribute("no");
		}

    //myPage.jspでユーザ情報確認(リンク)が押された際の処理
        if(no.equals("1")){
			/*
			 * ShohishaDao dao = new ShohishaDao();
			 * request.setAttribute("list",dao.selectAll()); //userKakunin.jspの画面を決める値をセット
			 */
    		HttpSession session=request.getSession(true);
    		String sId=(String) session.getAttribute("id");
    		ShohishaDao dao=new ShohishaDao();

    		//ユーザー情報の取得
    		ArrayList<ShohishaBean> list=new ArrayList<ShohishaBean>();
    		list=dao.joken(sId);
    		String sName=list.get(0).getName();
    		String dateBirth=list.get(0).getBirth();
    		String postCode=list.get(0).getPost();
    		String address=list.get(0).getAdress();
    		String tel=list.get(0).getTel();
    		String mailAddress=list.get(0).getMail();
    		String sPass=list.get(0).getPass();

    		//ユーザー情報をセッションにセット
    		session.setAttribute("sId", sId);
    		session.setAttribute("sName", sName);
    		session.setAttribute("dateBirth", dateBirth);
    		session.setAttribute("postCode", postCode);
    		session.setAttribute("address", address);
    		session.setAttribute("tel", tel);
    		session.setAttribute("mailAddress", mailAddress);
    		session.setAttribute("sPass", sPass);


        	request.setAttribute("submit","henko");
			//forward先を指定
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/userKakunin.jsp");
			rd.forward(request, response);
		}

     //myPage.jspで購入履歴確認(リンク)が押された際の処理
        if(no.equals("2")){
        	OrderDao dao = new OrderDao();
			request.setAttribute("list",dao.selectAll());;
			//forward先を指定
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/sogo/shohisha/rireki.jsp");
			rd.forward(request, response);
		}

	}


}
