<%@page import="java.util.ArrayList"%>
<%@page import="bean.ShohinBean" %>
<%@page import="bean.KijiBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品説明</title>
</head>
<body>


	<!-- メニューバー -->
	<div class="wrapper">
    	<div class="menu_bar">
    	<table>
    	<tr>
    		<td><a href="">トップメニュー</a></td> <!-- トップメニューへのリンク -->
    		<td><a href="">カート</a></td>　<!-- カートへのリンク -->
    		<td><a href="">マイページ</a></td><!-- マイページへのリンク -->
    		<td><a href="">ログイン</a></td><!-- ログインページへのリンク -->
    		<td><a href="">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    	</table>
   	 	</div>

    <!-- 商品画像表示 -->
    	<div class="image">
    	<img src="" name="" >
    	</div>

    <!-- 商品詳細 -->
    <% ArrayList<ShohinBean> listShohinShosai=new ArrayList<ShohinBean>();
    	listShohinShosai=(ArrayList<ShohinBean>)session.getAttribute("Shohin_shosai");
    	String shohinName=listShohinShosai.get(0).getShohinName();
    	String shohinId=listShohinShosai.get(0).getShohinId();
    	java.math.BigDecimal value=listShohinShosai.get(0).getValue();

    	ArrayList<KijiBean> listShohinKiji=new ArrayList<>();
    	listShohinKiji=(ArrayList<KijiBean>)session.getAttribute("Kiji_shosai");
    	String kijiName=listShohinKiji.get(0).getKijiName();


    %>

    <div class="shousai">
    <table>
    	<tr>
    	<td>商品：<%= shohinName %> </td>　<!-- 商品名表示 -->
   	 	</tr>

   	 	<tr>
    	<td>価格：<%= value %>円</td>　<!-- 価格表示 -->
   	 	</tr>

   	 	<tr>
    	<td>説明：AAA</td> <!-- 説明表示 -->
   	 	</tr>

   	 	<tr>
    	<td>生地：<%=kijiName %></td>　<!-- 生地表示 -->
   	 	</tr>

   	 	<tr>
   	 	<!-- 数量選択 -->
   	 	<td>
   	 	数量:
   	 	<form action="/group2work/shohisha/CartControlServlet" method="post">
   	 		<select name="kazu_konyu">
   	 			<option selected value="1">1</option>
   	 			<% for(int i=2;i<=10;i++){ %>
   	 			<option value="<%=i%>"><%=i%></option>
   	 			<%} %>
   	 		</select>
   	 		<input type="hidden" name="shohin_id" value="<%= shohinId %>">
   	 		<button type="submit" name="submit" value="add_to_cart">カートへ追加</button>
   	 	</form>
   	 	</td>
   	 	</tr>


    </table>
    </div>


	</div>
</body>
</html>