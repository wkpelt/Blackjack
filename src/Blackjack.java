import java.util.Scanner;

class Blackjack {

    public static void main(String[] args) {

        String playerName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Blackjack");
        System.out.println("What is your name?");
        playerName = sc.nextLine();
        Game Game = new Game(playerName);
        Game.startGame();
    }
}
