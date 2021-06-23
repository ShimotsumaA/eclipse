<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
</head>
<body>


<% Object obj = request.getAttribute("submit"); %>
<% String submit = obj.toString(); %>
<% System.out.println(submit); %>

<div style="text-align:center">
<h1>社員一覧</h1>

<%  if (submit.equals("変更確定")){ %>
		<p style="color:red">変更が完了しました。</p>
 <% } else if (submit.equals("削除確定")){ %>
		<p style="color:red">削除が完了しました。</p>
<% } %>

<form method="post">
<table  align="center" border="1">
	<tr>
		<td></td>
		<td>ID</td>
		<td>氏名</td>
		<td>パスワード</td>
	</tr>
	<tr>
		<td><input type="radio" name="kanrisha" value="kanrisha"></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table><br><br>

<input type="submit" formaction="/group2work/KanrishaTorokuServlet" name="submit" value="変更">
<input type="submit" formaction="/group2work/jsp/sogo/kanrisha/idStaffKakunin.jsp" name="submit" value="削除">
<input type="button" name="back" value="戻る" onclick="location.href='/group2work//jsp/sogo/kanrisha/idStaffMenu.jsp'">
</form>
</div>

</body>
</html>