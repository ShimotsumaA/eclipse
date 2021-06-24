<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文</title>
</head>
<body>
	<!-- メニューバー -->
	<div class="wrapper">
    	<div class="menu_bar">
    	<table>
    	<tr>
    		<td><a href="top.jsp">トップメニュー</a></td> <!-- トップメニューへのリンク -->
    		<td><a href="cart.jsp">カート</a></td>　<!-- カートへのリンク -->
    		<td><a href="">マイページ</a></td><!-- マイページへのリンク -->
    		<td><a href="">ログイン</a></td><!-- ログインページへのリンク -->
    		<td><a href="">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    	</table>
   	 	</div>

   	 	<!-- 見出し -->
   	 	<p class="midasi">注文内訳</p>

   	 	<!-- 商品詳細 -->
   	 	<div class="shosai">
			<table>
			<!-- for文で取り出し -->
			<tr>
				<td>
				<img src="" name="">
				</td>
				<td>
				商品:AAA<!-- 商品名表示 --><br>
				数量:BBB<!-- 数量表示 --><br>
				価格:CCC<!-- 価格表示 -->
				</td>
			</tr>
			</table>
   	 	</div>

   	 	<!-- 合計金額 -->
   	 	<div class="gokei">
   	 		<table>
			<tr>
				<th>合計金額</th>
			</tr>
			<tr>
				<td>商品合計:xxxxx円</td><!-- 合計金額表示 -->
				<td>送料:xxxxx円</td><!-- 送料表示 -->
				<td>総計:xxxxx円</td><!-- 総計表示 -->
			</tr>
   	 		</table>
   	 	<!-- ボタン -->
   	 	<div class="submit">
   	 		<form method="post">
   	 			<button type="submit" name="submit" value="jyusho" formaction="">住所入力</button>
   	 			<button type="submit" name="submit" value="return" formaction="">戻る</button>
   	 		</form>
   	 	</div>


   	 	</div>


</div>

</body>
</html>