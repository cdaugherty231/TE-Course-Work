import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		
		String test = null;
		
		//if (test != null) this is preferable to trying to catch a null pointer exception
		
		//prompt the coach for number of players
		System.out.println("Enter number of players on your team:");
		
		//read in the number of players
		Scanner input = new Scanner(System.in); //have ONE scanner that i use throughout
		String strNumPlayers = input.nextLine(); //don't use input.nextInt();
		
		
		int numPlayers=0;
		try {
			//convert strNumPlayers to an int		
			numPlayers = Integer.parseInt(strNumPlayers);		
			/* Long.parseLong, Double.parseDouble, Boolean.parseBoolean */
			if (numPlayers < 0) {
				throw new Exception("number of players must be positive.");
			}
		}
		catch(NumberFormatException e) { //if they entered a string
			System.out.println("You did not enter an integer. Assuming 0 players.");
		} catch (Exception e) { //if they entered a negative number and we threw our own exception
			System.out.println("It doesn't make sense to have negative players. Assuming 0 players.");
			numPlayers=0;
		}
		
	    //for every player
		//prompt for name, number of times at bat, number of hits
		String[] playerNames = new String[numPlayers];
		int[] playerAtBats = new int[numPlayers];
		int[] playerHits = new int[numPlayers];
		
		for (int i=0; i<numPlayers; i++) {
			System.out.println("Enter player name: ");
			String name = input.nextLine(); 
			playerNames[i] = name;
			
			int atBats=-1;
			while( atBats<0) {
				String strAtBat = GetTimesAtBat(input, name);
				try {
					atBats = Integer.parseInt(strAtBat);
					System.out.println("Integer was entered.");
				}
				catch(NumberFormatException e) { //code will come here if the parse failed
					System.out.println("Please enter a positive integer.");
					atBats = -1; //stay in the loop
				}
				System.out.println("End of atBats loop");
			}
			
			playerAtBats[i] = atBats;
			
			int hits = atBats+1; 
			while (hits>atBats) {
				
				hits = GetPositiveInteger(input,"Enter number of hits for "+name +" (must be less than at bats)");
			
				playerHits[i] = hits;
			}
			
		}
		
		System.out.println("Your player list: ");
		//print all players and batting average
		
		//lets also figure out the highest batting average as we go
		int indexHighestBattingAverage = 0; 
		for (int i=0; i<numPlayers; i++) {
			//figure out batting average
			double battingAverage = CalculateBattingAverage(playerHits[i],playerAtBats[i]);
			
			if (battingAverage > CalculateBattingAverage(playerHits[indexHighestBattingAverage],playerAtBats[indexHighestBattingAverage]))
				indexHighestBattingAverage = i; 
			
			// s is string, f is double, d is integer
			System.out.format("Player name: %-10s Batting average: %.3f \n", playerNames[i],battingAverage);
	
		}
		
		//print player with best batting average
		if (playerNames.length > 0){
		  System.out.format("%s has the highst batting average of %.3f",
				playerNames[indexHighestBattingAverage],
				CalculateBattingAverage(playerHits[indexHighestBattingAverage],playerAtBats[indexHighestBattingAverage]));
		
		}
		/* Some string stuff you need for your homework*/
		String str2 = "a";
		str2 += "bc";
		String str1 = "abc";
		System.out.println("String 1 is "+str1 + " string 2 is "+str2);
		System.out.println("String equality test ==: "+areStringsEqualUsingEqualsEquals(str1,str2));
		System.out.println("String equality test .equals: "+areStringsEqualUsingDotEquals(str1,str2));
		
		String url = "www.techelevator.com";
		String [] myArray = url.split("\\.");
		
		System.out.println(myArray[0]);
		
		String sentence = "this!is!a!sentence.";
		String [] words = sentence.split("!");
		System.out.println(words[1]);

	}

	/**
	 * @param input
	 * @param name
	 * @return
	 */
	private static String GetTimesAtBat(Scanner input, String name) {
		System.out.println("Enter number of times at bat for "+name);
		String strAtBat = input.nextLine();
		return strAtBat;
	}
	
	private static int GetPositiveInteger(Scanner input, String message) {
		System.out.println(message);
		String str = input.nextLine();
		int intValue = -1;
		try {
			intValue = Integer.parseInt(str);
			if (intValue<0) {
				//either yell at them and re-prompt by calling the method again
				//or just go ahead and throw and go to the catch
				throw new NumberFormatException("POSTIVE");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("I SAID A POSITIVE INTEGER!");
			return GetPositiveInteger(input,message);
		}
				
		return intValue;
	}
	
	
	public static double CalculateBattingAverage(int hits, int timesAtBat) {
		//check for divide by zero first
		if (timesAtBat==0)
		{
			return 0;
		}
		
		double battingAverage = (double)hits / timesAtBat; 
		return battingAverage;
	}
	
	public static boolean areStringsEqualUsingEqualsEquals(String s1, String s2)
	{
		return s1==s2;
	}
	
	public static boolean areStringsEqualUsingDotEquals(String s1, String s2)
	{
		return s1.equals(s2);
	}

}
