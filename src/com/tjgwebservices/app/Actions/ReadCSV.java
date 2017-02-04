package com.tjgwebservices.app.Actions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.tjgwebservices.app.dataObjects.Font;
import com.tjgwebservices.app.dataObjects.Image;
import com.tjgwebservices.app.dataObjects.Logo;
import com.tjgwebservices.app.dataObjects.Position;
import com.tjgwebservices.app.dataObjects.TextString;

public class ReadCSV extends ActionsBase {

	public ReadCSV() {
		// TODO Auto-generated constructor stub
	}

	
	
	public ArrayList<Image> readCSVFromPath(String pathName) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Image> images = new ArrayList<Image>();
		int counter=0;
		try {

			br = new BufferedReader(new FileReader(pathName));
			while ((line = br.readLine()) != null) {
				if (counter>0){
					Image image = new Image(); 
				        // use comma as separator
					String[] imageData = line.split(cvsSplitBy);
					
					image.setImageID(counter);
					image.setPath(imageData[1]);
					image.setLogoID(Integer.valueOf(imageData[2]));
					image.setTextID(Integer.valueOf(imageData[4]));
					image.setTextID(Integer.valueOf(imageData[6]));
					
					
					Position[] positions = Position.values();
					
					for(Position pos : Position.values()) {
					    if(pos.toString().equals(imageData[3])){
					    	image.setLogoPosition(imageData[3]);
					    }
					    if(pos.toString().equals(imageData[5])){
					    	image.setTextPosition(imageData[5]);
					    }
					}
					images.add(image);
				}
				counter++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return images;
		
	}

	
	public ArrayList<TextString> readTextsFromPath(String pathName) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<TextString> texts= new ArrayList<TextString>();
		int counter=0;
		try {

			br = new BufferedReader(new FileReader(pathName));
			while ((line = br.readLine()) != null) {
				if (counter>0){
					TextString textString = new TextString(); 
				        // use comma as separator
					String[] textData = line.split(cvsSplitBy);						
					textString.setTextID(counter);
					textString.setText(textData[1]);
					texts.add(textString);
				}
				counter++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return texts;
	}


	public ArrayList<Font> readFontsFromPath(String pathName) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Font> fonts = new ArrayList<Font>();
		int counter=0;
		try {

			br = new BufferedReader(new FileReader(pathName));
			while ((line = br.readLine()) != null) {
				if (counter>0){
					Font font = new Font(); 
				        // use comma as separator
					String[] fontData = line.split(cvsSplitBy);						
					font.setFontID(counter);
					font.setFontStyle(fontData[1]);
					font.setFontSize(Integer.valueOf(fontData[2]));
					font.setFontColor(fontData[3]);
					fonts.add(font);
				}
				counter++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fonts;
		
	}


	public ArrayList<Logo> readLogosFromPath(String pathName) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Logo> logos = new ArrayList<Logo>();
		int counter=0;
		try {

			br = new BufferedReader(new FileReader(pathName));
			while ((line = br.readLine()) != null) {
				if (counter>0){
					Logo logo = new Logo(); 
				        // use comma as separator
					String[] textData = line.split(cvsSplitBy);						
					logo.setLogoID(counter);
					logo.setLogoPath(textData[1]);
					logos.add(logo);
				}
				counter++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return logos;
	}
	
}
