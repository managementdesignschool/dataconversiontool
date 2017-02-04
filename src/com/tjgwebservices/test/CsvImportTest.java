package com.tjgwebservices.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tjgwebservices.app.Actions.ReadCSV;
import com.tjgwebservices.app.dataObjects.Image;
import com.tjgwebservices.app.dataObjects.ImportCSV;
import com.tjgwebservices.app.dataObjects.TextObject;
import com.tjgwebservices.app.dataObjects.TextString;

public class CsvImportTest extends BaseTest {

	@Before 
	public void setupTest() {
	}
	
	@Test
	public void testCsvImport() {
		ImportCSV csv = new ImportCSV();
		
		assert(csv.getImages().isEmpty());
//		csv.setTextObjects(textObjects);
//		csv.setTextStrings(textStrings);
		
	}

	@Test
	public void testReadCSV() {
		ReadCSV rCSV = new ReadCSV();
		ArrayList<Image> images = rCSV.readCSVFromPath(getPhotoArchive()+"Images.csv");
		System.out.println("***testReadCSV");
		System.out.println(images.get(0).getImageID());
		System.out.println(images.size());
		System.out.println("***testReadCSV");

	}
	
	@Test
	public void testParseCSV() {
		ImportCSV csv = new ImportCSV();
		Image image = new Image();
		assertTrue(csv.getImages().isEmpty());		
	}
	
	@After
	public void tearDown(){
	}

}
