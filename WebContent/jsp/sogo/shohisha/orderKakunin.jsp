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

<body>
<form method="post">
<div style="text-align:center;">
	<h2>注文確認</h2>
	注文を確定します。よろしいですか？<br>

	購入詳細<br>
	<img src="/group2work/image/np0001_picture01.jpg" alt="バッグ " width="193" height="130"><br>

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
	商品名:<%= list1.get(0).getShohinName() %><br>
	価格：<%=list1.get(0).getValue() %><br>
	個数：<%=listODetail.get(i-1).getKazuKonyu() %><br>

	<%} %>
</div>

<div style="text-align:center;">
	支払い方法：<%=session.getAttribute("shiharai") %><br>
	配送先住所<br>
	<%=session.getAttribute("post_code") %><br>
	<%=session.getAttribute("address") %><br>

</div>

<div style="text-align:center;">
	商品合計：<%=(Integer)session.getAttribute("gokei")%>円<br>
	送料：<%=(Integer)session.getAttribute("soryo")%><br>
	合計：<%=(Integer)session.getAttribute("gokei")%><br>

</div>

	<button type="submit" name="submit" value="chumon" formaction="/group2work/BuyControl">確定</button><br>
	<button type="button" name="submit" value="return">戻る</button><br>
</form>


</body>
</html>