<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫変更確認</title>
</head>
<body>

<%if(session.getAttribute("nyukoHenko")!=null) {%>
<div style=text-align:center>
<form action="/group2work/ZaikoKanriServlet" method="post">
<%
String hyoujiflag=(String)session.getAttribute("nyukoHenko");
String hyouji="";
int oldZaiko=(Integer)session.getAttribute("zaiko");
int newZaiko=0;
if(hyoujiflag.equals("nyuko")){

	int nyuko=(Integer)session.getAttribute("nyuko");
	hyouji="入庫";
	newZaiko=oldZaiko+nyuko;

}else if(hyoujiflag.equals("henko")){
	int shinki=(Integer)session.getAttribute("shinki");
	hyouji="変更";
	newZaiko=shinki;
}


%>
	<h1><%=hyouji %>確認</h1>
	以下の情報を変更します。よろしいですか？<br><br>
	商品ID：<%=session.getAttribute("shohinId") %><br>
	商品名：<%=session.getAttribute("shohinName") %><br>
	<%=hyouji %>前在庫数：<%=oldZaiko %><br>
	<%=hyouji %>後在庫数：<%=newZaiko %><font color="red">パラメータ</font><br>
	<input type="submit" name="submit" value="確定">
</form>
	<input type="button" value="戻る" onClick="history.go(-1)">
</div>
<%} %>
</body>
</html>