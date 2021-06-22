package bean;

import java.io.Serializable;

public class ShohishaBean implements Serializable{
	private String sId;
	private String sName;
	private String dateBirth;
	private String postCode;
	private String adress;
	private String tel;
	private String mailAdress;
	private String sPass;

	//ID
	public String getId() {
		return sId;
	}
	public void setId(String sId) {
		this.sId = sId;
	}

	//名前
	public String getName() {
		return sName;
	}
	public void setName(String sName) {
		this.sName = sName;
	}

	//生年月日
	public String getBirth() {
		return dateBirth;
	}
	public void setBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	//郵便番号
	public String getPost() {
		return postCode;
	}
	public void setPost(String postCode) {
		this.postCode = postCode;
	}

	//住所
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	//電話番号
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	//メール
	public String getMail() {
		return mailAdress;
	}
	public void setMail(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	//パスワード
	public String getPass() {
		return sPass;
	}
	public void setPass(String sPass) {
		this.sPass = sPass;
	}

}
