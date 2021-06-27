<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="bean.KanrishaBean" %>
 <%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
</head>
<body>


<% String submit = request.getParameter("submit"); %>
<% System.out.println(submit); %>

<div style="text-align:center">
<h1>管理者情報の変更・削除</h1>

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
	</tr>
	<tr>
	<%
		ArrayList<KanrishaBean> list = (ArrayList<KanrishaBean>)session.getAttribute("list");
		for(int i=0; i<list.size(); i++) {%>

		<td><input type="radio" name="radio" value=<%=list.get(i).getId() %>></td>
		<td><%=list.get(i).getId() %></td>
		<td><%=list.get(i).getName() %></td>
	</tr>
	<% } %>
</table><br><br>

<input type="submit" formaction="/group2work/KanrishaTorokuServlet" name="submit" value="変更">
<button type="submit" formaction="/group2work/jsp/sogo/kanrisha/idStaffKakunin.jsp" name="submit" value="delete">削除</button>
<input type="button" name="back" value="戻る" onclick="location.href='/group2work//jsp/sogo/kanrisha/idStaffMenu.jsp'">
</form>
</div>

</body>
</html>