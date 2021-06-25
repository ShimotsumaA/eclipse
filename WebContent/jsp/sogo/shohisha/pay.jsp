<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お支払方法選択</title>
</head>
<body>

	<div class="wrapper">
		<div class="">
		</div>

	<form method="post">

		<div class="">
			<h1 class="midasi">お支払方法を選択</h1>
			<table>
			<tr>
				<td>お支払方法</td>
			</tr>

			<tr>
				<td><input type="radio" id="siharai" value="hurikomi"></td>
				<td>銀行振込</td>
			</tr>

			<tr>
				<td><input type="radio" id="siharai" value="credit_card"></td>
				<td>クレジットカード決済</td>
			</tr>

			<tr>
				<td><input type="radio" id="siharai" value="daibiki"></td>
				<td>代金引換　<br><p>*代引き手数料がかかります</p></td>
			</table>
		</div>

		<div class="">
			<button type="submit" name="submit" value="zokko" formaction="/group2work/BuyControl">続行</button>
			<button type="button" name="submit" value="return" >戻る</button>
		</div>

	</form>

	</div>
</body>
</html>