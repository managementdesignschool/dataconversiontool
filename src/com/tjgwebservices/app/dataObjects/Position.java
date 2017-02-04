package com.tjgwebservices.app.dataObjects;

public enum Position {

	TOP_LEFT("0,0"),
	TOP_RIGHT("0,100"),
	BOTTOM_LEFT("100,0"),
	BOTTOM_RIGHT("100,100"),
	CENTER("50,50");
	
	private final String position;
	private Position(final String p) { position = p; }
	public String toString() { return position; }
	
	

}
