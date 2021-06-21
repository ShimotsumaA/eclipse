<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報入力</title>
</head>
<body>

<div style="text-align:center">
<h1>管理社情報登録</h1>
<br>
<br>

<form action="" method="post">
<table  align="center">
	<tr>
		<td align="right">ID：</td>
		<td><input type="text" name="id" size="15"></td>
	</tr>
	<tr>
		<td align="right">氏名：</td>
		<td><input type="text" name="name" size="10"></td>
	</tr>
	<tr>
		<td align="right">役職：</td>
		<td><select name="zokusei" >
				<option value="kyaku">お客様</option>
				<option value="kanrisya">管理者</option>
				</select></td>
	</tr>
	<tr>
		<td align="right">パスワード：</td>
		<td><input type="text" name="pass1" size="15"></td>
	</tr>
	<tr>
		<td align="right">パスワード再入力：</td>
		<td><input type="text" name="pass2" size="15"></td>
	</tr>
</table>
<br>
<br>

<input type="submit" name="submit" value="確認">
<input type="button" name="back" value="戻る" onclick="location.href=''">
</form>

</div>

</body>
</html>