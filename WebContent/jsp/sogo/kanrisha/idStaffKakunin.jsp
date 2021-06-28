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

<%
	String submit = request.getParameter("submit");
	System.out.println(submit+"idStaffKakunin");
%>

<% if (submit.equals("登録情報確認")){ %>
	<h1>管理者情報の登録確認</h1><br><br>

	以下の情報を登録します。よろしいですか？<br><br>

	<form action="/group2work/KanrishaTorokuServlet" method="post">
	<table  align="center">
		<tr>
			<td align="right">ID：</td>
			<td><%=session.getAttribute("id") %></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td><%=session.getAttribute("name") %></td>
		</tr>
		<tr>
			<td align="right">役職：</td>
			<td><%=session.getAttribute("postName") %></td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td><%=session.getAttribute("pass") %></td>
		</tr>
	</table><br><br>

	<input type="submit" name="submit" value="登録確定">
	<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/idStaffMod.jsp?submit=1'">
	</form>
	</div>

<% }else { %>

	<%
		if (submit.equals("変更情報確認")){
	%>

		<h1>管理者情報の変更確認</h1><br><br>
		以下の情報を変更します。よろしいですか？<br><br>

	<% } else if (submit.equals("delete")){ %>

		<h1>管理者情報の削除確認</h1><br><br>
		以下の情報を削除します。よろしいですか？<br><br>

	<%
		}

		//postIdをpostNameに変換する
		String postId = (String)session.getAttribute("postId");
		System.out.println(postId);
		String postName;

		if (postId.equals("1")){
			postName = "社員";
		} else {
			postName = "アルバイト";
		}

		System.out.println(postName);

	%>

	<form action="/group2work/KanrishaTorokuServlet" method="post">
	<table  align="center">
		<tr>
			<td align="right">ID：</td>
			<td><%= session.getAttribute("id") %></td>
		</tr>
		<tr>
			<td align="right">氏名：</td>
			<td><%= session.getAttribute("name") %></td>
		</tr>
		<tr>
			<td align="right">役職：</td>
			<td><%= postName %></td>
		</tr>
		<tr>
			<td align="right">パスワード：</td>
			<td><%= session.getAttribute("pass") %></td>
		</tr>
	</table><br><br>

	<% if (submit.equals("変更情報確認")){ %>
		<input type="submit" name="submit" value="変更確定">
		<button type="submit" name="submit" value="back" formaction="/group2work/jsp/sogo/kanrisha/idStaffMod.jsp">戻る</button>

	<% } else if (submit.equals("delete")){ %>
		<input type="submit" name="submit" value="削除確定">
		<input type="button" name="back" value="戻る" onclick="location.href='/group2work/kanrishaIchiranServlet?submit=1'">
	<% } %>


	</form>
	</div>
<% } %>
</body>
</html>