package bean;

import java.io.Serializable;

public class shohishaBean implements Serializable {

	private String sId;
	private String sName;
	private String dateBirth;
	private String postCode;
	private String adress;
	private String tel;
	private String mailAdress;
	private String sPass;

	shohishaBean(){
	}

	public void setId(String sId) {
		this.sId=sId;
	}

	public String getId() {
		return this.sId;
	}

	public void setName(String sName) {
		this.sName=sName;
	}

	public String getName() {
		return this.sName;
	}

	public void setDateBirth(String datebirth) {
		this.dateBirth=datebirth;
	}

	public String getDateBirth() {
		return this.dateBirth;
	}

	public void setPostCode(String postCode) {
		this.postCode=postCode;
	}

	public String getPostCode() {
		return this.postCode;
	}
	public void setAdress(String adress) {
		this.adress=adress;
	}

	public String getAdress() {
		return this.adress;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}

	public String getTel() {
		return this.tel;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress=mailAdress;
	}

	public String getMailAdress() {
		return this.mailAdress;
	}

	public void setSPass(String sPass) {
		this.sPass=sPass;
	}

	public String getSPass() {
		return this.sPass;
	}
}