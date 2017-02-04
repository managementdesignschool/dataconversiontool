package com.tjgwebservices.app.dataObjects;

import java.util.ArrayList;

public class ImportCSV {
	private ArrayList<Image> images = new ArrayList<Image>();
	private ArrayList<Font> fonts = new ArrayList<Font>();
	private ArrayList<TextString> texts = new ArrayList<TextString>();
	private ArrayList<Logo> logos = new ArrayList<Logo>();

	public ImportCSV(){
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}

	public ArrayList<Font> getFonts() {
		return fonts;
	}

	public void setFonts(ArrayList<Font> fonts) {
		this.fonts = fonts;
	}

	public ArrayList<TextString> getTexts() {
		return texts;
	}

	public void setTexts(ArrayList<TextString> texts) {
		this.texts = texts;
	}

	public ArrayList<Logo> getLogos() {
		return logos;
	}

	public void setLogos(ArrayList<Logo> logos) {
		this.logos = logos;
	}

	
}
