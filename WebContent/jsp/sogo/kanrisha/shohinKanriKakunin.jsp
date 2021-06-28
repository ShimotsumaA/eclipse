<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kanrisha.ShohinDao" %>
<%@ page import="shohisha.CategoryDao" %>
<%@ page import="bean.CategoryBean" %>
<%@ page import="bean.ShohinBean" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理確認</title>
</head>
<body>
<div style="text-align:center">
<% System.out.println(request.getParameter("submit")); %>

<%if(request.getParameter("submit").equals("登録確認")){%>

	<h1>商品登録の確認</h1>
	以下の情報を登録します。よろしいですか？<br><br>

	<form action="/group2work/ShohinKanriServlet" method="post">

	<table  align="center">
		<tr>
			<td align="right">商品名：</td>
			<td align="left"><%=session.getAttribute("name") %></td>
		</tr>
		<tr>
			<td align="right">商品ID:</td>
			<td align="left"><%=session.getAttribute("id") %></td>
		</tr>
		<tr>
			<td align="right">販売価格:</td>
			<td align="left"><%=session.getAttribute("price") %></td>
		</tr>

		<%
			String categoryId = (String)session.getAttribute("category");
			CategoryDao dao = new CategoryDao();
			ArrayList<CategoryBean>list = dao.joken(categoryId);
			String categoryName = list.get(0).getCategoryName();
		%>
		<tr>
			<td align="right">カテゴリ：</td>
			<td align="left"><%=categoryName %></td>
		</tr>
		<tr>
			<td align="right">生地ID：</td>
			<td align="left"><%=session.getAttribute("kiji") %></td> <!-- shohinKanriModからパラメータ取得 -->
		</tr>
	</table><br><br>

	<input type="submit" name="submit" value="登録確定" >
	<input type="button" value="戻る" onClick="location.href='/group2work/jsp/sogo/kanrisha/shohinKanriMod.jsp?no=1'">
	</form>
</div>
<%}  else if (request.getParameter("submit").equals("変更確認")){%>
<div style="text-align:center">
	<h1>商品変更の確認</h1>

	<%ArrayList<ShohinBean> list=(ArrayList<ShohinBean>)session.getAttribute("list");%>

	以下の情報を変更します。よろしいですか？<br><br>

	<form action="/group2work/ShohinKanriServlet" method="post">

	<table  align="center">
		<tr>
			<td align="right">商品名：</td>
			<td align="left"><%=session.getAttribute("name") %></td>
		</tr>
		<tr>
			<td align="right">商品ID:</td>
			<td align="left"><%=session.getAttribute("shohinId")  %></td>
		</tr>
		<tr>
			<td align="right">販売価格:</td>
			<td align="left"><%=session.getAttribute("price") %></td>
		</tr>

		<%
			String categoryId = (String)session.getAttribute("category");
			System.out.println( categoryId);
			CategoryDao dao = new CategoryDao();
			ArrayList<CategoryBean>list2 = dao.joken(categoryId);
			String categoryName = list2.get(0).getCategoryName();
		%>
		<tr>
			<td align="right">カテゴリ：</td>
			<td align="left"><%=categoryName %></td>
		</tr>
		<tr>
			<td align="right">生地ID：</td>
			<td align="left"><%=session.getAttribute("kiji") %></td> <!-- shohinKanriModからパラメータ取得 -->
		</tr>
	</table><br><br>

	<input type="submit" name="submit" value="変更確定">
	<input type="button" value="戻る" onClick="history.go(-1)">
	</form>
</div>

<%
	} else if (request.getParameter("submit").equals("delete")) {

		//商品が選択されていない
		if (request.getParameter("radio") == null){

				request.setAttribute("errorMsg","商品を選択してください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/sogo/kanrisha/shohinKanriIchiran.jsp");
				dispatcher.forward(request, response);
			}
%>
<div style="text-align:center">
	<h1>商品削除</h1>

	以下の情報を削除します。よろしいですか？<br><br>

<form action="/group2work/ShohinKanriServlet" method="post">



	<table  align="center">
		<tr>
			<td align="right">商品名：</td>
			<td align="left"><%=session.getAttribute("shohinName") %></td>
		</tr>
		<tr>
			<td align="right">商品ID:</td>
			<td align="left"><%=session.getAttribute("shohinId") %></td>
		</tr>
		<tr>
			<td align="right">販売価格:</td>
			<td align="left"><%=session.getAttribute("value") %> </td>
		</tr>

		<tr>
			<td align="right">カテゴリ：</td>
			<td align="left"><%=session.getAttribute("categoryName") %></td>
		</tr>
		<tr>
			<td align="right">生地ID：</td>
			<td align="left"><%=session.getAttribute("kijiId") %></td> <!-- shohinKanriModからパラメータ取得 -->
		</tr>
	</table><br><br>

	<input type="submit" name="submit" value="削除確定">
	<input type="button" value="戻る" onClick="history.go(-1)">
	</form>
</div>
<%} %>
</body>
</html>