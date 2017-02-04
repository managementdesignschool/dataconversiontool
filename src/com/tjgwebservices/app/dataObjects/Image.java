package com.tjgwebservices.app.dataObjects;

import java.awt.image.BufferedImage;

public class Image extends ImportCSV{
	private int imageID;
	private String path;
	private BufferedImage imageObject;
	private int logoID;
	private String logoPosition;
	private int textID;
	private String textPosition;
	private int fontID;
	

	public Image(){
	}


	public int getImageID() {
		return imageID;
	}


	public void setImageID(int imageID) {
		this.imageID = imageID;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public BufferedImage getImageObject() {
		return imageObject;
	}


	public void setImageObject(BufferedImage imageObject) {
		this.imageObject = imageObject;
	}


	public int getLogoID() {
		return logoID;
	}


	public void setLogoID(int logoID) {
		this.logoID = logoID;
	}


	public String getLogoPosition() {
		return logoPosition;
	}


	public void setLogoPosition(String logoPosition) {
		this.logoPosition = logoPosition;
	}


	public int getTextID() {
		return textID;
	}


	public void setTextID(int textID) {
		this.textID = textID;
	}


	public String getTextPosition() {
		return textPosition;
	}


	public void setTextPosition(String textPosition) {
		this.textPosition = textPosition;
	}


	public int getFontID() {
		return fontID;
	}


	public void setFontID(int fontID) {
		this.fontID = fontID;
	}


}
