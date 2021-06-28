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
<style>
	*{
	font-family:游ゴシック
	}

	body{
	background-image:url("/group2work/image/43455.jpg")
	}

	table.menu_bar{
	position:relative;
	left:800px;
	top:-100px;
	}

</style>
</head>
<body>
<img src="/group2work/image/NishidaPrinting800x800px.jpg" width="150" height="150">


	<!-- メニューバー -->
	<div class="wrapper">
    	<div class="menu_bar">
    	<table class="menu_bar">
    		<tr>
				<% if(session.getAttribute("id")!=null){%>
					<!-- マイページへのリンク -->
					<td><a href="/group2work/LogInOutServlet?submit=logout">ログアウト</a></td>
					<td><a href="/group2work/jsp/sogo/shohisha/mypage.jsp">マイページ</a></td>
					<% }else{ %>
					<!-- ログインページへのリンク -->
					<td><a href="/group2work/jsp/sogo/login.jsp">ログイン</a></td>
					<% }
					%>


					<!-- マイページへのリンク -->
				<td><a href="/group2work/CartHyoujiServlet">カート</a></td>
					<!-- カートへのリンク -->
				<td><a href="/group2work/jsp/sogo/top.jsp">トップページへ</a></td>
					<!-- トップメニューへのリンク -->
			</tr>
		</table>
   	 	</div>
	<center>
    <!-- 商品画像表示 -->
    	<div class="image">
    	<img src="/group2work/image/np0001_picture01.jpg" name="バッグ" width=250px height=300px>
    	</div>

    <!-- 商品詳細 -->
    <% ArrayList<ShohinBean> listShohinShosai=new ArrayList<ShohinBean>();
    	listShohinShosai=(ArrayList<ShohinBean>)session.getAttribute("Shohin_shosai");
    	String shohinName=listShohinShosai.get(0).getShohinName();
    	String shohinId=listShohinShosai.get(0).getShohinId();
    	java.math.BigDecimal value=listShohinShosai.get(0).getValue();

    	ArrayList<KijiBean> listShohinKiji=new ArrayList<>();
    	listShohinKiji=(ArrayList<KijiBean>)session.getAttribute("Kiji_shosai");
    	String kijiName=listShohinKiji.get(0).getKijiSyurui();


    %>

    <div class="shousai">
    <table class="shousai">
    	<tr>
    	<td>商品：<%= shohinName %> </td>　<!-- 商品名表示 -->
   	 	</tr>

   	 	<tr>
    	<td>価格：<%= value.intValue() %>円</td>　<!-- 価格表示 -->
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
   	 	<form action="/group2work/CartControlServlet" method="post">
   	 		<select name="kazu_konyu">
   	 			<option selected value="1">1</option>
   	 			<% for(int i=2;i<=10;i++){ %>
   	 			<option value="<%=i%>"><%=i%></option>
   	 			<%} %>
   	 		</select>
   	 		<input type="hidden" name="shohin_id" value="<%= shohinId %>">
   	 		<button type="submit" name="submit" value="add_to_cart">カートへ追加</button>

   	 		<%if(request.getAttribute("AddedToCart")!=null) {%>
   	 		<p>カートに追加しました。</p>
   	 		<%} %>
   	 	</form>
   	 	</td>
   	 	</tr>


    </table>
    </div>


	</div>
</center>
</body>
</html>