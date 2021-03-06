<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.ShohishaBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報</title>
<meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
</head>
<style>
	*{
	font-family:"游ゴシック"
	}
	h2{
	background-color:#87ceeb
	}

</style>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<%
  	String no = request.getParameter("no");
 %>

 <!-- 登録情報の確認(確定)-->

 <% if(request.getAttribute("submit")!=null&&request.getAttribute("submit").equals("toroku")){ %>
	<form action ="/group2work/UserRegisterControl"  method="post">
<!-- メニューバー -->
	<div class="wrapper">
	<div align="center">



		<h2>登録情報の確認</h2>

		<p>以下の情報を登録します。よろしいですか？</p>
		<table>
			<tr>
				<td>氏名：</td>
				<td><%=session.getAttribute("sName") %></td>
			</tr>

			<tr>
				<td>生年月日：</td>
				<td><%=session.getAttribute("dateBirth") %></td>
			</tr>

			<tr>
				<td>郵便番号：</td>
				<td><%=session.getAttribute("postCode") %></td>
			</tr>

			<tr>
				<td>住所：</td>
				<td><%=session.getAttribute("address") %></td>
			</tr>

			<tr>
				<td>電話番号：</td>
				<td><%=session.getAttribute("tel") %></td>
			</tr>

			<tr>
				<td>メールアドレス：</td>
				<td><%=session.getAttribute("mailAddress") %></td>
			</tr>

			<tr>
				<td>ID：</td>
				<td><%=session.getAttribute("sId") %></td>
			</tr>

			<tr>
				<td>パスワード：</td>
				<td><%=session.getAttribute("sPass") %></td>
			</tr>

		</table>
		<br>
		<table>
			<tr>
				<td><input type ="submit" name="submit" value="確定"></td>
				<td><input type ="submit" name="submit" value="戻る" onclick="location.href='/group2work/jsp/sogo/shohisha/shopping.jsp'"></td>
		</tr>
		</table>
	</div>
	</div>
	<%if(request.getAttribute("2kaime")!=null){ %>
	<input type="hidden" name="kakunin" value="henkou">
	<%} %>
	</form>


 <!-- 登録情報の変更 -->
 <%} else if(request.getAttribute("submit")!=null&&request.getAttribute("submit").equals("henko")){ %>
	<form action ="/group2work/UserRegisterControl" method="post">
	<div align="center">
		<h2>登録情報の変更</h2>
		<% if(request.getAttribute("kakunin")==null){%>
		<p>以下の情報を変更します。よろしいですか？</p>
		<%} %>
		<table>
			<tr>
				<td>氏名：</td>
				<td><%=session.getAttribute("sName") %></td>
			</tr>

			<tr>
				<td>生年月日：</td>
				<td><%=session.getAttribute("dateBirth") %></td>
			</tr>

			<tr>
				<td>郵便番号：</td>
				<td><%=session.getAttribute("postCode") %></td>
			</tr>

			<tr>
				<td>住所：</td>
				<td><%=session.getAttribute("address") %></td>
			</tr>

			<tr>
				<td>電話番号：</td>
				<td><%=session.getAttribute("tel") %></td>
			</tr>

			<tr>
				<td>メールアドレス：</td>
				<td><%=session.getAttribute("mailAddress") %></td>
			</tr>

			<tr>
				<td>ID：</td>
				<td><%=session.getAttribute("sId") %></td>
			</tr>

			<tr>
				<td>パスワード：</td>
				<td><%=session.getAttribute("sPass") %></td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td><input type ="submit" name="submit" value="変更"></td>
				<td><input type ="button" name="submit" onclick="location.href='/group2work/jsp/sogo/shohisha/shopping.jsp'" value="戻る"></td>
			</tr>
		</table>
	</div>
	<input type="hidden" name="mod" value="mod">
	</form>
<% }else{%>
<form action ="/group2work/UserRegisterControl" method="post">
	<div align="center">
		<h2>登録情報の確認</h2>
		<font color="red">
		<%if(request.getAttribute("compmsg")!=null){ %>
		<%=request.getAttribute("compmsg") %>
		<%} %></font>

		<table>
			<tr>
				<td>氏名：</td>
				<td><%=session.getAttribute("sName") %></td>
			</tr>

			<tr>
				<td>生年月日：</td>
				<td><%=session.getAttribute("dateBirth") %></td>
			</tr>

			<tr>
				<td>郵便番号：</td>
				<td><%=session.getAttribute("postCode") %></td>
			</tr>

			<tr>
				<td>住所：</td>
				<td><%=session.getAttribute("address") %></td>
			</tr>

			<tr>
				<td>電話番号：</td>
				<td><%=session.getAttribute("tel") %></td>
			</tr>

			<tr>
				<td>メールアドレス：</td>
				<td><%=session.getAttribute("mailAddress") %></td>
			</tr>

			<tr>
				<td>ID：</td>
				<td><%=session.getAttribute("sId") %></td>
			</tr>

			<tr>
				<td>パスワード：</td>
				<td><%=session.getAttribute("sPass") %></td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td><input type ="submit" name="submit" value="変更"></td>
				<td><button type ="button" name="submit" onclick="location.href='/group2work/jsp/sogo/shohisha/shopping.jsp'">戻る</button></td>
			</tr>
		</table>
	</div>
	<input type="hidden" name="mod" value="mod">
	</form>

<% }%>





</body>
</html>