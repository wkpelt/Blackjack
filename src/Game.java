import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String playerName;
    Player player;
    Player dealer;
    Deck deck;
    Scanner sc;
    

    public Game() {
        System.out.println("Blackjack");
        System.out.println("What is your name?");
        this.sc = new Scanner(System.in);
        this.playerName = sc.nextLine();
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


    public void startGame() {
        System.out.println("Type 'play' to start the game | 'quit' to quit playing | 'help' for more commands.");
        JSONUtils.savePlayer(player.getPlayerName(),player.getBalance());
        while (true) {
        	String playerCommand = sc.nextLine();
        	if(playerCommand.equals("quit")) {
        		JSONUtils.savePlayer(player.getPlayerName(),player.getBalance());
        		System.exit(0);
        	}
        	if(playerCommand.equals("players")) {
        		JSONUtils.givePlayers();
        	}
        	if(playerCommand.equals("help")) {
        		System.out.println("More commands: players, balance");
        	}
        	if(playerCommand.equals("balance")) {
        		System.out.println(player.getBalance());
        	}
        	if(playerCommand.equals("play")) {
        			this.dealer = new Player("Dealer");
        			player.clearHand(player.getHand());
        			
        			System.out.println("The round is beginning, please place your bet");
        			System.out.println("Your balance: " + player.getBalance());
        			
        			int playerBet = 0;
    				try 
    				{
    					playerBet = sc.nextInt();        			
    				} 
    				catch (Exception e)
    				{
    					System.out.println("Illegal argument, please enter an integer value");
    				}
        			
        			if (playerBet > player.getBalance() || player.getBalance() == 0) {
        				System.out.println("\nmenisit töihin :D");
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
        				System.out.println("Dealer gets a hidden card");
        				
        				player.printHand();
        				
        				System.out.println("");
        				System.out.println(player.getHandSum() + " vs " + dealer.giveFirst() + " and a hidden card");
        				twentyone(playerBet);
    					System.out.println("\nWhat would you like to do?");
    					System.out.println("hit, stay, double or split");
        					
    					//Delicious readability, would've been a lot better if it had been it methods in mind from the start 
        				//all this just to get split to work...
    					gameLoop(playerCommand, player, playerBet);
    					
        			System.out.println("Now it's the dealers turn");
        			dealer.printDealerHand();
        			while(dealer.getHandSum() < 17) {
        				dealerHit();
        				dealerBust(playerBet);
        				dealerTwentyone(playerBet);
        				
        			}
        			//if dealer has blackjack ends the game and starts again, else checks who won
                	if(deck.deckSize() <= 104) {
                		deck.shuffle();
                		System.out.println("Shuffling the deck!");
                	}
        			dealerTwentyone(playerBet);
        			whoWon(playerBet);
        			
        		}	
        	}
        }
    }
	public void hit(String playerCommand, Player playerA) {
		if(playerCommand.equals("hit")) {
			playerA.addCard(deck.deal());
			playerA.printLast();
			System.out.println("Total of: " + playerA.getHandSum());
		}
	}
	
	//Had to use this currentHand way. we should've made a class for the hand itself
	public boolean doubledown(String playerCommand, int playerBet, Player currentHand) {
		if(playerCommand.contentEquals("double")) {
			if(player.getBalance() >= playerBet*2) {
			playerBet = playerBet * 2;
			currentHand.addCard(deck.deal());
			currentHand.printLast();
			System.out.println("You end with: " + currentHand.getHandSum());
			bust(playerBet, currentHand);
			return true;
			}
		}
		return false;
	}

	
	
		
	public boolean stay(String playerCommand) {
		if(playerCommand.contentEquals("stay")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void bust(int playerBet, Player currentHand) {
		if(currentHand.getHandSum() > 21) {
			System.out.println("BUST!");
			player.setBalance(player.getBalance() - playerBet);
			startGame();
		}
	}
	
	public void twentyone(int playerBet) {
		if(player.getHandSum() == 21) {
			System.out.println("Blackjack!");
			player.setBalance(player.getBalance() + playerBet);
			startGame();
		}
	}
	
	public void dealerHit() {
		System.out.println("Dealer hits");
		dealer.addCard(deck.deal());
		dealer.printLast();
		System.out.println( "Total of: " + dealer.getHandSum());
	}
	
	public void dealerBust(int playerBet) {
		if(dealer.getHandSum() > 21) {
			System.out.println("Dealer busts! You win!");
			player.setBalance(player.getBalance() + playerBet);
			startGame();
		}
	}
	
	public void dealerTwentyone(int playerBet) {
		if(dealer.getHandSum() == 21) {
			System.out.println("Dealer blackjack!");
			player.setBalance(player.getBalance() - playerBet);
			startGame();
		}
	}
	public void whoWon(int playerBet) {
		if(player.getHandSum() > dealer.getHandSum()) {
			System.out.println("You win!!");
			player.setBalance(player.getBalance() + playerBet);
			startGame();
		}
		if(player.getHandSum() < dealer.getHandSum()) {
			System.out.println("Dealer wins!");
			player.setBalance(player.getBalance() - playerBet);
			startGame();
		}
	}
	
	public void gameLoop(String playerCommand, Player currentHand, int playerBet) {
		while(currentHand.getHandSum() <= 21) {
			playerCommand = sc.nextLine();
			split(playerCommand, currentHand, playerBet);
			hit(playerCommand, currentHand);
			if (doubledown(playerCommand, playerBet, currentHand)) {
				break;
			}
			if (stay(playerCommand)) {
				break;
			}
		}
		bust(playerBet, currentHand);
	}
	
	public void split(String playerCommand, Player currentHand, int playerBet) {
		if(playerCommand.contentEquals("split")) {
			ArrayList<Card> abc = currentHand.getHand();
			if(abc.get(0).getRank().getRankValue() == abc.get(1).getRank().getRankValue()) {
				Player temp = new Player();
				//Can't work like this, would have to write all the logic inside here again...
				//all of these should've been methods, RREEE more methods
				//did it wow this is ass tho, so much work to get this to work
			
			temp.addCard(currentHand.returnLast());
			currentHand.removeCard(1);
			hit("hit", currentHand);
			hit("hit", temp);
			gameLoop(playerCommand, currentHand, playerBet);
			gameLoop(playerCommand, temp, playerBet);
			}
			else {
				System.out.println("Split not allowed, your cards have to have the same value");

				gameLoop(playerCommand, currentHand, playerBet);
			}
			
		}
	}
}