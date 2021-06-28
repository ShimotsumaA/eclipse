<%@page import="kanrisha.ShohinDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal" %>
<%@page import="bean.OrderDetailBean" %>
<%@page import="bean.ShohinBean" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.LinkedHashMap" %>
<%@page import="java.util.Map" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
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
<div class="wrapper">
<!-- メニューバー -->
<div align="center">
		<div class="menu_bar">
    	<table>
    	<tr>
    		<td><a href="/group2work/jsp/sogo/shohisha/shopping.jsp">メニュー</a></td> <!-- メニューへのリンク -->
    		<td><a href="/group2work/jsp/sogo/shohisha/gaiyo.jsp">配送料に関して</a><!-- 配送料ページへのリンク -->
    	</tr>
    	</table>
   	 	</div>


    <div class="contents">
    <h2 id="midasi"> カート一覧</h2>

    <%if((Boolean)request.getAttribute("cartflag") && (session.getAttribute("id")!=null)) {%>
    <%
	ArrayList<OrderDetailBean> listODetail=(ArrayList<OrderDetailBean>)session.getAttribute("oDetailList");
	String shohinId="";
	String shohinName="";%>

    <table>

    <!-- for文で抽出 -->
    <% for(int i=1;i<=listODetail.size();i++){
		shohinId=listODetail.get(i-1).getShohinId();

		ShohinDao dao=new ShohinDao();
		ArrayList<ShohinBean> list1=new ArrayList<>();
		list1=dao.joken(shohinId);%>
		<tr>
    	<td>商品名:<%= list1.get(0).getShohinName() %><br>
    	数量:<%=listODetail.get(i-1).getKazuKonyu() %><br>
    	価格：<%=list1.get(0).getValue() %>円


    	<form action="/group2work/CartCancel" method="post">
    	<input type="hidden" name="shohinId" value="<%=shohinId %>">
    	<button type="submit" name=submit value="cancel" >キャンセル</button>
    	</form>
   	 	</td>
   	 	</tr>

   	 	<%} %>
    </table>

    <!-- カート合計表示 -->
    <p id="sum_cart">カート合計:<%= (Integer)session.getAttribute("gokei") %>円</p>
    </div>

    <!-- 注文ボタン -->
    <form action="/group2work/CartHyoujiServlet" method="post">
    <button type="submit" name="submit" value="tyumonhakotira">ご注文はこちら</button>
    </form>

    <%}else if((Boolean)request.getAttribute("cartflag") && (session.getAttribute("login")==null)){ %>

    <table>

    	<% Map<String, Integer> cart = new LinkedHashMap<String,Integer>();
		cart = (Map<String, Integer>) session.getAttribute("cart");
			for (Map.Entry<String, Integer> entry : cart.entrySet()) {
			String shohinId = entry.getKey();
			int konyuKosu = entry.getValue(); %>
			<% ShohinDao dao=new ShohinDao();
			ArrayList<ShohinBean> list1=new ArrayList<>();
			list1=dao.joken(shohinId);%>
			<tr>
    		<td>商品名:<%= list1.get(0).getShohinName() %><br>
    		数量:<%=konyuKosu %><br>
    		価格：<%=list1.get(0).getValue() %>円
    		<form action="/group2work/CartCancel" method="post">
    		<input type="hidden" name="shohinId" value="<%=shohinId %>">
    		<button type="submit" name=submit value="cancel" >キャンセル</button>
    		</form>
   	 		</td>
   	 		</tr>

			<%} %>
	</table>

		<p id="sum_cart">カート合計:<%= (Integer)session.getAttribute("gokei") %>円</p>
	 	    <form action="/group2work/CartHyoujiServlet" method="post">
    		<button type="submit" name="submit" value="tyumonhakotira">ご注文はこちら</button>
    		</form>

    <%}else{%>
    カートに商品が存在しません
    <%} %>
	<br><br>
    <input type="button" name="back" value="戻る" onclick="location.href='/group2work/ECHyoujiServlet'">



    <div class="footer"></div>
</div>
</div>
</body>
</html>