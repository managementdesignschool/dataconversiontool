package com.tjgwebservices.app.Actions;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.tjgwebservices.app.dataObjects.Image;

public class ParseXML extends ActionsBase {

	public ParseXML() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Image> parseXML(String path){
		System.out.println("ParseXML");
		ArrayList<Image> images=new ArrayList<Image>();
		XPath xpath = XPathFactory.newInstance().newXPath();
	    InputSource inputSource = new InputSource(path);
        Reader reader = inputSource.getCharacterStream();
        String contents = reader.toString();
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(contents);
            String jsonPrettyPrintString = xmlJSONObj.toString(4);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
    		System.out.println("JSON Exception");
            System.out.println(je.toString());
			je.printStackTrace();
        }
	    try {
		    String xmlString = xpath.evaluate("//images", inputSource);
		    
		} catch (XPathExpressionException e1) {
			// TODO Auto-generated catch block
    		System.out.println("ParseXML - XPath Exception");
			e1.printStackTrace();
		}
	    
	    Image xmlImage = new Image();
	    try {
			NodeList imageBlocks = (NodeList) xpath.compile("//images//image").evaluate(inputSource, XPathConstants.NODESET);
			int nodeSize = imageBlocks.getLength();
			for (int i=0; i<nodeSize; i++) {
			    try {
			    	xmlImage.setImageID(Integer.valueOf(xpath.evaluate("//image["+i+"]//id", inputSource)));
			    	xmlImage.setPath((xpath.evaluate("//image["+i+"]//imagePath", inputSource)));
			    	xmlImage.setLogoID(Integer.valueOf(xpath.evaluate("//image["+i+"]//logoID", inputSource)));
			    	xmlImage.setLogoPosition(xpath.evaluate("//image["+i+"]//logoPosition", inputSource));
			    	xmlImage.setTextID(Integer.valueOf(xpath.evaluate("//image["+i+"]//textID", inputSource)));
			    	xmlImage.setFontID(Integer.valueOf(xpath.evaluate("//image["+i+"]//fontID", inputSource)));
					xmlImage.setPath((xpath.evaluate("//image["+i+"]//imagePath", inputSource)));
					xmlImage.setImageObject(ImageIO.read(new URL(xmlImage.getPath())));
				} catch (XPathExpressionException | IOException e) {
		    		System.out.println("ParseXML - XPath Exception");
					e.printStackTrace();
				}
			}
			
		} catch (XPathExpressionException e1) {
			// TODO Auto-generated catch block
    		System.out.println("ParseXML - XPath Exception");
			e1.printStackTrace();
		}
	return images;	
	}
	
}
