import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// list of cards in order
	private List<Card> deck = new ArrayList<Card>();

	// populate the deck inthe constructor. let's default to just a regular card
	// game
	public Deck() {
		populateDeckAndShuffle();
	}



	/**
	 * 
	 */
	private void populateDeckAndShuffle() {
		String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };
		for (String suit : suits) {
			for (int cardValue = 1; cardValue <= 13; cardValue++) {
				Card c = new Card(cardValue, suit);
				deck.add(c);
			}
		}
		shuffle();
	}



	// deal a card
	// remove a card from the list and return that card
	public Card dealOne() {
		if (deck.size() == 0) {
			populateDeckAndShuffle();
		
		}

		Card c = deck.get(0);
		deck.remove(0);
		return c;
		// return null; return null if the deck is empty

	}

	// shuffle
	public void shuffle() {
		Collections.shuffle(deck);
	}

	// get amount of cards
	public int getCountCardsLeft() {
		return deck.size();
	}
}
