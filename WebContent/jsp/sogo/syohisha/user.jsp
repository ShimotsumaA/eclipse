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
	<h1>ユーザ登録フォーム</h1>
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
			<tr>
				<td align="right">郵便番号：</td>
				<td><input type="text" name="postCode" size="40"  maxlength="8"></td>
			</tr>
			<tr>
				<td align="right">住所：</td>
				<td><textarea name=”adress” rows=”3″ cols="40" wrap=”hard”  maxlength="30"></textarea></td>
			</tr>
			<tr>
				<td align="right">電話番号：</td>
				<td><input type="text" name="tel" size="40" maxlength="13">></td>
			</tr>
			<tr>
				<td align="right">メールアドレス：</td>
				<td><input type="text" name="mailAdress" size="40"></td>
			</tr>
			<tr>
				<td align="right">ID：</td>
				<td><input type="text" name="tel" size="40" maxlength="10">></td>
				<td><input type="submit" name="submit" value="使用可能か確認"></td>

			</tr>
			<tr>
				<td align="right">パスワード：</td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15">></td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15">></td>
			</tr>
		</table>
		<table>
		<tr>
			<td><input type ="submit" name="submit" value="確認"></td>
		</tr>
		</table>
	</form>
<% } %>

 <!-- ユーザ登録情報変更フォーム -->
 <% if (no.equals("2")){%>
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
			<tr>
				<td align="right">郵便番号：</td>
				<td><input type="text" name="postCode" size="40"  maxlength="8"></td>
			</tr>
			<tr>
				<td align="right">住所：</td>
				<td><textarea name=”adress” rows=”3″ cols="40" wrap=”hard”  maxlength="30"></textarea></td>
			</tr>
			<tr>
				<td align="right">電話番号：</td>
				<td><input type="text" name="tel" size="40" maxlength="13">></td>
			</tr>
			<tr>
				<td align="right">メールアドレス：</td>
				<td><input type="text" name="mailAdress" size="40"></td>
			</tr>
			<tr>
				<td align="right">ID：</td>
				<td><input type="text" name="tel" size="40" maxlength="10">></td>
				<td><input type="submit" name="submit" value="使用可能か確認"></td>

			</tr>
			<tr>
				<td align="right">パスワード：</td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15">></td>
				<td><input type="passwprd" name="sPass" size="40" maxlength="15">></td>
			</tr>
		</table>
		<table>
		<tr>
			<td><input type ="submit" name="submit" value="確認"></td>
		</tr>
		</table>
	</form>
<% } %>

</body>
</html>