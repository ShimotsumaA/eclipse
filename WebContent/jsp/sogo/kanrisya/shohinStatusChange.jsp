<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品受注ステータス変更</title>
</head>
<body>

<div style="text-align:right">
<a href="">メニューへ戻る</a>
</div>
<br>

<div style="text-align:center">

注文番号：<br>
現在のステータスは
<font color="red">ステータス</font>
です。<br><br>

<form action="" method="post">
<table border="1" align="center">
	<th></th><th>ステータス</th>
	<tr>
		<td><input type="radio" name="radio" value=""></td><td>入金済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value=""></td><td>出荷準備中</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value=""></td><td>出荷済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value=""></td><td>配達済み</td>
	</tr>
	<tr>
		<td><input type="radio" name="radio" value=""></td><td>キャンセル</td>
	</tr>
</table>
<br><br>

<input type="submit" name="submit" value="確認">
<input type="button" name="back" value="戻る" onclick="location.href=''">
</form>

</body>
</html>