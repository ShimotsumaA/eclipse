package bean;

import java.math.BigDecimal;

public class UriageBean {
	private String shohinId;
	private int gokeiKosu;
	private String shohinName;
	private BigDecimal value;
	private BigDecimal gokei;

	public void setShohinId(String shohinId) {
		this.shohinId=shohinId;
	}
	public String getShohinId() {
		return this.shohinId;
	}
	public void setShohinName(String shohinName) {
		this.shohinName=shohinName;
	}
	public String getShohinName() {
		return this.shohinName;

	}
	public int getGokeiKosu() {
		return gokeiKosu;
	}

	public void setGokeiKosu(int gokeiKosu) {
		this.gokeiKosu = gokeiKosu;
	}

	public void setValue(java.math.BigDecimal value) {
		this.value=value;
	}
	public java.math.BigDecimal getValue(){
		return this.value;
	}

	public void setGokei(java.math.BigDecimal gokei) {
		this.gokei=gokei;
	}
	public java.math.BigDecimal getGokei(){
		return this.gokei;
	}


}
