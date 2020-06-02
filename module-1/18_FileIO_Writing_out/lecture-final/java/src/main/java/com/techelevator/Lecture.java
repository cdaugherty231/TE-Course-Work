package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {
		
		Scanner userInput = new Scanner(System.in); //ONE SCANNER connected to System.in
		
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
		if (f.exists()) {//returns true if the file or directory exists
			System.out.println("name: "+f.getName());
			System.out.println("absolute path:"+ f.getAbsolutePath());
			if (f.isDirectory()) {
				System.out.println("type: directory");
			} else {
				System.out.println("type: file");
			}			
		}
		else {
			System.out.println(f.getAbsolutePath()+" does not exist");
		}
		
		
		/* 
		 * The File class also allows us to manipulate file system objects 
		 * */
		 
		/* ************************
		 * CREATING A DIRECTORY 
		 * ************************/
		System.out.println("let's create a directory!");
		System.out.println("enter path for new directory: ");
		String dirPath = userInput.nextLine();
		
		File newDirectory = new File(dirPath);
		if (newDirectory.exists()) {
			System.out.println("Sorry, that directory already exists");
		} else {
			//make the directory
			if (newDirectory.mkdir()) {
				System.out.println("Directory created successfully");
			} else {
				System.out.println("Directory creation failed.");
			}
		}
		
		
		 
		/* ************************
		 * CREATING A FILE 
		 * ************************/
		System.out.println("Let's create a file!");
		System.out.println("enter name for the file: ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory,fileName);
		
		System.out.println("created successfully? " + (newFile.createNewFile()? "yes":"no. error"));
		System.out.println("name: "+newFile.getName());
		System.out.println("size: "+newFile.length());
		 
		/* ************************
		 * WRITING TO A FILE 
		 * ************************/
		
		System.out.println("let's write something in the file!");
		PrintWriter writer = new PrintWriter(newFile);
		writer.println("some message to be stored in the file");
	
		System.out.println("that's all folks ");
		writer.close(); //this pushes everythign that was in the buffer to the file, aka dumps the bucket 
		
		//DEFAULT IS FILE IS OVERWRITTEN, NOT APPENDED
		
		try(PrintWriter anotherOne = new PrintWriter(newFile)){ //using the try-with-resource automatically closes the resource after the try
			anotherOne.println("Write a line");
			anotherOne.print("using print");
			anotherOne.print(" stays on same line just like the console!");
			anotherOne.println("somethign else");
		}
		catch (Exception e)
		{
			System.out.println("uh oh, something went wrong");
			System.out.println(e.getMessage());
		}
		
		try(PrintWriter anotherOne = new PrintWriter("k.txt")){ //using the try-with-resource automatically closes the resource after the try
			anotherOne.println("Write a line");
			anotherOne.print("using print");
			anotherOne.print(" stays on same line just like the console!");
			anotherOne.println("somethign else");
		}
		catch (Exception e)
		{
			System.out.println("uh oh, something went wrong");
			System.out.println(e.getMessage());
		}
		
		FileOutputStream fos = new FileOutputStream("k.txt",true); //true means open for append
		//FileOutputStream wants BYTES - yuck
  
         fos.write("append to the end".getBytes());    
         fos.close();    
         
         //what happens when you open a file that doesn't exist for writing?
         PrintWriter anotherOne = new PrintWriter("l.txt");
         anotherOne.println("if this worked then the program created the file");
         anotherOne.close();
         
         try {
	         PrintWriter anotherAnotherOne = new PrintWriter("dirNoExist/bla/j.txt");
	         anotherAnotherOne.println("if this worked then the program created the file");
	         anotherAnotherOne.close();
         }
         catch (FileNotFoundException e) {
        	 System.out.println("couldn't open file for writing.");
        	 System.out.println(e.getMessage());
         }
		
		System.out.println("Finished successfully");
	}

}
