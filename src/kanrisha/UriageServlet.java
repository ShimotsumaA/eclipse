package kanrisha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UriageServlet")

public class UriageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//no=1(日)、no=2(月)で売上計算する
		String no = request.getParameter("no");
		System.out.println(no);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/uriage.jsp");
		dispatcher.forward(request, response);
	}

}
