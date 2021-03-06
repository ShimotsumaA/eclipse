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


<% if(submit.equals("変更") || submit.equals("3") || submit.equals("back")){ %>

		<div style="text-align:center">
		<h1>管理者情報変更</h1><br>

		<% if (submit.equals("3")){
			String message =(String)request.getAttribute("message");
		%>
					<p style="color:red"><%=message %></p>
		<% }  %>

		<form action="/group2work/KanrishaTorokuServlet" method="post">

		<table  align="center">
			<tr>
				<td align="right">ID：</td>
				<td><%=session.getAttribute("id") %></td>
			</tr>
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="name" size="40"  maxlength="15" value =<%=session.getAttribute("name") %>></td>
			</tr>
			<tr>
				<%
					String postId = (String)session.getAttribute("postId");
					System.out.println("postIdは"+postId);

					if (postId.equals("1")){ %>

						<td align="right">役職：</td>
						<td align="left"><select name="postId" >
								<option value="1" selected>社員</option>
								<option value="2">アルバイト</option>
								</select></td>

				<% } else { %>
						<td align="right">役職：</td>
						<td align="left"><select name="postId" >
								<option value="1" >社員</option>
								<option value="2" selected>アルバイト</option>
								</select></td>
				<% } %>
			</tr>
			<tr>
				<td align="right">パスワード：</td>
				<td><input type="password" name="pass1" size="40"  maxlength="15" value= <%=session.getAttribute("pass") %>></td>
			</tr>
			</table>
				・パスワードは4文字以上15文字以内で半角入力のみ可能です。<br>​
				・アルファベットと数字を必ず組み合わせてください。<br><br>
			<table  align="center">
			<tr>
				<td align="right">パスワード再入力：</td>
				<td><input type="password" name="pass2" size="40"  maxlength="15" value= <%=session.getAttribute("pass")%>></td>
			</tr>
		</table><br>
		・確認のためにもう一度ご入力ください。<br><br>

		<input type="submit" name="submit" value="変更情報確認">
		<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/kanrisha/shainIchiran.jsp'">
		</form>
		</div>

<%}  else { %> <!-- submit=1、2、登録確定 -->
		<div style="text-align:center">
		<h1>管理者情報登録</h1>

		<%
			if (submit.equals("2")){
				String message =(String)request.getAttribute("message");
		%>
				<p style="color:red"><%=message %></p>
		<%
			} else if (submit.equals("登録確定")){
		%>
			<p style="color:red">登録が完了しました。</p>
		<% } %>

		<form action="/group2work/KanrishaTorokuServlet" method="post">
		<br><table  align="center">
			<tr>
				<td align="right">ID：</td>
				<td><input type="text" name="id" size="40"  maxlength="10"></td>
			</tr>
		</table><br>
		・IDは10文字以内で半角入力のみ可能です。​<br>
		・アルファベットと数字のみ使用可能です。<br>​
		・大文字と小文字の区別はしません。<br><br>

		<table  align="center">
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="name" size="40" maxlength="15" ></td>
			</tr>
			<tr>
				<td align="right">役職：</td>
				<td align="left"><select name="postId" >
						<option value="1">社員</option>
						<option value="2">アルバイト</option>
						</select></td>
			</tr>
			<tr>
				<td align="left">パスワード：</td>
				<td><input type="password" name="pass1" size="40" maxlength="15" ></td>
			</tr>
		</table><br>

		・パスワードは4文字以上15文字以内で半角入力のみ可能です。<br>​
		・アルファベットと数字を必ず組み合わせてください。<br><br>

		​<table  align="center">
			<tr>
				<td align="right">パスワード再入力：</td>
				<td><input type="password" name="pass2" size="40" maxlength="15" ></td>
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