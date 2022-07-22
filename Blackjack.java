import java.util.Scanner;

public class Blackjack {
    private Dealer dealer;
    private Player player;
    private Deck deck;

    private int curBet;
    private int minBet;
    private int maxBet;

    private Scanner in;

    public void startGame() {
        in = new Scanner(System.in);
        dealer = new Dealer();

        System.out.println("----------Blackjack----------");

        setupGame();
        initPlayer();

        System.out.printf("\nHi, %s!\n", player.getName());
        System.out.println("Game starts now.");

        startGameLoop();
    }

    private void setupGame() {
        System.out.print("Enter the minimum bet($): ");
        minBet = in.nextInt();
        System.out.print("Enter the maximum bet($): ");
        maxBet = in.nextInt();
    }

    private void initPlayer() {
        System.out.print("\nEnter your name: ");
        String playerName = in.next();

        System.out.print("Enter your start balance($): ");
        long playerBalance = in.nextLong();

        player = new Player(playerName, playerBalance);
    }

    private void startGameLoop() {
        int gameNumber = 1;

        while (true) {
            if (!checkMoney()) {
                System.out.println("\nYou have not enough money to play!");
                break;
            }

            System.out.printf("\n----------GAME %d----------\n", gameNumber);

            placeBet();

            deck = new Deck();

            player.takeCard(deck.giveCard());
            player.takeCard(deck.giveCard());
            dealer.takeCard(deck.giveCard());
            dealer.takeCard(deck.giveCard());

            player.showCards();
            dealer.showFirstCard();

            gameNumber++;
            break;
        }

        System.out.println("----------GAME OVER----------");
    }

    private boolean checkMoney() {
        return player.getMoney() >= minBet;
    }

    private void placeBet() {
        System.out.printf("\nYour balance: %d$.\n", player.getMoney());
        System.out.printf("Enter your bet(%d - %d$): ", minBet, Math.min(player.getMoney(), maxBet));

        curBet = in.nextInt();
        while (curBet < minBet || curBet > maxBet || curBet > player.getMoney()) {
            System.out.print("Your bet is incorrect! Try again: ");
            curBet = in.nextInt();
        }
        player.placeBet(curBet);
        System.out.printf("\nYou've bet %d$.\n\n", curBet);
    }
}
