<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品受注ステータス変更確認</title>
</head>
<body>

<div style="text-align:center">

<h1>商品ステータス変更確認</h1><br>
以下の商品ステータスを変更します。よろしいですか？<br><br>

<form action="/group2work/TyumonStatuKanriServlet"" method="post">
<table align="center">
	<tr>
		<td align="right">商品ID：</td><td></td>
	</tr>
	<tr>
		<td align="right">商品名：</td><td></td>
	</tr>
	<tr>
		<td align="right">変更前ステータス：</td><td></td>
	</tr>
	<tr>
		<td align="right">変更後ステータス：</td><td></td>
	</tr>
</table>
<br>
<br>

<input type="submit" name="submit" value="変更確定">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/shohinStatusChange.jsp'">
</form>

</body>
</html>