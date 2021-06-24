<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者情報入力</title>
</head>
<body>

<% String submit = request.getParameter("submit");%>
<!-- デバック用 -->
<% System.out.println(submit+"idStafMod"); %>


<% if(submit.equals("変更")) { %>

	<div style="text-align:center">
	<h1>管理社情報変更</h1><br>

	<form action="/group2work/KanrishaTorokuServlet" method="post">

	<table  align="center">
		<tr>
			<td align="right">ID：</td>
			<td><input type="text" name="id" size="15"  placeholder="表示させたいテキストを記述"></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td><input type="text" name="name" size="10"  placeholder="表示させたいテキストを記述"></td>
		</tr>
		<tr>
			<td align="right">役職：</td>
			<td><select name="zokusei" >
					<option value="kyaku">お客様</option>
					<option value="kanrisya">管理者</option>
					</select></td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td><input type="text" name="pass1" size="15"  placeholder="表示させたいテキストを記述"></td>
		</tr>
		</table><br><br>

	<input type="submit" name="submit" value="変更情報確認">
	<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/shainIchiran.jsp'">
	</form>
	</div>

<%}  else { %>
	<div style="text-align:center">
	<h1>管理社情報登録</h1>

	<% if (submit.equals("登録確定")){ %>
		<p style="color:red">登録が完了しました。</p>
	<% } %>

	<form action="/group2work/KanrishaTorokuServlet" method="post">
	<br><table  align="center">
		<tr>
			<td align="right">ID：</td>
			<td><input type="text" name="id" size="15"></td>
		</tr>
	</table><br>
	・IDは10文字以内で半角入力のみ可能です。​<br>
	・アルファベットと数字のみ使用可能です。<br>​
	・大文字と小文字の区別はしません。<br><br>

	<table  align="center">
		<tr>
			<td align="right">氏名：</td>
			<td><input type="text" name="name" size="10"></td>
		</tr>
		<tr>
			<td align="right">役職：</td>
			<td><select name="zokusei" >
					<option value="kyaku">お客様</option>
					<option value="kanrisya">管理者</option>
					</select></td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td><input type="text" name="pass1" size="15"></td>
		</tr>
	</table><br>

	・パスワードは4文字以上15文字以内で半角入力のみ可能です。<br>​
	・アルファベットと数字を必ず組み合わせてください。<br><br>

	​<table  align="center">
		<tr>
			<td align="right">パスワード再入力：</td>
			<td><input type="text" name="pass2" size="15"></td>
		</tr>
	</table><br>
	・確認のためにもう一度ご入力ください。<br><br>

	<input type="submit" name="submit" value="登録情報確認">
	<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/idStaffMenu.jsp'">
	</form>
	</div>
<% } %>

</body>
</html>