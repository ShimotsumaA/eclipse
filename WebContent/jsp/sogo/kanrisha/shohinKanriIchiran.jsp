<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="bean.ShohinBean" %>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>

</head>
<body>

<form action="/group2work/ShohinKanriServlet" method="post">
<div style= "text-align:center">

<h1>商品一覧</h1><br>

<%ArrayList<ShohinBean> list=(ArrayList<ShohinBean>)session.getAttribute("list");%>
<%System.out.println(list.get(0).getShohinId()); %>
<%String errorMsg=(String) request.getAttribute("errorMsg");%>
<%if(errorMsg!=null) {%>
<font color="red"><%=errorMsg%></font>
<% }%>

<table border="1" align="center">
<tr>
<td> </td><td>商品ID</td><td>商品名</td><td>販売価格</td><td>カテゴリ</td><td>生地ID</td>
</tr>
<%for(int i=0; i<list.size(); i++) {%>
<tr>
<td><input type="radio" name="radio" value=<%=list.get(i).getShohinId() %>></td>
<td><%=list.get(i).getShohinId()%></td>
<td><%=list.get(i).getShohinName() %></td>
<td><%=list.get(i).getValue() %></td>
<td><%=list.get(i).getCategoryId() %></td>
<td><%=list.get(i).getKijiId() %></td>
</tr>

<%} %>
</table><br><br>

<!-- form shohinKanriMod?no=2 -->
<input type="submit" name="submit" value="変更">

<!-- form shohinKanriKakunin -->

<button type="submit" formaction="/group2work/jsp/sogo/kanrisha/shohinKanriKakunin.jsp" name="submit" value="delete"> 削除</button>


<input type="button" value="戻る" onClick="history.go(-1)">

</form>
</body>
</html>