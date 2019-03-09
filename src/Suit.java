public enum Suit {HEARTS("Hearts"), DIAMONDS("Spades"), SPADES("Diamonds"), CLUBS("Clubs");
	
	private final String suitString;
	
	private Suit(String suitString){
	this.suitString = suitString;
	}
	
	public String getSuitString() {
		return suitString;
	}
}