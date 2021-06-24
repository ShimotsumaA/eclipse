<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫入力</title>

</head>
<body>
<%if(request.getParameter("submit").equals("入庫")){%>
<div style=text-align:center>
	<h1>在庫管理</h1>
	商品ID：request.getParameter<br>
	商品名：パラメータ取得<br>
	在庫数：パラメータ取得<br><br>

	入力分の在庫数を追加します。<br><br>

	<label for="tuika">入庫数：現在の在庫数+</label>
	<input type="text" name="nyuko" size="30" id="tuika"><br><br>

	<input type="submit" name="submit"value="確認">
	<input type="button" value="戻る" onClick="history.go(-1)">
</div><br><br>
<%} %>

<%if(request.getParameter("submit").equals("変更")){%>
<div style=text-align:center>
	<h1>在庫管理</h1>
	商品ID：request.getParameter<br>
	商品名：パラメータ取得<br>
	在庫数：パラメータ取得<br><br>

	入力分の在庫数を追加します。<br><br>

	<label for="sinki">新規在庫数:</label>
	<input type="text" name="shinki" size="30" id="sinki">現在の在庫数<br><br>

	<input type="submit" value="確認">
	<input type="button" value="戻る" onClick="history.go(-1)">
</div>
<%} %>
	</body>
</html>