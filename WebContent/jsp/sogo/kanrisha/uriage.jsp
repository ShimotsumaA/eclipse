<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上管理</title>
</head>
<body>

<div style="text-align:center">
<h1>売上管理</h1>



<form action="/group2work/UriageSevlet?no=1" method="post">
<input type="date" name="date">
<input type="submit" name="submit" value="日別">
<br><br>
</form>

<form action="/group2work/UriageSevlet?no=2" method="post">
<input type="month" name="month">
<input type="submit" name="submit" value="月別">
<br><br>
</form>

<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/menu.jsp'">

</div>

<!-- 日別は表、月別は表とグラフを表示させる -->
</body>
</html>