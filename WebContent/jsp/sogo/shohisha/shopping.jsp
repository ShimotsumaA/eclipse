<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.CategoryBean" %>
<%@ page import="bean.ShohinBean" %>
<%@ page import="bean.KijiBean" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
<div class="wrapper">
<!-- メニューバー -->
    <div class="menu_bar">
    <table>
    <tr>
    <td><a href="/group2work/jsp/sogo/top.jsp">トップメニュー</a></td> <!-- トップメニューへのリンク -->
    <td><a href="/group2work/shohisha/CartHyoujiServlet">カート</a></td>　<!-- カートへのリンク -->
    <td><a href="/group2work/shohisha/MyPageServlet">マイページ</a></td><!-- マイページへのリンク -->
    <td><a href="/group2work/jsp/sogo/login.jsp">ログイン</a></td><!-- ログインページへのリンク -->
    </tr>
    </table>
    </div>
<!-- カテゴリ検索 -->
    <div class="side_bar">
    <table>
    <tr>
    <td><a href="">総合メニューへ</a></td>
	</tr>

    <!-- 検索ボックス -->
	<tr>
	<td>
	<form action="" method="post">
    <input type="text" name="kensaku"><input type="button">
    </form>
    </td>
    </tr>

    <!-- カテゴリ選択（for文) -->
    <tr>
    <td>
    	<p>カテゴリ</p>
    	<form action="/group2work/shohisha/ECHyoujiServlet" method="post" name="category">

    	<% ArrayList<CategoryBean> list=(ArrayList<CategoryBean>)session.getAttribute("listCategory");
    		for(int i=1;i<=list.size();i++){%>
    		<input type="hidden" name="category_id" value="<%= list.get(i-1).getCategoryId()%>">
    		<a href="javascript:category.submit()"><%=list.get(i-1).getCategoryName() %></a>
    		<%} %>

    	</form>
    </td>
    </tr>

    <!-- 生地選択 (for文)-->
    <tr>
    <td>
    	<p>生地</p>
    	<form action="/group2work/shohisha/ECHyoujiServlet" method="post" name="kiji">
  	 	<% ArrayList<KijiBean> list2=(ArrayList<KijiBean>)session.getAttribute("listKiji");
    		for(int i=1;i<=list2.size();i++){%>
    		<input type="hidden" name="kiji_id" value="<%= list2.get(i-1).getKijiId()%>">
    		<a href="javascript:category.submit()"><%=list2.get(i-1).getKijiSyurui() %></a>
    		<%} %>

    	</form>
    </td>
    </tr>

    </table>
    </div>

<!-- 商品表示 -->
    <div class="shohin_hyozi">
    <table>

    <tr>
    <td>
    <!-- 商品for文で取り出し -->
    	<form action="/group2work/shohisha/ShohinHyojiServlet" method="post" name="shohin">

    	<br>
    	<% ArrayList<ShohinBean> list3=(ArrayList<ShohinBean>)session.getAttribute("listShohin");
    		for(int i=1;i<=list3.size();i++){%>
    	<input type="hidden" name="shohin_id" value="<%= list3.get(i-1).getShohinId()%>">
    	<a href="javascript:shohin.submit()"><img src=""></a><br>
    	<p><%= list3.get(i-1).getShohinName() %></p>
    	<p><%= list3.get(i-1).getValue() %></p>
    	<%} %>

    	</form>
    </td>
    </tr>
    </table>
    </div>

	<!-- フッター -->
    <div class="footer">
    <table>
    <tr>
    	<td><a href="/group2work/jsp/souryou.jsp">配送料に関して</a></td>
    </tr>
    <tr>
    	<td><a href="/group2work/jsp/gaiyo.jsp">特定商取引法に基づく表記</a></td>
    </tr>
    </table>
    </div>

</div>

</body>
</html>