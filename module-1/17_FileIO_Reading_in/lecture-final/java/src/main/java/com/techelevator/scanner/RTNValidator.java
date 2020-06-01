package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)  {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		
		/*general format for reading from a file
		 * while (input.hasNextLine()) {
			    String line = input.nextLine();
			
			    // do something with input
			}
		*/
		
		if (inputFile != null) {
			//since the Scanner is in the paranthese as part of the try, it closes when try is over
			try(Scanner fileScanner = new Scanner(inputFile)) { 
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					String rtn = line.substring(0, 9);
					
					if(checksumIsValid(rtn) == false) {
						System.out.println(line);
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find file "+e.getMessage());
				e.printStackTrace();
			}
		}
		
		System.out.println("let's mess with the input file");
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
	
		File f = new File(path);
		Scanner readF = null;//declare it up here so it's in scope in finally
		try {
			readF = new Scanner(f); //this doesn't auto close
			while(readF.hasNextLine()) {//while there are still lines left
				String line = readF.nextLine();//read the next line 
				//do something 
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (readF != null) {
				readF.close();
			}
		}
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	private static File getInputFileFromUser() {
		//since the Scanner is in the paranthese as part of the try, it closes when try is over
		

			
			System.out.print("Please enter path to input file >>> ");
			String path = userInput.nextLine();
		
			File inputFile = new File(path);
			if(inputFile.exists() == false) { // checks for the existence of a file
				System.out.println(path+" does not exist");
				inputFile = null;
			} else if(inputFile.isFile() == false) {
				System.out.println(path+" is not a file");
				inputFile = null;
			}
		
			return inputFile;
		
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
