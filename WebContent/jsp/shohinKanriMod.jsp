<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理（登録・変更の入力）</title>
</head>
<%String no=request.getParameter("no") ;%>
<body>
<form action="shohinKanriKakunin.jsp" method="post">
<%if(no.equals("1")) {%>
<div style=text-align:center>
<h1>商品登録</h1><br>
<label for="name">商品名：</label>
<input type="text" name="name" size="30" id="name"><br>

<label for="id">商品ID：</label>
<input type="text" name="id" size="30" id="id"><br>

<label for="kakaku">販売価格：</label>
<input type="text" name="price" size="30" id="kakaku"><br>

カテゴリ:
<select name="カテゴリ">
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

	<h1>商品変更</h1><br><br>
	<table align="center">
		<tr>
		<td align="left"><label for="name">商品名：</label>
		<input type="text" name="name" size="30" id="name">変更前の値<br></td>
		</tr>
		<tr>
		<td align="left">
		商品ID：<font color="red">選択されたID</font></td><br>
		</tr>
		<tr>
		<td align="left">
		<label for="kakaku">販売価格：</label>
		<input type="text" name="price" size="30" id="kakaku">変更前の値
		</td><br>
		</tr>
		<tr>
		<td align="left">
		カテゴリ:
		<select name="カテゴリ">
		</select>
		</td><br>
		</tr>
		<tr>
		<td align="left">
		<label for="kijiId">生地ID：</label>
		<input type="text" name="kiji" size="30" id="kijiId">変更前の値<br>
		</td>
		</tr>
	</table>
<form action="/group2work/ShohinKanriServlet" method="post">
	<input type="submit" name="submit" value="変更確認">
</form>
	<input type="button" value="戻る"onClick="history.go(-1)">
</div>
<%} %>
</body>
</html>