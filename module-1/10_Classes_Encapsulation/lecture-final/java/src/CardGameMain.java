
public class CardGameMain {
	
	//final means that it can't be changed
	//i can't access class vars that are static from a method that is not
	//final vars are UPPERCASE and words seperated by underscore
	public static final double PI = 3.14;
	public static final int HOURS_PER_DAY = 24;//consts are often used instead of magic numbers
	
	//using final with reference vars is weird DONT DO IT. The REFERENCE won't change but the object still can
	public static final Deck FINAL_DECK = new Deck();

	public static void main(String[] args) {	
		
		//i can still do this even though FINAL_DECK is final
		//Deck myDeck = FINAL_DECK;
		//myDeck.dealOne();
		
		// I cannot change what it's referencing
		//FINAL_DECK = new Deck();  //THIS is what final prevents

		//PI = 3.1416; //I cannot change PI because it's final
		
		//should we have 52 individual variables or use 4 maps or a list of cards
		//a card has to have a suite
		//value for face cards that aren't numbers
		
		//Card class that has a face value and suit
		
		Card aceofHearts = new Card(1,"Hearts");
		System.out.println(aceofHearts);
		aceofHearts.flip();
		System.out.println(aceofHearts);
		
		//i can call static methods by the class
		System.out.println(Card.getCardNameForValue(13));
		//what does's an 11
		//since getCardNameForValue is STATIC, I can call it with Card
		String whats11 = Card.getCardNameForValue(11);
		System.out.println(whats11);
		
		//Create a deck of cards and deal out a few
		System.out.println("*** DEAL SOME CARDS***");
		Deck d = new Deck();
		d.shuffle();
		Card c = d.dealOne();
		c.flip();
		System.out.println(c);
		c = d.dealOne();
		c.flip();
		System.out.println(c);
		for (int i=0;i<100; i++) {
			Card nextCard = d.dealOne();
		
			nextCard.flip();
			System.out.println(nextCard);
		}
		
		//This code doesn't need to known any Card implementation details
		/* A loosely coupled system is one in which each of its components has, 
		 * or makes use of, little or no knowledge of the definitions of other separate components.
		 */
		
		//round is static method in Math so we can call it by the classname
		Math.round(5.5);
	}

}
