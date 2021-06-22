<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>配送地域選択</title>
</head>
<body>

	<p class="midasi">お届け先住所</p>
	<form action="" method="post">

	<table>
	<tr>
		<td></td>
		<td>*住所登録が配送先と異なる場合、配送先の住所を入力してください。</td>
	</tr>

	<tr>
		<td>郵便番号:</td>
		<td><input type="text" name="post_code" value="デフォルト" size="8" maxlength="8"> <!-- 郵便番号の取得 --> </td>
	</tr>

	<tr>
		<td>住所:</td>
		<td><textarea rows="3" cols="40" name="address"><!-- 住所の取得 --></textarea></td>
	</tr>
	</table>

	<button type="submit" name="submit" value="kakutei">確定</button>

	</form>

</body>
</html>