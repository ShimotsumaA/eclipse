package bean;

import java.io.Serializable;

public class KijiBean implements Serializable{

	private String kijiId;
	private String kijiName;

	public String getKijiId() {
		return kijiId;
	}
	public void setKijiId(String kijiId) {
		this.kijiId = kijiId;
	}
	public String getKijiName() {
		return kijiName;
	}
	public void setKijiName(String kijiName) {
		this.kijiName = kijiName;
	}
}
