package bean;

import java.io.Serializable;

public class ShohishaBean implements Serializable{
	private String sId;
	private String sName;
	private String dateBirth;
	private String postCode;
	private String address;
	private String tel;
	private String mailAddress;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		return mailAddress;
	}
	public void setMail(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	//パスワード
	public String getPass() {
		return sPass;
	}
	public void setPass(String sPass) {
		this.sPass = sPass;
	}

}
