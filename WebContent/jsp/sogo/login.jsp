<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

<div style="text-align:center">
<h1>ログイン</h1>
<br>
<br>

<form action="/group2work/LogInOutServlet" method="post">
<select name="zokusei" >
<option value="kyaku">お客様</option>
<option value="kanrisya">管理者</option>
</select>
<br>
<br>

<table  align="center">
	<tr>
		<td align="right">ID：</td>
		<td><input type="text" name="id" size="10"></td>
	</tr>
	<tr>
		<td>パスワード：</td>
		<td><input type="text" name="pass" size="15"></td>
	</tr>
</table>
<br>
<br>

<input type="submit" name="submit" value="ログイン">
</form>
<br><br>

<a href="" >パスワードを忘れた方はこちら</a>
<br><br>

<a href="/group2work/jsp/sogo/shohisha/user.jsp?no=1" >初めてご利用の方はこちら</a>
<br><br><br>

<a href="/group2work/jsp/sogo/top.jsp" >TOPへ</a>
</div>

</body>
</html>