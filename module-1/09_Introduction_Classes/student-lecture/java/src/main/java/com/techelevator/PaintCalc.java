package com.techelevator;

import java.util.Scanner;

public class PaintCalc {
	
	static Scanner scan = new Scanner(System.in);

	/* This program will allow the user to enter multiple walls by selecting 1 
	 * and then when they select 2 calculate paint needed based on how many walls they entered
	 * 
	 * To do: Create a class to keep track of the walls and use it appropriately
	 */
	public static void main(String[] args) {	
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
				int area = height * width;
				System.out.println("Added "+height+"x"+width+" wall - "+area+" square feet");
				
				//TODO: create an object to hold this wall and add it to a list
				
			} else if(userChoice.equals("2")) {
				
				// Here we need to sum up the areas of all walls that have been entered
				
				//To do - loop through our list and of walls and do the print and calc for realz
			
				System.out.println("Wall 1: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				System.out.println("Wall 2: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				System.out.println("Wall 3: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				System.out.println("Wall 4: 10x15 - 150 square feet"); // PROTOTYPE ONLY!!!
				
							
				int totalArea = 600; // PROTOTYPE ONLY!!!
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
