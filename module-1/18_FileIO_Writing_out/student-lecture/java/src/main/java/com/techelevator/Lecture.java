package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {
		
		Scanner userInput = new Scanner(System.in);
		
		/* 
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and 
		 * modify file system objects.
		 * 
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 * 
		 * A new instance of File can be created from a String that contains a file system path 
		 */
		
		System.out.print("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine();
		File f = new File(path);

		/* 
		 * The File class allows us to inspect various attributes of a file system object 
		 */
		 
		/* ***************************
		 * INSPECTING THE FILESYSTEM 
		 * ***************************/
		
		
		/* 
		 * The File class also allows us to manipulate file system objects 
		 * */
		 
		/* ************************
		 * CREATING A DIRECTORY 
		 * ************************/
		
		
		 
		/* ************************
		 * CREATING A FILE 
		 * ************************/
		
		
		
		 
		/* ************************
		 * WRITING TO A FILE 
		 * ************************/
		
		
		
	}

}
