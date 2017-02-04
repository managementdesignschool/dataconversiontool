package com.tjgwebservices.app.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ParseCSV extends ActionsBase {
	private CSVReader reader;
	private String pathName;

	public ParseCSV(){
	}
	
	public ParseCSV(String path){
		setPathName(path);
		try {
			setReader(new CSVReader(new FileReader(path)));
		} catch (FileNotFoundException e) {
			try {
				throw new Exception("path not found.");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public boolean readCSV() {
	    String [] nextLine;
	    try {
			while ((nextLine = reader.readNext()) != null) {
			   // nextLine[] is an array of values from the line
			   System.out.println(nextLine[0] + nextLine[1] + "etc...");
			}
		} catch (IOException e) {
			try {
				throw new Exception("Unable to read csv " + e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				return false;	
			}
		}
		return true;	
	}
	
	public boolean writeCSV(String[] entries, String outputPath) {
	    CSVWriter writer;
	    
	    boolean alreadyExists = new File(outputPath).exists();
		try {
			writer = new CSVWriter(new FileWriter(outputPath, true), ',');
		    writer.writeNext(entries);
		    writer.close();
		} catch (IOException e) {
			try {
				throw new Exception("Unable to write CSV.");
			} catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
		}
	    return true;
	}
	 
	public CSVReader getReader() {
		return reader;
	}

	public void setReader(CSVReader reader) {
		this.reader = reader;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

    
}
