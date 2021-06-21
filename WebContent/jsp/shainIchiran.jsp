<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="java.util.ArrayList"%>
<%@ page import="bean.kanrishaBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
</head>
<body>

<div style="text-align:center">
<h1>社員一覧</h1>
<br>
<br>

<form action="" method="post">
<table  align="center" border="1">
	<tr>
		<td></td>
		<td>ID</td>
		<td>氏名</td>
		<td>役職</td>
		<td>パスワード</td>
	</tr>
	<!-- セッション領域から社員情報の入ったlistを取り出す -->
	<% ArrayList<kanrishaBean> list =  (ArrayList<kanrishaBean>)session.getAttribute("list"); %>
	<% int i = 0; %>
	<% while (i < list.size()) { %>
	<tr>
		<td><input type="radio" name="kanrisha" value="kanrisha"></td>
		<td><%= list.get(i).getId() %></td>
		<td><%= list.get(i).getName() %></td>
		<td><%= list.get(i).getPostId() %></td>
		<td><%= list.get(i).getPass() %>
	</tr>
	<% i++; %>
	<% } %>
</table>
<br>
<br>
<input type="submit" name="submit" value="変更">
<input type="submit" name="submit" value="削除">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/idStaffMenu.jsp'">
</form>
</div>

</body>
</html>