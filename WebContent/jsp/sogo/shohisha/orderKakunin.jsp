<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文確認</title>
</head>

<body>
<form>
<div style="text-align:center;">
	<h2>注文確認</h2>
	注文を確定します。よろしいですか？<br>

	購入詳細<br>
	<img src="/group2work/image/np0001_picture01.jpg" alt="バッグ " width="193" height="130"><br>

	商品名:<%=session.getAttribute("shohin_name") %><br>
	価格：<%=session.getAttribute("value") %><br>
	個数：<%=session.getAttribute("kazu_konyu") %><br>


	<imput type="button" name="submit" value="chumon" formmethod="post" formaction="/orderCollect.jsp">
</form>

</div>
</body>
</html>