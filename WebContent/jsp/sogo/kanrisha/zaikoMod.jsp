<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫入力</title>

</head>
<body>

	<%
	if (request.getAttribute("nyukoHenko") != null && request.getAttribute("nyukoHenko").equals("nyuko")) {
	%>
	<div style="text-align: center">
		<form action="/group2work/ZaikoKanriServlet" method="post">
			<h1>在庫入庫</h1>
			商品ID：<%=session.getAttribute("shohinId")%><br> 商品名：<%=session.getAttribute("shohinName")%><br>
			在庫数：<%=session.getAttribute("zaiko")%><br>
			<br> 入力分の在庫数を追加します。<br>
			<br> <label for="tuika">入庫数：</label> <input type="text"
				name="nyuko" size="30" id="tuika"><br>
			<br> <input type="submit" name="submit" value="確認"> <input
				type="button" value="戻る" onClick="history.go(-1)">
		</form>
	</div>
	<br>
	<br>
	<%
	}
	%>

	<%
	if (request.getAttribute("nyukoHenko") != null && request.getAttribute("nyukoHenko").equals("henko")) {
	%>
	<div style="text-align: center">
		<form action="/group2work/ZaikoKanriServlet" method="post">
			<h1>在庫変更</h1>
			商品ID：<%=session.getAttribute("shohinId")%><br> 商品名：<%=session.getAttribute("shohinName")%><br>
			在庫数：<%=session.getAttribute("zaiko")%><br>
			<br> 在庫数を入力した値に変更します。<br>
			<br> <label for="sinki">新規在庫数:</label> <input type="text"
				name="shinki" size="30" id="sinki" value="<%=session.getAttribute("zaiko")%>"><br>
			<br> <input type="submit" name="submit" value="確認"> <input
				type="button" value="戻る" onClick="history.go(-1)">
		</form>
	</div>
	<%
	}
	%>
</body>
</html>