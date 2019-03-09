import java.util.ArrayList;

public class Player {
	//* pelaajan nimi
	private String name;
	
	//* pelaajan k‰si
	private ArrayList<Card> hand;
	
	//* konstruktori
	public Player(String aName) {
		this.name = aName;
		hand.clear();
		}
	
	//* Lis‰‰ kortti k‰teen metodi
	public boolean addCard(Card aCard) {
		hand.add(aCard);
		return (this.getHandSum() <= 21);
	}
	
	//* Palauttaa k‰den arvo
	public int getHandSum() {
		int handSum = 0;
		int cardRank;
		int numAces = 0;
		
		for (int c = 0; c < hand.size(); c++) {
			cardRank = ((hand.get(c)).getRank()).getRankValue();
			
			if (cardRank == 1) {
				numAces++;
				handSum += 11;
			} else if (cardRank > 10) {
				handSum += 10;
			} else {
				handSum += cardRank;
			}
		}
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
			
		return handSum;
	}
}
