package shohisha;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartCancel
 */
@WebServlet("/CartCancel")
public class CartCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartCancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session=request.getSession(true);
		Boolean cancel=null;
		//キャンセルボタンが押されたとき
		if(request.getParameter("submit")!=null&&request.getParameter("submit").equals("cancel")) {
			//ログイン済みの場合
			if(session.getAttribute("id")!=null) {
				//セッションカートに商品がある場合
				if(session.getAttribute("cart")!=null) {
					String shohinId=request.getParameter("shohinId");
					Map<String, Integer> cart = new LinkedHashMap<>();
					cart = (Map<String, Integer>) session.getAttribute("cart");
					cart.remove(shohinId);
					cancel=true;

				//セッションカートに商品がない場合
				}else {
					String sId=(String)session.getAttribute("id");
					OrderDao dao1=new OrderDao();
					OrderDetailDAO dao2=new OrderDetailDAO();
					String oDetailId=dao1.jokenSIdStatus(sId, 0).get(0).getODetailId();

					int kensu=dao2.deleteShohin(oDetailId, sId);


					if(kensu>=1) {
						cancel=true;
					}else {
						cancel=false;
					}

				}


			}else {
				String shohinId=request.getParameter("shohinId");
				Map<String, Integer> cart = new LinkedHashMap<>();
				cart = (Map<String, Integer>) session.getAttribute("cart");
				cart.remove(shohinId);
				cancel=true;
			}

		}

		request.setAttribute("cancel", cancel);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/group2work/CartHyoujiServlet");
		dispatcher.forward(request, response);
	}

}
