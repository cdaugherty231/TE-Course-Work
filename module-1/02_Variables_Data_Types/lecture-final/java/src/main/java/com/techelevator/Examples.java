package com.techelevator;

public class Examples {

	public static void main(String[] args) {
		
		/*Java datatypes
		 * 
		 * boolean - true or false
		 * byte - -127 to 127
		 * char - /u000-/ufff ('a','b','c') - single  chars are surrounded by '
		 * int -   -2^31 to 2^31
		 * float - -3.4*10^38 to 3.4*10^35
		 * double - +-5 * 10^-324 to +-1.7 * 1-^308
		 * long - -2^63 to 2^63
		 */
		
		
		// Variable declaration
		int x;
		
		// Assignment statement
		x = 3;
		
		// We can also declare and assign in one statement
		int y = 5;
		
		boolean test = true;
		//boolean test2 = 5;  datatype and type of what i'm assigning it MUST MATCH
		
		String BADVARIABLENAME = "strings go in double quotes \n"; // \t is for tab
		char c = 'c';
		
		// variable names should start with a lower case letter and use camelCase
		int ageOfAdulthood = 18;
		
		//int 1StartWithNumber = 5; variable names cannot start with a number
		
		// literal values of type char appear between single quotes
		char theFirstLetter = 'a';
		
		// use floating point types like double to represent decimal values
		double averageNumberNumberOfChildren = 2.5;
		
		// three different types of assignment statements
		// 1) assigning a literal
		x = 2;
		// 2) assigning from another variable
		y = x;
		// 3) assigning the result of an expression
		y = x + 3;
		
		// ******************
		// LITERALS
		// ******************
		int myInt = 123;
		byte myByte = 3;
		//myByte = myInt;  // causes a compiler error because the int variable is capable of holding values that won't fit in a byte
		myInt = myByte;
		
		// Hexadecimal literals are preceded by 0x
		int twentySix = 0x1A;
		
		// String literals appear between double quotes
		String firstName = "John";
		String lastName = "Doe";
		// the + operator is used for String concatenation
		String fullName = firstName + " " + lastName;
		System.out.println("first name: "+firstName);
		System.out.println("last name: "+lastName);
		System.out.println("full name: "+fullName);
		
		int numberOfNETStudents = 8;
		int numberOfJavaStudents = 14;
		int totalNumberOfStudents = numberOfNETStudents + numberOfJavaStudents;
		System.out.println("totalNumberOfStudents is equal to: "+totalNumberOfStudents);
		
		// **********************
		// TRUNCATION AND CASTING
		// **********************
		
		int cookiesEaten = 10;
		int numberOfChildrenEatingCookies = 6;
		float averageCookiesEaten = cookiesEaten / numberOfChildrenEatingCookies; // the right hand side of this operation is evaluated as an int, so the fractional value is truncated
		System.out.println("Average Cookies Eaten: "+averageCookiesEaten);
		
		
	
		
		averageCookiesEaten = (float)cookiesEaten / numberOfChildrenEatingCookies; // here we "cast" an int variable to type float so that the result of the arithmetic operation is a float
		System.out.println("(casting to float) Average Cookies Eaten: "+averageCookiesEaten);
		
		int testIntValue = 5;
		double myDouble = testIntValue; 
		testIntValue = (int) myDouble; 
		
		double aDouble = 7.89;
		//int anInteger = aDouble;  // this is a compiler error
		int anInteger = (int)aDouble;  // this will truncate the fractional part of the double
		System.out.println(aDouble+" cast to an int is equal to: "+anInteger);
		
		
		// **********************
		// ARITHMETIC OPERATORS
		// **********************
		int a = 12;
		System.out.println("What happens to b?");
		int b = a + 3;  // ADDITION
		System.out.println(b);
		b = a - 5;  // SUBTRACTION
		System.out.println(b);
		b = a * 2;  // MULTIPLICATION
		System.out.println(b);
		b = a / 2;  // DIVISION
		System.out.println(b);
		
		// Modulus division
		int remainder = 10 % 3;
		System.out.println("The remainder of dividing 10 by 3 is "+remainder);
		
		remainder = 8 % 4;
		System.out.println("The remainder of dividing 8 by 4 is "+remainder);
		
		// ***********************
		// ESCAPE CHARACTERS
		// ***********************
		String emerilQuote = "Emeril said, \"Bam!\"";
		System.out.println(emerilQuote);
		
		System.out.println("To print \\ I need two backslashes");
		
		System.out.println("Hello!\n\nGoodbye!");  // The escape character for newline is \n
		
		System.out.println("Hello\tGoodbye"); // The escape character for tab is \t
		
		//Literal suffixes
		float fVar = 4.0f; 
		//option b 
		float fVar2 = (float)4.0; 
		
		//not clear why i'm using 60, 60 and 24. these are magic numbers
		int numSecondsInADay= 60*60*24; 
		
		//better
		int numSecondsPerMin = 60;
		int numMinPerHour = 60;
		int numHourPerDay = 24;
		
		int numSecondsPerDay = numSecondsPerMin*numMinPerHour*numHourPerDay; 
	}

}