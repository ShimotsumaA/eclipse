<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理確認</title>
</head>
<body>
<% System.out.println(request.getParameter("submit")); %>
<%if(request.getParameter("submit").equals("登録確認")){%>
<div style="text-align:center">

	<h1>商品登録</h1><br><br>
	以下の情報を登録します。よろしいですか？<br><br>

	<form action="/group2work/ShohinKanriServlet" method="post">

	商品名：<br>
	商品ID:<br>
	販売価格:<br>
	カテゴリ：<br>
	生地ID：	<!-shohinKanriModからパラメータ取得-><br><br>

	<input type="submit" name="submit" value="登録確定" >
	<input type="button" value="戻る" onClick="history.go(-1)">
	</form>
</div>
<%} %>

<%if(request.getParameter("submit").equals("変更確認")){%>
<div style="text-align:center">
	<h1>商品変更</h1><br><br>
	以下の情報を変更します。よろしいですか？<br><br>

	<form action="/group2work/ShohinKanriServlet" method="post">

	商品名：<br>
	商品ID:<br>
	カテゴリ：<br>
	生地ID：	<!-shohinKanriModからパラメータ取得-><br><br>

	<input type="submit" name="submit" value="変更確定">

	<input type="button" value="戻る" onClick="history.go(-1)">
	</form>
</div>
<%} %>

<%if(request.getParameter("submit").equals("delete"))	{%>
<div style="text-align:center">
	<h1>商品削除</h1><br><br>
	以下の情報を削除します。よろしいですか？<br><br>

	<form action="/group2work/ShohinKanriServlet" method="post">

	商品名：<br>
	商品ID:<br>
	カテゴリ：<br>
	生地ID：	<!-shohinKanriModからパラメータ取得-><br><br>

	<input type="submit" name="submit" value="削除確定">
	<input type="button" value="戻る" onClick="history.go(-1)">
	</form>
</div>
<%} %>
</body>
</html>