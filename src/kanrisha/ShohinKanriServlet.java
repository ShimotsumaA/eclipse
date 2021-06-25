package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sogo.ErrCheck;

/**
 * Servlet implementation class ShohinKanriServlet
 */
@WebServlet("/ShohinKanriServlet")
public class ShohinKanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinKanriServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//		String forward=null;


		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//商品一覧画面の変更ボタンが押された
		ErrCheck err=new ErrCheck();

		//商品が選択されていない

		if(request.getParameter("submit").equals("変更")) {
			System.out.println(request.getParameter("radio"));
			if(request.getParameter("radio")==null) {
				request.setAttribute("errorMsg","商品を選択してください");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
				dispatcher.forward(request, response);

			}

			

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=2");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ");
		}

		//商品変更画面の変更ボタンが押された
		if(request.getParameter("submit").equals("変更確認")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriKakunin.jsp");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ!");
		}


		if(request.getParameter("submit").equals("変更確定")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
				dispatcher.forward(request, response);
				System.out.println("ディスパッチ!!!");

		}

		if(request.getParameter("submit").equals("登録確認")){
			//入力値をセッション領域に預ける。
			HttpSession session=request.getSession();

			session.setAttribute("name", request.getParameter("name"));
			session.setAttribute("id", request.getParameter("id"));
			session.setAttribute("price", request.getParameter("price"));
			session.setAttribute("category", request.getParameter("category"));
			session.setAttribute("kiji", request.getParameter("kiji"));

			ErrCheck errchk=new ErrCheck();




			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriKakunin.jsp");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ!!!!");
		}

		if(request.getParameter("submit").equals("登録確定")){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=1");
				dispatcher.forward(request, response);
				System.out.println("ディスパッチ!!!!!");
			}

		if(request.getParameter("submit").equals("削除確定")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ!!!!!");
		}


//		//セッションの取得
//        HttpSession session = request.getSession(true);
//
////        登録確認画面の登録ボタンが押された時
//		if(request.getParameter("submit").equals("登録")) {
//			String shohinId=(String)session.getAttribute("shohinId");
//			String shohinName=(String)session.getAttribute("shohinName");
//			String categoryId=(String)session.getAttribute("categoryId");
//			String kijiId=(String)session.getAttribute("kijiId");
//			java.math.BigDecimal value=new BigDecimal((String)session.getAttribute("value"));
//
//			//DAOをインスタンス化
//			ShohinDao dao=new ShohinDao();
//			int rs=dao.insert(shohinId,shohinName,categoryId,kijiId,value);
//			System.out.println(rs);
//			request.setAttribute("compmsg", "登録が完了しました");
//			forward="/jsp/sogo/kanrisya/shohinKanriMenu.jsp";
//
//		}
////	登録確認画面の変更ボタンが押された時
//		if(request.getParameter("submit").equals("変更")) {
//			String shohinId=(String)session.getAttribute("shohinId");
//			String shohinName=(String)session.getAttribute("shohinName");
//			String categoryId=(String)session.getAttribute("categoryId");
//			String kijiId=(String)session.getAttribute("kijiId");
//			java.math.BigDecimal value=new BigDecimal((String)session.getAttribute("value"));
//
//		//DAOをインスタンス化
//			ShohinDao dao =new ShohinDao();
//			int rs=dao.update(shohinId, shohinName, kijiId, categoryId, value);
//			System.out.println(rs);
//			request.setAttribute("compmsg", "変更されました");
//			forward="/jsp/sogo/kanrisya/shohinKanriMenu.jsp";
//		}
//		if(request.getParameter("submit").equals("削除")){
//
//			String id = (String)session.getAttribute("id");
//
//			//DAOをインスタンス化
//			ShohinDao dao= new ShohinDao();
//			int rs =dao.delete(id);
//			System.out.println(rs);
//			request.setAttribute("compmsg","削除されました");
//			request.setAttribute("list",dao.selectAll());
//			forward="/jsp/sogo/kanrisya/shohinKanriMenu.jsp";
//		}
//		RequestDispatcher rd = request.getRequestDispatcher(forward);
//		rd.forward(request, response);
//	}




	}
}
