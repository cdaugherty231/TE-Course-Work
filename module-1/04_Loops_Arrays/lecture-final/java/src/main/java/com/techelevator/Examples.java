package com.techelevator;

public class Examples {

	public static void main(String[] args) {
		
		int numStudentsInJava = 23; 
		/* Arrays*/
		// datatype[] identifier = new datatype[size of the array]
		String [] studentNames = new String[numStudentsInJava]; //array has indexes 0 through 22
		studentNames[0] = "Jake";
		studentNames[22]="Ben"; 
		
		//studentNames[23] = "error";
		System.out.println(studentNames[0]);
		
		int [] studentQuizScores = new int[numStudentsInJava];
		studentQuizScores[0]=100;
		studentQuizScores[1]=studentQuizScores[0];
		
		int[] array1 = new int[1];
		array1[0] = 1;
		
		int[] array2 = new int[1];
		array2[0] = 1;
		
		if (array1 ==  array2) {
			System.out.println("Arrays are equal");
		}
		
		int[]array3 = array2; 
		array3[0] = 4;
		
		System.out.println(array2[0]);
		
		int zero = 0;
		int sum = array1[zero] + array2[zero];
		array3[zero]=sum;
		
		//create and initialize at the same tiem
		int [] threeZeros = new int[3];
		threeZeros[0]=0;
		threeZeros[1]=0;
		//threeZeros[2]=0;
		
		//logically equiv to threeZeros
		int  []alsoThreeZeros = {0,0,0}; 
		alsoThreeZeros[0]=1;
		
		//can't use shortcut if you don't have all the elements even if you know the count
		
		int[] test1 = {1,2};
		int []test2 = {2,3,4};
		test2 = test1; 
		
		int x;
		int y;

		System.out.println("*******************************************");
		System.out.println("**** INCREMENT AND DECREMENT OPERATORS ****");
		System.out.println("*******************************************");
		System.out.println();

		/* The ++ operator increments a variable by 1 (i.e. adds one to the
		 * value of the variable and assigns the result to the variable) */
		x = 1;
		System.out.println("x == " + x);
		x++;
		System.out.println("x++ == " + x);
		System.out.println();

		/* The -- operator decrements a variable by 1 (i.e. subtracts one from the
		 * value of the variable and assigns the result to the variable) */
		x = 1;
		System.out.println("x == " + x);
		x--;
		System.out.println("x-- == " + x);
		System.out.println();

		// when the ++ is used as a postfix operator the increment is performed after evalutation
		System.out.println("x = 1");
		x = 1;
		System.out.println("y = x++");
		y = x++;
		System.out.println("x == " + x);
		System.out.println("y == " + y);
		System.out.println();

		// when the ++ is used as a prefix operator the increment is performed before evalutation
		System.out.println("x = 1");
		x = 1;
		System.out.println("y = ++x");
		y = ++x;
		System.out.println("y == " + y);
		System.out.println("x == " + x);
		System.out.println();

		System.out.println("****************************************");
		System.out.println("**** SHORTHAND ASSIGNMENT OPERATORS ****");
		System.out.println("****************************************");
		System.out.println();

		/* The "shorthand operators" are ( += -= *= ).  They have the
		 * effect of applying the arithmetic operator on the variable
		 * on the left and the expression on the right and then assigning
		 * the result to the variable on the left.
		 *
		 * So, this:
		 *
		 *     x = x + 2;
		 *
		 * Is equivalent to this:
		 *
		 *     x += 2;
		 */
		System.out.println("x = 0");
		x = 0;
		System.out.println("y = 0");
		y = 0;

		System.out.println("x += 5");
		x += 5;
		System.out.println("x == " + x);

		// the right hand side of the operator can be an expression
		System.out.println("y += x * 2 + 3");
		y += x * 2 + 3;
		System.out.println("y == " + y);
		System.out.println();

		System.out.println("*******************");
		System.out.println("**** FOR LOOPS ****");
		System.out.println("*******************");
		System.out.println();
		
		/* for loop syntax
		 * for (loop-start-condition; loop-continuation-condition (must be bool) ; end-of-loop-action) {
		 *     do some stuff in my loop
		 * }
		 * 
		 */

		System.out.println("Displaying the numbers 0 - 9 using a for loop");
		for (int ix = 0; ix < 10; ix++) {
			System.out.println(ix);
		}
		System.out.println();

		// Print whether each number between 1 and 10 (inclusive) is even or odd
		for (int ix = 1; ix <= 10; ix++) {
			if (ix % 2 == 0) {
				System.out.println(ix + " is even");
			} else {
				System.out.println(ix + " is odd");
			}
		}
		System.out.println();

		// loops can be nested
		System.out.println("Displaying the numbers 1 - 5, five times, using nested for loops");
		for (int ix = 0; ix < 5; ix++) {
			for (int jx = 1; jx <= 5; jx++) {
				System.out.println(jx);
			}
		}
		System.out.println();
		
		//can have mult start conditions seperated by commas and mutliptle continue conditions
		for (int i=0,j=20; i < j && x<100  ; i++, j-=3) {
			if (i%2==0) {
			  System.out.println("i: "+i+" j: "+j);
			}
		}

		System.out.println("****************");
		System.out.println("**** ARRAYS ****");
		System.out.println("****************");
		System.out.println();

		// the following line declares an array of Strings with 4 elements
		String[] fruit = new String[4];
		fruit[0] = "Apple";
		fruit[1] = "Orange";
		fruit[2] = "Banana";
		fruit[3] = "Pear";
		System.out.println("I have " + fruit.length + " fruits!");
		for (int index = 0; index < fruit.length; index++) {
			System.out.println("Item at index "+ index+ " is "+fruit[index]);
		}
		System.out.println();

		// the following array has length 3 even when no values have been assigned.
		String[] trees = new String[3];
		System.out.println("I have room for " + trees.length + " trees!");
		trees[1] = "Maple";
		System.out.println(trees[1]);
		for (int i=0; i<trees.length;i++) {
			System.out.println("i is "+i+ " trees[i] is " + trees[i] + " trees is " + trees);
		}

		int[] intArray = new int[] { 1, 2, 3 }; // this is how we declare an array literal
		for (int ix = 0; ix < intArray.length; ix++) {
			System.out.print(intArray[ix]);
		}
		System.out.println();
		System.out.println();

		// The same literal syntax would apply to an array of Strings
		String[] stooges = new String[] { "Larry", "Curly", "Moe" };
		for (int i=0; i<stooges.length; i++) {
			System.out.println(stooges[i]);
		}

		/* Arrays are Objects, so they are "passed by reference".  In other words. when assigning
		 * the value of one array variable to another array variable, we are assigning a reference
		 * to the same array to both */
		char[] firstArray = new char[] { 'a', 'b', 'c' };
		char[] secondArray = firstArray;

		secondArray[0] = 'z';
		System.out.println("firstArray[0]: " + firstArray[0]);
		System.out.println("secondArray[0]: " + secondArray[0]);
		
		//create an array of 41 quizscores and set them all to 100
		int[]quizScores = new int[41];
		for (int i=0; i<quizScores.length;i++)
		{
			quizScores[i]=100;
		}
		
		quizScores[13]=60;
		//get average quiz score
		//add them all up and then divide by length
		int quizScoreSum =0;
		for (int y1=0; y1<quizScores.length; y1++) {
			quizScoreSum += quizScores[y1];
		}
		double average = (double)quizScoreSum / quizScores.length; 
		System.out.println(average);
		
		//while loop
		// while (continuation-condition) {
		//   statments in the while
		// }
		
		int counter = 0;
		while (counter < 10) {
			System.out.println(counter);
			counter++;
		}
		
		//LOOPS DONT END WITH SEMICOLONS
		for (int i=0;i<10;i++); /*the loop is over. this is just a code block*/	{
			System.out.println("HERE");
		}
	}

}
