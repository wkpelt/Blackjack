import java.util.Scanner;

class main {

    public static void main(String[] args) {
        int player_random1 = 100;
        int player_random2 = 100;

        while (player_random1 >= 12 || player_random2 >= 12 || player_random1 < 3 || player_random2 < 3) {
            player_random1 = (int) (Math.random() * 100);
            player_random2 = (int) (Math.random() * 100);
        }

        int player_total = player_random1 + player_random2;

        System.out.println("You get a " + player_random1 + " and a " + player_random2);
        System.out.println("Your total is " + player_total);
        if (player_total == 21) {
            System.out.println("Blackjack! Player Wins!");
            return;
        }
        System.out.println();

        int dealer_random1 = 100;
        int dealer_random2 = 100;

        while (dealer_random1 >= 12 || dealer_random2 >= 12 || dealer_random1 < 3 || dealer_random2 < 3) {
            dealer_random1 = (int) (Math.random() * 100);
            dealer_random2 = (int) (Math.random() * 100);
        }

        int dealer_total = dealer_random1 + dealer_random2;

        boolean hidden = Math.random() < 0.5; // to decide whether to hide one card or not

        if (hidden == true) {
            System.out.println("The dealer has a " + dealer_random1 + " showing and a hidden card");
            System.out.println("His total is hidden too");
            System.out.println();
        } else {
            System.out.println("The dealer has a " + dealer_random1 + " showing  and a " + dealer_random2);
            System.out.println("Dealer total is " + dealer_total);
            System.out.println();
            if (dealer_total == 21) {
                System.out.println("Blackjack! Dealer Wins!");
                return;
            }
        }

        String player_preference;
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to hit or stay?");
        player_preference = in.nextLine();

        while (player_preference.equals("hit")) {
            int player_random3 = 100;
            while (player_random3 >= 12 || player_random3 < 3) {
                player_random3 = (int) (Math.random() * 100);
            }
            player_total = player_total + player_random3;
            System.out.println("You drew a " + player_random3);
            System.out.println("Your total is " + player_total);
            System.out.println();

            if (player_total > 21) {
                System.out.println("Busted! Dealer wins!");
                return;
            } else if (player_total == 21) {
                System.out.println("You Win!");
                return;
            }
            System.out.println("Would you like to hit or stay?");
            player_preference = in.nextLine();
        }

        if (player_preference.equals("stay")) {
            System.out.println();
            System.out.println("Okay, dealer's turn.");
            int dealer_random3 = 100;
            while (dealer_random3 >= 12 || dealer_random3 < 3) {
                dealer_random3 = (int) (Math.random() * 100);
            }

            System.out.println("His hidden card was " + dealer_random2);
            System.out.println("His total was " + dealer_total);
            System.out.println();

            if (dealer_total > 16) {
                System.out.println("Dealer stays");
            } else {
                while (dealer_total <= 16) {
                    dealer_total = dealer_total + dealer_random3;
                    System.out.println("Dealer choses to hit.");
                    System.out.println("He draws a " + dealer_random3);
                    System.out.println("His total is " + dealer_total);
                }
            }

            System.out.println();
            System.out.println("Dealer total is " + dealer_total);
            System.out.println("Your total is " + player_total);

            if ((player_total > dealer_total && player_total < 21) || dealer_total > 21) {
                System.out.println("YOU WIN!");
            } else if ((dealer_total < 21 && player_total < dealer_total) || player_total > 21) {
                System.out.println("Dealer wins!");
            }
        }
    }
}