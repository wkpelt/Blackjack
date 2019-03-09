import java.util.Scanner;

public class Game {
    protected String playerName;
    protected int round;

    public Game(String playerName) {
        this.playerName = playerName;
        this.round = 0;
        CheckPlayers check = new CheckPlayers();
        check.ifExists(playerName);
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