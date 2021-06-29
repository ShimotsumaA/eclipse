<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<style>
	*{
	font-family:"游ゴシック"
	}
	h1{
	background-color:#87ceeb
	}
</style>
</head>
<body>

	<div style="text-align: center">
		<h1>ログイン</h1>
		<br>

<%	String no="";
	if(request.getParameter("no")!=null){
	no = request.getParameter("no");
	System.out.println(no);
	}
	if (no.equals("2")) {
		String message = (String) request.getAttribute("message");
%>
	<font color="red"> <%=message%></font><br><br>
<% } else {

		}
%>

		<form action="/group2work/LogInOutServlet" method="post">
			<select name="zokusei">
				<option value="kyaku">お客様</option>
				<option value="shain">社員</option>
				<option value="aru">アルバイト</option>
			</select> <br> <br>

			<table align="center">
				<tr>
					<td align="right">ID：</td>
					<td><input type="text" name="id" size="40"  maxlength="10"></td>
				</tr>
				<tr>
					<td>パスワード：</td>
					<td><input type="password" name="pass" size="40"  maxlength="15"></td>
				</tr>
			</table>
			<br> <br> <input type="submit" name="submit" value="ログイン">
		</form>
		<br>
		<br> <a href="/group2work/jsp/sogo/password.jsp">ID・パスワードを忘れた方はこちら</a> <br>
		<br> <a href="/group2work/jsp/sogo/shohisha/user.jsp?no=1">初めてご利用の方はこちら</a>
		<br>
		<br>
		<br> <a href="/group2work/jsp/sogo/top.jsp">TOPへ</a>
	</div>

</body>
</html>