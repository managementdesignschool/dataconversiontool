package com.tjgwebservices.app.dataObjects;

public class Font{

	private int fontID;
	private String fontStyle;
	private String fontColor;
	private int fontSize;

	public Font(){
	}

	public int getFontID() {
		return fontID;
	}

	public void setFontID(int fontID) {
		this.fontID = fontID;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

}
