<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.ShohishaBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報</title>
</head>
<body>
<%
  	String no = request.getParameter("no");
 	if(no==null){
  		no=(String)request.getAttribute("no");
  	}
 %>
 <!-- 登録情報の変更 -->
 <% if (no.equals("1")){%>
	<%
	ArrayList<ShohishaBean> list =(ArrayList<ShohishaBean>)session.getAttribute("list");
	%>
	<div text align="right">
	<a href="myPage.jsp">マイページ</a>
	<a href="top.jsp">トップページ</a>
	</div>

	<div align = "center">
		登録情報の変更
		<table border="1">
			<tr align="center">
				<td>氏名</td>
				<td>生年月日</td>
				<td>郵便番号</td>
				<td>住所</td>
				<td>電話番号</td>
				<td>メールアドレス</td>
				<td>ID</td>
				<td>パスワード</td>
			<tr>
				<tr align="center">
					<td><%=list.get(i).getSName()%></td>
					<td><%=list.get(i).getDateBirth()%></td>
					<td><%=list.get(i).getPostCode()%></td>
					<td><%=list.get(i).getAdress()%></td>
					<td><%=list.get(i).getTel()%></td>
					<td><%=list.get(i).getPostCode()%></td>
					<td><%=list.get(i).getMailAdress()%></td>
					<td><%=list.get(i).getSId()%></td>
					<td><%=list.get(i).getSPass()%></td>
				</tr>
		</table>

		<input type ="submit"  name="submit" value="変更">
		<input type="button" name="back" value="戻る" onclick="user.jsp">

	</div>
<%
}
%>

 <!-- 登録情報の確認(確定)-->
<%if (no.equals("2")){%>
	<%
	ArrayList<ShohishaBean> list =(ArrayList<ShohishaBean>)session.getAttribute("list");
	%>
	<div text align="right">
	<a href="myPage.jsp">マイページ</a>
	<a href="top.jsp">トップページ</a>
	</div>

	<div align = "center">
		登録情報の確認
		<table border="1">
			<tr align="center">
				<td>氏名</td>
				<td>生年月日</td>
				<td>郵便番号</td>
				<td>住所</td>
				<td>電話番号</td>
				<td>メールアドレス</td>
				<td>ID</td>
				<td>パスワード</td>
			<tr>
				<tr align="center">
					<td><%=list.get(i).getSName() %></td>
					<td><%=list.get(i).getDateBirth() %></td>
					<td><%=list.get(i).getPostCode() %></td>
					<td><%=list.get(i).getAdress() %></td>
					<td><%=list.get(i).getTel() %></td>
					<td><%=list.get(i).getPostCode() %></td>
					<td><%=list.get(i).getMailAdress() %></td>
					<td><%=list.get(i).getSId() %></td>
					<td><%=list.get(i).getSPass() %></td>
				</tr>
		</table>
		 <!-- 変更→modに遷移する -->
		<input type ="submit"  name="submit" value="確定">
		<input type="button" name="back" value="戻る" onclick="user.jsp">

	</div>
<%
}
%>

 <!-- 登録情報の確認(変更)-->
<%if (no.equals("3")){%>
	<%
	ArrayList<ShohishaBean> list =(ArrayList<ShohishaBean>)session.getAttribute("list");
	%>
	<div text align="right">
	<a href="myPage.jsp">マイページ</a>
	<a href="top.jsp">トップページ</a>
	</div>

	<div align = "center">
		登録情報の確認
		<table border="1">
			<tr align="center">
				<td>氏名</td>
				<td>生年月日</td>
				<td>郵便番号</td>
				<td>住所</td>
				<td>電話番号</td>
				<td>メールアドレス</td>
				<td>ID</td>
				<td>パスワード</td>
			<tr>
				<tr align="center">
					<td><%=list.get(i).getSName() %></td>
					<td><%=list.get(i).getDateBirth() %></td>
					<td><%=list.get(i).getPostCode() %></td>
					<td><%=list.get(i).getAdress() %></td>
					<td><%=list.get(i).getTel() %></td>
					<td><%=list.get(i).getPostCode() %></td>
					<td><%=list.get(i).getMailAdress() %></td>
					<td><%=list.get(i).getSId() %></td>
					<td><%=list.get(i).getSPass() %></td>
				</tr>
		</table>
		 <!-- 変更→modに遷移する -->
		<input type ="submit"  name="submit" value="変更">
		<input type="button" name="back" value="戻る" onclick="user.jsp">

	</div>
<% } %>

</body>
</html>