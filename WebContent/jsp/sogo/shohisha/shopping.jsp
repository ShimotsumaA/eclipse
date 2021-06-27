<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.CategoryBean"%>
<%@ page import="bean.ShohinBean"%>
<%@ page import="bean.KijiBean"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>online-store Nishida Printing</title>
<link rel="stylesheet" href="./shopping.css">
<style>

	h1{
	background-color:#87ceeb
	}

	h2{
	background-color:#f0ffff
	}

	*{
	margin:0;

}

body{
	background-image:url("/group2work/image/43455.jpg")
}

h1{
	font-family: cursive;

}



table.about{
	margin-left:auto;
	margin-right:0;
	border-spacing:70px 0px;
	position:relative;
	right:90px;
	top:-140px

}

table.shohin{
	margin-left:auto;
	margin-right:0;
	border-spacing:50px 70px;
	position:relative;
	bottom:250px;
	right:50px;

}

div.side_bar{
	clear:right;
}

table.link{
	margin-left:auto;
	margin-right:auto;
	border-spacing:100px 0px;
}
</style>
</head>
<body>

	<img src="/group2work/image/NishidaPrinting800x800px.jpg" width="150" height="150">

	<div class="wrapper">
		<!-- メニューバー -->
		<div class="menu_bar">
			<table class="about" >
				<tr>
					<td><a href="/group2work/jsp/sogo/login.jsp">ログイン</a></td>
					<!-- ログインページへのリンク -->
					<td><a href="/group2work/jsp/sogo/shohisha/mypage.jsp">マイページ</a></td>
					<!-- マイページへのリンク -->
					<td><a href="/group2work/jsp/sogo/shohisha/cart.jsp">カート</a></td>
					<!-- カートへのリンク -->
					<td><a href="/group2work/jsp/sogo/top.jsp">トップページへ</a></td>
					<!-- トップメニューへのリンク -->
				</tr>
			</table>
		</div>
		<!-- カテゴリ検索 -->
		<div class="side_bar">
			<table class="side">


				<!-- 検索ボックス -->
				<tr>
					<form action="" method="post">
						<input type="text" name="kensaku"><input type="button">
					</form>
					</td>
				</tr>

				<!-- カテゴリ選択（for文) -->
				<tr class="category">
					<td>
						<p>カテゴリ</p>
						<form action="/group2work/ECHyoujiServlet" method="post"
							name="category">

							<%
							ArrayList<CategoryBean> list = (ArrayList<CategoryBean>) session.getAttribute("listCategory");
							for (int i = 1; i <= list.size(); i++) {
							%>
							<input type="hidden" name="category_id"
								value="<%=list.get(i - 1).getCategoryId()%>"> <a
								href="javascript:category.submit()"><%=list.get(i - 1).getCategoryName()%></a><br>
							<%
							}
							%>

						</form>
					</td>
				</tr>

				<!-- 生地選択 (for文)-->
				<tr>
					<td>
						<p>生地</p>
						<form action="/group2work/ECHyoujiServlet" method="post"
							name="kiji">
							<%
							ArrayList<KijiBean> list2 = (ArrayList<KijiBean>) session.getAttribute("listKiji");
							for (int i = 1; i <= list2.size(); i++) {
							%>
							<input type="hidden" name="kiji_id"
								value="<%=list2.get(i - 1).getKijiId()%>"> <a
								href="javascript:category.submit()"><%=list2.get(i - 1).getKijiSyurui()%></a><br>
							<%
							}
							%>

						</form>
					</td>
				</tr>

			</table>
		</div>

		<!-- 商品表示 -->
		<div class="shohin_hyozi">
			<table class="shohin">
				<tr>
					<td>
						<!-- 商品for文で取り出し -->
						<form action="/group2work/ShohinHyojiServlet"
							method="post" name="shohin">
							<br>

							<%
							ArrayList<ShohinBean> list3 = (ArrayList<ShohinBean>) session.getAttribute("listShohin");
							%>

							<table class="shohin"  style="text-align:center">
								<tr>
									<%
									int count = 0;
									for (int i = 1; i <= list3.size(); i++) {
									%>
									<td><input type="hidden" name="shohin_id"
										value="<%=list3.get(i - 1).getShohinId()%>"> <a
										href="javascript:shohin.submit()"><img src="/group2work/image/np0002_picture02.jpg"width=150 height=150></a><br>
										<p><%=list3.get(i - 1).getShohinName()%></p>
										<p><%=list3.get(i - 1).getValue()%>円</p>
										<%count = count + 1;%>
									<td>
										<%if (count % 3 == 0) {%>

								</tr>
								<tr>
										<%}%>

									<%}%>
								</tr>
							</table>

						</form>
					</td>
				</tr>
			</table>
		</div>

		<!-- フッター -->
		<div class="footer">
			<table class="link">
				<tr>
					<td><a href="/group2work/jsp/sogo/shohisha/souryou.jsp">配送料に関して</a></td>
					<td><a href="/group2work/jsp/sogo/shohisha/gaiyo.jsp">特定商取引法に基づく表記</a></td>
				</tr>
			</table>
		</div>

	</div>

</body>
</html>