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
<body>
	<!-- メニューバー -->
	<div class="wrapper">
    	<div class="menu_bar">
    	<table>
    	<tr>
    		<td><a href="/group2work/jsp/sogo/top.jsp">トップメニュー</a></td> <!-- トップメニューへのリンク -->
    		<td><a href="/group2work/jsp/sogo/shohisha/cart.jsp">カート</a></td>　<!-- カートへのリンク -->
    		<td><a href="/group2work/jsp/sogo/shohisha/mypage.jsp">マイページ</a></td><!-- マイページへのリンク -->
    		<td><a href="/group2work/jsp/sogo/login.jsp">ログイン</a></td><!-- ログインページへのリンク -->
    		<td><a href="/group2work/jsp/sogo/shohisha/gaiyo.jsp">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    	</table>
   	 	</div>

   	 	<!-- 見出し -->
   	 	<p class="midasi">注文内訳</p>

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
				価格:<%=list1.get(0).getValue() %><!-- 価格表示 -->
				</td>
			</tr>
			<%} %>
			</table>
   	 	</div>

   	 	<!-- 合計金額 -->
   	 	<div class="gokei">
   	 		<table>
			<tr>
				<th>合計金額</th>
			</tr>
			<tr>
				<td>商品合計:<%= (Integer)session.getAttribute("gokei") %>円</td><!-- 合計金額表示 -->
				<td>送料:<%=(Integer)session.getAttribute("soryo") %>円</td><!-- 送料表示 -->
				<td>総計:<%=(Integer)session.getAttribute("sokei") %>円</td><!-- 総計表示 -->
			</tr>
   	 		</table>
   	 	<!-- ボタン -->
   	 	<div class="submit">
   	 		<form method="post">
   	 			<button type="submit" name="submit" value="jyusho" formaction="/group2work/shohisha/BuyControlServlet">住所入力</button>
   	 			<button type="submit" name="submit" value="return" formaction="">戻る</button>
   	 		</form>
   	 	</div>


   	 	</div>


</div>

</body>
</html>