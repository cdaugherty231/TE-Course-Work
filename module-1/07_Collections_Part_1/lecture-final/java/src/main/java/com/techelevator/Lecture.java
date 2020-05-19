package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
	
		
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> studentNames = new ArrayList<String>();
		studentNames.add("Andie");
		studentNames.add("Jacob");
		studentNames.add("Tim");
		studentNames.add("tien");
		

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		//for (datatype element_name : list or array)
		for(String student : studentNames) {
			System.out.println(student);
		}
		
		/*
		 * for (int i=0;i<studentNames.size();i++) {
		 *     String student = studentNames.get(i);
		 *     System.out.println(student);
		 *   }
		 */
		
		studentNames.add(0,"Conner"); //add coner first in the list at index 0
		System.out.println("Added Conner first");
		for(String student : studentNames) {
			System.out.println(student);
		}
		
		//can access by index
		System.out.println("the first item is "+ studentNames.get(0));
		
		//have the same in bounds requirements
		//System.out.println("the first item is "+ studentNames.get(20)); RUNTIME ERROR

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		studentNames.add("Conner");
		System.out.println("add conner again");
		for(String student : studentNames) {
			System.out.println(student);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		studentNames.add(3,"Cameron");
		System.out.println("add cameron at index 3");
		for(String student : studentNames) {
			System.out.println(student);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		studentNames.remove(5);
		System.out.println("removed index 5");
		for(String student : studentNames) {
			System.out.println(student);
		}
		
		studentNames.remove("Andie");
		System.out.println("removed Andie");
		for(String student : studentNames) {
			System.out.println(student);
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		System.out.println("Does list contain Rory?" + studentNames.contains("Rory"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		// String[] array =   (String[]) studentNames.toArray(); THIS GIVES AN ERROR
	
		String[] array =   (String[]) studentNames.toArray(new String[studentNames.size()]);
		//studentNames.add(1.2); can't add a double to a list of strings

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
	    //List<int> = new ArrayList<int>();  you cannot have a list of primitivese
		/*
		 * Java Primitive Type	Wrapper Class	Constructor Argument
			byte				Byte			byte or String
			short				Short			short or String
			int					Integer			int or String
			long				Long			long or String
			float				Float			float, double, or String
			double				Double			double or String
			char				Character		char
			boolean				Boolean			boolean or String
		 */
		List<Integer> myIntList = new ArrayList<Integer>();
		Integer i = new Integer("1");
	    int j = i; 
	    
	    /*
	     * Autoboxing is the automatic process of converting a primitive type to a reference type.
		   Unboxing is when an object is moved off of the heap and converted back into a primitive type or value type.

	     */
	    Integer myInt = 1; 
	    myIntList.add(5);

	    
	    List<Double> myDoubleList = new ArrayList<Double>();
	    myDoubleList.add(4.4);
	    myDoubleList.add(0,1.1);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		/*
		 * for (Datatype element_identifier : list) {
		 *    do something with element_identifier
		 *   }
		 */
		
		//get teh sum of all doubles in myDoubleList
		double sum = 0;
		for(double myDub : myDoubleList) {
			sum += myDub;
		}
		System.out.println("sum of all the doubles is "+sum);

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		//FIFO
		Queue<String> groceryStoreLine = new LinkedList<String>();
		groceryStoreLine.offer("Sarah");
		groceryStoreLine.offer("Jake");
		groceryStoreLine.offer("Steve");
		groceryStoreLine.offer("Rob");
		groceryStoreLine.offer("Deb");
		
		System.out.println("THere are "+groceryStoreLine.size()+" people in line");
		System.out.println("Who is next in line "+ groceryStoreLine.peek()); //see who's next, but don't remove
		
		//wait on Sarah so she should be removed from the queue
		System.out.println("Checking out "+groceryStoreLine.poll());
		groceryStoreLine.offer("Josh");
		
		System.out.println("Who is next in line "+ groceryStoreLine.peek()); //see who's next, but don't remove
		
		List<String> customers = new ArrayList<String>();
		//while loop to go through my queue
		while (groceryStoreLine.size()>0) {
			String serviceUser = groceryStoreLine.poll();
			//add the serviceuserto the list of customers
			customers.add(serviceUser);
			
			System.out.println("Checking out "+serviceUser); //grabs who's next and removes them from the queue
			System.out.println("Who is next in line "+ groceryStoreLine.peek()); //see who's next, but don't remove
		}
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		
		Stack<String> websitesVisited = new Stack<String>();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		websitesVisited.push("www.google.com");
		websitesVisited.push("www.cincinnati.com");
		websitesVisited.push("www.cnn.com");
		websitesVisited.push("www.techelevator.com");

		System.out.println("The stack contains "+ websitesVisited.size());
		
		System.out.println("On top of the stack "+ websitesVisited.peek());
		websitesVisited.push("www.slashdot.org");
		System.out.println("On top of the stack "+ websitesVisited.peek());

		////////////////////
		// POPPING THE STACK
		////////////////////
		String lastOne = websitesVisited.pop(); 
		System.out.println("Popped "+lastOne);
		
		System.out.println("On top of the stack "+ websitesVisited.peek());
		
		//loop to go through the whole stack
		while (websitesVisited.size()>0) {
			System.out.println("Popping "+websitesVisited.pop()); 
			//System.out.println("Popping "+websitesVisited.peek()); //infinite loop!
		}

	}
}
