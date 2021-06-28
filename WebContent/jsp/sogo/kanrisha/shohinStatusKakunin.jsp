<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文受注ステータス変更確認</title>
</head>
<body>

<div style="text-align:center">

<h1>注文受注ステータス変更確認</h1><br>
以下の注文ステータスを変更します。よろしいですか？<br><br>

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

			int newStatusId = (Integer)session.getAttribute("newStatusId");
			String newHyouji=null;
			switch(newStatusId){
				case 1:
				newHyouji="注文済み";
				break;

				case 2:
				newHyouji="入金済み";
				break;

				case 3:
				newHyouji="出荷準備中";
				break;

				case 4:
				newHyouji="出荷済み";
				break;

				case 5:
				newHyouji="配達済み";
				break;

				case 6:
				newHyouji="キャンセル";
				break;
			}
		%>

<form action="/group2work/TyumonStatuKanriServlet" method="post">
<table align="center">
	<tr>
		<td align="right">注文番号：</td><td><%=session.getAttribute("orderId") %></td>
	</tr>
	<tr>
		<td align="right">変更前ステータス：</td><td><%=hyouji %></td>
	</tr>
	<tr>
		<td align="right">変更後ステータス：</td><td><%=newHyouji %></td>
	</tr>
</table>
<br>
<br>

<button type="submit" name="submit" value="kakutei">変更確定</button>
<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/shohinStatusChange.jsp?submit=1'">
</form>

</body>
</html>