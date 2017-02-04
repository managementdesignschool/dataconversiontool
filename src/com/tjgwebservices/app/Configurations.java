package com.tjgwebservices.app;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Configurations {

	private String dataPath;
	private String photoArchive;
	private String targetPath;
	private String imageDirectory;
	public Configurations(){}
	
	public Configurations(String os){
		XPath xpath = XPathFactory.newInstance().newXPath();
	    InputSource inputSource = new InputSource("configuration.xml");
		    
	    try {
		    setDataPath(xpath.evaluate("//configurations//configuration[@id='"+os+"']//dataPath", inputSource));
		    setPhotoArchive(xpath.evaluate("//configurations//configuration[@id='"+os+"']//photoArchive", inputSource));
		    setTargetPath(xpath.evaluate("//configurations//configuration[@id='"+os+"']//targetPath", inputSource));
		    setImageDirectory(xpath.evaluate("//configurations//configuration[@id='"+os+"']//targetPath", inputSource));
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}
		    
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public String getPhotoArchive() {
		return photoArchive;
	}

	public void setPhotoArchive(String photoArchive) {
		this.photoArchive = photoArchive;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public String getImageDirectory() {
		return imageDirectory;
	}

	public void setImageDirectory(String imageDirectory) {
		this.imageDirectory = imageDirectory;
	}
	
}
