<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>配送地域選択</title>
</head>
<body>
	<p>配送地域を選択してください。<br>
	<select name="北海道">
		<option selected>北海道</option>
		<option>北海道</option>
	</select>

	<select name="北東北">
		<option selected>北東北</option>
		<option>青森県</option>
		<option>秋田県</option>
		<option>岩手県</option>
	</select>

	<select name="南東北">
		<option selected>南東北</option>
		<option>宮城県</option>
		<option>山形県</option>
		<option>福島県</option>
	</select>

	<select name="関東">
		<option selected>関東</option>
		<option>茨城県</option>
		<option>栃木県</option>
		<option>埼玉県</option>
		<option>千葉県</option>
		<option>東京都</option>
		<option>神奈川県</option>
		<option>山梨県</option>
	</select>

	<select name="信越">
		<option selected>信越</option>
		<option>新潟県</option>
		<option>長野県</option>
	</select>

	<select name="北陸">
		<option selected>北陸</option>
		<option>富山県</option>
		<option>石川県</option>
		<option>福井県</option>
	</select>

	<select name="中部">
		<option selected>中部</option>
		<option>静岡県</option>
		<option>愛知県</option>
		<option>三重県</option>
		<option>岐阜県</option>
	</select>

	<select name="関西">
		<option selected>関西</option>
		<option>大阪府</option>
		<option>京都府</option>
		<option>滋賀県</option>
		<option>奈良県</option>
		<option>和歌山県</option>
		<option>兵庫県</option>
	</select>

	<select name="中国">
		<option selected>中国</option>
		<option>岡山県</option>
		<option>広島県</option>
		<option>山口県</option>
		<option>鳥取県</option>
		<option>島根県</option>
	</select>

	<select name="四国">
		<option selected>四国</option>
		<option>香川県</option>
		<option>徳島県</option>
		<option>愛媛県</option>
		<option>高知県</option>
	</select>

	<select name="九州">
		<option selected>九州</option>
		<option>福岡県</option>
		<option>佐賀県</option>
		<option>長崎県</option>
		<option>熊本県</option>
		<option>大分県</option>
		<option>宮崎県</option>
		<option>鹿児島県</option>
	</select>

	<select name="沖縄">
		<option selected>沖縄</option>
		<option>沖縄県</option>
	</select>
	</p>

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