<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
<div class="wrapper">
<!-- メニューバー -->
    <div class="menu_bar">
    <table>
    	<tr>
    	<td><a href="">トップメニュー</a></td> <!-- トップメニューへのリンク -->
    	<td><a href="">カート</a></td>　<!-- カートへのリンク -->
    	<td><a href="">マイページ</a></td><!-- マイページへのリンク -->
    	<td><a href="">ログイン</a></td><!-- ログインページへのリンク -->
    	<td><a href="">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    </table>
    </div>

    <div class="contents">
    <p id="midasi"> カート一覧</p>
    <table>
    <tr>
    <!-- for文で抽出 -->
    	<td>商品A<br>
    	価格：XXX円<br>
    	個数:1
    	<form action="" method="post">
    	<button type="submit" name=submit value="cancel" id="商品A">キャンセル</button>
    	</form>
   	 	</td>
    </table>

    <!-- カート合計表示 -->
    <p id="sum_cart">カート合計:XXX円</p>
    </div>

    <!-- 注文ボタン -->
    <form action="" method="post">
    <button type="button" name="submit" value="tyumonhakotira">ご注文はこちら</button>
    </form>

    <div class="footer">Three</div>
</div>

</body>
</html>