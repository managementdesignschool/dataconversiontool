package com.tjgwebservices.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.tjgwebservices.app.Actions.WaterMarkCreator;

public class WaterMarkTest extends BaseTest{

			
	@Before 
	public void setupTest() {
	}
	
	@Test
	public void waterMarkTest1() {
		System.out.println("Test adding Text");
		File sourceImageFile = new File(getPhotoArchive()+"photo1.jpg");
		File destImageFile = new File(getTargetPath()+"text_watermarked.png");
		assertTrue(sourceImageFile.exists());
		assertTrue(sourceImageFile.isFile());
		WaterMarkCreator.addTextWatermark("Watermark Test 1", sourceImageFile, destImageFile);
		destImageFile = new File(getTargetPath()+"text_watermarked.png");
		assertTrue(destImageFile.exists());
		assertTrue(destImageFile.isFile());		
	}

	
	@Test
	public void waterMarkTest2() {
		System.out.println("Test adding Logo");
		File sourceImageFile = new File(getPhotoArchive()+"photo2.jpg");
		File destImageFile = new File(getTargetPath()+"logo2_watermarked.png");
		File logoImageFile = new File(getPhotoArchive()+"logo2.png");
		assertTrue(sourceImageFile.exists());
		assertTrue(sourceImageFile.isFile());
		assertTrue(logoImageFile.exists());
		assertTrue(logoImageFile.isFile());
		WaterMarkCreator.addImageWatermark(logoImageFile, sourceImageFile, destImageFile);
		destImageFile = new File(getTargetPath()+"logo2_watermarked.png");
		assertTrue(destImageFile.exists());
		assertTrue(destImageFile.isFile());		
	}

	@Test
	public void waterMarkTest3() {
		System.out.println("Test adding Text and Logo");
		File sourceImageFile = new File(getPhotoArchive()+"photo3.jpg");
		File destImageFile = new File(getTargetPath()+"logo3_watermarked.png");
		File logoImageFile = new File(getPhotoArchive()+"logo3.png");
		assertTrue(sourceImageFile.exists());
		assertTrue(sourceImageFile.isFile());
		assertTrue(logoImageFile.exists());
		assertTrue(logoImageFile.isFile());
		WaterMarkCreator.addTextWatermark("Watermark 3 test", sourceImageFile, destImageFile);
		sourceImageFile = new File(getTargetPath()+"logo3_watermarked.png");		
		destImageFile = new File(getTargetPath()+"logo3_textand_logo_watermarked.png");
		WaterMarkCreator.addImageWatermark(logoImageFile, sourceImageFile, destImageFile);
		destImageFile = new File(getTargetPath()+"logo3_textand_logo_watermarked.png");
		assertTrue(destImageFile.exists());
		assertTrue(destImageFile.isFile());
	}
	
}
