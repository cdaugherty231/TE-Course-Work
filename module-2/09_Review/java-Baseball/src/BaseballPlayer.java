import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class BaseballPlayer {
	
	private String name;
	private int atBats;
	private int hits;
	private int jerseyNumber;
	private Rating rating; 
	
    public static enum Position {
		    CATCHER,
		    PITCHER,
		    SHORTSTOP,
		    FIRSTBASE
		  }
    
    public static enum Rating {
	    LOW,
	    MEDUIM,
	    HIGH
	  }
	
	//all of my jersey numbers must be between 0 and 99
	public static final int MIN_JERSEY_NUM = 0;
	public static final int MAX_JERSEY_NUM = 99;
	
	//pretending players on differnt team can't have same jersey number
	public static final Set<Integer> takenJerseyNums = new TreeSet<Integer>();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the atBats
	 */
	public int getAtBats() {
		return atBats;
	}
	/**
	 * @param atBats the atBats to set
	 */
	public void setAtBats(int atBats) {
		this.atBats = atBats;
		setRating();
	}
	/**
	 * 
	 */
	private void setRating() {
		if (getBattingAverage() < .1) {
			rating = Rating.LOW;
		} else if (getBattingAverage() < .2)
			rating = Rating.MEDUIM;
		else rating = Rating.HIGH;
	}
	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}
	/**
	 * @param hits the hits to set
	 */
	public void setHits(int hits) {
		this.hits = hits;
		setRating();
	}
	/**
	 * @return the jerseyNumber
	 */
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	/**
	 * @param jerseyNumber the jerseyNumber to set
	 * @Returns true if the jersey number is in the appropriate range and unused
	 * false and does NOT update jersey number if unnacceptable
	 */
	public boolean setJerseyNumber(int jerseyNumber) {
		if (isInRange(jerseyNumber) && isAvailable(jerseyNumber)) {
			this.jerseyNumber = jerseyNumber;
			takenJerseyNums.add(jerseyNumber);
			return true;
		}
		return false;
	}
	/**
	 * @param jerseyNumber
	 * @return
	 */
	private static boolean isAvailable(int jerseyNumber) {
		return !takenJerseyNums.contains(jerseyNumber);
	}
	
	/**
	 * @param jerseyNumber
	 * @return
	 */
	private boolean isInRange(int jerseyNumber) {			
		return jerseyNumber > MIN_JERSEY_NUM && jerseyNumber < MAX_JERSEY_NUM;
	}

	
	public double getBattingAverage() {
		//check for divide by zero first
		if (atBats==0)
		{
			return 0;
		}
		
		double battingAverage = (double)hits / atBats; 
		return battingAverage;
	}
	
	public static int generateRandomJerseyNumber() {
		Random rand = new Random();
		int jerseyNum = 0;
		while (true) {
			jerseyNum = rand.nextInt(MAX_JERSEY_NUM); //parameter is upper bound for random number generator
			if (isAvailable(jerseyNum)) {
				break;
			}
		}
		return jerseyNum;
	}

}
