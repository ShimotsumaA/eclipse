<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
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
    </tr>
    </table>
    </div>
<!-- カテゴリ検索 -->
    <div class="side_bar">
    <table>
    <tr>
    <td><a href="">総合メニューへ</a></td>
	</tr>
    <!-- 検索ボックス -->
	<tr>
	<td>
	<form action="" method="post">
    <input type="text" name="kensaku"><input type="button">
    </form>
    </td>
    </tr>

    <!-- カテゴリ選択（for文) -->
    <tr>
    <td>
    	<p>カテゴリ</p>
    	<form action="" method="post" name="">
    	<input type="hidden" value="<!-- index_number -->">
    	<a href="">カテゴリ名</a>
    	</form>
    </td>
    </tr>

    <!-- 生地選択 (for文)-->
    <tr>
    <td>
    	<p>生地</p>
    	<form action="" method="post" name="">
    	<input type="hidden" value="<!-- index_number -->">
    	<a href="">生地名</a>
    	</form>
    </td>
    </tr>

    </table>
    </div>

<!-- 商品表示 -->
    <div class="shohin_hyozi">
    <table>

    <tr>
    <td>
    <!-- for文で取り出し -->
    	<form action="" method="post" name="">
    	<a href=""><img src=""></a><br>
    	</form><br>
    	<p>商品名</p>
    	<p>価格</p>
    </td>
    </tr>
    </table>
    </div>

	<!-- フッター -->
    <div class="footer">
    <table>
    <tr>
    	<td><a href="">配送料に関して</a></td>
    </tr>
    <tr>
    	<td><a href="">特定商取引法に基づく表記</a></td>
    </tr>
    </table>
    </div>

</div>

</body>
</html>