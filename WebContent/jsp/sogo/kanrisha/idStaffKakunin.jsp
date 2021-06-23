<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者情報登録</title>
</head>
<body>
<div style="text-align:center">

<% String submit = request.getParameter("submit"); %>
<% System.out.println(submit+"idStaffKakunin"); %>

<% if (submit.equals("登録情報確認")){ %>
	<h1>管理者情報登録確認</h1><br><br>

	以下の情報を登録します。よろしいですか？<br><br>

	<form action="/group2work/KanrishaTorokuServlet" method="post">
	<table  align="center">
		<tr>
			<td align="right">ID：</td>
			<td></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td></td>
		</tr>
		<tr>
			<td align="right">役職：</td>
			<td><select name="zokusei" >
					<option value="kyaku">お客様</option>
					<option value="kanrisha">管理者</option>
					</select></td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td></td>
		</tr>
	</table><br><br>

	<input type="submit" name="submit" value="登録確定">
	<input type="button" name="back" value="戻る" onclick="location.href='/group2work//jsp/sogo/kanrisha/idStaffMod.jsp?submit=1'">
	</form>
	</div>

<% }else { %>

	<% if (submit.equals("変更情報確認")){ %>

		<h1>管理者情報変更確認</h1><br><br>
		以下の情報を変更します。よろしいですか？<br><br>

	<% } else if (submit.equals("削除")){ %>

		<h1>管理者情報削除確認</h1><br><br>
		以下の情報を削除します。よろしいですか？<br><br>

	<% } %>

	<form action="/group2work/KanrishaTorokuServlet" method="post">
	<table  align="center">
		<tr>
			<td align="right">ID：</td>
			<td></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td></td>
		</tr>
		<tr>
			<td align="right">役職：</td>
			<td><select name="zokusei" >
					<option value="kyaku">お客様</option>
					<option value="kanrisha">管理者</option>
					</select></td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td></td>
		</tr>
	</table><br><br>
	<% if (submit.equals("変更情報確認")){ %>
		<input type="submit" name="submit" value="変更確定">
	<% } else if (submit.equals("削除")){ %>
		<input type="submit" name="submit" value="削除確定">
	<% } %>

	<input type="button" name="back" value="戻る" onclick="location.href='/group2work//jsp/sogo/kanrisha/idStaffMod.jsp?submit=1'">
	</form>
	</div>
<% } %>
</body>
</html>