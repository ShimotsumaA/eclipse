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
	<select name="chiikiselect">
	<optgroup label="北海道">
		<option value=1>北海道</option>
	</optgroup>

	<optgroup label="北東北">
		<option value=2>青森県</option>
		<option value=3>秋田県</option>
		<option value=4>岩手県</option>
	</optgroup>

	<optgroup label="南東北">
		<option value=5>宮城県</option>
		<option value=6>山形県</option>
		<option value=7>福島県</option>
	</optgroup>

	<optgroup label="関東">
		<option value=8>茨城県</option>
		<option value=9>栃木県</option>
		<option value=10>群馬県</option>
		<option value=11>埼玉県</option>
		<option value=12>千葉県</option>
		<option value=13>東京都</option>
		<option value=14>神奈川県</option>
		<option value=15>山梨県</option>
	</optgroup>

	<optgroup label="信越">
		<option value=16>新潟県</option>
		<option value=17>長野県</option>
	</optgroup>

	<optgroup label="北陸">
		<option value=18>富山県</option>
		<option value=19>石川県</option>
		<option value=20>福井県</option>
	</optgroup>

	<optgroup label="中部">
		<option value=21>静岡県</option>
		<option value=22>愛知県</option>
		<option value=23>三重県</option>
		<option value=24>岐阜県</option>
	</optgroup>

	<optgroup label="関西">
		<option value=25>大阪府</option>
		<option value=26>京都府</option>
		<option value=27>滋賀県</option>
		<option value=28>奈良県</option>
		<option value=29>和歌山県</option>
		<option value=30>兵庫県</option>
	</optgroup>

	<optgroup label="中国">
		<option value=31>岡山県</option>
		<option value=32>広島県</option>
		<option value=33>山口県</option>
		<option value=34>鳥取県</option>
		<option value=35>島根県</option>
	</optgroup>

	<optgroup label="四国">
		<option value=36>香川県</option>
		<option value=37>徳島県</option>
		<option value=38>愛媛県</option>
		<option value=39>高知県</option>
	</optgroup>

	<optgroup label="九州">
		<option value=40>福岡県</option>
		<option value=41>佐賀県</option>
		<option value=42>長崎県</option>
		<option value=43>熊本県</option>
		<option value=44>大分県</option>
		<option value=45>宮崎県</option>
		<option value=46>鹿児島県</option>
	</optgroup>

	<optgroup label="沖縄">
		<option value=47>沖縄県</option>
	</optgroup>
	</select>
	</p>

	<p class="midasi">お届け先住所</p>
	<form action="/group2work/shohisha/PostServlet" method="post">

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