package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {

	private int height;
	private int width; 
	
	//static means that it's shared between ALL OBJECTS and can be accessed from the class name
	//DO NOT USE STATIC UNLESS YOU UNDERSTAND WHAT ITS DOING AND REALLY MEAN TO 
	private static int  allTheRectanglesEver =0; 
	public static int getAllTheRectanglesEver() { return allTheRectanglesEver;}
	
	public int thisIsBadDontDoThis; //DON'T DO THIS
	
	//if i don't have any constructors,i automatically get one that does nothing
	//default no-arg constructor
	// if i add another constructor, then i have to define this method explicitly	
	public Rectangle() {
		height = 0;
		width = 0;
		allTheRectanglesEver++;
	}
	
	/* A constructor is called ALWAYS AND ONLY when a new object is created
	 * constructors are PUBLIC, no return value
	 */
	public Rectangle(int height, int width) {
		setHeight(height);
		setWidth(width);
		allTheRectanglesEver++;
	}
	
	/* THIS IS FORBIDDEN because they have the same signature
	public Rectangle(int width, int height) {
		setHeight(height);
		setWidth(width);
	}
	*/
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		if (height>0) {
			this.height = height;
			//height = height; DONT DO THIS  this is settign the parameter to the parameter 
			//height = this.height; DONT DO THIS very common programming mistake
		}
		
	}
	
	public int getWidth() {
		return width; 
	}
	
	public void setWidth(int w) {
		if (w>0) {
			width = w;
		}
	}
	
	public int getArea() {
		return width*height;
	}
	
	//overloaded - An overloaded function is the ability to create multiple functions with the same name and return type. 
	//The parameter signature must be different.
	
	public boolean isLargerThan(Rectangle r) {
		return getArea() > r.getArea();
	}
	public boolean isLargerThan(int width, int height) {
		return getArea() > width * height; 
	}
	
	@Override
	public boolean equals(Object rect) {
		return this.height == ((Rectangle) rect).getHeight() &&  this.width == ((Rectangle) rect).getWidth();
	}
	
	@Override
	public String toString() {//stringification
		return "Height: "+height+" Width: "+width; 
	}
}
