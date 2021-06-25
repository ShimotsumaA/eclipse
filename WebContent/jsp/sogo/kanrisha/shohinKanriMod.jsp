<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="bean.ShohinBean" %>
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
<select name="category">
</select><br>

<label for="kijiId">生地ID：</label>
<input type="text" name="kiji" size="30" id="kijiId"><br>

<input type="submit" name="submit" value="登録確認">
</form>
<input type="button" value="戻る"onClick="history.go(-1)">
</div>
<%} %>

<%if(no.equals("2"))  {%>
<div style=text-align:center>
<form action="/group2work/ShohinKanriServlet" method="post">
	<h1>商品変更</h1><br><br>

	<%ArrayList<ShohinBean> list=(ArrayList<ShohinBean>)session.getAttribute("list");%>

	<table align="center">
		<tr>
		<td align="left"><label for="name">商品名：</label>
		<input type="text" name="name" size="30" id="name" value="<%=list.get(0).getShohinName() %>"><br></td>
		</tr>
		<tr>
		<td align="left">
		商品ID：<font color="red"><%=list.get(0).getShohinId() %></font></td><br>
		</tr>
		<tr>
		<td align="left">
		<label for="kakaku">販売価格：</label>
		<input type="text" name="price" size="30" id="kakaku" value=<%=list.get(0).getValue() %>>
		</td><br>
		</tr>
		<tr>
		<td align="left">
		カテゴリ:
		<select name="カテゴリ">
		<%for(int i=0; i<list.size(); i++) {%>
		<option><%=list.get(i).getCategoryId() %></option>
		<%} %>
		</select>
		</td><br>
		</tr>
		<tr>
		<td align="left">
		<label for="kijiId">生地ID：</label>
		<input type="text" name="kiji" size="30" id="kijiId" value=<%=list.get(0).getKijiId()%>>変更前の値<br>
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