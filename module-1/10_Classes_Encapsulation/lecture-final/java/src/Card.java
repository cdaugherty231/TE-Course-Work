import java.util.LinkedHashMap;
import java.util.Map;



//Card class that has a face value and suit
public class Card {
	
	/*Encapsulation is: - The packaging of data and functions into a single component - 
	 * Hiding the implementation details of a class to prevent other parties from setting the data
     * to an invalid or inconsistent state and also reduce coupling
	 */

	//we're goign to want to print this as a string and use it as an int	
	private int value; //this represents 1 for A, 2, 3, 4,... 
	
	//static means it's class level so can be accessed by class name and shared between objects
	private static Map<Integer,String> valueMap = new LinkedHashMap<Integer,String>();
	
	//do we see the front or back of the card
	private boolean faceUp; 
	
    private String suit; //this will be Hearts, Diamonds, Clubs or Spades or Joker
    
    public Card(int value, String suit) {
    	//all cards default to face down
    	faceUp = false;
    	this.value = value;
    	this.suit = suit; 
    	    	    	
    	//add to value map all of the values 1-13
    	Integer ace = new Integer(1);
    	valueMap.put(ace,"Ace");
    	for (int i=2; i<=10;i++) { //for 2 through 10
    		Integer nextInt = new Integer(i);
    		valueMap.put(nextInt,nextInt.toString());
    	}
    	valueMap.put(new Integer(11),"Jack"); //i don't have to assign the new integer to a reference var, i can just pop it in the list
    	valueMap.put(new Integer(12),"Queen");
    	valueMap.put(new Integer(13),"King");
    }
    
    /* what behavior/methods should a card have */
    //flip, get the color, see what it is
    //determine if one card is greater than another (boolean for aceHigh)
    //return result of adding two cards together
    
    public boolean flip() {
    	faceUp = !faceUp; 
    	return faceUp; 
    }
    
    
    @Override
    public String toString() {
    	if (faceUp) {
    		return getCardNameForValue(value) + " of "+suit;
    	}
    	else {
    		return "Back of the card";
    	}
    }
    
    //i'll let people look up the value of the card by the map
    //static methods are shared and can be called the class name
    //i can only access static data from static methods
    public static String getCardNameForValue(int value) {
    	if (valueMap.containsKey(value))
    		return valueMap.get(value);
    	return "unknown";
    }

}
