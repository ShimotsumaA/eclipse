<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者総合メニュー</title>
</head>
<body>

<div style="text-align:center">
<h1>管理者総合メニュー</h1><br>

<a href="idStaffMenu.jsp">管理者ID管理</a><br>
<a href="shohinKanriMenu.jsp">商品管理</a><br>
<a href="/group2work/ZaikoIchiranServlet">在庫管理</a><br>
<a href="/group2work/TyumonStatuIchiranServlet">商品受注ステータス</a><br>
<a href="uriage.jsp">売上管理</a><br><br><br>

<form action="/group2work/LogInOutServlet" method="post">
<input type="submit"  name="submit" value="ログアウトしてトップページに戻る">
</form>

</div>
</body>
</html>