<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了</title>
</head>
<style>
	*{
	font-family:"游ゴシック"
	}
	h2{
	background-color:#87ceeb
	}

	h4{
	background-color:#f0ffff
	}

	table{

	}
</style>
<body>
	<div style="text-align:center">
	<h2>ご注文完了</h2>

	<p>誠にありがとうございます。ご注文が完了しました。<br><br>
	</p>

	<p>ご注文内容の詳細をメールにてご送付しておりますので、ご確認ください。<br>
	   しばらく経ってもご注文完了メールが届かない場合は<font color=#0066cc>「お問い合わせフォーム」</font>よりご連絡ください。<br><br>
	</p>

	<p>下記の<font color=red>「注文番号」</font>をお控えいただきますようお願いいたします。<br>
	   ご注文に関するお問い合わせの際にお伺いさせていただきます。<br>
       ※「ご注文完了メール」にも記載されておりますのでご確認ください。<br>
    </p>


    <div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333;">
    	<p style="">注文番号：００００００００<br>
							 注文日時：２０２１/〇〇/〇〇<br>
							 登録メールアドレス：xxxxxxxxxxxx@xxxxxx<br>
		</p>

  	</div>

	<input type="button" name="back" value="戻る" onclick="location.href='/group2work/jsp/sogo/shohisha/shopping.jsp'">
	</div>
</body>
</html>