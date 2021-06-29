<%@page import="kanrisha.ShohinDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.OrderDetailBean" %>
<%@page import="bean.ShohinBean" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文確認</title>
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
<form method="post">

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
	<h2>注文確認</h2>
	注文を確定します。よろしいですか？<br>

	購入詳細<br>


	<%
	ArrayList<OrderDetailBean> listODetail=(ArrayList<OrderDetailBean>)session.getAttribute("oDetailList");
	String shohinId="";
	String shohinName="";
	for(int i=1;i<=listODetail.size();i++){
		shohinId=listODetail.get(i-1).getShohinId();

		ShohinDao dao=new ShohinDao();
		ArrayList<ShohinBean> list1=new ArrayList<>();
		list1=dao.joken(shohinId);
	%>

	<img src="/group2work/image/<%=shohinId %>.jpg"  alt="バッグ " width="180" height="210"><br>
	商品名:<%= list1.get(0).getShohinName() %><br>
	価格：<%=list1.get(0).getValue().intValue() %>円<br>
	個数：<%=listODetail.get(i-1).getKazuKonyu() %><br><br>

	<%} %>
</div>

<div style="text-align:center;">
	支払い方法：<%=session.getAttribute("shiharai") %><br>
	配送先住所<br>
	<%=session.getAttribute("post_code") %><br>
	<%=session.getAttribute("address") %><br><br>

</div>

<div style="text-align:center;">
	商品合計：<%=(Integer)session.getAttribute("gokei")%>円<br>
	送料：<%=(Integer)session.getAttribute("soryo")%>円<br>
	合計：<%=(Integer)session.getAttribute("sokei")%>円<br>

</div><br>

	<div align="center">
	<button type="submit" name="submit" value="chumon" formaction="/group2work/BuyControl">確定</button>
	<button type="button" name="submit" value="return" onClick="history.go(-1)">戻る</button><br>
	</div>
	</div>
</form>


</body>
</html>