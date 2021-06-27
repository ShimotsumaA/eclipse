<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="bean.ShohishaBean" %>
<%@ page import="bean.OrderDetailBean" %>
<%@ page import="bean.OrderBean" %>
<%@ page import="bean.ShohinBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kanrisha.ShohinDao" %>
<%@ page import="bean.TyumonBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品受注ステータス管理</title>
</head>
<body>

<!-- noクエリ文字列によって画面遷移を分ける -->
<% String no = request.getParameter("no"); %>
<% System.out.println(no); %>

<div style="text-align:center">

<h1>商品受注ステータス一覧</h1>

<% if (no.equals("2")){ %>
	<p> <font color="red">商品受注ステータスの変更が完了しました。</font></p>
<% } %>

<form action="/group2work/TyumonStatuKanriServlet" method="post">
<table border="1" align="center">
	<tr>
		<th></th><th>注文番号</th><th>日付</th><th>顧客ID</th><th>住所</th><th>電話番号</th><th>内訳</th><th>受注ステータス</th>
	</tr>
	<tr>
	<%
		ArrayList<TyumonBean> tyumonListAll=(ArrayList<TyumonBean>) session.getAttribute("tyumonListAll");
		ArrayList<OrderBean> orderListJoken;
		ArrayList<ShohinBean> shohinList;
		ArrayList<OrderDetailBean> orderDetailList;
		ArrayList<ShohishaBean> shohishaList;

	for(int i=0; i<tyumonListAll.size(); i++) {
		orderListJoken=tyumonListAll.get(i).getOrderList();
		orderDetailList=tyumonListAll.get(i).getODetailList();
		shohishaList=tyumonListAll.get(i).getShohishaList();


		String orderId=orderListJoken.get(0).getOrderId(); //注文番号
		String date=orderListJoken.get(0).getDate(); //日付
		int statusId=orderListJoken.get(0).getStatusId();// ステータスid

		String sId=shohishaList.get(0).getId();//消費者id
		String sName=shohishaList.get(0).getName();//名前
		String address=shohishaList.get(0).getAdress();//住所
		String tel=shohishaList.get(0).getTel();//電話番号


		ShohinDao dao4 = new ShohinDao();




 	%>
		<td><input type="radio" name="radio" value= "<%=orderId%>"></td>
		<td><%=orderId %></td>
		<td><%=date %></td>
		<td><%=sId %></td>
		<td><%=address %></td>
		<td><%=tel %></td>
		<td>
		商品名：個数<br>
		<%for(int j=0; j<orderDetailList.size();j++){
			String shohinId=orderDetailList.get(j).getShohinId();
			shohinList=dao4.joken(shohinId);
			String shohinName=shohinList.get(0).getShohinName();
			int konyuKosu=orderDetailList.get(j).getKazuKonyu();
		%>
		<%=shohinName %>:<%=konyuKosu%>個	<br>
		<% }%>
		</td>

		<td>
		<%String hyouji=null;
		switch(statusId){
			case 1:
			hyouji="注文済み";
			break;

			case 2:
			hyouji="入金済み";
			break;

			case 3:
			hyouji="出荷準備";
			break;

			case 4:
			hyouji="配達済み";
			break;

			case 5:
			hyouji="キャンセル";
			break;

		}%>
		<%=hyouji %>
		</td>
	</tr>
	<% } %>
</table>
<br>
注文番号を選択して受注ステータス変更ボタンを押してください。<br><br>

<input type="submit" name="submit" value="受注ステータス変更">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/menu.jsp'">
</form>
</div>

</body>
</html>