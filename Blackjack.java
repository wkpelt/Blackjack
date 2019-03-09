import java.util.Scanner;

class Blackjack {

    public static void main(String[] args) {

        String playerName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nimenne?");
        playerName = sc.nextLine();
        Game Game = new Game(playerName);
        Game.startGame();
    }
}
