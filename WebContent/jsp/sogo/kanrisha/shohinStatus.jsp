<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<td><input type="radio" name="radio" value="status"></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
	</tr>
</table>
<br>
注文番号を選択して受注ステータス変更ボタンを押してください。<br><br>

<input type="submit" name="submit" value="受注ステータス変更">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/menu.jsp'">
</form>
</div>

</body>
</html>