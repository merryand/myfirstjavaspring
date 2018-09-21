package com.study.jara.domain;

public class Jara {
	private int code;
	private String itemname;
	private String rarity;
	private String itemtype;
	private String pictureurl;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	@Override
	public String toString() {
		return "Jara [code=" + code + ", itemname=" + itemname + ", rarity=" + rarity + ", itemtype=" + itemtype
				+ ", pictureurl=" + pictureurl + "]";
	}

}
