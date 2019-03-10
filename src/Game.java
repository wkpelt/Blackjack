import java.util.Scanner;

import org.json.JSONObject;

public class Game {
    protected String playerName;
    protected int round;
    private boolean gameNotOver;
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
        	if(playerCommand.equals("save") && !gameNotOver) {
        		JSONUtils.savePlayer(player.getPlayerName(),player.getBalance());
        	}
        	if(playerCommand.equals("stop")) {
        		this.gameNotOver = false;
        		startGame();
        	}
        	if(playerCommand.equals("play")) {
        			this.dealer = new Player("Dealer");
        			player.clearHand(player.getHand());
        			this.gameNotOver = true;
        			
        			System.out.println("The round is beginning, pleace place your bet");
        			System.out.println("Your balance: " + player.getBalance());
        			
        			int playerBet = sc.nextInt();
        			
        			if (playerBet > player.getBalance() || player.getBalance() == 0) {
        				System.out.println("menisit töihin :D");
        				startGame();
        			}
        			
        			else {
        				System.out.println("Bet accepted");
        				
        				player.addCard(deck.deal());
        				System.out.println("You get");
        				player.printLast();
        				
        				
        				dealer.addCard(deck.deal());
        				System.out.println("Dealer gets");
        				dealer.printLast();
        				
        				player.addCard(deck.deal());
        				System.out.println("You get");
        				player.printLast();
        				
        				dealer.addCard(deck.deal());
        				//(piilossa oleva kortti)
        				
        				player.printHand();
        				
        				System.out.println("");
        				System.out.println(player.getHandSum() + " vs " + dealer.giveLast());
        				
    					System.out.println("\nWhat would you like to do?");
    					System.out.println("hit, stay, double or split");
        					
        				while(player.getHandSum() <= 21) {
        					playerCommand = sc.nextLine();
	        				if(playerCommand.equals("hit")) {
	        					player.addCard(deck.deal());
	        					player.printLast();
	        					System.out.println("Total of: " + player.getHandSum());
	        				}
	        				if(player.getHandSum() > 21) {
	        					System.out.println("BUST!");
	        					startGame();
	        				}
        				}
        		}	
        	}
        }
    }
}