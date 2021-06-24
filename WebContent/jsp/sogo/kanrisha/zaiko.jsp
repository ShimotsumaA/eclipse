<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理</title>
</head>
<body>
<form action="zaikoMod.jsp" method="post">
<div style=text-align:right>
	<a href="menu.jsp">メニューへ戻る</a>
</div>
<div style=text-align:center>
<h1>在庫管理</h1>
<table border="1" align="center">
<tr>
	<td> </td><th>商品ID</th><th>商品名</th><th>在庫数</th>
</tr>
<tr>
	<td><input type="radio" name="zaiko" value="a"></td><td> </td><td> </td><td> </td>
</tr>
<tr>
	<td><input type="radio" name="zaiko" value="b"></td><td> </td><td> </td><td> </td>
</tr>
<tr>
	<td><input type="radio" name="zaiko" value="c"></td><td> </td><td> </td><td> </td>
</tr>
<tr>
	<td><input type="radio" name="zaiko" value="d"></td><td> </td><td> </td><td> </td>
</tr>
</table><br><br>

	<input type="submit" name="submit" value="入庫">
	<input type="submit" name="submit" value="変更">
</form>
<input type="button" value="戻る" onClick="history.go(-1)">
</div>
</body>
</html>