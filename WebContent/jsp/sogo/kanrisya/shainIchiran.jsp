<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
</head>
<body>

<div style="text-align:center">
<h1>社員一覧</h1>
<br>
<br>

<form action="/kanrishaTorokuServlet" method="post">
<table  align="center" border="1">
	<tr>
		<td></td>
		<td>ID</td>
		<td>氏名</td>
		<td>パスワード</td>
	</tr>
	<tr>
		<td><input type="radio" name="kanrisha" value="kanrisha"></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
<br>
<br>
<input type="submit" name="submit" value="変更">
<input type="submit" name="submit" value="削除">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work//jsp/sogo/kanrisya/idStaffMenu.jsp'">
</form>
</div>

</body>
</html>