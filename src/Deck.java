
import java.util.*;


public class Deck {
	
	ArrayList<Card> deck;
	
	
	public Deck() {
		createDeck();
	}
	
	public void createDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		
		
		//* adds cards of four decks in a stupid way and i'm stupid and this is stupid
		for (int i = 0; i < 4; i++) {
			

				deck.add(new Card(Rank.ACE, Suit.HEARTS));
				deck.add(new Card(Rank.TWO, Suit.HEARTS));
				deck.add(new Card(Rank.THREE, Suit.HEARTS));
				deck.add(new Card(Rank.FOUR, Suit.HEARTS));
				deck.add(new Card(Rank.FIVE, Suit.HEARTS));
				deck.add(new Card(Rank.SIX, Suit.HEARTS));
				deck.add(new Card(Rank.SEVEN, Suit.HEARTS));
				deck.add(new Card(Rank.EIGHT, Suit.HEARTS));
				deck.add(new Card(Rank.NINE, Suit.HEARTS));
				deck.add(new Card(Rank.TEN, Suit.HEARTS));
				deck.add(new Card(Rank.JACK, Suit.HEARTS));
				deck.add(new Card(Rank.QUEEN, Suit.HEARTS));
				deck.add(new Card(Rank.KING, Suit.HEARTS));
			
			
				deck.add(new Card(Rank.ACE, Suit.DIAMONDS));
				deck.add(new Card(Rank.TWO, Suit.DIAMONDS));
				deck.add(new Card(Rank.THREE, Suit.DIAMONDS));
				deck.add(new Card(Rank.FOUR, Suit.DIAMONDS));
				deck.add(new Card(Rank.FIVE, Suit.DIAMONDS));
				deck.add(new Card(Rank.SIX, Suit.DIAMONDS));
				deck.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
				deck.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
				deck.add(new Card(Rank.NINE, Suit.DIAMONDS));
				deck.add(new Card(Rank.TEN, Suit.DIAMONDS));
				deck.add(new Card(Rank.JACK, Suit.DIAMONDS));
				deck.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
				deck.add(new Card(Rank.KING, Suit.DIAMONDS));
				
				deck.add(new Card(Rank.ACE, Suit.SPADES));
				deck.add(new Card(Rank.TWO, Suit.SPADES));
				deck.add(new Card(Rank.THREE, Suit.SPADES));
				deck.add(new Card(Rank.FOUR, Suit.SPADES));
				deck.add(new Card(Rank.FIVE, Suit.SPADES));
				deck.add(new Card(Rank.SIX, Suit.SPADES));
				deck.add(new Card(Rank.SEVEN, Suit.SPADES));
				deck.add(new Card(Rank.EIGHT, Suit.SPADES));
				deck.add(new Card(Rank.NINE, Suit.SPADES));
				deck.add(new Card(Rank.TEN, Suit.SPADES));
				deck.add(new Card(Rank.JACK, Suit.SPADES));
				deck.add(new Card(Rank.QUEEN, Suit.SPADES));
				deck.add(new Card(Rank.KING, Suit.SPADES));
				
				deck.add(new Card(Rank.ACE, Suit.CLUBS));
				deck.add(new Card(Rank.TWO, Suit.CLUBS));
				deck.add(new Card(Rank.THREE, Suit.CLUBS));
				deck.add(new Card(Rank.FOUR, Suit.CLUBS));
				deck.add(new Card(Rank.FIVE, Suit.CLUBS));
				deck.add(new Card(Rank.SIX, Suit.CLUBS));
				deck.add(new Card(Rank.SEVEN, Suit.CLUBS));
				deck.add(new Card(Rank.EIGHT, Suit.CLUBS));
				deck.add(new Card(Rank.NINE, Suit.CLUBS));
				deck.add(new Card(Rank.TEN, Suit.CLUBS));
				deck.add(new Card(Rank.JACK, Suit.CLUBS));
				deck.add(new Card(Rank.QUEEN, Suit.CLUBS));
				deck.add(new Card(Rank.KING, Suit.CLUBS));
				

			/* old(doesn't work) was done before rank was also an enum
			for (int j = 1; i < 10; j++) {
				deck.add(new Card(j, Suit.HEARTS));
				deck.add(new Card(j, Suit.DIAMONDS));
				deck.add(new Card(j, Suit.SPADES));
				deck.add(new Card(j, Suit.CLUBS));
			}
			
			* adds all picture cards
			for (int j=0; j < 3; j++) {
				deck.add(new Card(10, Suit.HEARTS));
				deck.add(new Card(10, Suit.DIAMONDS));
				deck.add(new Card(10, Suit.SPADES));
				deck.add(new Card(10, Suit.CLUBS));
			}
			**/
		}
	}
		

	
	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();
		
		while(deck.size() > 0) {
			int indeksi = (int) (Math.random() * deck.size());
			temp.add(deck.get(indeksi));
			deck.remove(indeksi);
		}
		
		deck = temp;
	}
	
	
	public Card deal() {
		Card a = deck.get(0);
		deck.remove(0);
		return a;
		
	}

}
