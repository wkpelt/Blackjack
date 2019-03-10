import java.util.Scanner;

import org.json.JSONObject;

public class Game {
    protected String playerName;
    protected int round;
    Player player;
    Player dealer;
    Deck deck;
    Scanner sc;

    public Game() {
        System.out.println("Blackjack");
        System.out.println("What is your name?");
        this.sc = new Scanner(System.in);
        this.playerName = sc.nextLine();
        this.round = 0;
        this.deck = new Deck();
        ifPlayerExists();
    }
    
    public void ifPlayerExists() {
        boolean playerExists = JSONUtils.objectExists(playerName);
        
        if(playerExists) {
        	System.out.println("Welcome back " + playerName + "!");
        	this.player = new Player(playerName);
        	player.setBalance(JSONUtils.balanceOfPlayer(playerName));
        	System.out.println("Your balance is: " + player.getBalance() + "€");
        }
        else {
        	System.out.println("Welcome, " + playerName + "!");
        	this.player = new Player(playerName);
        	player.setBalance(100);
        	System.out.println("Your balance is: " + player.getBalance() + "€");
        }
    }

	public String givePlayerName() {
        return playerName;
    }

    public int giveRound() {
        return round;
    }

    public void startGame() {
        System.out.println("Type 'play' to start the game");
        while (true) {
        	if(deck.deckSize() <= 104) {
        		deck.shuffle();
        		System.out.println("Shuffling the deck!");
        	}
        	String playerCommand = sc.nextLine();
        	if(playerCommand.equals("save")) {
        		System.out.println("moi");
        		JSONUtils.savePlayer(player.getPlayerName(),player.getBalance());
        	}
        	if(playerCommand.equals("stop")) {
        		// pysäytä peli jos erä on loppu
        		System.out.println("Stopped");
        	}
        	if(playerCommand.equals("play")) {
        		System.out.println("The round beginning set your bet");
        		int playerBet = sc.nextInt();
        		player.addCard(deck.deal());
        		dealer.addCard(deck.deal());
        		player.addCard(deck.deal());
        		dealer.addCard(deck.deal());
        		//*kesken
        		//*System.out.println("Your cards are:" + getRank())
        		
        	}
        }

}
}