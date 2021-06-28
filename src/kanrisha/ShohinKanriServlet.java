package kanrisha;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CategoryBean;
import bean.ShohinBean;
import shohisha.CategoryDao;
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
		String submit=request.getParameter("submit");
		System.out.println(submit);

		//セッション領域を作成
		HttpSession session=request.getSession(true);

		if(submit.equals("変更")) {
			String shohinId=request.getParameter("radio");
			System.out.println(shohinId);

			//商品が選択されていない
			if(request.getParameter("radio")==null) {
				request.setAttribute("errorMsg","商品を選択してください");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
				dispatcher.forward(request, response);

			}

			ShohinDao dao=new ShohinDao();
			CategoryDao dao2=new CategoryDao();
			ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
			ArrayList<CategoryBean> listCategory=new ArrayList<CategoryBean>();

			list=dao.joken(shohinId);


			session.setAttribute("shohinId",list.get(0).getShohinId());
			session.setAttribute("shohinName",list.get(0).getShohinName());
			session.setAttribute("value",list.get(0).getValue().intValue());
			session.setAttribute("categoryId",list.get(0).getCategoryId());
			session.setAttribute("kijiId", list.get(0).getKijiId());
			session.setAttribute("listCategory", listCategory);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=2");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ");
		}

		//商品変更画面の変更ボタンが押された
		if(submit.equals("変更確認")) {


			session.setAttribute("name", request.getParameter("name"));
			session.setAttribute("id", request.getParameter("id"));
			session.setAttribute("price", request.getParameter("price"));
			session.setAttribute("category", request.getParameter("category"));
			session.setAttribute("kiji", request.getParameter("kiji"));

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriKakunin.jsp");
			dispatcher.forward(request, response);
			System.out.println("ディスパッチ!");
		}

//		登録確認画面の変更ボタンが押された時
		if(submit.equals("変更確定")) {

				String shohinId=(String)session.getAttribute("id");
				String shohinName=(String)session.getAttribute("name");
				String categoryId=(String)session.getAttribute("category");
				String kijiId=(String)session.getAttribute("kiji");
				java.math.BigDecimal value=new BigDecimal((String)session.getAttribute("value"));

			//DAOをインスタンス化
				ShohinDao dao =new ShohinDao();
				int rs=dao.update(shohinId, shohinName, kijiId, categoryId, value);
				System.out.println(rs);
				request.setAttribute("compmsg", "変更されました");


				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
				dispatcher.forward(request, response);
				System.out.println("ディスパッチ!!!");

		}

		if(submit.equals("登録確認")){

			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String price = request.getParameter("price");
			String kiji = request.getParameter("kiji");

			//いずれかの項目が入力されていない
			if (name.equals("") || id.equals("") || price.equals("") || kiji.equals("")) {

				request.setAttribute("message", "すべての項目を入力してください。");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=3");
				dispatcher.forward(request, response);

			} else {

				//エラーチェック
				ErrCheck err =new ErrCheck();

				//商品IDが存在するかどうか
				if (err.existShohinId(id)) {

					String message = "商品IDが既に存在します。";
					request.setAttribute("message", message);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=3");
					dispatcher.forward(request, response);

				} else {
					System.out.println("idは存在しません。");
				}


				//入力値をセッション領域に預ける。
				session.setAttribute("name", name);
				session.setAttribute("id", id);
				session.setAttribute("price", price);
				session.setAttribute("category", request.getParameter("category"));
				session.setAttribute("kiji", kiji);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriKakunin.jsp");
				dispatcher.forward(request, response);
				System.out.println("商品管理確認へ");

			}
		}

		if(submit.equals("登録確定")){

			String shohinId=(String)session.getAttribute("id");
			String shohinName=(String)session.getAttribute("name");
			String categoryId=(String)session.getAttribute("category");
			String kijiId=(String)session.getAttribute("kiji");
			java.math.BigDecimal value=new BigDecimal((String)session.getAttribute("value"));

			//DAOをインスタンス化
			ShohinDao dao=new ShohinDao();
			int rs=dao.insert(shohinId,shohinName,categoryId,kijiId,value);
			System.out.println(rs);
			request.setAttribute("compmsg", "登録が完了しました");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=1");
			dispatcher.forward(request, response);

			}

		if(submit.equals("削除確定")){
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
