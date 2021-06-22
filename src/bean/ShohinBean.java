package bean;

import java.io.Serializable;

public class ShohinBean implements Serializable {
	private String shohinId;
	private String shohinName;
	private String kijiId;
	private String categoryId;
	private java.math.BigDecimal value;

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
	public void setKijiId(String kijiId) {
		this.kijiId=kijiId;
	}
	public String getKijiId() {
		return this.kijiId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId=categoryId;
	}
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setValue(java.math.BigDecimal value) {
		this.value=value;
	}
	public java.math.BigDecimal getValue(){
		return this.value;
	}
}

