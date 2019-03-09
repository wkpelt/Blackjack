
import java.util.*;


public class Deck {
	
	ArrayList<Card> deck;
	
	
	public Deck() {
		createDeck();
	}
	
	public void createDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		
		
		//* adds cards of four decks
		for (int i = 0; i < 4; i++) {

			//* adds all number value cards
			for (int j = 1; i < 10; j++) {
				deck.add(new Card(j, Suit.HEARTS));
				deck.add(new Card(j, Suit.DIAMONDS));
				deck.add(new Card(j, Suit.SPADES));
				deck.add(new Card(j, Suit.CLUBS));
			}
			//* adds all picture cards
			for (int j=0; j < 3; j++) {
				deck.add(new Card(10, Suit.HEARTS));
				deck.add(new Card(10, Suit.DIAMONDS));
				deck.add(new Card(10, Suit.SPADES));
				deck.add(new Card(10, Suit.CLUBS));
			}
		
		}
		
	}
	
	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();
		
		while(deck.size() > 0) {
			int indeksi = (int) (Math.random() * deck.size());
			temp.add(deck.remove(indeksi));
		}
		
		deck = temp;
	}
	
	
	public Card deal() {
		Card a = deck.get(0);
		deck.remove(0);
		return a;
		
	}

}
