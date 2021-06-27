<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="bean.ShohinBean" %>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理</title>
</head>
<body>
<%ArrayList<ShohinBean> list=(ArrayList<ShohinBean>)request.getAttribute("list");%>
<%--if(request.getParameter("submit").equals("確定")){ --%>
<form action="/group2work/ZaikoKanriServlet" method="post">
<div style=text-align:right>
	<a href="menu.jsp">メニューへ戻る</a>
</div>
<div style=text-align:center>
<h1>在庫管理</h1>
<table border="1" align="center">
<tr>
	<td> </td><th>商品ID</th><th>商品名</th><th>在庫数</th>
</tr>
<%for(int i=0; i<list.size(); i++) {%>

<tr>
<td><input type="radio" name="radio" value=<%=list.get(i).getShohinId() %>>
<td><%=list.get(i).getShohinId()%></td>
<td><%=list.get(i).getShohinName() %></td>
<td><%=list.get(i).getZaiko() %></td>
</tr>
<%} %>
</table><br><br>

	<input type="submit" name="submit" value="入庫">
	<input type="submit" name="submit" value="変更">
</form>
<input type="button" value="戻る" onClick="history.go(-1)">
</div>
<%--} --%>
</body>
</html>