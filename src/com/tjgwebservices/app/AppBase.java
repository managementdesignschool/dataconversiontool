package com.tjgwebservices.app;

import java.util.Properties;

import com.tjgwebservices.app.Actions.ImageManager;


public class AppBase {
	private Properties paths;
	private ImageManager im;
	
	
	public AppBase(){
		paths = new Properties();
		paths.setProperty("imageCSV", "");
		paths.setProperty("textCSV", "");
		paths.setProperty("logoCSV", "");
		paths.setProperty("fontCSV", "");
		
	}

	public Properties getPaths() {
		return paths;
	}


	public void setPaths(Properties paths) {
		this.paths = paths;
	}

	public ImageManager getIm() {
		return im;
	}

	public void setIm(ImageManager im) {
		this.im = im;
	}



	
}
