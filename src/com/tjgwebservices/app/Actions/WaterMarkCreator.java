package com.tjgwebservices.app.Actions;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WaterMarkCreator extends ActionsBase {

	public WaterMarkCreator() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Embeds a textual watermark over a source image to produce a watermarked
	 * one.
	 * 
	 * @param text
	 *            The text to be embedded as watermark.
	 * @param sourceImageFile
	 *            The source image file.
	 * @param destImageFile
	 *            The output image file.
	 */
	public static void addTextWatermark(String text, File sourceImageFile,
			File destImageFile) {
		System.out.println("Add Text Watermark");
		System.out.println("WaterMarkCreator - add Text WaterMark:"+
				sourceImageFile.getAbsolutePath() + sourceImageFile.lastModified()
				+ sourceImageFile.isFile() + sourceImageFile.getFreeSpace());
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

			// initializes necessary graphic properties
			AlphaComposite alphaChannel = AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, 0.3f);
			g2d.setComposite(alphaChannel);
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("Arial", Font.BOLD, 64));
			FontMetrics fontMetrics = g2d.getFontMetrics();
			Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

			// calculates the coordinate where the String is painted
			int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
			int centerY = sourceImage.getHeight() / 2;

			// paints the textual watermark
			g2d.drawString(text, centerX, centerY);

			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();

			System.out.println("The tex watermark is added to the image.");

		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Add Text Watermark - IOException");
			System.err.println(ex);
		}
	}

	/**
	 * Embeds an image watermark over a source image to produce a watermarked
	 * one.
	 * 
	 * @param watermarkImageFile
	 *            The image file used as the watermark.
	 * @param sourceImageFile
	 *            The source image file.
	 * @param destImageFile
	 *            The output image file.
	 */
	public static void addImageWatermark(File logoImageFile,
			File sourceImageFile, File destImageFile) {
			System.out.println("WaterMarkCreator - add Logo WaterMark:"+
					logoImageFile.getAbsolutePath() + logoImageFile.lastModified()
					+ logoImageFile.isFile() + logoImageFile.getFreeSpace());
			System.out.println("WaterMarkCreator - source Image WaterMark:"+
					sourceImageFile.getAbsolutePath());
			System.out.println("WaterMarkCreator - dest Image WaterMark:"+
					destImageFile.getAbsolutePath());
			BufferedImage sourceImage;
			try {
				sourceImage = ImageIO.read(sourceImageFile);
				// initializes necessary graphic properties
				Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
				AlphaComposite alphaChannel = AlphaComposite.getInstance(
						AlphaComposite.SRC_OVER, 0.3f);
				g2d.setComposite(alphaChannel);
				BufferedImage logoImage;

				System.out.println("WaterMarkCreator - logo Image");
				logoImage = ImageIO.read(logoImageFile);
				// calculates the coordinate where the image is painted
				int topLeftX = (sourceImage.getWidth() - logoImage.getWidth()) / 2;
				int topLeftY = (sourceImage.getHeight() - logoImage
						.getHeight()) / 2;

				int width = sourceImage.getWidth() / 4;
				int height = sourceImage.getHeight() / 4;
				
				// paints the image watermark
				g2d.drawImage(logoImage, topLeftX, topLeftY, width, height, null);

				ImageIO.write(sourceImage, "png", destImageFile);
				g2d.dispose();

				System.out.println("The image watermark is added to the image.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Add Image Watermark - IOException");
				e.printStackTrace();
			}

	}

}




