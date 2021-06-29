<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員ID管理</title>
</head>
<body>
<div style="text-align:right">
< a href="/menu.jsp">管理者総合メニューへ</a>


<div style="text-align:center">
<h1>社員ID管理</h1>
<br>
<br>
<a href="idStaffMod.jsp?submit=1">管理者の登録</a><br><br>
<a href="/group2work/kanrishaIchiranServlet?submit=1">管理者の変更・削除</a><br><br>

<input type="button" name="back" value="戻る" onclick="location.href='menu.jsp'">
</div>

</body>
</html>