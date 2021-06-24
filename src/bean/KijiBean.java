package bean;

import java.io.Serializable;

public class KijiBean implements Serializable{

	private String kijiId;
	private String kijiSyurui;
	private String colour;

	public String getKijiId() {
		return kijiId;
	}
	public void setKijiId(String kijiId) {
		this.kijiId = kijiId;
	}
	public String getKijiSyurui() {
		return kijiSyurui;
	}
	public void setKijisyurui(String syurui) {
		this.kijiSyurui = syurui;
	}

	public String getKijiColour() {
		return colour;
	}
	public void setKijiColour(String colour) {
		this.colour = colour;
	}




}
