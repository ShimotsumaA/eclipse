<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お支払方法選択</title>
</head>
<body>
	<div style="text-align:center">
			<h1>お支払方法を選択</h1>
		<form method="post">
		<table border="1" align="center">
			<th></th><th>お支払方法</th>
			<tr>
				<td><input type="radio" name="shiharai" value="hurikomi"></td>
				<td>銀行振込</td>
			</tr>

			<tr>
				<td><input type="radio" name="shiharai" value="credit_card"></td>
				<td>クレジットカード決済</td>
			</tr>

			<tr>
				<td><input type="radio"  name="shiharai" value="daibiki"></td>
				<td>代金引換</td>
			</table>
				<p>*代引き引き換えは、代引き手数料がかかります</p>
			<br><br>

		<div class="">
			<button type="submit" name="submit" value="zokko" formaction="/group2work/BuyControl">続行</button>
			<button type="button" name="submit" value="return" >戻る</button>
		</div>
		</form>

	</div>
</body>
</html>