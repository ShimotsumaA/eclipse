package kanrisha;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UriageBean;

import java.io.*;


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

		HttpSession session= request.getSession(true);

		ArrayList<UriageBean> list=new ArrayList<UriageBean>();
		String date=null;

		//日の表を表示させる
		if (no.equals("1")) {
			date=request.getParameter("date");
		} else {
			date=request.getParameter("month");

		}

			Uriage uriage=new Uriage();
			Map<String, Integer> shohinMap=uriage.MapDate(date);

			ShohinDao dao=new ShohinDao();

			for (Map.Entry<String, Integer> entry : shohinMap.entrySet()) {
				String shohinId = entry.getKey();
				int gokeiKosu = entry.getValue();
				String shohinName=dao.joken(shohinId).get(0).getShohinName();
				BigDecimal value=dao.joken(shohinId).get(0).getValue();
				BigDecimal gokei=BigDecimal.valueOf(gokeiKosu).multiply(value);

				UriageBean bean=new UriageBean();
				bean.setGokei(gokei);
				bean.setGokeiKosu(gokeiKosu);
				bean.setShohinId(shohinId);
				bean.setShohinName(shohinName);
				bean.setValue(value);

				list.add(bean);

			}

		//月のグラフを表示させる

		session.setAttribute("uriage", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/uriage.jsp");
		dispatcher.forward(request, response);
	}

}
