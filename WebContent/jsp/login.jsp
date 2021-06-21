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
<font size="4">ログイン</font>
<br>
<br>
<select name="zokusei" >
<option value="kyaku">お客様</option>
<option value="kanrisya">管理者</option>
</select>
<br>
<br>
<table  align="center">
	<tr>
		<td align="right">ID：</td>
		<td><input type="text" name="id" size="15"></td>
	</tr>
	<tr>
		<td>パスワード：</td>
		<td><input type="text" name="pass" size="15"></td>
	</tr>
</table>
<br>
<br>
<input type="submit" name="submit" value="ログイン">
<br>
<br>
<a href="" >パスワードを忘れた方はこちら</a>
<br>
<br>
<br>
<a href="" >TOPへ</a>
</div>

</body>
</html>