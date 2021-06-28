<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報</title>
<link rel="stylesheet" href="./user.css">
</head>
<style>
	*{
	font-family:"游ゴシック"
	}
	h2{
	background-color:#87ceeb
	}

	input[type="text"]:focus,
	texture:focus {
    box-shadow: 0 0 7px #3498db;
    border: 1px solid #3498db;
	}

	table.text{
	margin-left:auto;
	margin-right:auto;
	}

	table.ID{
	margin-left:auto;
	margin-right:auto;
	}

	table.pass{
	margin-left:auto;
	margin-right:auto;
	}

</style>
<body>
<%
  	String no = request.getParameter("no");
 	if(no==null){
  		no=(String)request.getAttribute("no");
  	}

 	String errmsg=null;
 	String errmsg2=null;
 	String errmsg3=null;



 	if(request.getAttribute("errmsg")!=null){
 	 errmsg=(String)request.getAttribute("errmsg");
 	}

 	if(request.getAttribute("errmsg2")!=null){
 	 	 errmsg2=(String)request.getAttribute("errmsg2");
 	}

 	if(request.getAttribute("errmsg3")!=null){
 	 	 errmsg3=(String)request.getAttribute("errmsg3");
 	}


 %>


 <!-- ユーザ情報登録フォーム -->
 <% if (no.equals("1")){%>
 	<div style="text-align:center">



 	<h2>ユーザ登録フォーム</h2>
	<br><br>
<form action="/group2work/UserRegisterControl" method="post">

		<table class="text">
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" name="sName" size="40" maxlength="15" placeholder="例）鈴木太郎"></td>
			</tr>
			<tr>
				<td align="right">生年月日：</td>
				<td><input type="text" name="dateBirth" size="40"  maxlength="10" placeholder="例）2020/01/01"></td>
			</tr>
			<tr>
				<td align="right">郵便番号：</td>
				<td><input type="text" name="postCode" size="40"  maxlength="8" placeholder="例）123-4567"></td>
			</tr>
			<tr>
				<td align="right">住所：</td>
				<td><textarea name="address" rows=”3″ cols="40"  wrap=”hard”  maxlength="30"></textarea></td>
			</tr>
			<tr>
				<td align="right">電話番号：</td>
				<td><input type="text" name="tel" size="40" maxlength="13" placeholder="例）123-4567-8910"></td>
			</tr>
			<tr>
				<td align="right">メールアドレス：</td>
				<td><input type="text" name="mailAddress" size="40" placeholder="例）sample@gmail.com"></td>
			</tr>
			<tr>
				<td align="right">ID：</td>
				<td><input type="text" name="sId" size="40" maxlength="10"></td>
				<td><%=errmsg %></td>
			</tr>
		</table>
		<table class="ID">
			<tr>
				<td><input type="submit" name="submit" value="使用可能か確認"></td>
			</tr>
			<tr>
			<td>・IDは10文字以内で半角入力のみ可能です。</td>
			</tr>
			<tr>
			<td>・英数字を必ず組み合わせてください。</td>
			</tr>
			<tr>
			<td>・大文字と小文字は区別しません。</td>
			</tr>



		</table>
		<table  align="center">
			<tr>
			<td><%=errmsg2 %><br><%=errmsg3 %></td>
				<td align="right">パスワード：</td>
				<td><input type="password" name="sPass" size="40" maxlength="15"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="password" name="sPassK" size="40" maxlength="15" placeholder="確認のためにもう一度ご入力ください"></td>
			</tr>
		</table>
		<table class="pass">
			<tr>
				<td>・パスワードは4文字以上15文字以内で半角入力のみ可能です。</td>
			</tr>
			<tr>
				<td>・英数字を必ず組み合わせてください。</td>
			</tr>
		</table>
		<table  align="center">
		<tr>
			<td><input type ="submit" name="submit" value="登録"></td>
			<td><input type="button" value="戻る" onclick="location.href='/group2work/jsp/sogo/top.jsp'">
		</tr>
	</table>
		</form>


	</div>


 <!-- ユーザ登録情報変更フォーム -->
 <%} else if (no.equals("2")){%>
 	<div style="text-align:center">
 	<form action="/group2work/UserRegisterControl" method="post">

 	<h2>ユーザ登録情報変更フォーム</h2>
	<br><br>
		<!-- 初期値valueを入れました -->
		<table  align="center">
			<tr>
				<td align="right">氏名：</td>
				<td><input type="text" value="<%=session.getAttribute("sName") %>" name="sName" size="40" maxlength="15"></td>
			</tr>
			<tr>
				<td align="right">生年月日：</td>
				<td><input type="text" value="<%=session.getAttribute("dateBirth") %>" name="dateBirth" size="40"  maxlength="10"></td>
			</tr>
			<tr>
				<td align="right">郵便番号：</td>
				<td><input type="text" value="<%=session.getAttribute("postCode")%>"name="postCode" size="40"  maxlength="8"></td>
			</tr>
			<tr>
				<td align="right">住所：</td>
				<td><textarea name="address" rows="3" cols="40" wrap="hard"  maxlength="30"><%=session.getAttribute("address")%> </textarea></td>
			</tr>
			<tr>
				<td align="right">電話番号：</td>
				<td><input type="text" value="<%=session.getAttribute("tel")%>" name="tel" size="40" maxlength="13"></td>
			</tr>
			<tr>
				<td align="right">メールアドレス：</td>
				<td><input type="text" value="<%=session.getAttribute("mailAddress")%>" name="mailAddress" size="40"></td>
			</tr>
			<tr>
			<td><%=errmsg %></td>
				<td align="right">ID：</td>
				<td><%-- <input type="text" value="--%><%=session.getAttribute("sId")%><%--" name="sId" size="40" maxlength="10"></td>
				<td><input type="submit" name="submit" value="使用可能か確認"> --%></td>
			</tr>
<!-- 			・IDは10文字以内で半角入力のみ可能です。<br>
			・英数字を必ず組み合わせてください。<br>
			・大文字と小文字は区別しません。<br><br> -->
			<tr>

				<td align="right">パスワード：</td>
				<td><input type="password" name="sPass" size="40" maxlength="15"></td>
				<td><%=errmsg2 %><br><%=errmsg3 %></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="password" name="sPassK" size="40" maxlength="15" placeholder="確認のためにもう一度ご入力ください"></td>
			</tr>
		</table><br>
			・パスワードは4文字以上15文字以内で半角入力のみ可能です。<br>
			・英数字を必ず組み合わせてください。<br>
			・パスワードを変更しない場合は変更前のパスワードを入力してください。<br><br>

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