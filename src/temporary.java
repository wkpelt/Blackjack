
public class temporary {

	public void hit(String playerCommand) {
		if(playerCommand.equals("hit")) {
			player.addCard(deck.deal());
			player.printLast();
			System.out.println("Total of: " + player.getHandSum());
		}
	}
	
	
	public void doubledown(String playerCommand) {
		if(playerCommand.contentEquals("double")) {
			playerBet = playerBet * 2;
			player.addCard(deck.deal());
			player.printLast();
			System.out.println("You end with: " + player.getHandSum());
			if(player.getHandSum() > 21) {
				System.out.println("BUST!");
				player.setBalance(player.getBalance() - playerBet);
				startGame();
			}
			else{ break;
			}
		}
	}
	
		
	public void stay(String playerCommand) {
		if(playerCommand.contentEquals("stay")) {
			break;
		}
	}
	
	public void bust() {
		if(player.getHandSum() > 21) {
			System.out.println("BUST!");
			player.setBalance(player.getBalance() - playerBet);
			startGame();
		}
	}
	
	public void twentyone() {
		if(player.getHandSum() == 21) {
			System.out.println("Blackjack!");
			player.setBalance(player.getBalance() + playerBet);
			startGame();
		}
	}
	
	public void split(String playerCommand, Player currentHand, int playerBet) {
		if(playerCommand.contentEquals("split")) {
			ArrayList<Card> abc = currentHand.getHand();
			if(abc.size() < 2 && abc.get(0).getRank() == abc.get(1).getRank()) {
				Player temp = new Player();
				//Can't work like this, would have to write all the logic inside here again...
				//all of these should've been methods, RREEE more methods
			
			temp.addCard(currentHand.returnLast());
			currentHand.removeCard(1);
			gameLoop(playerCommand, currentHand, playerBet);
			gameLoop(playerCommand, temp, playerBet);
			}
			else {
				System.out.println("Split not allowed, your cards have to have the same value");
			}
			
		}
	}
	
	
	public void gameLoop(Player currentHand) {
		while(currentHand.getHandSum() <= 21) {
			sc.nextLine();
			playerCommand = sc.nextLine();
			hit(playerCommand, currentHand);
			if (doubledown(playerCommand, playerBet, currentHand)) {
				break;
			}
			if (stay(playerCommand)) {
				break;
			}
			twentyone(playerBet);
			
			
		}
		bust(playerBet, currentHand);
	}
}
