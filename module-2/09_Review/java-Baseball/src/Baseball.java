import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {

		// prompt the coach for number of players
		System.out.println("Enter number of players on your team:");

		// read in the number of players
		Scanner input = new Scanner(System.in); // have ONE scanner that i use throughout
		String strNumPlayers = input.nextLine(); // don't use input.nextInt();

		// convert strNumPlayers to an int
		int numPlayers = Integer.parseInt(strNumPlayers);
		/* Long.parseLong, Double.parseDouble, Boolean.parseBoolean */

		// for every player
		// prompt for name, number of times at bat, number of hits
		List<BaseballPlayer> myTeam = new ArrayList<>();

		for (int i = 0; i < numPlayers; i++) {
			BaseballPlayer player = new BaseballPlayer();

			System.out.println("Enter player name: ");
			String name = input.nextLine();
			player.setName(name);
			System.out.println("Enter number of times at bat for " + name);
			String strAtBat = input.nextLine();
			int atBats = Integer.parseInt(strAtBat);
			player.setAtBats(atBats);

			int hits = atBats + 1;
			while (hits > atBats) {
				System.out.println("Enter number of hits for " + name + " (must be less than at bats)");
				String strHits = input.nextLine();
				hits = Integer.parseInt(strHits);
				player.setHits(hits);
			}

			int jerseyNum = -1;
			boolean jerseyNumOk = false;
			//continue in the loop while the jersey num is invalid
			while (!jerseyNumOk) {
				System.out.println("Enter jersey number for " + name);
				String strJ = input.nextLine();
				jerseyNum = Integer.parseInt(strAtBat);
				jerseyNumOk = player.setJerseyNumber(jerseyNum);
			}

			myTeam.add(player);
		}

		System.out.println("Your player list: ");
		// print all players and batting average

		// lets also figure out the highest batting average as we go
		BaseballPlayer playerWithBestAverage = (myTeam.size() > 0) ? myTeam.get(0) : null;
		for (BaseballPlayer player : myTeam) {
			// figure out batting average
			double battingAverage = player.getBattingAverage();

			if (battingAverage > playerWithBestAverage.getBattingAverage())
				playerWithBestAverage = player;

			// s is string, f is double, d is integer
			System.out.format("Player name: %-10s Batting average: %.3f \n", player.getName(), battingAverage);

		}

		// print player with best batting average
		if (playerWithBestAverage != null) {
			System.out.format("%s has the highst batting average of %.3f", playerWithBestAverage.getName(),
					playerWithBestAverage.getBattingAverage());

		}
		/*
		 * Some string stuff you need for your homework String str2 = "a"; str2 += "bc";
		 * String str1 = "abc"; System.out.println("String 1 is "+str1 +
		 * " string 2 is "+str2); System.out.println("String equality test ==: "
		 * +areStringsEqualUsingEqualsEquals(str1,str2));
		 * System.out.println("String equality test .equals: "
		 * +areStringsEqualUsingDotEquals(str1,str2));
		 * 
		 * String url = "www.techelevator.com"; String [] myArray = url.split("\\.");
		 * 
		 * System.out.println(myArray[0]);
		 * 
		 * String sentence = "this!is!a!sentence."; String [] words =
		 * sentence.split("!"); System.out.println(words[1]);
		 */

	}

	public static boolean areStringsEqualUsingEqualsEquals(String s1, String s2) {
		return s1 == s2;
	}

	public static boolean areStringsEqualUsingDotEquals(String s1, String s2) {
		return s1.equals(s2);
	}

}
