import java.util.Scanner;

import org.json.JSONObject;

public class Game {
    protected String playerName;
    protected int round;

    public Game(String playerName) {
        this.playerName = playerName;
        this.round = 0;
        ifPlayerExists();
    }
    
    public void ifPlayerExists() {
        boolean playerExists = JSONUtils.objectExists(playerName);
        
        if(playerExists) {
        	System.out.println("Welcome back " + playerName + "!");
        	System.out.println("Your balance is: " + "€");
        }
        else {
        	System.out.println("Welcome, " + playerName + "!");
        	System.out.println("Your balance is: 100€");
        }
    }

	public String givePlayerName() {
        return playerName;
    }

    public int giveRound() {
        return round;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        while (sc.nextLine() != "stop") {
            //
        }
    }

}