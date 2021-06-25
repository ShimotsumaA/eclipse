<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報</title>
</head>
<body>
<%
  	String no = request.getParameter("no");
 	if(no==null){
  		no=(String)request.getAttribute("no");
  	}
 %>
 <!-- ユーザ情報登録フォーム -->
 <% if (no.equals("1")){%>
 	<form action="/group2work/UserRegisterControl" method="post">
 	<div style="text-align:center">
	<h1>ユーザ登録フォーム</h1>
	<br><br>

		<table  align="center">
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="sName" size="40" maxlength="15"></td>
			</tr>
			<tr>
				<td align="right">生年月日：</td>
				<td><input type="text" name="dateBirth" size="40"  maxlength="10"></td>
			</tr>
		</table><br>
			記入例） 2000/01/01<br><br>
		<table  align="center">
			<tr>
				<td align="right">郵便番号：</td>
				<td><input type="text" name="postCode" size="40"  maxlength="8"></td>
			</tr>
		</table><br>
			記入例） xxx-xxxx<br><br>
		<table  align="center">
			<tr>
				<td align="right">住所：</td>
				<td><textarea name="address" rows=”3″ cols="40" wrap=”hard”  maxlength="30"></textarea></td>
			</tr>
			<tr>
				<td align="right">電話番号：</td>
				<td><input type="text" name="tel" size="40" maxlength="13"></td>
			</tr>
		</table><br>
			記入例） 030-xxxx-xxxx<br><br>
		<table  align="center">
			<tr>
				<td align="right">メールアドレス：</td>
				<td><input type="text" name="mailAddress" size="40"></td>
			</tr>
			<tr>
				<td align="right">ID：</td>
				<td><input type="text" name="sId" size="40" maxlength="10"></td>
				<td><input type="submit" name="submit" value="使用可能か確認"></td>
			</tr>
		</table><br>
			・IDは10文字以内で半角入力のみ可能です。<br>
			・英数字を必ず組み合わせてください。<br>
			・大文字と小文字は区別しません。<br><br>
		<table  align="center">
			<tr>
				<td align="right">パスワード：</td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15"></td>
			</tr>
		</table><br>
			・パスワードは4文字以上15文字以内で半角入力のみ可能です。<br>
			・英数字を必ず組み合わせてください。<br><br>
		<table  align="center">
			<tr>
				<td align="right">パスワード再度入力：</td>
				<td><input type="passwprd" name="sPassK" size="40" maxlength="15"></td>
			</tr>
		</table><br>
			・確認のためにもう一度ご入力ください。<br><br>
		<table  align="center">
		<tr>
			<td><input type ="submit" name="submit" value="登録"></td>
		</tr>
		</table>
	</form>
	</div>


 <!-- ユーザ登録情報変更フォーム -->
 <%} else if (no.equals("2")){%>
 	<form action="/group2work/shohisha/UserRegisterControl" method="post">
 	<div style="text-align:center">
 	<h1>ユーザ登録情報変更フォーム</h1>
	<br><br>

	<form action="" method="post">
		<table  align="center">
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="sName" size="40" maxlength="15"></td>
			</tr>
			<tr>
				<td align="right">生年月日：</td>
				<td><input type="text" name="dateBirth" size="40"  maxlength="10"></td>
			</tr>
		</table><br>
			記入例） 2000/01/01<br><br>
		<table  align="center">
			<tr>
				<td align="right">郵便番号：</td>
				<td><input type="text" name="postCode" size="40"  maxlength="8"></td>
			</tr>
		</table><br>
			記入例） xxx-xxxx<br><br>
		<table  align="center">
			<tr>
				<td align="right">住所：</td>
				<td><textarea name=”address” rows=”3″ cols="40" wrap=”hard”  maxlength="30"></textarea></td>
			</tr>
			<tr>
				<td align="right">電話番号：</td>
				<td><input type="text" name="tel" size="40" maxlength="13">></td>
			</tr>
		</table><br>
			記入例） 030-xxxx-xxxx<br><br>
		<table  align="center">
			<tr>
				<td align="right">メールアドレス：</td>
				<td><input type="text" name="mailAddress" size="40"></td>
			</tr>
			<tr>
				<td align="right">ID：</td>
				<td><input type="text" name="sId" size="40" maxlength="10"></td>
				<td><input type="submit" name="submit" value="使用可能か確認"></td>
			</tr>
		</table><br>
			・IDは10文字以内で半角入力のみ可能です。<br>
			・英数字を必ず組み合わせてください。<br>
			・大文字と小文字は区別しません。<br><br>
		<table  align="center">
			<tr>
				<td align="right">パスワード：</td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15"></td>
			</tr>
		</table><br>
			・パスワードは4文字以上15文字以内で半角入力のみ可能です。<br>
			・英数字を必ず組み合わせてください。。<br><br>
		<table  align="center">
			<tr>
				<td align="right">パスワード再度入力：</td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15"></td>
			</tr>
		</table><br>
			・確認のためにもう一度ご入力ください。<br><br>
		<table  align="center">
		<tr>
			<td><input type ="submit" name="submit" value="変更"></td>
		</tr>
		</table>
	</form>
	</div>
<% } %>

</body>
</html>