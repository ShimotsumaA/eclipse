<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品受注ステータス変更</title>
</head>
<body>

<div style="text-align:right">
<a href="/group2work/jsp/sogo/kanrisha/menu.jsp">メニューへ戻る</a>
</div>
<br>

<div style="text-align:center">

<h1>注文ステータス変更</h1>

<%
	String submit = request.getParameter("submit");

	if (submit.equals("2")){
%>

		<p> <font color="red"><%= request.getAttribute("message") %></font></p>

<% } %>

注文番号：<%=session.getAttribute("orderId") %><br>
現在のステータスは

<%
	int statusId = (Integer)session.getAttribute("statusId");

	String hyouji=null;
	switch(statusId){
		case 1:
		hyouji="注文済み";
		break;

		case 2:
		hyouji="入金済み";
		break;

		case 3:
		hyouji="出荷準備中";
		break;

		case 4:
		hyouji="出荷済み";
		break;

		case 5:
		hyouji="配達済み";
		break;

		case 6:
			hyouji="キャンセル";
			break;

	}
%>

<font color="red"><%=hyouji %></font>
です。<br><br>

<form action="/group2work/TyumonStatuKanriServlet" method="post">
<table border="1" align="center">
	<th></th><th>ステータス</th>
	<tr>
		<td><input type="radio" name="radio" value="1"></td><td>注文済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value="2"></td><td>入金済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value="3"></td><td>出荷準備中</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value="4"></td><td>出荷済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value="5"></td><td>配達済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value="6"></td><td>キャンセル</td>
	</tr>
</table>
<br><br>

<input type="submit" name="submit" value="変更確認">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/shohinStatus.jsp?no=1'">
</form>

</body>
</html>