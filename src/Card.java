public class Card {
	Rank rank;
	Suit suit;
	
	public Card(){
	}
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}
