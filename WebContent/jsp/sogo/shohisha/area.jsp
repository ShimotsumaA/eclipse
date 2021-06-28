<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>配送地域選択</title>
</head>
<style>
	*{
	font-family:"游ゴシック"
	}
	h3{
	background-color:#87ceeb
	}
	body{
		background-image:url("/group2work/image/43455.jpg")
	}
</style>
<body>
<!-- メニューバー -->
<div align="center">
		<div class="menu_bar">
    	<table>
    	<tr>
    		<td><a href="/group2work/jsp/sogo/shohisha/shopping.jsp">メニュー</a></td> <!-- メニューへのリンク -->
    		<td><a href="/group2work/jsp/sogo/shohisha/gaiyo.jsp">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    	</table>
   	 	</div>
	<div style="text-align:center">
	<form action="/group2work/PostServlet" method="post">
	<h3>住所入力</h3>

	<p>配送地域を選択してください。<br>
	<select name="chiikiselect">
	<optgroup label="北海道">
		<option value=1>北海道</option>
	</optgroup>

	<optgroup label="北東北">
		<option value=2>青森県</option>
		<option value=5>秋田県</option>
		<option value=3>岩手県</option>
	</optgroup>

	<optgroup label="南東北">
		<option value=4>宮城県</option>
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
		<option value=19>山梨県</option>
	</optgroup>

	<optgroup label="信越">
		<option value=15>新潟県</option>
		<option value=20>長野県</option>
	</optgroup>

	<optgroup label="北陸">
		<option value=16>富山県</option>
		<option value=17>石川県</option>
		<option value=18>福井県</option>
	</optgroup>

	<optgroup label="中部">
		<option value=22>静岡県</option>
		<option value=23>愛知県</option>
		<option value=24>三重県</option>
		<option value=21>岐阜県</option>
	</optgroup>

	<optgroup label="関西">
		<option value=27>大阪府</option>
		<option value=26>京都府</option>
		<option value=25>滋賀県</option>
		<option value=29>奈良県</option>
		<option value=30>和歌山県</option>
		<option value=28>兵庫県</option>
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


	<p class="midasi">*住所登録が配送先と異なる場合、配送先の住所を入力してください</p>

	<table align="center" border="1">
	<tr>
		<td>郵便番号:</td>
		<td><input type="text" name="post_code" value="<%=session.getAttribute("post_code") %>" size="30" maxlength="8"> </td>
	</tr>

	<tr>
		<td>住所:</td>
		<td><textarea rows="3" cols="40" name="address"><%=session.getAttribute("address") %></textarea></td>
	</tr>
	</table>
	<br><br>
	<font color="red">
			<%if(request.getAttribute("compmsg")!=null){ %>
				<%= request.getAttribute("compmsg")%>
			<% } %>

		</font>

	<button type="submit" name="submit" value="kakutei">確定</button>
	<button type="button" name="submit" value="return" onClick="history.go(-1)">戻る</button><br>

	</form>
	</div>
</div>
</body>
</html>