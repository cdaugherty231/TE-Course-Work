package com.techelevator;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 	
	
		
		String s1 = new String("test"); 
		String s2 = "test"; //shortcut from java since we use string all the time
		
		//to call an objects method
		//identifier/name of the object followed immediately by a period and then the name of the method
		System.out.println("type something");
		String strInput = input.nextLine(); //input is my object, we are calling nextLine
		
		Scanner in2;
		//in2.nextLine(); you can't call a method on an object until after you've INSTANTIATED it with the new keyword
		
		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String theString = "this is a literal string"; 
		theString = "change the string"; //this allocates a whole new piece of memory on the heap 
		//and changes the reference variable to point to the new spot in memory

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();
		
		// String methods that we call on objects: length, substring, indexOf, charAt, contains
		System.out.println("the length of "+theString+" is "+theString.length());
		System.out.println("first 5 characters of the string are: "+theString.substring(0,5));
		//System.out.println("first 5 characters of the string are: "+theString.substring(18,5)); runtime error
		
		int foundTheAtIndex = theString.indexOf("the"); //returns -1 if not found
		System.out.println("Found the at "+foundTheAtIndex);
		
		//how many the's are in my string? 
		int count = countOccurences(theString, "the");
		System.out.println("Count of the: "+count);

		count = countOccurences(theString, "g");
		System.out.println("Count of g: "+count);
		
		char myChar = theString.charAt(3); //this will give us a runtime error if the index is bigger than the string lenght
		System.out.println("Character at index 3 is: "+myChar);
		
		String allThes = "the athedjfkajsdf;thefj;adksfjathefa;djfakthe";
		count = countOccurences(allThes,"the");

		System.out.println("the length of "+allThes+" is "+allThes.length());
		System.out.println("first 5 characters of the string are: "+allThes.substring(0,5));
		
		//contains is going to be true or false ifthe string contains the parameter
		boolean test = allThes.contains(theString);
		
		String alphabet= "abcdefg";
		String a = "a";
		System.out.println("Does a contain alphabet? "+a.contains(alphabet)); 
		System.out.println("Does alpabet contain a? "+alphabet.contains(a)); 
		
		alphabet.toUpperCase(); //strings are immutable. we did NOT change alphabet
		System.out.println(alphabet);
		
		alphabet = alphabet.toUpperCase();  //we set alpha reference to the new string
		System.out.println(alphabet);
		System.out.println(alphabet.length());
		
		System.out.println(theString.toUpperCase());//this prints the string that's returned from toUpperCase
		System.out.println(theString);//but we didn't actually modify theString
		
		System.out.println(theString.replace("e", "!%^$#$DK")); //print the string that's returned from replace
		System.out.println(theString); //replace did NOT modify our original string
		
		// replace("a","b"); I have to have an object that's replace is getting called on/for

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();



		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		String hello1 = "hello";
		String start = "hel";
		String end = "lo";
		String hello2 = start+end;
		if (hello1 == hello2) { //== tests if they are pointing to the same place on the heap
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}

	/**
	 * @param theString
	 * @param searchFor
	 * @return
	 */
	private static int countOccurences(String theString, String searchFor) {
		int foundTheAtIndex = theString.indexOf(searchFor);
		int count=0;
		while (foundTheAtIndex != -1) {
			count++;
			foundTheAtIndex = theString.indexOf(searchFor,foundTheAtIndex+1);
		}
		return count;
	}
}
