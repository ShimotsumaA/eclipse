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
<%if(no.equals("1")) {%>
<form action="/group2work/ShohinKanriServlet" method="post">
<div style=text-align:center>
<h1>商品登録</h1><br>
<label for="name">商品名：</label>
<input type="text" name="name" size="30" id="name"><br>

<label for="id">商品ID：</label>
<input type="text" name="id" size="30" id="id"><br>

<label for="kakaku">販売価格：</label>
<input type="text" name="price" size="30" id="kakaku"><br>

カテゴリ:

<%--ArrayList<ShohinBean> list=(ArrayList<ShohinBean>)session.getAttribute("list");--%>

<%--for(int i=0; i<list.size(); i++) {--%>
<select name="category">
<%--=list.get(i).getCategoryId() --%>
<option>1</option>
<option>2</option>
<option>3</option>
</select><br>
<%} %>
<label for="kijiId">生地ID：</label>
<input type="text" name="kiji" size="30" id="kijiId"><br>

<input type="submit" name="submit" value="登録確認">
</form>
<input type="button" value="戻る"onClick="history.go(-1)">
<font color="red">
		<%if(request.getAttribute("compmsg")!=null){ %>
			<%= request.getAttribute("compmsg")%>
		<% } %>
		</font>

</div>
<%--} --%>


<%if(no.equals("2"))  {%>
<div style=text-align:center>
<form action="/group2work/ShohinKanriServlet" method="post">
	<h1>商品変更</h1><br><br>



	<table align="center">
		<tr>
		<td align="left"><label for="name">商品名：</label>
		<input type="text" name="name" size="30" id="name" value="<%=session.getAttribute("shohinName") %>"><br></td>
		</tr>
		<tr>
		<td align="left">
		商品ID：<font color="red"><%=session.getAttribute("shohinId") %></font></td><br>
		</tr>
		<tr>
		<td align="left">
		<label for="kakaku">販売価格：</label>
		<input type="text" name="price" size="30" id="kakaku" value=<%=session.getAttribute("value") %>>
		</td><br>
		</tr>
		<tr>
		<td align="left">
		カテゴリ:
		<select name="category">
		<%ArrayList<CategoryBean> list=(ArrayList<CategoryBean>)session.getAttribute("listCategory");
		String categoryId=(String)session.getAttribute("categoryId");

		%>
		<%for(int i=0; i<list.size(); i++) {%>


		<option value="<%=list.get(i).getCategoryId()%>" <%if(categoryId.equals(list.get(i).getCategoryId())){ %> selected<%} %>>
		<%=list.get(i).getCategoryName() %>
		</option>
		<%} %>
		</select>
		</td><br>
		</tr>
		<tr>
		<td align="left">
		<label for="kijiId">生地ID：</label>
		<input type="text" name="kiji" size="30" id="kijiId" value=<%=session.getAttribute("kijiId") %>>変更前の値<br>
		</td>
		</tr>
	</table>

	<input type="submit" name="submit" value="変更確認">
	<input type="button" value="戻る"onClick="history.go(-1)">
</form>
</div>
<%} %>
</body>
</html>