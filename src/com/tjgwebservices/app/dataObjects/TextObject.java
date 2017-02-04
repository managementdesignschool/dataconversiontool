package com.tjgwebservices.app.dataObjects;

public class TextObject extends ImportCSV{
	private int textID;
	private int fontID;
	private String position;
	
	public TextObject(){		
	}

	public int getTextID() {
		return textID;
	}

	public void setTextID(int textID) {
		this.textID = textID;
	}

	public int getFontID() {
		return fontID;
	}

	public void setFontID(int fontID) {
		this.fontID = fontID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}
