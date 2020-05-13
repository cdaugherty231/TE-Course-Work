package com.techelevator;

public class Examples {

	public static void main(String[] args) {
		
		/* Review Section */
		//casting and literal suffixes and type conversion
		
		//not losing any data here
		int intVal = 5;
		double doubleVal = intVal; 
		
		//now I'm losing data so i have to reassure the compiler
		//with an explicit cast that i really want to do it
		doubleVal = 5; 
		intVal = (int) doubleVal ; 
		
		//since a literal decimal number is automatically a double (15 decimal places)
		//we have to cast or use a literal suffix to assign to a float (5 decimal places)
		float floatVal = (float) 5.0; 	
		float floatVal2 = 5.0f; 
			
		//intVal = 5.0; the compiler knows that 5.0 is a double and thinks you'll lose data converting double to int
		
		int x1;
		int y1 = 5 + 1; 
		int area = (5*9+1) * (2-3); 
		
		//post and pre increment/decrement
		intVal++; 
		//same as intVal = intVal + 1;
		//intVal += 1; 
		intVal--;
		
		//preincrement and decrement
		++intVal; 
		
		int test = 5;
		System.out.println("Preincrement test: "+ (++test)); //increment first, then print
		System.out.println("test is " + test);
		
		test =5;
		System.out.println("Post increment test: "+ (test++)); //print first, then increment
		System.out.println("test is " + test);
		
		test = 5;
		int testB = test++;  //test would be 6 and testB would be 5

		/* End of Review Section */
		//call a method
		sayHi("Katie");
		
		
		// declaration statement for a variable named "result" of type boolean
		boolean result;

		System.out.println("****************************");
		System.out.println("*** COMPARISON OPERATORS ***");
		System.out.println("****************************");
		System.out.println();
		/*
		 ==  Equal to
		 !=  Not equal to
		*/
		result = 2 == 2;
		System.out.println("2 == 2 : " + result);
		result = (2 == 3);
		System.out.println("2 == 3 : " + result);
		result = ('a' == 'a');
		System.out.println("'a' == 'a' : " + result);
		result = ('a' == 'b');
		System.out.println("'a' == 'b' : " + result);
		result = (2 != 2);
		System.out.println("2 != 2 : " + result);
		result = (2 != 3);
		System.out.println("2 != 3 : " + result);
		result = ('a' != 'a');
		System.out.println("'a' != 'a' : " + result);
		result = ('a' != 'b');
		System.out.println("'a' != 'b' : " + result);
		System.out.println();
		
		result = 2 + 1 == 2 + 3;
		//does 3 equal 5? result will be false
		result = (2 + 1) == (2 + 3);

		/*
		 >  Greater than
		 <  Less than
		 >= Greater than or equal to
		 <= Less than or equal to
		*/
		result = (2 > 1);
		System.out.println("2 > 1 : " + result);
		result = (2 < 2);
		System.out.println("2 < 2 : " + result);
		result = (2 < 2);
		System.out.println("2 < 2 : " + result);
		result = (2 <= 3);
		System.out.println("2 <= 3 : " + result);
		result = (5 >= 5);
		System.out.println("5 >= 5 : " + result);
		System.out.println();

		System.out.println("*************************");
		System.out.println("*** LOGICAL OPERATORS ***");
		System.out.println("*************************");
		System.out.println();
		/*
		 &&  AND
		 ||  OR
		 !  NOT
		 ^  XOR  (exclusive OR)
		 */
		result = true && true;
		System.out.println("true && true : " + result);
		result = true && false;
		System.out.println("true && false : " + result);
		result = false && false;
		System.out.println("false && false : " + result);

		result = true || true;
		System.out.println("true || true : " + result);
		result = true || false;
		System.out.println("true || false : " + result);
		result = false || false;
		System.out.println("false || false : " + result);

		result = !true;
		System.out.println("!true : " + result);
		result = !false;
		System.out.println("!false : " + result);

		result = true ^ true;
		System.out.println("true ^ true : " + result);
		result = true ^ false;
		System.out.println("true ^ false : " + result);
		result = false ^ false;
		System.out.println("false ^ false : " + result);
		System.out.println();

		System.out.println("***************************");
		System.out.println("*** BOOLEAN EXPRESSIONS ***");
		System.out.println("***************************");
		System.out.println();

		int value = 100;
		result = (value > 200) || (value < 500);
		System.out.println("(value > 200) || (value < 500) : " + result);

		result = (value > 200) && (value < 500);
		System.out.println("(value > 200) && (value < 500) : " + result);

		result = !(value >= 300);
		System.out.println("!(value >= 300) : " + result);

		System.out.println("*******************************");
		System.out.println("*** SHORT CIRCUIT OPERATORS ***");
		System.out.println("*******************************");
		System.out.println();

		int x = 3;
		int y = 0;
		//result =  (x / y) > 2 && (y > 0);  // causes a divide by zero exception to be thrown
		result = (y > 0) && (x / y) > 2; //since this is an and and (y>0) is false, then the && will be false since the left is false so it doesn't evaluate the right
		System.out.println(result);
		
		//if you have an || statement, if the left is True then it doens't evaluate the right becuase the or is true		

		
		//order matters
		result = false && false ||  true;
		System.out.println("false && false ||  true : " + result);
		
		result = (false && true) || true; //true 
		result = false && (true || true); //false

		System.out.println("*******************************");
		System.out.println("*** IF STATEMENTS ***");
		System.out.println("*******************************");
		System.out.println();

		//----------------------------------------------------

		System.out.println("*** Basic if statement ***");
		
		/*
		 * if (exp) {
		 * 
		 *    execute if exp is true
		 *   }
		 *  else { this whole else is optional
		 *    execute if exp is false
		 *   }
		 */

		int freezingPointFahrenheit = 32;
		int outsideTempFahrenheit = 80;
		//if the if or the else are only one statement, the brackets are optional, BUT ARE BEST PRACTICE
		if (outsideTempFahrenheit <= freezingPointFahrenheit) 
			System.out.println("Would you like a nice hot cup of coffee?");			
		 else 
			System.out.println("Would you like a cool, refreshing iced mocha?");
		
		//just have an if and no else
		if (5<10)
			System.out.print("this prints");
		    System.out.print("this will always print regardless of the if statement"); //this IS NOT INSIDE THE IF BLOCK
		

		//----------------------------------------------------

		System.out.println("*** if-else statement ***");

		boolean condition1 = true;
		boolean condition2 = true;
		if (condition1) {
			System.out.println("Condition 1 is true!");
		} else if (condition2) {
			System.out.println("Condition 2 is true!");
			if(5<10)
			{
				System.out.print("5 is less than 10");
			}
		} else {
			System.out.println("No conditions are true!");
		}

		//----------------------------------------------------

		System.out.println("*** a boolean variable is valid boolean expression ***");

		boolean isSunny = true;
		if (isSunny) {
			System.out.println("Better wear some sun screen...");
		}

		//----------------------------------------------------

		System.out.println("*** if statements can be used with blocks ***");

		if (outsideTempFahrenheit > freezingPointFahrenheit) {
			System.out.println("Summer time!!!");
		} else {
			System.out.println("Dress in layers");
			System.out.println("Wear gloves");
			System.out.println("Wear hat");
			System.out.println("Wear scarf");
		}
		

		if (5<120 || 68+1 > 3 && 5<9 && condition1 || condition2)
			System.out.println("this if statement is true but gross");
		
		boolean helper = 5<120 || 68+1 > 3 && 5<9; //whatever be a helper to make my code more readable
		if (helper && condition1 || condition2)
			System.out.println("this if statement is true and less gross");
		
		if ( (helper && condition1) || condition2)
			System.out.println("this if statement is true and not gross");
		
	

		System.out.println("*******************************");
		System.out.println("*** VARIABLE SCOPE ***");
		System.out.println("*******************************");
		System.out.println();

		int firstVariable = 2;
		if (firstVariable > 0) {
			int secondVariable = firstVariable;
		}
		//int thirdVariable = secondVariable * 2; // this will cause a compile error because secondVariable is not "in scope"
		//int firstVariable = 3;  // this is a compiler error because we already have a variable named firstVariable in this scope
		int secondVariable = 7; // this is allowed because there is no variable named secondVariable in this scope

		boolean burnItDown = shouldBurnDownTheBuilding(14, 20);
	}

	static boolean shouldBurnDownTheBuilding(int numberOfEmployees, int piecesOfCake) {
		if (numberOfEmployees > piecesOfCake) {
			return true;
		} else {
			return false;
		}
	}
	
	//methods that return nothing are void
	public static void sayHi(/*parameters go in the parentheses*/ String name) {
		System.out.println("Hi, "+name);
		
	}
}
