package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogInOutServlet")
public class LogInOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードを設定する
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");

		//管理者総合メニューへ遷移する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/group2work/menu.jsp");
		dispatcher.forward(request, response);
	}

}
