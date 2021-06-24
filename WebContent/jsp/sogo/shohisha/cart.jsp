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
    <table>
    <tr>
    <!-- for文で抽出 -->
    	<td>商品A<br>
    	価格：XXX円<br>
    	個数:1
    	<form action="" method="post">
    	<button type="submit" name=submit value="cancel" id="商品A">キャンセル</button>
    	</form>
   	 	</td>
    </table>

    <!-- カート合計表示 -->
    <p id="sum_cart">カート合計:XXX円</p>
    </div>

    <!-- 注文ボタン -->
    <form action="" method="post">
    <button type="submit" name="submit" value="tyumonhakotira">ご注文はこちら</button>
    </form>

    <%}else{ %>
    <p>カートに商品が存在しません</p>
    <%} %>
    <input type="button" name="back" value="戻る" onclick="location.href=''">



    <div class="footer"></div>
</div>

</body>
</html>