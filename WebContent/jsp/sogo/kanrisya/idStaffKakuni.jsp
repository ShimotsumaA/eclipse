<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者情報登録</title>
</head>
<body>

<div style="text-align:center">
<h1>管理者情報登録</h1>
<br>
<br>
以下の情報を登録します。よろしいですか？
<br>
<br>

<form action="" method="post"></form>
<table  align="center">
	<tr>
		<td align="right">ID：</td>
		<td></td>
	</tr>
	<tr>
		<td align="right">氏名：</td>
		<td></td>
	</tr>
	<tr>
		<td align="right">役職：</td>
		<td><select name="zokusei" >
				<option value="kyaku">お客様</option>
				<option value="kanrisha">管理者</option>
				</select></td>
	</tr>
	<tr>
		<td align="right">パスワード：</td>
		<td></td>
	</tr>
</table>
<br>
<br>

<input type="submit" name="submit" value="登録">
<input type="button" name="back" value="戻る" onclick="location.href=''">
</form>
</div>

</body>
</html>