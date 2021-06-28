<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<style>
	*{
	font-family:"游ゴシック"
	}
	body{
		background-image:url("/group2work/image/43455.jpg")
	}
</style>
<body>


	<div align ="center">
		<h3>マイページ</h3>

		<a href="/group2work/MyPageServlet?no=1">ユーザ情報確認</a><br><br>
		<a href="/group2work/MyPageServlet?no=2">購入履歴</a><br><br>

		<input type="button" name="back" value="戻る" onclick="location.href='shopping.jsp'">
	</div>


</body>
</html>