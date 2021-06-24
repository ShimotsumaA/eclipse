<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>

</head>
<body>

<div style= "text-align:center">
<h1>商品一覧</h1><br>



<table border="1" align="center">
<tr>
<td> </td><td>商品ID</td><td>商品名</td><td>販売価格</td><td>カテゴリ</td><td>生地ID</td>
</tr>
<tr>
<td><input type="radio" name="商品" value="A"></td><td>0000000001</td><td>商品A</td><td>100</td><td>    </td><td>    </td>
</tr>
<tr>
<td><input type="radio" name="商品" value="B"></td><td>0000000002</td><td>商品B</td><td>200</td><td>    </td><td>    </td>
</tr>
<tr>
<td><input type="radio" name="商品" value="C"></td><td>0000000003</td><td>商品C</td><td>300</td><td>    </td><td>    </td>
</tr>
<tr>
<td><input type="radio" name="商品" value="D"></td><td>0000000004</td><td>商品C</td><td>400</td><td>    </td><td>    </td>
</tr>
</table><br><br>
<form action="/group2work/ShohinKanriServlet" method="post">
<!-- form shohinKanriMod?no=2 -->
<input type="submit" name="submit" value="変更">
</form>

<!-- form shohinKanriKakunin -->
<form action="shohinKanriKakunin.jsp" >
<input type="submit" name="submit" value="削除">
</form>
<input type="button" value="戻る" onClick="history.go(-1)">
</body>
</html>