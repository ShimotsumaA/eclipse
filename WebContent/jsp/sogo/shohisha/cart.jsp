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
<body>
<div class="wrapper">
<!-- メニューバー -->
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

    <div class="contents">
    <p id="midasi"> カート一覧</p>

    <%if((Boolean)request.getAttribute("cartflag") && (session.getAttribute("login")!=null)) {%>
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


    	<form action="" method="post">
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
    <form action="/group2work/shohisha/CartHyojiServlet" method="post">
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
    		<form action="" method="post">
    		<input type="hidden" name="shohinId" value="<%=shohinId %>">
    		<button type="submit" name=submit value="cancel" >キャンセル</button>
    		</form>
   	 		</td>
   	 		</tr>

			<%} %>
	</table>
	<p id="sum_cart">カート合計:<%= (Integer)session.getAttribute("gokei") %>円</p>

    <%}else{ %>
    カートに商品が存在しません
    <%} %>

    <input type="button" name="back" value="戻る" onclick="location.href=''">



    <div class="footer"></div>
</div>

</body>
</html>