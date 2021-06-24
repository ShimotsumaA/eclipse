<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫変更確認</title>
</head>
<body>
<%if(request.getParameter("submit").equals("確認")) {%>
<div style=text-align:center>
	<h1>変更確認</h1>
	以下の情報を変更します。よろしいですか？<br><br>
	商品ID：<br>
	商品名：<br>
	価格：<br>
	変更前在庫数：<br>
	変更後在庫数：<font color="red">パラメータ</font><br>
<form action="/group2work/ZaikoKanriServlet" method="post">
	<input type="submit" name="submit" value="確定">
</form>
	<input type="button" value="戻る" onClick="history.go(-1)">
</div>
<%} %>
</body>
</html>