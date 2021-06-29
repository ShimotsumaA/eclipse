<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="bean.ShohinBean" %>
 <%@page import="shohisha.CategoryDao" %>
 <%@page import="bean.CategoryBean" %>

 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理（登録・変更の入力）</title>
</head>

<%String no=request.getParameter("no") ;%>
<body>
<div style=text-align:center>

<%if(no.equals("1") || no.equals("3")) {%>

<form action="/group2work/ShohinKanriServlet" method="post">
<h1>商品登録</h1>

	<% if (no.equals("3")){
				String message =(String)request.getAttribute("message");
			%>
						<p style="color:red"><%=message %></p>
			<% }  %>

<table  align="center">
	<tr>
		<td align="right"><label for="name" align="left">商品名：</label></td>
		<td><input type="text" name="name" size="30" id="name" maxlength="15"></td>
	</tr>
	<tr>
		<td align="right"><label for="id" align="left">商品ID：</label></td>
		<td><input type="text" name="id" size="30" id="id" maxlength="6"></td>
	</tr>
	<tr>
		<td align="right"><label for="kakaku" align="left">販売価格：</label></td>
		<td><input type="text" name="price" size="30" id="kakaku" maxlength="8"></td>
	</tr>
	<tr>
		<td align="right">カテゴリ:</td>

		<%--ArrayList<ShohinBean> list=(ArrayList<ShohinBean>)session.getAttribute("list");--%>

		<%--for(int i=0; i<list.size(); i++) {--%>
		<td align="left"><select name="category">
		<%--=list.get(i).getCategoryId() --%>
		<option value="1">バッグ</option>
		<option value="2">ポーチ</option>
		<option value="3">Tシャツ</option>
		</select></td>
	</tr>
	<tr>
		<td align="right"><label for="kijiId">生地ID：</label></td>
		<td><input type="text" name="kiji" size="30" id="kijiId" maxlength="20"></td>
	</tr>
</table><br><br>

<input type="submit" name="submit" value="登録確認">
<input type="button" value="戻る"onClick="location.href='/group2work/jsp/sogo/kanrisha/shohinKanriMenu.jsp'">
</form>

<% } else if(no.equals("2") || no.equals("5")) { %>

<form action="/group2work/ShohinKanriServlet" method="post">
	<h1>商品変更</h1>

<% if (no.equals("5")){
			String message = (String)request.getAttribute("message");
	%>
			<p style="color:red"><%=message %></p>

	<% } %>

	<table align="center">
		<tr>
		<td align="right"><label for="name">商品名：</label></td>
		<td align="left"><input type="text" name="name" size="30" id="name" maxlength="15" value="<%=session.getAttribute("shohinName") %>"></td>
		</tr>
		<tr>
		<td align="right">商品ID：</td>
		<td align="left"><font color="red"><%=session.getAttribute("shohinId") %></font></td>
		</tr>
		<tr>
		<td align="lright"><label for="kakaku">販売価格：</label></td>
		<td align="left"><input type="text" name="price" size="30" id="kakaku"  maxlength="8" value="<%=session.getAttribute("value") %>"></td>
		</tr>
		<tr>
		<td align="right">カテゴリ:</td>
		<td align="left"><select name="category">
		<%
			ArrayList<CategoryBean> list=(ArrayList<CategoryBean>)session.getAttribute("listCategory");
			String categoryId=(String)session.getAttribute("categoryId");

			for(int i=0; i<list.size(); i++) {
		%>

		<option value="<%=list.get(i).getCategoryId()%>" <%if(categoryId.equals(list.get(i).getCategoryId())){ %> selected<%} %>>
		<%=list.get(i).getCategoryName() %>
		</option>
		<%} %>
		</select></td>
		</tr>
		<tr>
		<td align="right"><label for="kijiId">生地ID：</label></td>
		<td align="left"><input type="text" name="kiji" size="30" id="kijiId" value=<%=session.getAttribute("kijiId") %>></td>
		</tr>
	</table><br><br>

	<input type="submit" name="submit" value="変更確認">
	<input type="button" value="戻る"onClick="location.href='/group2work/jsp/sogo/kanrisha/shohinKanriMenu.jsp'">
</form>
</div>
<%} %>
</body>
</html>