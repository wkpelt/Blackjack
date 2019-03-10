
import java.util.*;


public class Deck {
	
	public ArrayList<Card> deck;
	
	
	public Deck() {
		createDeck();
	}
	
	public void createDeck() {
		this.deck = new ArrayList<Card>();
		
		//*adds four decks
		for (int i=0; i < 4; i++) {
			//* adds a single decks worth of cards
			for (Suit s: Suit.values()) {
				for(Rank r : Rank.values()) {
					deck.add(new Card(r,s));
				}
			}
		}
		shuffle();
	}
	
	public void reShuffle() {
		deck.removeAll(deck);
		//*adds four decks
		for (int i=0; i < 4; i++) {
			//* adds a single decks worth of cards
			for (Suit s: Suit.values()) {
				for(Rank r : Rank.values()) {
					deck.add(new Card(r,s));
				}
			}
		}
		shuffle();
	}
		

	
	public void shuffle() {
		ArrayList<Card> temp = new ArrayList<Card>();
		
		while(deck.size() > 0) {
			int indeksi = (int) (Math.random() * deck.size());
			temp.add(deck.get(indeksi));
			//System.out.println(temp.get(temp.size()-1).getRank().getRankValue());
			deck.remove(indeksi);
		}
		
		deck = temp;
	}
	
	public int deckSize() {
		return deck.size();
	}
	
	public void clearDeck() {
		deck.clear();
	}
	
	public Card deal() {
		Card a = deck.get(0);
		deck.remove(0);
		return a;
		
	}

}
