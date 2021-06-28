<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kanrisha.ShohinDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal" %>
<%@page import="bean.OrderDetailBean" %>
<%@page import="bean.ShohinBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文</title>
</head>
<style>
	*{
	font-family:"游ゴシック"
	}
	h2{
	background-color:#87ceeb
	}
	body{
		background-image:url("/group2work/image/43455.jpg")
	}
</style>
<body>
	<!-- メニューバー -->
	<div class="wrapper">
	<div align="center">
    	<div class="menu_bar">
    	<table>
    	<tr>
    		<td><a href="/group2work/jsp/sogo/shohisha/shopping.jsp">メニュー</a></td> <!-- メニューへのリンク -->
    		<td><a href="/group2work/jsp/sogo/shohisha/gaiyo.jsp">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    	</table>
   	 	</div>

   	 	<!-- 見出し -->
   	 	<h2 class="midasi">注文内訳</h2>

   	 	<!-- 商品詳細 -->
   	 	<div class="shosai">
			<table>
			<!-- for文で取り出し -->
			<%ArrayList<OrderDetailBean> listODetail=(ArrayList<OrderDetailBean>)session.getAttribute("oDetailList");
			String shohinId="";
			String shohinName="";%>

			<% for(int i=1;i<=listODetail.size();i++){
			shohinId=listODetail.get(i-1).getShohinId();

			ShohinDao dao=new ShohinDao();
			ArrayList<ShohinBean> list1=new ArrayList<>();
			list1=dao.joken(shohinId);%>
			<tr>
				<td>
				<img src="" name="">
				</td>
				<td>
				商品:<%= list1.get(0).getShohinName() %><br>
				数量:<%=listODetail.get(i-1).getKazuKonyu() %><!-- 数量表示 --><br>
				価格:<%=list1.get(0).getValue().intValue() %>円<!-- 価格表示 -->
				</td>
			</tr>
			<%} %>
			</table>
   	 	</div>

   	 	<!-- 合計金額 -->
   	 	<div class="gokei" align="center">
   	 		<table align="center">
			<tr>
				<td></td>
				<th>合計金額</th>
				<td></td>
			</tr>
			<tr>
				<td>商品合計:<%= (Integer)session.getAttribute("gokei") %>円</td><!-- 合計金額表示 -->
				<td>送料:<%=(Integer)session.getAttribute("soryo") %>円</td><!-- 送料表示 -->
				<td>総計:<%=(Integer)session.getAttribute("sokei") %>円</td><!-- 総計表示 -->
			</tr>
   	 		</table>
   	 		<br><br>
   	 	<!-- ボタン -->
   	 	<div class="submit">
   	 		<form method="post">
   	 			<button type="submit" name="submit" value="jyusho" formaction="/group2work/BuyControl">住所入力</button>
   	 			<button type="button" name="submit" value="return" onClick="history.go(-1)">戻る</button><br>
   	 	</div>

		</div>
   	 	</div>
	</center>

</div>

</body>
</html>