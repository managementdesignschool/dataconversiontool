package com.tjgwebservices.app.Actions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.tjgwebservices.app.dataObjects.Image;
import com.tjgwebservices.app.dataObjects.ImportCSV;
import com.tjgwebservices.app.dataObjects.TextObject;
import com.tjgwebservices.app.dataObjects.TextString;

public class ImageManager extends ActionsBase {
	
	private BufferedImage inputImage;
	private URL url;
	private Graphics graphics;
	private ImportCSV importCSV;
	
	public ImageManager(){
		
	}
	
	public File processImage(String imagePath,TextObject textObject) {
		System.out.println("Image Manager - Process Image: " + imagePath);
		Image image;
		try {
			setUrl(new URL(imagePath));
			System.out.println("Image Manager: setUrl");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			setUrl(null);
			e1.printStackTrace();
		}
		try {
			
			setInputImage(ImageIO.read(getUrl()));
			System.out.println("Image Manager - Set Input Image: ");
		} catch (IOException e) {
			System.out.println("Unable to readImage:" + getUrl());
			e.printStackTrace();
			return null;
		}		
		
		File imageFile = new File(imagePath);
		
		System.out.println("File Properties: ");
		System.out.println("name: " + imageFile.getParent());
		System.out.println("parent: " + imageFile.getParent());
		System.out.println("absolute file path: " + imageFile.getAbsolutePath());
		try {
			System.out.println("canonical file path: " + imageFile.getCanonicalPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("last modified: " + imageFile.lastModified());
		System.out.println("length: " + imageFile.length());
		setGraphics(getInputImage().getGraphics());
		System.out.println("Image Manager - Set Graphics");
		getGraphics().setFont(getGraphics().getFont());
		System.out.println("Image Manager - Set Font");
		
		ArrayList<TextString> texts = importCSV.getTexts();
		System.out.println("Image Manager - Get Texts");
		String imageText = null;
		
		int textsSize = texts.size(); 
		System.out.println("Image Manager - Text Size: " + textsSize);
		for (int i=0;i<textsSize; i++){
			if (textObject.getTextID() == i) {
				imageText = texts.get(i).getText();
			}
			if(imageText.isEmpty() || imageText.equals(null)) {
				System.out.println("Image Manager - Image Text is Empty: ");
				try {
					System.out.println("ImageManager: Text Exception");
					throw new Exception("Text for id: " + textObject.getTextID());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		String pos =  textObject.getPosition();
		String posXY[] = pos.split(",");
		
		int posX = Integer.valueOf(posXY[0]);
		int posY = Integer.valueOf(posXY[1]);		
		System.out.println("Image Manager - Position x and y: " + posX + "," + posY);
		
		getGraphics().drawString(imageText, posX, posY);
		System.out.println("Image Manager - Set Input Image: Draw String");
		File parentDirectory=new File(imageFile.getParent());
		File targetFile = new File(parentDirectory.getParent()+"/target/"+imageFile.getName());
		
		try {
			ImageIO.write(getInputImage(), "png", targetFile);
			System.out.println("Image Manager - Writing Input Image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Image Manager - Set Input Image: IO Exception");
			e.printStackTrace();
			return null;
		}
		
		return targetFile;
		
	}

	
	public BufferedImage processWatermark(BufferedImage img, String origImage, String destImage){
		Graphics2D g2 = img.createGraphics();
		
		try {
		    // retrieve image
		    File outputfile = new File(destImage);
		    ImageIO.write(img, "png", outputfile);
			return ImageIO.read(new URL(destImage));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}				
		
	}
	
	public BufferedImage processBufferedImageWatermark( String origImage, String destImage){
		try {
		    // retrieve image
		    BufferedImage bi = this.getInputImage();
		    File outputfile = new File("saved.png");
		    ImageIO.write(bi, "png", outputfile);
		    return ImageIO.read(new URL(destImage));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public File processTextOnImage(BufferedImage img, String text){
		Graphics2D g2 = img.createGraphics();
		//g2.setColor(Color.black);
//		g2.setFont(Font.SERIF);
		g2.setColor(Color.BLUE);
//		g2.setFont(Font.SERIF);
		g2.drawString(text, 80,1440);
		 
		File outputfile = new File("imagewithtext.png");
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return outputfile;
	}
/*	
	public BufferedImage waterMarkImage(BufferedImage img, BufferedImage watermarkedImage, String origImage, String destImage) {
		FileFilter filter = new FileFilter();
		Watermark wm = new Watermark();
		
//		Watermark filter = new Watermark(Position.CENTER, watermarkedImage, 0.5f);
		BufferedImage newImage = ((Object) filter).apply(img);
		return newImage;
	}
	*/
	public BufferedImage getInputImage() {
		return inputImage;
	}

	public void setInputImage(BufferedImage inputImage) {
		this.inputImage = inputImage;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Graphics getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	
	public ImportCSV getImportCSV() {
		return importCSV;
	}

	public void setImportCSV(ImportCSV importCSV) {
		this.importCSV = importCSV;
	}

	
}
