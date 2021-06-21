<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理確認</title>
</head>
<body>
<div style="text-align:center">

<h1>商品登録</h1><br><br>
以下の情報を登録します。よろしいですか？<br><br>
商品名：<br>
商品ID:<br>
カテゴリ：<br>
生地ID：	<!-shohinKanriModからパラメータ取得-><br><br>
<input type="submit" value="登録">
<input type="button" value="戻る" onClick="history.go(-1)">
<!-クエリ文字列->
<h1>商品変更</h1><br><br>
以下の情報を変更します。よろしいですか？<br><br>
商品名：<br>
商品ID:<br>
カテゴリ：<br>
生地ID：	<!-shohinKanriModからパラメータ取得-><br><br>
<input type="submit" value="変更">
<input type="button" value="戻る" onClick="history.go(-1)">

<h1>商品削除</h1><br><br>
以下の情報を削除します。よろしいですか？<br><br>
商品名：<br>
商品ID:<br>
カテゴリ：<br>
生地ID：	<!-shohinKanriModからパラメータ取得-><br><br>
<input type="submit" value="削除">
<input type="button" value="戻る" onClick="history.go(-1)">
</div>
</body>
</html>