package com.tjgwebservices.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tjgwebservices.app.Actions.ImageManager;
import com.tjgwebservices.app.Actions.ImageProcessor;
import com.tjgwebservices.app.dataObjects.Image;
import com.tjgwebservices.app.dataObjects.ImportCSV;
import com.tjgwebservices.app.dataObjects.TextObject;
import com.tjgwebservices.app.dataObjects.TextString;

public class ProcessImageTest  extends BaseTest{
	private TextObject textObject = new TextObject();
	private TextString textString = new TextString();
	private Image testImage;
	
	
	@Before 
	public void setupTest() {
		init();
//		File newFile = new File(".\\src\\main\\resources\\photo_archive\\importCSV.xml");
		
//		ParseXML.parseXML("importCSV.xml");
	}
	
	@Test
	public void testImageCreation() {
		ImportCSV csv = new ImportCSV();
		assertTrue(csv.getImages().isEmpty());
//		csv.setTextObjects(textObjects);
//		csv.setTextStrings(textStrings);
		
	}

	@Test
	public void testProcessImageTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testImageProcess() {
		//ImportCSV csv = new ImportCSV();
		String path1 = "Images.csv";
		String path2 ="Fonts.csv";
	    String path3 = "Text.csv";
	    String path4 = "Logo.csv";
	    String targetPath = getTestConfiguration().getTargetPath();
	    String photoArchive = getTestConfiguration().getPhotoArchive();
	    System.out.println("photoArchive");
	    System.out.println(photoArchive);
	    ImageProcessor imageProcessor = new ImageProcessor();
	    ImageManager im1 = imageProcessor.processImage(photoArchive+path1, photoArchive+path2, photoArchive+path3, photoArchive+path4);
	    assertFalse(im1.getImportCSV().getFonts().isEmpty());
	    assertFalse(im1.getImportCSV().getImages().isEmpty());
	    assertFalse(im1.getImportCSV().getLogos().isEmpty());
	    assertFalse(im1.getImportCSV().getTexts().isEmpty());
	    //im1.getImportCSV().getImages().get(0)
	}
	
	@After
	public void tearDown(){
	}

	public TextObject getTextObject() {
		return textObject;
	}

	public void setTextObject(TextObject textObject) {
		this.textObject = textObject;
	}

	public TextString getTextString() {
		return textString;
	}

	public void setTextString(TextString textString) {
		this.textString = textString;
	}

	public Image getTestImage() {
		return testImage;
	}

	public void setTestImage(Image testImage) {
		this.testImage = testImage;
	}

	
}
