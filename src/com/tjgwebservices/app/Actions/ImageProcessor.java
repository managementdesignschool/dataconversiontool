package com.tjgwebservices.app.Actions;

import java.io.File;

import com.tjgwebservices.app.dataObjects.Image;
import com.tjgwebservices.app.dataObjects.ImportCSV;
import com.tjgwebservices.app.dataObjects.TextObject;

public class ImageProcessor extends ActionsBase {
	private Image tempImage = new Image();
	private ImageManager imageManager = new ImageManager();

	public ImageProcessor() {
	}

	public ImageManager processImage(String pathImage, String pathFonts, String pathTexts, String pathLogos) {
		getTempImage().setPath(getAppConfig().getTargetPath()+"targetimage.png");
		
		ImportCSV csv = new ImportCSV();
		ImageManager imageManager = new ImageManager();
		ReadCSV rCSV = new ReadCSV();
		csv.setImages(rCSV.readCSVFromPath(pathImage));
		csv.setFonts(rCSV.readFontsFromPath(pathFonts));
		csv.setTexts(rCSV.readTextsFromPath(pathTexts));
		csv.setLogos(rCSV.readLogosFromPath(pathLogos));

		imageManager.setImportCSV(csv);
		TextObject textObject = new TextObject();
		textObject.setFontID(1);
		textObject.setFonts(csv.getFonts());

		System.out.println("app config data path");
		System.out.println(getAppConfig().getDataPath());
		
		System.out.println("app config target path");
		System.out.println(getAppConfig().getTargetPath());

		int imageSize = csv.getImages().size();
		int logoSize = csv.getLogos().size();
		int textSize = csv.getTexts().size();
		String logoFilePath ="";
		String textString="";
		for (int i=0; i<imageSize; i++) {
			String imagePath = getAppConfig().getImageDirectory() + csv.getImages().get(i).getPath();
			int logoID = csv.getImages().get(i).getLogoID();
			for (int j=0; j < logoSize; j++) {
				if (logoID == j) {
					logoFilePath = csv.getLogos().get(j).getLogoPath();					
				}
			}
			int textID = csv.getImages().get(i).getTextID();
			for (int k=0; k < textSize; k++) {
				if (textID == k) {
					textString = csv.getTexts().get(k).getText();					
				}
			}
			String targetPath = getAppConfig().getTargetPath() + csv.getImages().get(i).getPath();
			
			if (logoFilePath.equals("")) {
				System.out.println("No logo added.");
			} else {
				String logoPath = getAppConfig().getTargetPath() + logoFilePath;
				System.out.println(imagePath);
				WaterMarkCreator.addImageWatermark(new File(logoPath), new File(imagePath), new File(targetPath));				
			};
			
			if (textString.equals("")) {
				System.out.println("No text added.");				
			} else {
				WaterMarkCreator.addTextWatermark(textString, new File(targetPath), new File("completed_"+targetPath));
			}
		}

		
		return imageManager;		
	}
	
	

	public Image getTempImage() {
		return tempImage;
	}

	public void setTempImage(Image tempImage) {
		this.tempImage = tempImage;
	}

	public ImageManager getImageManager() {
		return imageManager;
	}

	public void setImageManager(ImageManager imageManager) {
		this.imageManager = imageManager;
	}

	
}
