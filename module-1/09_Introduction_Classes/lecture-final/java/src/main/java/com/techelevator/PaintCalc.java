package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Encapsulation - the concept of hiding values or state of data within a class, limiting the points of access.
   Polymorphism - the ability for our code to take on different forms
   Inheritance - the practice of creating a hierarchy for classes in which descendants obtain the attributes and behaviors from other classes classes.
*/

public class PaintCalc {
	//PaintCalc - PascalCase - use for class names
	//paintCalc - camelCase
	
	//i can declare and instantiate class level variables
	static Scanner scan = new Scanner(System.in);
	private int classLevelVar = 1;
	
	//classLevelVar++; DON'T DO THIS. Code belongs in a method
	

	/* This program will allow the user to enter multiple walls by selecting 1 
	 * and then when they select 2 calculate paint needed based on how many walls they entered
	 * 
	 * To do: Create a class to keep track of the walls and use it appropriately
	 */
	public static void main(String[] args) {	
		
		//Practice just for fun
		Rectangle rect = new Rectangle();
		rect.setHeight(5);
		rect.setWidth(10);
		System.out.println("Height is "+rect.getHeight());
		System.out.println("Width is "+rect.getWidth());
		System.out.println("Area is "+rect.getArea());
		
		Rectangle r2 = new Rectangle();
		r2.setHeight(20);
		r2.setWidth( 200);
		
		System.out.println("r2 Height is "+r2.getHeight());
		System.out.println("r2 Width is "+r2.getWidth());
		
		Rectangle objectsAreReference = r2;
		System.out.println("objectsAreReference Height is "+objectsAreReference.getHeight());
		System.out.println("objectsAreReference Width is "+objectsAreReference.getWidth());
		
		Rectangle r3 = new Rectangle(4,4);
		
		System.out.print("Is R3 larger than r2?");
		System.out.println(r3.isLargerThan(r2));
		
		System.out.print("Is R3 larger than 2x2?");
		System.out.println(r3.isLargerThan(2,2));
		
		rect.thisIsBadDontDoThis = 5;; 
		
		System.out.println("All the rectangles "+ Rectangle.getAllTheRectanglesEver());
		
		r2.equals(r3);
		System.out.println(r2);
		
		System.out.println("Starting for realz now");
		
		//create my list of walls BEFORE the loop starts
		List<Rectangle> walls = new ArrayList<Rectangle>();
		//walls.add(new Rectangle(1,1)); we can add a new rectangle to the list
		
		//Rectangle.setWidth(5); DONT DO THIS when you have the red squiggly, the suggestion to fix IS WRONG
		
		boolean done = false;
		while(done == false) {
			
			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();
			
			System.out.println();
			
			if(userChoice.equals("1")) {
				
				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				
				Rectangle wall = new Rectangle(height,width);//the ORDER of the parameters matter, not their names here
				int area = wall.getArea();
				System.out.println("Added "+height+"x"+width+" wall - "+area+" square feet");
				
				walls.add(wall);
				
			} else if(userChoice.equals("2")) {
				
				// Here we need to sum up the areas of all walls that have been entered
							
				int wallNum =1; //this just makes pretty output
				int totalArea = 0;
				for(Rectangle wall : walls) {
					System.out.println("Wall "+ wallNum++ + ": "+wall.getHeight()+"x"+wall.getWidth()+" - "+wall.getArea()+" square feet");
					totalArea += wall.getArea();
				}
				
							
				
				System.out.println("===============================");
				System.out.println("Total Area: "+totalArea+" square feet");
				
				// 1 gallon of paint covers 400 square feet
				float gallonsRequired = (float)totalArea / 400;
				System.out.println("Paint Required: "+gallonsRequired+" gallons");
				
				done = true;
			}
		}		
	}

}
