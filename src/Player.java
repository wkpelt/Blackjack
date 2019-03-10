import java.util.ArrayList;

public class Player {
	//* pelaajan nimi
	private String name;
	
	//* pelaajan massit
	private int balance;
	
	//* getit ja setit
	public String getPlayerName() {
        return name;
    }
	
	public int getBalance() {
        return balance;
    }
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setPlayerName(String name) {
		this.name = name;
	}
	
	//* pelaajan k‰si
	private ArrayList<Card> hand;
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	//* konstruktori
	public Player(String aName) {
		this.name = aName;
		this.hand = new ArrayList<Card>();
	}
	//default constructor, to allow making a temporary player for split
	public Player() {
		this.name = "";
		this.hand = new ArrayList<Card>();
	}
	
	//* Lis‰‰ kortti k‰teen metodi
	public boolean addCard(Card aCard) {
		hand.add(aCard);
		return (this.getHandSum() <= 21);
	}
	
	public void removeCard(int index) {
		hand.remove(index);
	}
	
	public ArrayList<Card> clearHand(ArrayList<Card> b) {
		b.clear();
		return (b);
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
	
	public void printHand() {
		System.out.println("You have");
		for (Card c : hand) {
			System.out.print("| " + c.getRank() + " of " + c.getSuit().getSuitString() + ", " + c.getRank().getRankValue() + " | ");
		}
		System.out.println("The value of your hand is " + this.getHandSum());
	}
	public void printLast() {
		Card c = hand.get(hand.size()-1);
		System.out.println("| " + c.getRank() + " of " + c.getSuit().getSuitString() + ", " + c.getRank().getRankValue() + " | ");
	}
	
	public Card returnLast() {
		return hand.get(hand.size()-1);
	}
	
	public void removeLast() {
		// could just be remove(1), because used only in split and split only allowed with two cards
		hand.remove(hand.size()-1);
	}
	
	public int giveLast() {
		Card c = hand.get(hand.size()-1);
		return (c.getRank().getRankValue());
	}
	public void printDealerHand() {
		System.out.println("Dealer has");
		for (Card c : hand) {
			System.out.print("| " + c.getRank() + " of " + c.getSuit().getSuitString() + ", " + giveLast() + " | ");
		}
		System.out.println("The value of the dealer's hand is " + this.getHandSum());
	}
}
